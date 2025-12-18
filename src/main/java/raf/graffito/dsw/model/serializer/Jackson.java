package raf.graffito.dsw.model.serializer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.tree.GraffTreeItem;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.compositions.Project;
import raf.graffito.dsw.model.composite.compositions.Workspace;

import java.io.File;
import java.io.IOException;

public class Jackson implements  Serializer {
    private final ObjectMapper objectMapper;

    public Jackson() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.enable(com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT);
    }

    @Override
    public void loadProject(File file) {
        try
        {

            Workspace root= ApplicationFramework.getInstance().getGr().getWorkspace();
            JsonNode projectNode=objectMapper.readTree(file);
            GraffNode node;





        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void saveProject(Project project, File file)
    {

        try {
            objectMapper.writeValue(file, project);
            System.out.println("Projekat je sačuvan u: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


