package raf.graffito.dsw.gui.swing.tree;

import raf.graffito.dsw.core.composite.compositions.Workspace;
import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;
import raf.graffito.dsw.gui.swing.tree.view.GraffTreeView;

public interface GraffTree {
    public GraffTreeView generateTree(Workspace root);
    public void addChild(GraffTreeItem root);
    public GraffTreeItem getSelectedNode();
}

