package raf.graffito.dsw.controller;

import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.tree.GraffTreeImplementation;
import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;
import raf.graffito.dsw.gui.swing.tree.observer.Notification;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.implementations.leaves.compositions.Presentation;
import raf.graffito.dsw.model.implementations.leaves.compositions.Project;

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
        if(selected == null)
        {
            ApplicationFramework.getInstance().getMg().generateInfo("Molim vas izaberite cvor za brisanje");
                    return;
        }

        if(selected.getGraffNode() instanceof Project)
        {

            ((GraffTreeImplementation)MainFrame.getInstance().getGraffTree()).sendingToAll(Notification.PROJECT_DELETED,selected);
        }
        else if (selected.getGraffNode() instanceof  Presentation)
        {
            ((GraffTreeImplementation)MainFrame.getInstance().getGraffTree()).sendingToAll(Notification.PRESENTATION_DELETED,selected);
        }
        else {
            ((GraffTreeImplementation)MainFrame.getInstance().getGraffTree()).sendingToAll(Notification.SLIDE_DELETED,selected);
        }

    }
}
