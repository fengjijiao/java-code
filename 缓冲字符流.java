package test;

import java.io.*;
import java.util.Arrays;

public class test22 {
    /*缓冲字符流
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
            BufferedReader br = new BufferedReader(fr);
            char[] buffer = new char[10];
            int len;
            while ((len = br.read(buffer)) != -1) {//等于-1时表示文件已经读取完了
                System.out.printf(new String(buffer, 0, len));
            }
            System.out.println();
            br.close();//关闭缓冲输入流
            fr.close();//关闭输入流
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void FileContentWriter(String filePath, char[] content) {
        try {
            FileWriter fw = new FileWriter(filePath);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.flush();//将输出流写入文件
            bw.close();//关闭输出流
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void FileCopy(String sourcePath, String destinationPath) {
        try {
            FileReader fr = new FileReader(sourcePath);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(destinationPath);
            BufferedWriter bw = new BufferedWriter(fw);
            char[] buffer = new char[10];
            int len;
            while((len = br.read(buffer)) != -1) {
                bw.write(Arrays.copyOfRange(buffer, 0, len));
            }
            bw.flush();
            bw.close();
            fw.close();
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
