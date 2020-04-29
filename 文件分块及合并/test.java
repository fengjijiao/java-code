package test3;

public class test {
    public static void main(String[] args) {
        String file="app-release.zip"; //文件的路径
        String outfile="out.zip"; //文件的路径
        String fileExtension = file.split("\\.")[1];
        int count=10;  //将文件切割成多少份
        SplitFileOperater splitFileOperater = new SplitFileOperater(fileExtension,"C:\\Users\\jijiao\\IdeaProjects\\test\\src\\test3");
        splitFileOperater.getSplitFile(file, count);//分割
        String[] fileNames = splitFileOperater.getSplitFileNames(file, count);
        for (String fileName: fileNames) {
            System.out.println(fileName);
        }
        String[] fileMD5s = splitFileOperater.getSplitFileMD5s(file, count);
        for (String fileMD5: fileMD5s) {
            System.out.println(fileMD5);
        }
        splitFileOperater.merge(outfile, file,count);//合并
    }
}
