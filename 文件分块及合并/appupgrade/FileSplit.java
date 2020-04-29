package test3.appupgrade;

public class FileSplit
{
    private boolean zipped;

    private int count;

    private Files[] files;

    public boolean getZipped ()
    {
        return zipped;
    }

    public void setZipped (boolean zipped)
    {
        this.zipped = zipped;
    }

    public int getCount ()
    {
        return count;
    }

    public void setCount (int count)
    {
        this.count = count;
    }

    public Files[] getFiles ()
    {
        return files;
    }

    public void setFiles (Files[] files)
    {
        this.files = files;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [zipped = "+zipped+", count = "+count+", files = "+files+"]";
    }
}