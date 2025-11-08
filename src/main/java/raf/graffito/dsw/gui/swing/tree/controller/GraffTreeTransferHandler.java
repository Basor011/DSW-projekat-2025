package raf.graffito.dsw.gui.swing.tree.controller;

import com.sun.source.tree.Tree;
import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;
import raf.graffito.dsw.model.composite.GraffNode;
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
import java.util.List;

public class GraffTreeTransferHandler extends TransferHandler {
    private final DataFlavor nodeFlavor = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType + ";class=" + GraffTreeItem.class.getName(), "GraffTreeItem");

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

        JTree.DropLocation dl = (JTree.DropLocation) support.getDropLocation(); //dobavljamo drop location
        TreePath dpath = dl.getPath();
        if(dpath == null) { return false; }

        GraffTreeItem dropTarget = (GraffTreeItem) dpath.getLastPathComponent();
        GraffNode targetNode = dropTarget.getGraffNode();

        if(!(targetNode instanceof Presentation)) return false;

        return true;
    }

    @Override
    public boolean importData(TransferSupport support) {


        /*
        if(!canImport(support)) { return false; }

        // Extract transfer data.
        DefaultMutableTreeNode[] nodes = null;
        try {
            Transferable t = support.getTransferable();
            nodes = (DefaultMutableTreeNode[])t.getTransferData(nodeFlavor);
        } catch(UnsupportedFlavorException ufe) {
            System.out.println("UnsupportedFlavor: " + ufe.getMessage());
        } catch(java.io.IOException ioe) {
            System.out.println("I/O error: " + ioe.getMessage());
        }

        //droplocation info
        JTree.DropLocation dl = (JTree.DropLocation) support.getDropLocation();
        int childIndex = dl.getChildIndex();

        TreePath destination = dl.getPath();
        DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) destination.getLastPathComponent();
        JTree tree = (JTree) support.getComponent();
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
        //konfiguracija za dropnode
        int index = childIndex;
        if(childIndex == -1) index = parentNode.getChildCount();
        //dodajemo podatke u model
        for(int i = 0; i < nodes.length; i++) model.insertNodeInto(nodes[i], parentNode, i++);
        model.reload();
        return true;

         */
        if(!canImport(support)) { return false; }


        GraffTreeItem transferredItem = null;
        try {
            Transferable t = support.getTransferable();
            transferredItem = (GraffTreeItem) t.getTransferData(nodeFlavor);
        } catch(UnsupportedFlavorException ufe) {
            ApplicationFramework.getInstance().getMg().generateError("Greska pri dnd");
            return false;
        } catch(java.io.IOException ioe) {
            ApplicationFramework.getInstance().getMg().generateError("Greska");
            return false;
        }


        JTree.DropLocation dl = (JTree.DropLocation) support.getDropLocation();
        int childIndex = dl.getChildIndex();

        TreePath destination = dl.getPath();
        GraffTreeItem parentNode = (GraffTreeItem) destination.getLastPathComponent();
        JTree tree = (JTree) support.getComponent();
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();


        int index = childIndex;
        if(childIndex == -1) index = parentNode.getChildCount();


        model.insertNodeInto(transferredItem, parentNode, index);

        return true;
    }

    private class NodesTransferable implements Transferable {
        private final GraffTreeItem item;

        public NodesTransferable(GraffTreeItem item) {
            this.item = item;
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{nodeFlavor};
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return nodeFlavor.equals(flavor);
        }

        @Override
        public Object getTransferData(DataFlavor flavor) {
            return item;
        }

    }

}

