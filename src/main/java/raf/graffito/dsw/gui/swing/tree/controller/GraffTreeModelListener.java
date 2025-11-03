package raf.graffito.dsw.gui.swing.tree.controller;

import raf.graffito.dsw.gui.swing.view.MainFrame;

import javax.swing.*;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class GraffTreeModelListener implements TreeModelListener {


    @Override
    public void treeNodesChanged(TreeModelEvent e) {
        TreePath path=e.getTreePath();
        DefaultMutableTreeNode node=(DefaultMutableTreeNode)path.getLastPathComponent();
        String text=node.toString();
        if (path==null) return;
        System.out.println("NGIG");
        if(text.contains("Project"))
        {
            System.out.println("Projekat je bre");

            MainFrame.getInstance().getRightPanel().setProjectNameLabel(new JLabel(text));

        }
        else if(text.contains("Presentation"))
        {
            MainFrame.getInstance().getRightPanel().setPresentationNameLabel(new JLabel(text));
        }

    }

    @Override
    public void treeNodesInserted(TreeModelEvent e) {

    }

    @Override
    public void treeNodesRemoved(TreeModelEvent e) {



    }

    @Override
    public void treeStructureChanged(TreeModelEvent e) {

    }
}
