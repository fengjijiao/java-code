package test3;

import com.alibaba.fastjson.JSON;
import test3.appupgrade.AppUpgrade;
import test3.appupgrade.CheckCodes;
import test3.appupgrade.FileSplit;
import test3.appupgrade.Files;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        AppUpgrade appUpgrade = new AppUpgrade();
        String latestVersion = "6.2";
        int latestVersionCode = 53;
        boolean zipped = true;
        String releaseNotesString = "- 切换新的下载方式，提升下载更新速率！\n" + "- 从6.2开始仅大更新会显示在这里\n" + "- 请注意：国内网络下载速率可能会不佳！！！\n" + "- 释出于" + new Date().toString();
        String dirPath = "C:\\Users\\jijiao\\IdeaProjects\\test\\src\\test3";
        String file="app-release.zip"; //文件的路径
        String outfile="out.zip"; //文件的路径
        String fileExtension = file.split("\\.")[1];
        int count=10;  //将文件切割成多少份
        SplitFileOperater splitFileOperater = new SplitFileOperater(fileExtension,dirPath);
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
        appUpgrade.setLatestVersion(latestVersion);
        appUpgrade.setLatestVersionCode(latestVersionCode);
        appUpgrade.setUrl("https://www.fjj.us/cache/app-release.apk");
        CheckCodes checkCodes = new CheckCodes();
        checkCodes.setMd5(FileOperater.getFileMD5(new File(dirPath + "/" + "app-release.apk")));
        checkCodes.setSha256("");
        appUpgrade.setCheckCodes(checkCodes);
        String[] releaseNotes = releaseNotesString.split("\n");
        appUpgrade.setReleaseNotes(releaseNotes);
        FileSplit fileSplit = new FileSplit();
        if(fileNames.length != fileMD5s.length) {
            System.out.println("文件数不一致！");
            return;
        }
        Files[] files = new Files[count];
        for (int i=0;i<fileNames.length;i++) {
             Files fs = new Files();
             CheckCodes checkCodes1 = new CheckCodes();
             checkCodes1.setMd5(fileMD5s[i]);
             checkCodes1.setSha256("");
             fs.setCheckCodes(checkCodes1);
             fs.setUrl("https://www.fjj.us/cache/" + fileNames[i]);
             files[i] = fs;
        }
        fileSplit.setFiles(files);
        fileSplit.setCount(count);
        fileSplit.setZipped(zipped);
        appUpgrade.setFileSplit(fileSplit);
        String result = JSON.toJSON(appUpgrade).toString();
        System.out.println(result);
        try {
            File file1 = new File(dirPath + "/" + "update-changelog.json");
            FileOutputStream fileOutputStream = new FileOutputStream(file1);
            fileOutputStream.write(result.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
