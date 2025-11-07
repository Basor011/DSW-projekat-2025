package raf.graffito.dsw.gui.swing.tree.controller;

import com.sun.tools.javac.Main;
import raf.graffito.dsw.gui.swing.tree.GraffTreeImplementation;
import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;
import raf.graffito.dsw.gui.swing.tree.observer.Notification;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.gui.swing.view.PresentationView;
import raf.graffito.dsw.model.implementations.leaves.compositions.Presentation;
import raf.graffito.dsw.model.implementations.leaves.compositions.Project;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
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

        if (indices != null && indices.length > 0)
        {
            for (int index : indices) {
                GraffTreeItem child = (GraffTreeItem) parent.getChildAt(index);
                if(child.getGraffNode() instanceof Project) {
                   String newName = child.getGraffNode().getName();

                    ((GraffTreeImplementation)MainFrame.getInstance().getGraffTree()).sendToAll(null, newName);
                }
                else if(child.getGraffNode() instanceof Presentation)   // PRESENTATION RENAMED
                {
                    ((GraffTreeImplementation)MainFrame.getInstance().getGraffTree()).sendingToAll(Notification.PRESENTATION_RENAMED,child);
                    /*
                    GraffTreeItem test=((PresentationView)MainFrame.getInstance().getTabbedPane().getSelectedComponent()).getPresentation(); // ako je renamed prez trenutno otvorena
                    if(test.equals(child)){
                        String newName = child.getGraffNode().getName();
                        System.out.println("Kachigga");
                        MainFrame.getInstance().getTabbedPane().getSelectedComponent().setName(newName);
                        ((GraffTreeImplementation) MainFrame.getInstance().getGraffTree()).sendToAll(newName, null);
                    }

                     */
                   // MainFrame.getInstance().getTabbedPane().recoverTabs(parent);
                }
            }
        }
        else
        { //ako je workspace
           // MainFrame.getInstance().getRightPanel().update("","");
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
                if(child.getGraffNode() instanceof Presentation)
                {
                    if(((DefaultMutableTreeNode)parent).equals(MainFrame.getInstance().getTabbedPane().getLatestNode()))
                    {
                     //  System.out.println("ehehehehehehehe");
                        MainFrame.getInstance().getTabbedPane().recoverTabs(parent);
                    }
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
