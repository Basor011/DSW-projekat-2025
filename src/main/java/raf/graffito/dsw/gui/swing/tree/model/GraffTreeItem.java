package raf.graffito.dsw.gui.swing.tree.model;

import raf.graffito.dsw.core.composite.GraffNode;

import javax.swing.tree.DefaultMutableTreeNode;

public class GraffTreeItem extends DefaultMutableTreeNode {
    /// instanca cvora
    private GraffNode graffNode;

    public GraffTreeItem(GraffNode graffNode) {
        this.graffNode = graffNode;
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

    public void setGraffNode(GraffNode graffNode) {
        this.graffNode = graffNode;
    }
}
