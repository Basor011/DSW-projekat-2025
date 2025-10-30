package raf.graffito.dsw.core.composite.compositions;

import raf.graffito.dsw.core.composite.GraffNode;
import raf.graffito.dsw.core.composite.GraffNodeComposite;
import raf.graffito.dsw.core.composite.leaves.Slide;

public class Presentation extends GraffNodeComposite {
    public Presentation(String name, GraffNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(GraffNode child) {
        if(child instanceof Slide){
            children.add((Slide)child);
            child.setParent(this);
        }
        //else messageGenerator
    }

    @Override
    public void removeChild(GraffNode child) {
        children.remove(child);
        child.setParent(null);
    }
}
