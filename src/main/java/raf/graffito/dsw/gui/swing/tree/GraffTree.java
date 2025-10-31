package raf.graffito.dsw.gui.swing.tree;

import raf.graffito.dsw.core.composite.compositions.Workspace;
import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;

public interface GraffTree {
    public GraffTree generateTree(Workspace root);
    public void addChild(GraffTreeItem root);
    public GraffTreeItem getSelectedNode();
}

