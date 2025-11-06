package raf.graffito.dsw.controller;

import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.tree.GraffTreeImplementation;
import raf.graffito.dsw.gui.swing.tree.decorator.ColourDecorator;
import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.implementations.leaves.compositions.Project;

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
        if(selected == null) {
            ApplicationFramework.getInstance().getMg().generateInfo("Molim vas izaberite cvor za brisanje");
                    return;
        }
        if(selected.getGraffNode() instanceof Project)
        {
            //MainFrame.getInstance().getTabbedPane().getProjectColor().entrySet().removeIf(entry->entry.getValue().equals(selected));
           MainFrame.getInstance().getTabbedPane().getDecoratedProjects().removeIf(cd -> cd.getGraffTreeItem().equals(selected));


            if(selected.equals(MainFrame.getInstance().getTabbedPane().getLatestNode()))
            {
                ((GraffTreeImplementation)MainFrame.getInstance().getGraffTree()).sendToAll("","");
                //MainFrame.getInstance().getRightPanel().update("","");
                MainFrame.getInstance().getTabbedPane().removeAll();
            }
        }
            MainFrame.getInstance().getGraffTree().removeNode(selected);

    }
}
