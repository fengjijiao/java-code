package test3.bean;

public class AppUpgradeInfo
{
    private CheckCodes checkCodes;

    private FileSplitInfo fileSplitInfo;

    private String[] releaseNotes;

    private String releaseNotesString;

    private long size;

    private String latestVersion;

    private long latestVersionCode;

    private String url;

    public CheckCodes getCheckCodes ()
    {
        return checkCodes;
    }

    public void setCheckCodes (CheckCodes checkCodes)
    {
        this.checkCodes = checkCodes;
    }

    public FileSplitInfo getFileSplitInfo ()
    {
        return fileSplitInfo;
    }

    public void setFileSplitInfo (FileSplitInfo fileSplitInfo)
    {
        this.fileSplitInfo = fileSplitInfo;
    }

    public String[] getReleaseNotes ()
    {
        return releaseNotes;
    }

    public void setReleaseNotes (String[] releaseNotes)
    {
        this.releaseNotes = releaseNotes;
    }

    public String getReleaseNotesString ()
    {
        String releaseNotesString = "";
        for(String note: releaseNotes) {
            releaseNotesString += note + "\n";
        }
        return releaseNotesString;
    }

    public long getSize ()
    {
        return size;
    }

    public void setSize (long size)
    {
        this.size = size;
    }

    public String getLatestVersion ()
    {
        return latestVersion;
    }

    public void setLatestVersion (String latestVersion)
    {
        this.latestVersion = latestVersion;
    }

    public long getLatestVersionCode ()
    {
        return latestVersionCode;
    }

    public void setLatestVersionCode (long latestVersionCode)
    {
        this.latestVersionCode = latestVersionCode;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [checkCodes = "+checkCodes+", fileSplitInfo = "+fileSplitInfo+", releaseNotes = "+releaseNotes+", size = "+size+", latestVersion = "+latestVersion+", latestVersionCode = "+latestVersionCode+", url = "+url+"]";
    }
}