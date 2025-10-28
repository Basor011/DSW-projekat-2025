package raf.graffito.dsw.core.model.compositions;

import raf.graffito.dsw.core.model.GraffNode;
import raf.graffito.dsw.core.model.GraffNodeComposite;
import raf.graffito.dsw.core.model.leaves.Slide;

public class Presentation extends GraffNodeComposite {
    public Presentation(String name, GraffNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(GraffNode child) {
        if(child instanceof Slide){
            children.add((Slide)child);
        }
        //else messageGenerator
    }

    @Override
    public void removeChild(GraffNode child) {
        children.remove(child);
    }
}
