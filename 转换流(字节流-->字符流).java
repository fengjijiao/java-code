package test;

import java.io.*;

public class test23 {
    /*转换流：将字节流转为字符流
     */
    public static void main(String[] args) {
        String filePath = "ccc.txt";
        try {
            FileOutputStreamToWriter(filePath, "Hello, WQ!");
            FileInputStreamToReader(filePath);
        }catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(filePath);
        file.delete();
    }
    public static void FileInputStreamToReader(String filePath) throws Exception {
        FileInputStream in = new FileInputStream(filePath);
        InputStreamReader ir = new InputStreamReader(in, "UTF-8");//指定字符编码
        char[] buf = new char[1024];
        int len;
        while ((len = ir.read(buf)) != -1) {
            System.out.printf(new String(buf, 0,len));
        }
        System.out.println();
        ir.close();
        in.close();
    }
    public static void FileOutputStreamToWriter(String filePath, String fileContent) throws Exception {
        FileOutputStream out = new FileOutputStream(filePath);
        OutputStreamWriter iw = new OutputStreamWriter(out, "UTF-8");//指定字符编码
        iw.write(fileContent.toCharArray());
        iw.flush();
        iw.close();
        out.close();
    }
}
