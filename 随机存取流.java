package test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

public class test27 {
    public static void main(String[] args) {
        String filePath = "aaa.txt";
        try{
            initData(filePath);
            testRandomRead(filePath);
            /**
             * DDDD
             * AAAA
             * BBBB
             * CCCC
             * DDDD
             * RRRR
             * EEEE
             * QQQQ
             */
            testRandomWrite(filePath);
            testRandomRead(filePath);
            /**
             * DDDD
             * OOOOOBBBB
             * CCCC
             * DDDD
             * RRRR
             * EEEE
             * QQQQ
             */
        }catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(filePath);
        file.delete();
    }

    /**
     * 随机输入流示例
     * @param filePath
     * @throws Exception
     */
    public static void testRandomRead(String filePath) throws Exception {
        RandomAccessFile rr = new RandomAccessFile(filePath, "r");
        rr.seek(0);//起始位置（单位：字节）
        byte[] buf = new byte[1024];
        int len;
        while((len = rr.read(buf)) != -1) {
            System.out.printf(new String(buf, 0, len));
        }
        System.out.println();
        rr.close();
    }

    /**
     * 随机输出流示例
     * 若从非尾部写入则会从指定位置开始替换等长的字符
     * @param filePath
     * @throws Exception
     */
    public static void testRandomWrite(String filePath) throws Exception {
        RandomAccessFile rw = new RandomAccessFile(filePath, "rw");
        rw.seek(5);//起始写入位置
        rw.write("OOOOO".getBytes());//自带flush()
        rw.close();
    }

    /**
     * 初始化文件中的数据
     * @param filePath
     * @throws Exception
     */
    public static void initData(String filePath) throws Exception {
        FileOutputStream out = new FileOutputStream(filePath);
        BufferedOutputStream bw = new BufferedOutputStream(out);
        String data = "DDDD\n" +
                "AAAA\n" +
                "BBBB\n" +
                "CCCC\n" +
                "DDDD\n" +
                "RRRR\n" +
                "EEEE\n" +
                "QQQQ";
        bw.write(data.getBytes());
        bw.flush();
        bw.close();
        out.close();
    }
}
