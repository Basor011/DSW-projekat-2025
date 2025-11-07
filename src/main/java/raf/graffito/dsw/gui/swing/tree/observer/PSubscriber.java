package raf.graffito.dsw.gui.swing.tree.observer;

import javax.swing.tree.DefaultMutableTreeNode;

public interface PSubscriber {
    void update(DefaultMutableTreeNode node); //vrati se
}
