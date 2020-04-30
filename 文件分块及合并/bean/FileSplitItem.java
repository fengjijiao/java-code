package test3.bean;

public class FileSplitItem
{
    private CheckCodes checkCodes;

    private long size;

    private String url;

    public CheckCodes getCheckCodes ()
    {
        return checkCodes;
    }

    public void setCheckCodes (CheckCodes checkCodes)
    {
        this.checkCodes = checkCodes;
    }

    public long getSize ()
    {
        return size;
    }

    public void setSize (long size)
    {
        this.size = size;
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
        return "ClassPojo [checkCodes = "+checkCodes+", size = "+size+", url = "+url+"]";
    }
}