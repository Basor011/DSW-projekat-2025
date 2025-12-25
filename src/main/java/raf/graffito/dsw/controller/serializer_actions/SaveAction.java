package raf.graffito.dsw.controller.serializer_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.composite.compositions.Project;
import raf.graffito.dsw.model.serializer.Jackson;
import raf.graffito.dsw.model.serializer.Serializer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class SaveAction extends AbstractGraffAction {
    private Serializer serializer;
    private Project project;
    private File filepath;


    public SaveAction() {
        serializer = new Jackson();
        putValue(NAME, "Save Project");
        putValue(SHORT_DESCRIPTION, "Save the current project");

    }
    private void init()
    {
        if (MainFrame.getInstance().getTabbedPane().getLatestNode() == null) return;
        project = (Project) MainFrame.getInstance().getTabbedPane().getLatestNode().getGraffNode();
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        init();
        if (project == null) { ApplicationFramework.getInstance().getMg().generateError("Nemate otvoren projekat"); return;}
        if(ApplicationFramework.getInstance().getCommandManager().getHistory().isEmpty() && !project.isIzmenjen()) ApplicationFramework.getInstance().getMg().generateError("Niste izmenili projekat");

        if (e.getActionCommand().equals("template"))
        {
            File fileToSave = new File(MainFrame.getInstance().getTemplatePath(), project.getName().replaceAll("\\s+", "_") + ".json");
            serializer.saveProject(project, fileToSave);
            project.setIzmenjen(false);

        }
        else
        {
            File defaultDir = MainFrame.getInstance().getDefaultFilePath();

            if (defaultDir == null) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Izaberi direktorijum za projekat");
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                int userSelection = fileChooser.showSaveDialog(MainFrame.getInstance());

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File chosenDir = fileChooser.getSelectedFile();

                    File fileToSave = new File(chosenDir, project.getName().replaceAll("\\s+", "_") + ".json"
                    );
                    serializer.saveProject(project, fileToSave);
                    project.setIzmenjen(false);

                    MainFrame.getInstance().setDefaultFilePath(chosenDir);
                }

            }
            else
            {
                File fileToSave = new File(defaultDir, project.getName().replaceAll("\\s+", "_") + ".json");
                serializer.saveProject(project, fileToSave);
                project.setIzmenjen(false);
            }

        }




    }



}


