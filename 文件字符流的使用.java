package test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class test20 {
    /*字符流(与字节流仅2个差别[char, 实例类])
     */
    public static void main(String[] args) {
        String filePath = "fff.txt";
        String newFilePath = "ccc.txt";
        String fileContent = "Hello, WQ!";
        FileContentWriter(filePath, fileContent.toCharArray());//.toCharArray():转为字符数组
        FileContentReader(filePath);
        FileCopy(filePath, newFilePath);
        File file = new File(filePath);
        file.delete();
        File file1 = new File(newFilePath);
        file1.delete();
    }
    public static void FileContentReader(String filePath) {
        try {
            FileReader fr = new FileReader(filePath);
            char[] buffer = new char[10];
            int len;
            while ((len = fr.read(buffer)) != -1) {//等于-1时表示文件已经读取完了
                System.out.printf(new String(buffer, 0, len));
            }
            System.out.println();
            fr.close();//关闭输入流
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void FileContentWriter(String filePath, char[] content) {
        try {
            FileWriter fw = new FileWriter(filePath);
            fw.write(content);
            fw.flush();//将输出流写入文件
            fw.close();//关闭输出流
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void FileCopy(String sourcePath, String destinationPath) {
        try {
            FileReader fr = new FileReader(sourcePath);
            FileWriter fw = new FileWriter(destinationPath);
            char[] buffer = new char[10];
            int len;
            while((len = fr.read(buffer)) != -1) {
                fw.write(Arrays.copyOfRange(buffer, 0, len));
            }
            fw.flush();
            fw.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
