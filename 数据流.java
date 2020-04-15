package test;

import java.io.*;

public class test25 {
    /*数据流,不能直接在文件中一眼看出数据的值
     */
    public static void main(String[] args) {
        String filePath = "a.txt";
        try{
            OutputData(filePath);
            InputData(filePath);
        }catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(filePath);
        file.delete();
    }
    public static void InputData(String filePath) throws Exception {
        FileInputStream fi = new FileInputStream(filePath);
        DataInputStream di = new DataInputStream(fi);
        System.out.println(di.readBoolean());//注意此处必须指定正确的数据类型，否则会显示错误的内容
        di.close();
        fi.close();
    }
    public static void OutputData(String filePath) throws Exception {
        FileOutputStream fo = new FileOutputStream(filePath);
        DataOutputStream ds = new DataOutputStream(fo);
        ds.writeBoolean(false);
        ds.flush();
        ds.close();
        fo.close();
    }
}
