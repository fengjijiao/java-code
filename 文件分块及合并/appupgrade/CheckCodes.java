package test3.appupgrade;


public class CheckCodes
{
    private String sha256;

    private String md5;

    public String getSha256 ()
    {
        return sha256;
    }

    public void setSha256 (String sha256)
    {
        this.sha256 = sha256;
    }

    public String getMd5 ()
    {
        return md5;
    }

    public void setMd5 (String md5)
    {
        this.md5 = md5;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [sha256 = "+sha256+", md5 = "+md5+"]";
    }
}