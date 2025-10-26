package raf.graffito.dsw.core.model.compositions;

import raf.graffito.dsw.core.model.GraffNode;
import raf.graffito.dsw.core.model.GraffNodeComposite;

import java.util.ArrayList;
import java.util.List;

public class Workspace extends GraffNodeComposite {
    //private List<Project> projects;
    public Workspace(String name, GraffNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(GraffNode child) {
        if(child instanceof Project) {
            children.add((Project)child);
        }
        //else poziva se messageGenerator
    }

    @Override
    public void removeChild(GraffNode child) {
        children.remove(child);
    }
}
