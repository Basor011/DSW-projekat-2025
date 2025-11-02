package raf.graffito.dsw.controller;

import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;
import raf.graffito.dsw.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RemoveChildAction extends AbstractGraffAction {
    public RemoveChildAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,
                ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/remove.png"));
        putValue(NAME, "Remove Child");
        putValue(SHORT_DESCRIPTION, "Remove the selected project");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        GraffTreeItem selected = (GraffTreeItem) MainFrame.getInstance().getGraffTree().getSelectedNode();
        if(selected != null) {
            MainFrame.getInstance().getGraffTree().removeNode(selected);
        }
    }
}
