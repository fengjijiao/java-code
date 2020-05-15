package test4;
import java.awt.*;
import javax.swing.*;
public class test4 extends JFrame {
    private static test4 mInstance;

    test4() {
        GridLayout gridLayout = new GridLayout(6,1);
        setLayout(gridLayout);
        setSize(800,500);
        JMenuBar menuBar = new JMenuBar();
        add(menuBar);
        JMenu jMenuFile = new JMenu("文件");
        menuBar.add(jMenuFile);
        JMenuItem jMenuItemNewFile = new JMenuItem("新文件");
        jMenuFile.add(jMenuItemNewFile);
        JMenuItem jMenuItemOpenFile = new JMenuItem("打开...");
        jMenuFile.add(jMenuItemOpenFile);
        JMenuItem jMenuItemOpenRecentFile = new JMenuItem("打开近期");
        jMenuFile.add(jMenuItemOpenRecentFile);
        JMenuItem jMenuItemCloseProject = new JMenuItem("关闭项目");
        jMenuFile.add(jMenuItemCloseProject);
        JMenu jMenuEdit = new JMenu("编辑");
        menuBar.add(jMenuEdit);
        JMenuItem jMenuItemUnDo = new JMenuItem("撤回");
        jMenuEdit.add(jMenuItemUnDo);
        JMenuItem jMenuItemReDo = new JMenuItem("重做");
        jMenuEdit.add(jMenuItemReDo);
        JMenuItem jMenuItemCut = new JMenuItem("剪切");
        jMenuEdit.add(jMenuItemCut);
        JMenuItem jMenuItemCopy = new JMenuItem("复制");
        jMenuEdit.add(jMenuItemCopy);
        JMenuItem jMenuItemPaste = new JMenuItem("粘贴");
        jMenuEdit.add(jMenuItemPaste);
        JPanel OCPanel = new JPanel();
        add(OCPanel);
        JTextField jTextField = new JTextField("红火火恍恍惚惚");
        OCPanel.add(jTextField);
        setVisible(true);
    }

    public static void main(String[] args) {
        mInstance = new test4();
    }
}
