package test3;

import com.alibaba.fastjson.JSON;
import net.dongliu.apk.parser.ApkFile;
import net.dongliu.apk.parser.bean.ApkMeta;
import org.apache.commons.io.FileUtils;
import test3.bean.AppUpgradeInfo;
import test3.bean.CheckCodes;
import test3.bean.FileSplitInfo;
import test3.bean.FileSplitItem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        System.out.println("开始运行");
        AppUpgradeInfo appUpgradeInfo = new AppUpgradeInfo();
        boolean zipped = true;
        String releaseNotesString = "- 切换新的下载方式，提升下载更新速率！\n" + "- 从6.2开始仅大更新会显示在这里\n" + "- 请注意：国内网络下载速率可能会不佳！！！\n" + "- 释出于" + new Date().toString() + "\n" + "- 使用自动化程式生成" + "\n" + "- 作者：爱笑的祥和是**";
        String dirPath = "C:\\Users\\jijiao\\IdeaProjects\\test\\src\\test3";
        String apkfile="app-release.apk"; //文件的路径
        String file="app-release.zip"; //文件的路径
        String outfile="out.zip"; //文件的路径
        String fileExtension = file.split("\\.")[1];
        int count=10;  //将文件切割成多少份
        try {
            FileUtils.copyFile(new File(FileOperater.getFilePath("E:\\AndroidStudioProjects\\April\\app\\release", apkfile)), new File(FileOperater.getFilePath(dirPath, apkfile)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String latestVersion = null;
        long latestVersionCode = 0;
        ApkFile apkFile = null;
        try {
            apkFile = new ApkFile(new File(FileOperater.getFilePath(dirPath, apkfile)));
            ApkMeta apkMeta = apkFile.getApkMeta();
            System.out.println("APP名：" + apkMeta.getLabel());
            //System.out.println(apkMeta.getPackageName());
            System.out.println("版本名：" + apkMeta.getVersionName());
            System.out.println("版本号：" + apkMeta.getVersionCode());
            latestVersion = apkMeta.getVersionName();
            latestVersionCode = apkMeta.getVersionCode();
            /*for (UseFeature feature : apkMeta.getUsesFeatures()) {
                System.out.println(feature.getName());
            }*/
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        ZipUtils.zipFiles(FileOperater.getFilePath(dirPath, file), FileOperater.getFilePath(dirPath, apkfile));
        SplitFileOperater splitFileOperater = new SplitFileOperater(fileExtension, dirPath);
        splitFileOperater.getSplitFile(file, count);//分割
        String[] fileNames = splitFileOperater.getSplitFileNames(file, count);
        String[] fileMD5s = splitFileOperater.getSplitFileMD5s(file, count);
        String[] fileSHA256s = splitFileOperater.getSplitFileSHA256s(file, count);
        long[] fileSizes = splitFileOperater.getSplitFileSizes(file, count);
        //splitFileOperater.merge(outfile, file,count);//合并
        appUpgradeInfo.setLatestVersion(latestVersion);
        appUpgradeInfo.setLatestVersionCode(latestVersionCode);
        appUpgradeInfo.setUrl("https://www.fjj.us/cache/app-release.apk");
        appUpgradeInfo.setSize(FileOperater.getFileSize(new File(FileOperater.getFilePath(dirPath, apkfile))));
        CheckCodes checkCodes = new CheckCodes();
        checkCodes.setMd5(FileOperater.getFileMD5(new File(FileOperater.getFilePath(dirPath, apkfile))));
        checkCodes.setSha256(FileOperater.getFileSHA256(new File(FileOperater.getFilePath(dirPath, apkfile))));
        appUpgradeInfo.setCheckCodes(checkCodes);
        String[] releaseNotes = releaseNotesString.split("\n");
        appUpgradeInfo.setReleaseNotes(releaseNotes);
        FileSplitInfo fileSplit = new FileSplitInfo();
        FileSplitItem[] fileSplitItems = new FileSplitItem[count];
        for (int i=0;i<fileNames.length;i++) {
             FileSplitItem fs = new FileSplitItem();
             CheckCodes checkCodes1 = new CheckCodes();
             checkCodes1.setMd5(fileMD5s[i]);
             checkCodes1.setSha256(fileSHA256s[i]);
             fs.setCheckCodes(checkCodes1);
             fs.setUrl("https://www.fjj.us/cache/" + fileNames[i]);
             fs.setSize(fileSizes[i]);
            fileSplitItems[i] = fs;
        }
        fileSplit.setFileSplitItem(fileSplitItems);
        fileSplit.setCount(count);
        fileSplit.setZipped(zipped);
        appUpgradeInfo.setFileSplitInfo(fileSplit);
        String result = JSON.toJSON(appUpgradeInfo).toString();
        //写入更新文件
        try {
            File file1 = new File(FileOperater.getFilePath(dirPath, "update-changelog.json"));
            FileOutputStream fileOutputStream = new FileOutputStream(file1);
            fileOutputStream.write(result.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String outDir = FileOperater.getFilePath(dirPath,"out");
        String outApkDir = FileOperater.getFilePath(dirPath,"out/cache");
        File file1 = new File(outApkDir);
        if(!file1.exists() || !file1.isDirectory()) {
            file1.mkdirs();
        }
        //删除运行中产生的zip包
        File zipfile = new File(FileOperater.getFilePath(dirPath, file));
        zipfile.delete();
        //复制分块文件到out目录下
        File fileList = new File(dirPath);
        File[] files = fileList.listFiles();
        for (File f: files) {
            if(f.getName().startsWith("app-release") && !f.getName().endsWith(".zip")) {
                try {
                    FileUtils.copyFile(f, new File(FileOperater.getFilePath(outApkDir, f.getName())));
                    f.delete();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //复制更新文件到out目录下
        File file2 = new File(FileOperater.getFilePath(dirPath, "update-changelog.json"));
        try {
            FileUtils.copyFile(file2, new File(FileOperater.getFilePath(outDir, file2.getName())));
            file2.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("运行完成！");
    }
}
