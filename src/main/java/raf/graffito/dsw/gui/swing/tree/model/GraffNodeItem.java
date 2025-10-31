package raf.graffito.dsw.gui.swing.tree.model;

import raf.graffito.dsw.core.composite.GraffNode;

import javax.swing.tree.DefaultMutableTreeNode;

public class GraffNodeItem extends DefaultMutableTreeNode {
    /// instanca cvora
    private GraffNode graffNode;

    public GraffNodeItem(GraffNode graffNode) {
        this.graffNode = graffNode;
    }

    @Override
    public String toString() {
        return graffNode.getName();
    }

    public void setName(String name) {
        this.graffNode.setName(name);
    }
}
