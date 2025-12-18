package raf.graffito.dsw.controller.serializer_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.composite.compositions.Project;
import raf.graffito.dsw.model.serializer.Jackson;
import raf.graffito.dsw.model.serializer.Serializer;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.File;

public class LoadAction extends AbstractGraffAction {
    private Serializer serializer;

    public LoadAction() {
        putValue(NAME, "Load Project");
        putValue(SHORT_DESCRIPTION, "Load a project");
        serializer = new Jackson();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Otvori JSON projekat");
        fileChooser.setFileFilter(new FileNameExtensionFilter("JSON Files", "json"));

        int userSelection = fileChooser.showOpenDialog(MainFrame.getInstance());

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToLoad = fileChooser.getSelectedFile();
            Project loadedProject = serializer.loadProject(fileToLoad);

            if (loadedProject != null) {
                //MainFrame.getInstance().getGraffTree(). // ne znam kako da dodam u jtree
            }


        }

    }
}