package raf.graffito.dsw.controller.program_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.gui.swing.view.UploadSaveView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SaveOrLoadAction extends AbstractGraffAction {
    public SaveOrLoadAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,
                ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/icons for buttons/upload.png"));
        putValue(NAME, "Save/Upload");
        putValue(SHORT_DESCRIPTION, "Open the save or upload window");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        UploadSaveView uploadSaveView = new UploadSaveView();
        uploadSaveView.setLocationRelativeTo(null);
        uploadSaveView.setVisible(true);

    }

    }




