package test;

import java.io.*;
import java.util.Arrays;

public class test24 {
    /*标准输入输出流
    *默认输入设备为键盘，输出设备为显示器
     */
    public static void main(String[] args) {
        String filePath = "aaa.txt";
        try {
            //StandInputTest();
            StandInputToFileTest2(filePath);
        }catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(filePath);
        file.delete();
    }

    /**
     * 读取输入内容并显示
     * @throws Exception
     */
    public static void StandInputTest() throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);//转换流
        char[] buf = new char[1024];
        int len;
        while ((len = ir.read(buf)) != -1) {
            System.out.printf(new String(buf, 0, len));
        }
        ir.close();
    }

    /**
     * 读取输入内容并保持在文件中
     * @param filePath
     * @throws Exception
     */
    public static void StandInputToFileTest(String filePath) throws Exception {
        OutputStreamWriter ow = new OutputStreamWriter(new FileOutputStream(filePath));
        InputStreamReader ir = new InputStreamReader(System.in);//转换流
        BufferedReader bf = new BufferedReader(ir);
        String line;
        while ((line = bf.readLine()) != null) {
            if(line.equals("over")) {
                break;
            }
            System.out.println(line);
            ow.write(line);
            ow.flush();
        }
        bf.close();
        ir.close();
        ow.close();
    }
    /**
     * 读取输入内容并保持在文件中
     * @param filePath
     * @throws Exception
     */
    public static void StandInputToFileTest2(String filePath) throws Exception {
        OutputStreamWriter ow = new OutputStreamWriter(new FileOutputStream(filePath));
        InputStreamReader ir = new InputStreamReader(System.in);//转换流
        char[] buf = new char[1024];
        int len;
        while ((len = ir.read(buf)) != -1) {
            String line = new String(buf, 0, len);
            System.out.println(line.compareTo("over"));
            if(line.compareTo("over") == 1) {
                break;
            }
            System.out.printf(line);
            ow.write(line);
            ow.flush();
        }
        ir.close();
        ow.close();
    }
}
