package test;

import java.io.*;

public class test21 {
    //缓冲字节流
    public static void main(String[] args) {
        String sourcePath = "aaa.txt";
        String destinationPath = "bbb.txt";
        try {
            FileBufferedOutput(sourcePath, "Hello, WQ! ");
            FileBufferedInput(sourcePath);
            CopyFile(sourcePath, destinationPath);
        }catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(sourcePath);
        file.delete();
        File file1 = new File(destinationPath);
        file1.delete();
    }
    public static void FileBufferedInput(String filePath) throws Exception {
        FileInputStream in = new FileInputStream(filePath);
        BufferedInputStream br = new BufferedInputStream(in);
        byte[] buf = new byte[1024];
        int len;
        while ((len = br.read(buf)) != -1) {
            System.out.printf(new String(buf, 0 , len));
        }
        System.out.println();
        br.close();
    }
    public static void FileBufferedOutput(String filePath, String fileContent) throws Exception {
        FileOutputStream out = new FileOutputStream(filePath);
        BufferedOutputStream bw = new BufferedOutputStream(out);
        bw.write(fileContent.getBytes());
        bw.flush();
        bw.close();
    }
    public static void CopyFile(String sourcePath, String destinationPath) throws Exception {
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(sourcePath));
        BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(destinationPath));
        byte[] buf = new byte[1024];
        int len;
        while ((len = br.read(buf)) != -1) {
            bw.write(buf);
        }
        bw.close();
        br.close();
    }
}
