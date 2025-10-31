package raf.graffito.dsw.gui.swing.tree;

import raf.graffito.dsw.core.composite.GraffNode;
import raf.graffito.dsw.core.composite.compositions.Workspace;
import raf.graffito.dsw.gui.swing.tree.model.GraffNodeItem;

public interface GraffTree {
    public GraffTree generateTree(Workspace root);
    public void addChild(GraffNodeItem root);
    public GraffNodeItem getSelectedNode();
}

