package raf.graffito.dsw.gui.swing.tree.observer;

public interface TBPublisher
{
    public void addSubscriber(TBSubscriber subscriber);
    public void removeSubscriber(TBSubscriber subscriber);
    public void sendToAll(String presentationName, String projectName);


}
