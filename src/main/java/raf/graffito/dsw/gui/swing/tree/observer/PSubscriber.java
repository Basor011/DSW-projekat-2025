package raf.graffito.dsw.gui.swing.tree.observer;

import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;

public interface PSubscriber {
    void update(Notification notification, GraffTreeItem node);
}
