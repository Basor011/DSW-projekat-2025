package raf.graffito.dsw.controller.state_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.gui.swing.view.ImageListView;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.proxy.ImageProxy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class InsertImagesAction extends AbstractGraffAction {

    public InsertImagesAction() {
        putValue(SMALL_ICON, loadIcon("/images/imageelement - Copy.png")); // Postavljanje ikonice
        putValue(SHORT_DESCRIPTION, "Insert a new image?");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ImageListView view = MainFrame.getInstance().getRightPanel().getImageListView();
        if(view == null) return;

        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            for(File file : chooser.getSelectedFiles()) {
                view.addImg(new ImageProxy(file.getAbsolutePath()));
            }
        }
    }
}
