package raf.graffito.dsw.gui.swing.tree.controller;

import raf.graffito.dsw.gui.swing.tree.view.GraffTreeView;
import raf.graffito.dsw.model.composite.GraffNode;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

public class GraffTreeTransferHandler extends TransferHandler {
    private GraffTreeView graffTreeView;
    private DataFlavor nodeFlavor; //nas prenos, treba da bude tipa GraffNode, specificnije Slide

    public GraffTreeTransferHandler(GraffTreeView graffTreeView) {
        this.graffTreeView = graffTreeView;
        this.nodeFlavor = new DataFlavor(GraffNode.class, "GraffNode");
    }

    @Override //pamtimo koji cvor prenosimo
    protected Transferable createTransferable(JComponent c) {
        JTree tree = (JTree) c;
        TreePath path = tree.getSelectionPath();
        if(path != null) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
            GraffNode graffNode = (GraffNode) node.getUserObject();

        }
        return null;
    }

    @Override
    public boolean canImport(TransferSupport support) {
        if(!support.isDrop()) return false;

        if(!support.isDataFlavorSupported(nodeFlavor)) return false;
        return false;
    }
}
