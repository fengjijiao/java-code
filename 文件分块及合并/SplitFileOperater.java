package test3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SplitFileOperater {
    private String fileExtension;
    private String dirPath;

    public SplitFileOperater() {
        this(".apk", "");
    }

    public SplitFileOperater(String fileExtension, String dirPath) {
        this.fileExtension = fileExtension;
        this.dirPath = dirPath;
    }

    public static void main(String[] args) {
        String file="C:\\Users\\pc\\Desktop\\photo/1.jpg"; //文件的路径
        String outfile="C:\\Users\\pc\\Desktop\\photo/out.jpg"; //文件的路径
        int count=10;   //将文件切割成多少份
        SplitFileOperater splitFileOperater = new SplitFileOperater();
        splitFileOperater.getSplitFile(file, count);//分割
        splitFileOperater.merge(outfile, file,count);//合并
    }

    /**
     * 文件分割方法
     * @param file 文件的路径
     * @param count 文件分割的份数
     */
    public void getSplitFile(String file, int count) {
        RandomAccessFile raf = null;
        try {
            //获取目标文件 预分配文件所占的空间 在磁盘中创建一个指定大小的文件   r 是只读
            raf = new RandomAccessFile(new File(getFilePath(dirPath, file)), "r");
            long length = raf.length();//文件的总长度
            long maxSize = length / count;//文件切片后的长度
            long offSet = 0L;//初始化偏移量
            for (int i = 0; i < count - 1; i++) { //最后一片单独处理
                long begin = offSet;
                long end = (i + 1) * maxSize;
//                offSet = writeFile(file, begin, end, i);
                offSet = getWrite(file, i, begin, end);
            }
            if (length - offSet > 0) {
                getWrite(file, count-1, offSet, length);
            }

        } catch (FileNotFoundException e) {
            System.out.println("没有找到文件");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 指定文件每一份的边界，写入不同文件中
     * @param file 源文件
     * @param index 源文件的顺序标识
     * @param begin 开始指针的位置
     * @param end 结束指针的位置
     * @return long
     */
    public long getWrite(String file, int index, long begin, long end) {
        String a=file.split(fileExtension)[0];//分割出文件名
        long endPointer = 0L;
        try {
            //申明文件切割后的文件磁盘
            RandomAccessFile in = new RandomAccessFile(new File(getFilePath(dirPath, file)), "r");
            //定义一个可读，可写的文件并且后缀名为.tmp的二进制文件
            RandomAccessFile out = new RandomAccessFile(new File(getFilePath(dirPath, a + "_" + index + ".tmp")), "rw");

            //申明具体每一文件的字节数组
            byte[] b = new byte[1024];
            int n = 0;
            //从指定位置读取文件字节流
            in.seek(begin);
            //判断文件流读取的边界
            while(in.getFilePointer() <= end && (n = in.read(b)) != -1) {
                //从指定每一份文件的范围，写入不同的文件
                out.write(b, 0, n);
            }
            //定义当前读取文件的指针
            endPointer = in.getFilePointer();
            //关闭输入流
            in.close();
            //关闭输出流
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return endPointer;
    }
    /**
     * 文件合并
     * @param file 指定合并文件
     * @param tempFile 分割前的文件名
     * @param tempCount 文件个数
     */
    public void merge(String file,String tempFile,int tempCount) {
        String a=tempFile.split(fileExtension)[0];
        RandomAccessFile raf = null;
        try {
            //申明随机读取文件RandomAccessFile
            raf = new RandomAccessFile(new File(getFilePath(dirPath, file)), "rw");
            //开始合并文件，对应切片的二进制文件
            for (int i = 0; i < tempCount; i++) {
                //读取切片文件
                RandomAccessFile reader = new RandomAccessFile(new File(getFilePath(dirPath, a + "_" + i + ".tmp")), "r");
                byte[] b = new byte[1024];
                int n = 0;
                //先读后写
                while ((n = reader.read(b)) != -1) {//读
                    raf.write(b, 0, n);//写
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String[] getSplitFileMD5s(String file, int count) {
        String[] fileMD5s = new String[count];
        String[] fileNames = getSplitFileNames(file, count);
        for(int i=0;i<count;i++) {
            fileMD5s[i] = FileOperater.getFileMD5(new File(getFilePath(dirPath, fileNames[i])));
        }
        return fileMD5s;
    }

    public String[] getSplitFileNames(String file, int count) {
        String a = file.split(fileExtension)[0];//分割出文件名
        String[] fileNames = new String[count];
        for(int i=0;i<count;i++) {
            fileNames[i] = a + "_" + i + ".tmp";
        }
        return fileNames;
    }

    public String[] getSplitFilePaths(String file, int count) {
        String a = file.split(fileExtension)[0];//分割出文件名
        String[] fileNames = new String[count];
        for(int i=0;i<count;i++) {
            fileNames[i] = getFilePath(dirPath, a + "_" + i + ".tmp");
        }
        return fileNames;
    }

    public String getFilePath(String dirPath, String fileName) {
        if(dirPath.endsWith("\\") || dirPath.endsWith("/")) {
            return dirPath + fileName;
        }else {
            return dirPath + "/" + fileName;
        }
    }
}