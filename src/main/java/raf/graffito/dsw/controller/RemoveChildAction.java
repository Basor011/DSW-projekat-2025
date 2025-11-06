package raf.graffito.dsw.controller;

import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.gui.swing.model.implementations.leaves.compositions.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RemoveChildAction extends AbstractGraffAction {
    public RemoveChildAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,
                ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/minus.png"));
        putValue(NAME, "Remove Child");
        putValue(SHORT_DESCRIPTION, "Remove the selected child?");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        GraffTreeItem selected = (GraffTreeItem) MainFrame.getInstance().getGraffTree().getSelectedNode();
        if(selected != null) {
        if(selected.getGraffNode() instanceof Project)
        {
            MainFrame.getInstance().getTabbedPane().getProjectColor().entrySet().removeIf(entry->entry.getValue().equals(selected));
            if(selected.equals(MainFrame.getInstance().getTabbedPane().getLatestNode()))
            {
                System.out.println("NIGGA");
                MainFrame.getInstance().getRightPanel().update("","");
                MainFrame.getInstance().getTabbedPane().removeAll();
            }
        }
            MainFrame.getInstance().getGraffTree().removeNode(selected);
        }
    }
}
