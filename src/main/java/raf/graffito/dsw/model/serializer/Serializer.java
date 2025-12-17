package raf.graffito.dsw.model.serializer;

import raf.graffito.dsw.model.composite.compositions.Project;

import java.io.File;

public interface Serializer {
    Project loadProject(File file);
    void saveProject(Project project, File file);
    void saveAsProject(Project project, File file);
}
