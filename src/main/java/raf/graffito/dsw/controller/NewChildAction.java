package raf.graffito.dsw.controller;

import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.tree.GraffTreeItem;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.composite.compositions.Slide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewChildAction extends AbstractGraffAction {
    public NewChildAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_M,
                ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/icons for buttons/plus.png"));
        putValue(NAME, "New Project");
        putValue(SHORT_DESCRIPTION, "Create a new child?");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GraffTreeItem selected = (GraffTreeItem) MainFrame.getInstance().getGraffTree().getSelectedNode();
        if(selected==null) {
            ApplicationFramework.getInstance().getMg().generateInfo("Moras da odabereš čemu ćeš dodati novi čvor");
            return;
        }else if(selected.getGraffNode() instanceof Slide) {
            ApplicationFramework.getInstance().getMg().generateError("Slajd ne može da sadrži decu");
            return;
        }
        MainFrame.getInstance().getGraffTree().addChild(selected);
    }
}
