package test3.appupgrade;

public class Files
{
    private CheckCodes checkCodes;

    private String url;

    public CheckCodes getCheckCodes ()
    {
        return checkCodes;
    }

    public void setCheckCodes (CheckCodes checkCodes)
    {
        this.checkCodes = checkCodes;
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
        return "ClassPojo [checkCodes = "+checkCodes+", url = "+url+"]";
    }
}