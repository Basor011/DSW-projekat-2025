package raf.graffito.dsw.gui.swing.tree.model;

import raf.graffito.dsw.gui.swing.tree.decorator.iNode;
import raf.graffito.dsw.model.composite.GraffNode;

import javax.swing.tree.DefaultMutableTreeNode;

public class GraffTreeItem extends DefaultMutableTreeNode implements iNode {
    /// instanca cvora
    private GraffNode graffNode;

    public GraffTreeItem(GraffNode nodeModel) {
        this.graffNode = nodeModel;

    }

    @Override
    public String toString() {
        return graffNode.getName();
    }

    public void setName(String name) {
        this.graffNode.setName(name);
    }

    public GraffNode getGraffNode() {
        return graffNode;
    }
}
