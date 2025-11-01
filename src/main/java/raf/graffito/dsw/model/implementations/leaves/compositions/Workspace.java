package raf.graffito.dsw.model.implementations.leaves.compositions;

import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.GraffNodeComposite;

public class Workspace extends GraffNodeComposite {
    public Workspace(String name) {
        super(name, null);
    }

    @Override
    public void addChild(GraffNode child) {
        if(child instanceof Project) {
            if(!this.getChildren().contains(child)) {
                children.add((Project)child);
                child.setParent(this);
            }
        }
    }

    @Override
    public void removeChild(GraffNode child) {
        children.remove(child);
        child.setParent(null);
    }

    @Override
    public void removeNode(GraffNode node) {
        return; ///workspace ne moze da se obrise
    }
}
