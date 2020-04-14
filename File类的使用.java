package test;

import java.io.File;
import java.io.IOException;

public class test17 {
    /*
    File类的使用
     */
    public static void main(String[] args) {
        //创建file对象
        //File file = new File("D:/a/b/c/d/e/f");
        //File file = new File("D:\\a\\b\\c\\d\\e\\f");
        //上两句中\\与/等同
        File file = new File("test17.text");
        if(!file.exists()) {//判断文件是否存在
            try {
                file.createNewFile();//创建文件
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("文件名：" + file.getName());
        System.out.println("文件(new file所输入的路径)路径：" + file.getPath());
        System.out.println("文件(绝对路径)路径：" + file.getAbsolutePath());
        File file1 = file.getAbsoluteFile();//通过该文件或目录的绝对路径获取file对象
        System.out.println("文件(绝对路径)父路径：" + file.getParent());
        File file2 = new File("test17.txt");
        file1.renameTo(file2);//文件重命名
        System.out.println("可读：" + file2.canRead());
        System.out.println("可写：" + file2.canWrite());
        System.out.println("是否为目录：" + file2.isDirectory());
        System.out.println("是否为文件：" + file2.isFile());
        System.out.println("上次修改（时间戳）：" + file2.lastModified());
        System.out.println("文件大小（字节数）：" + file2.length());
        File file3 = new File("test188/222");
        file3.mkdir();//创建目录（单级）
        file3.mkdirs();//创建(多级)目录
        String[] fs = file3.list();//获取目录中的文件/目录名
        for(String f:fs) {
            System.out.println(f);
        }
        File[] ff = file3.listFiles();//获取目录中的文件/目录的file对象
        for(File f:ff) {
            System.out.println(f.lastModified());
        }
        file.delete();//删除文件
    }
}
