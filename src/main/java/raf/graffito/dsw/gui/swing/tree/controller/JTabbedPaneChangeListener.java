package raf.graffito.dsw.gui.swing.tree.controller;

import raf.graffito.dsw.gui.swing.view.MainFrame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JTabbedPaneChangeListener implements ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
       JTabbedPane tabbedPane = (JTabbedPane) e.getSource();
       int index = tabbedPane.getSelectedIndex();
       if (index == -1) return; //ako ne postoje tabovi return
       index= MainFrame.getInstance().getTabbedPane().getSelectedIndex();
       String text=MainFrame.getInstance().getTabbedPane().getTitleAt(index);
       String text2=MainFrame.getInstance().getTabbedPane().getLatestNode().toString();

       MainFrame.getInstance().getRightPanel().update(text,text2);

    }
}
