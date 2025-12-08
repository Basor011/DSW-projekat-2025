package raf.graffito.dsw.gui.swing.tree;

import raf.graffito.dsw.model.composite.compositions.Workspace;
import raf.graffito.dsw.gui.swing.tree.view.GraffTreeView;

public interface GraffTree {
    public GraffTreeView generateTree(Workspace root);
    public void addChild(GraffTreeItem root);
    public void removeNode(GraffTreeItem node);
    void addElement(GraffTreeItem element);
    public GraffTreeItem getSelectedNode();
}

