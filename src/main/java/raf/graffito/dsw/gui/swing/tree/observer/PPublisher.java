package raf.graffito.dsw.gui.swing.tree.observer;

public interface PPublisher {
    public void addSubscriber(PSubscriber subscriber);
    public void removeSubscriber(PSubscriber subscriber);
    public void sendingToAll(Notification notification, Object node);
}
