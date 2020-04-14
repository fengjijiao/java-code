package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class test19 {
    /*字节输入输出流适用范围广，因为它是直接操作二进制
     */
    //Input指由硬盘输入到内存中，output指由内存输出到硬盘中
    public static void main(String[] args) {
        String filePath = "fff.txt";
        String newFilePath = "ccc.txt";
        String fileContent = "Hello, WQ!";
        FileContentOutput(filePath, fileContent.getBytes());
        FileContentInput(filePath);
        FileCopy(filePath, newFilePath);
        File file = new File(filePath);
        file.delete();
        File file1 = new File(newFilePath);
        file1.delete();
    }
    public static void FileContentInput(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            byte[] buffer = new byte[10];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1) {//等于-1时表示文件已经读取完了
                System.out.printf(new String(buffer, 0, len));
            }
            System.out.println();
            fileInputStream.close();//关闭输入流
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void FileContentOutput(String filePath, byte[] content) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            fileOutputStream.write(content);
            fileOutputStream.flush();//将输出流写入文件
            fileOutputStream.close();//关闭输出流
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void FileCopy(String sourcePath, String destinationPath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(sourcePath);
            FileOutputStream fileOutputStream = new FileOutputStream(destinationPath);
            byte[] buffer = new byte[10];
            int len;
            while((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(Arrays.copyOfRange(buffer, 0, len));
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
