package raf.graffito.dsw.gui.swing.view;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class MyTabbedPane extends JTabbedPane {
    public void fillTabs(DefaultMutableTreeNode node)
    {
        String title=node.toString();
        JPanel panel= new JPanel();
        this.addTab(title,panel);

    }

}
