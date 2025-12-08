package raf.graffito.dsw.gui.swing.tree.controller;

import raf.graffito.dsw.gui.swing.tree.GraffTreeItem;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class GraffTreeSelectionListener implements TreeSelectionListener {

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath path = e.getPath();
        GraffTreeItem selectedItem = (GraffTreeItem) path.getLastPathComponent();
        System.out.println(selectedItem.getGraffNode().getName());
        System.out.println(e.getPath());
    }

}
