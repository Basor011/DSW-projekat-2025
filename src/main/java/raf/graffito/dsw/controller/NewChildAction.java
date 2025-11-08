package raf.graffito.dsw.controller;

import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.tree.model.GraffTreeItem;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.implementations.leaves.Slide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewChildAction extends AbstractGraffAction {
    public NewChildAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_M,
                ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/plus.png"));
        putValue(NAME, "New Project");
        putValue(SHORT_DESCRIPTION, "Create a new child?");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GraffTreeItem selected = (GraffTreeItem) MainFrame.getInstance().getGraffTree().getSelectedNode();
        if(selected==null)
        {
            ApplicationFramework.getInstance().getMg().generateInfo("Molim vas izaberite cvor");
            return;
        }else if(selected.getGraffNode() instanceof Slide) {
            ApplicationFramework.getInstance().getMg().generateError("Slide ne moze sadrzati novi tip cvora");
            return;
        }
        MainFrame.getInstance().getGraffTree().addChild(selected);
    }
}
