package raf.graffito.dsw.controller.serializer_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.composite.compositions.Project;
import raf.graffito.dsw.model.serializer.Jackson;
import raf.graffito.dsw.model.serializer.Serializer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class SaveAsAction extends AbstractGraffAction {
    private Serializer serializer;
    private Project project;
    public SaveAsAction() {
        putValue(NAME, "Save as");
        putValue(SHORT_DESCRIPTION,"Save somewhere else");
        serializer=new Jackson();
    }
    private void init()
    {
        if (MainFrame.getInstance().getTabbedPane().getLatestNode() == null) return;
        project = (Project) MainFrame.getInstance().getTabbedPane().getLatestNode().getGraffNode();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        init();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Izaberi direktorijum za projekat");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int userSelection = fileChooser.showSaveDialog(MainFrame.getInstance());

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File chosenDir = fileChooser.getSelectedFile();
            File fileToSave = new File(chosenDir, project.getName().replaceAll("\\s+", "_") + ".json");

            serializer.saveProject(project, fileToSave);
            MainFrame.getInstance().setDefaultFilePath(chosenDir);


        }

    }
}
