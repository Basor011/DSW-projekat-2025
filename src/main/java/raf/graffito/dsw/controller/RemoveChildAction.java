package raf.graffito.dsw.controller;

import raf.graffito.dsw.gui.swing.tree.GraffTreeImplementation;
import raf.graffito.dsw.gui.swing.tree.GraffTreeItem;
import raf.graffito.dsw.gui.swing.tree.observer.Notification;
import raf.graffito.dsw.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RemoveChildAction extends AbstractGraffAction {
    public RemoveChildAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,
                ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/icons for buttons/minus.png"));
        putValue(NAME, "Remove Child");
        putValue(SHORT_DESCRIPTION, "Remove the selected child?");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        GraffTreeItem selected = (GraffTreeItem) MainFrame.getInstance().getGraffTree().getSelectedNode();
        ((GraffTreeImplementation)MainFrame.getInstance().getGraffTree()).sendingToAll(Notification.NODE_DELETED,selected);
    }
}
