package raf.graffito.dsw.gui.swing.tree.controller;

import raf.graffito.dsw.gui.swing.tree.GraffTreeItem;

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
        parent.SortRenamedNodes(indices,parent);
    }

    @Override
    public void treeNodesInserted(TreeModelEvent e) {
        TreePath path = e.getTreePath();
        if (path == null) return;
        GraffTreeItem parent = (GraffTreeItem) path.getLastPathComponent();
        System.out.println(parent.getGraffNode().getName());
        int[] indices = e.getChildIndices();
        parent.sortInsertedNodes(indices, parent);

    }
    @Override
    public void treeNodesRemoved(TreeModelEvent e) {

    }

    @Override
    public void treeStructureChanged(TreeModelEvent e) {

    }
}
