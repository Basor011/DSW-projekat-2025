package raf.graffito.dsw.gui.swing.tree.observer;

import javax.swing.tree.DefaultMutableTreeNode;

public interface PPublisher {
    void addSub(PSubscriber subscriber);
    void removeSub(PSubscriber subscriber);
    void notify(DefaultMutableTreeNode node);
}
