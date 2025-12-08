package raf.graffito.dsw.gui.swing.tree.observer;

import raf.graffito.dsw.gui.swing.tree.GraffTreeItem;

public interface PPublisher {
    public void addSubscriber(PSubscriber subscriber);
    public void removeSubscriber(PSubscriber subscriber);
    public void sendingToAll(Notification notification, GraffTreeItem node);
}
