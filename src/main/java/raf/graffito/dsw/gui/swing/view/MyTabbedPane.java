package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.tree.GraffTreeImplementation;
import raf.graffito.dsw.gui.swing.tree.controller.JTabbedPaneChangeListener;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MyTabbedPane extends JTabbedPane {

    private Map<Color, DefaultMutableTreeNode> projectColor;
    private DefaultMutableTreeNode latestNode;
    private boolean isOpened;

    public MyTabbedPane(Map<Color, DefaultMutableTreeNode> projectColor) {
        this.projectColor = projectColor;
        this.addChangeListener(new JTabbedPaneChangeListener());
        this.projectColor = new HashMap<>();
        this.isOpened=false;


    }

    public Map<Color, DefaultMutableTreeNode> getProjectColor() {
        return projectColor;
    }

    public void fillTabs(DefaultMutableTreeNode node, Color colour) {

        this.removeAll();
        latestNode=node;
        for (int i=0; i < node.getChildCount(); i++)
        {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getChildAt(i);
            //System.out.println(child.toString() + " Test");
            if (projectColor.containsKey(colour)) {
                ApplicationFramework.getInstance().getMg().generateError("Nedostupna boja");
                return;
            }
            String title = child.toString();
            JPanel panel = new JPanel();
            this.addTab(title, panel);
            this.setBackgroundAt(i, colour);
            this.setForegroundAt(i, Color.BLACK);
            isOpened=true;

        }
        projectColor.put(colour,node);
    }

    public void recoverTabs(DefaultMutableTreeNode node)
    {
        this.removeAll();
        Color color=Color.GREEN;
        latestNode=node;
        for(Map.Entry<Color,DefaultMutableTreeNode> entry : projectColor.entrySet())
        {
            if(entry.getValue().equals(node))
            {
                 color=entry.getKey();
            }
        }
        for(int i=0;i<node.getChildCount();i++)
        {
            DefaultMutableTreeNode child=(DefaultMutableTreeNode) node.getChildAt(i);
            String title=child.toString();
            JPanel panel=new JPanel();
            this.addTab(title,panel);
            this.setBackgroundAt(i,color);
            this.setForegroundAt(i,Color.BLACK);
        }
    }

    public DefaultMutableTreeNode getLatestNode() {
        return latestNode;
    }

    public boolean isOpened() {
        return isOpened;
    }
}

