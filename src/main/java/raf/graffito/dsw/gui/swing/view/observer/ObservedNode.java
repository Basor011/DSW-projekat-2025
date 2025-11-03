package raf.graffito.dsw.gui.swing.view.observer;



public interface ObservedNode {
    public void addPanelSubscriber(ProjectObserver projectObserver);
    public void removePanelSubscriber(ProjectObserver projectObserver);
    public void notifyAll(String content);
}
