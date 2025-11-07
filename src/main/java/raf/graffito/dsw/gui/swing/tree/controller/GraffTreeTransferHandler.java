package raf.graffito.dsw.gui.swing.tree.controller;

import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;
import raf.graffito.dsw.gui.swing.tree.view.GraffTreeView;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.implementations.leaves.Slide;
import raf.graffito.dsw.model.implementations.leaves.compositions.Presentation;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class GraffTreeTransferHandler extends TransferHandler {
    private final DataFlavor nodeFlavor = new DataFlavor(GraffTreeItem.class, "GraffTreeItem");

    @Override
    protected Transferable createTransferable(JComponent c) {
        JTree tree = (JTree) c;
        GraffTreeItem item = (GraffTreeItem) tree.getLastSelectedPathComponent();

        if(item == null || !(item.getGraffNode() instanceof Slide)) {
            return null;
        }
        return new NodesTransferable(item);
    }

    @Override
    public int getSourceActions(JComponent c) {
        return MOVE;
    }

    @Override
    public boolean canImport(TransferSupport support) {
        if(!support.isDataFlavorSupported(nodeFlavor)) { return false; }
        if(!support.isDrop()) { return false; }

        JTree.DropLocation dl = (JTree.DropLocation) support.getDropLocation();
        TreePath dpath = dl.getPath();
        if(dpath == null) { return false; }

        GraffTreeItem dropTarget = (GraffTreeItem) dpath.getLastPathComponent();
        GraffNode targetNode = dropTarget.getGraffNode();

        if(!(targetNode instanceof Presentation)) return false;

        return true;
    }

    @Override
    public boolean importData(TransferSupport support) {
        if(!canImport(support)) { return false; }


        return false;
    }

    private class NodesTransferable implements Transferable{
        private final GraffTreeItem item;
        public NodesTransferable(GraffTreeItem item) {
            this.item = item;
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[] {nodeFlavor};
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return flavor.equals(nodeFlavor);
        }

        @Override
        public Object getTransferData(DataFlavor flavor) {
            return item;
        }
    }

}

