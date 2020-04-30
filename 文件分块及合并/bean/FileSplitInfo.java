package test3.bean;

public class FileSplitInfo
{
    private boolean zipped;

    private int count;

    private FileSplitItem[] fileSplitItem;

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

    public FileSplitItem[] getFileSplitItem ()
    {
        return fileSplitItem;
    }

    public void setFileSplitItem (FileSplitItem[] fileSplitItem)
    {
        this.fileSplitItem = fileSplitItem;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [zipped = "+zipped+", count = "+count+", fileSplitItem = "+fileSplitItem+"]";
    }
}