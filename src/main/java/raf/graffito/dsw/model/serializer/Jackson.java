package raf.graffito.dsw.model.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.composite.compositions.Project;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Jackson extends Component implements  Serializer{
private final ObjectMapper objectMapper;


    public Jackson() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.enable(com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT);


    }

    @Override
    public Project loadProject(File file) {
        try {
            // Deserijalizacija: čita JSON iz fajla i mapira ga u Project objekat
            return objectMapper.readValue(file, Project.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Vraćamo null u slučaju greške
        }    }

    @Override
    public void saveProject(Project project, File file) {

        try {
            // Serijalizacija: piše Project objekat kao JSON u fajl
            objectMapper.writeValue(file, project);
            System.out.println("Projekat je sačuvan u: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    @Override
    public void saveAsProject(Project project, File file) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Choose a file path");


        int result = chooser.showOpenDialog(MainFrame.getInstance().getTabbedPane());



        }


    }



