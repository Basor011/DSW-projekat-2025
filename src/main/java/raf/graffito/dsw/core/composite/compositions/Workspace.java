package raf.graffito.dsw.core.composite.compositions;

import raf.graffito.dsw.core.composite.GraffNode;
import raf.graffito.dsw.core.composite.GraffNodeComposite;

public class Workspace extends GraffNodeComposite {

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
