package raf.graffito.dsw.gui.swing.tree.controller;

import raf.graffito.dsw.gui.swing.tree.GraffTreeImplementation;
import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;
import raf.graffito.dsw.gui.swing.tree.observer.Notification;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.implementations.leaves.compositions.Presentation;
import raf.graffito.dsw.model.implementations.leaves.compositions.Project;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;

public class GraffTreeModelListener implements TreeModelListener {


    @Override
    public void treeNodesChanged(TreeModelEvent e) // nodes renamed
    {
        TreePath path=e.getTreePath();
        if(path==null) return;
        GraffTreeItem parent = (GraffTreeItem) path.getLastPathComponent();
        System.out.println(parent.getGraffNode().getName());
        int[] indices = e.getChildIndices();
        //parent.SortRenamedNodes(indices,parent);


        if (indices != null && indices.length > 0)
        {
            for (int index : indices) {
                GraffTreeItem child = (GraffTreeItem) parent.getChildAt(index);
                if(child.getGraffNode() instanceof Project)
                {
                    ((GraffTreeImplementation)MainFrame.getInstance().getGraffTree()).sendingToAll(Notification.PROJECT_RENAMED,child);
                }
                else if(child.getGraffNode() instanceof Presentation)   /// PRESENTATION RENAMED
                {
                    ((GraffTreeImplementation)MainFrame.getInstance().getGraffTree()).sendingToAll(Notification.PRESENTATION_RENAMED,child);
                }
            }
        }
        else ///  WORKSPACE
        {
            ((GraffTreeImplementation)MainFrame.getInstance().getGraffTree()).sendToAll("", "");
        }


    }

    @Override
    public void treeNodesInserted(TreeModelEvent e)
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
                if(child.getGraffNode() instanceof Presentation) ///  PRESENTATION INSERTED
                {
                    ((GraffTreeImplementation)MainFrame.getInstance().getGraffTree()).sendingToAll(Notification.PRESENTATION_INSERTED,child);
                }
            }
        }
    }

    @Override
    public void treeNodesRemoved(TreeModelEvent e) {

    }

    @Override
    public void treeStructureChanged(TreeModelEvent e) {

    }
}
