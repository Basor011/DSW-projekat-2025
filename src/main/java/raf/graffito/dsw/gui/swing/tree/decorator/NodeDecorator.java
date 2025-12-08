package raf.graffito.dsw.gui.swing.tree.decorator;

import raf.graffito.dsw.gui.swing.tree.GraffTreeItem;

public abstract class NodeDecorator implements iNode {
    GraffTreeItem decoratedItem;

    public NodeDecorator(GraffTreeItem decoratedItem) {
        this.decoratedItem = decoratedItem;
    }

    public GraffTreeItem getDecoratedItem() {
        return decoratedItem;
    }
}
