package test;

import java.io.File;

public class test18 {
    //遍历目录
    public static void main(String[] args) {
        File file = new File("../../");
        ListPrint(file);
    }
    private static void ListPrint(File file) {
        if(file.exists()) {
            if(file.isDirectory()) {
                System.out.println(file.getAbsolutePath() + "是目录");
                File[] files = file.listFiles();
                for(File f: files) {
                    ListPrint(f);
                }
            }else {
                System.out.println(file.getAbsolutePath() + "是文件");
            }
        }else {
            System.out.println("文件不存在!");
        }
    }
}
