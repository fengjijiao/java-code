package test3.appupgrade;

public class AppUpgrade
{
    private CheckCodes checkCodes;

    private String[] releaseNotes;

    private String latestVersion;

    private int latestVersionCode;

    private String url;

    private FileSplit fileSplit;

    public CheckCodes getCheckCodes ()
    {
        return checkCodes;
    }

    public void setCheckCodes (CheckCodes checkCodes)
    {
        this.checkCodes = checkCodes;
    }

    public String[] getReleaseNotes ()
    {
        return releaseNotes;
    }

    public String getReleaseNotesString ()
    {
        StringBuilder res = new StringBuilder();
        for(String note: releaseNotes) {
            res.append(note).append("\n");
        }
        return res.toString();
    }

    public void setReleaseNotes (String[] releaseNotes)
    {
        this.releaseNotes = releaseNotes;
    }

    public String getLatestVersion ()
    {
        return latestVersion;
    }

    public void setLatestVersion (String latestVersion)
    {
        this.latestVersion = latestVersion;
    }

    public int getLatestVersionCode ()
    {
        return latestVersionCode;
    }

    public void setLatestVersionCode (int latestVersionCode)
    {
        this.latestVersionCode = latestVersionCode;
    }

    public String getUrl ()
    {
        return url;
    }

    public String getUrlToDownload() {
        return url;
    }
    public void setUrl (String url)
    {
        this.url = url;
    }

    public FileSplit getFileSplit ()
    {
        return fileSplit;
    }

    public void setFileSplit (FileSplit fileSplit)
    {
        this.fileSplit = fileSplit;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [checkCodes = "+checkCodes+", releaseNotes = "+releaseNotes+", latestVersion = "+latestVersion+", latestVersionCode = "+latestVersionCode+", url = "+url+", fileSplit = "+fileSplit+"]";
    }
}