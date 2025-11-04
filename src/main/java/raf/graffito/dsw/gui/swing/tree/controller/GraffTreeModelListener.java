package raf.graffito.dsw.gui.swing.tree.controller;

import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.implementations.leaves.compositions.Presentation;
import raf.graffito.dsw.model.implementations.leaves.compositions.Project;
import raf.graffito.dsw.model.implementations.leaves.compositions.Workspace;

import javax.swing.*;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class GraffTreeModelListener implements TreeModelListener {


    @Override
    public void treeNodesChanged(TreeModelEvent e)
    {
        TreePath path=e.getTreePath();
        if(path==null) return;
        GraffTreeItem parent = (GraffTreeItem) path.getLastPathComponent();
        System.out.println(parent.getGraffNode().getName());
        int[] indices = e.getChildIndices();

        if (indices != null && indices.length > 0)
        {
            for (int index : indices) {
                GraffTreeItem child = (GraffTreeItem) parent.getChildAt(index);
                if(child.getGraffNode() instanceof Project) {
                    String newName = child.getGraffNode().getName();
                    MainFrame.getInstance().getRightPanel().update(null, newName);
                }
                else if(child.getGraffNode() instanceof Presentation)
                {
                    String newName = child.getGraffNode().getName();
                    MainFrame.getInstance().getRightPanel().update(newName,null);
                }


            }
        }
        else
        { //ako je workspace
            MainFrame.getInstance().getRightPanel().update("","");
        }


        /*
        JTree tree=(JTree)e.getSource();
        TreePath path=e.getTreePath();

        if (path==null) return;
        GraffTreeItem node= (GraffTreeItem) path.getLastPathComponent();
        String text = node.getGraffNode().getName();
        System.out.println("NGIG");

        if(node.getGraffNode() instanceof Project )
        {
            System.out.println("Projekat je bre");

            MainFrame.getInstance().getRightPanel().setProjectNameLabel(new JLabel(text));
            //MainFrame.getInstance().getRightPanel().update;

        }
        else if(node.getGraffNode() instanceof Presentation)
        {
            System.out.println("prese je bre");

            MainFrame.getInstance().getRightPanel().setPresentationNameLabel(new JLabel(text));
        }

         */

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
