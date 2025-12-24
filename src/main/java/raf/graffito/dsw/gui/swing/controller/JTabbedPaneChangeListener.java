package raf.graffito.dsw.gui.swing.controller;

import raf.graffito.dsw.gui.swing.tree.GraffTreeImplementation;
import raf.graffito.dsw.gui.swing.tree.observer.Notification;
import raf.graffito.dsw.gui.swing.view.MainFrame;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JTabbedPaneChangeListener implements ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e)
    {
        ((GraffTreeImplementation)MainFrame.getInstance().getGraffTree()).sendingToAll(Notification.TAB_CHANGED,null);
    }
}
