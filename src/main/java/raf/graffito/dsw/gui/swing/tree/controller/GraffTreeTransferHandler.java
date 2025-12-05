package raf.graffito.dsw.gui.swing.tree.controller;

import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.compositions.Slide;
import raf.graffito.dsw.model.composite.compositions.Presentation;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

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

        GraffTreeItem dropTarget = (GraffTreeItem) dpath.getLastPathComponent(); //item na koji smo bacili
        GraffNode targetNode = dropTarget.getGraffNode();

        return targetNode instanceof Presentation;
    }

    @Override
    public boolean importData(TransferSupport support) {

        if(!canImport(support)) { return false; }

        GraffTreeItem transferredItem;
        try {
            Transferable t = support.getTransferable();
            transferredItem = (GraffTreeItem) t.getTransferData(nodeFlavor);
        } catch(UnsupportedFlavorException | IOException ufe) {
            ApplicationFramework.getInstance().getMg().generateError("Greska pri premestanju slajdova");
            return false;
        }

        JTree.DropLocation dl = (JTree.DropLocation) support.getDropLocation();//gde bacamo slide
        int childIndex = dl.getChildIndex();
        TreePath destination = dl.getPath();
        GraffTreeItem targetParent = (GraffTreeItem) destination.getLastPathComponent();


        GraffNode srcparentNode = transferredItem.getGraffNode().getParent(); //pocetni parent
        GraffNode dstparentNode = targetParent.getGraffNode(); //zavrsni parent

        if(!(srcparentNode instanceof Presentation) || !(dstparentNode instanceof Presentation)) return false; //ne mozemo van prez
        if(srcparentNode != dstparentNode) return false; //ve mozemo van svoje prezentacije

        JTree tree = (JTree) support.getComponent();
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();


        int index = childIndex;
        if(childIndex == -1) index = targetParent.getChildCount();

        GraffTreeItem oldParent = (GraffTreeItem) transferredItem.getParent();
        int oldIndex = oldParent.getIndex(transferredItem);
        model.removeNodeFromParent(transferredItem);

        if (oldParent == targetParent && oldIndex < index) {
            index--;
        }

        model.insertNodeInto(transferredItem, targetParent, index);
        //tree.scrollPathToVisible(new TreePath(transferredItem.getPath()));
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

