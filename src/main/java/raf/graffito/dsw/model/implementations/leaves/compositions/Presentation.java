package raf.graffito.dsw.model.implementations.leaves.compositions;

import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.implementations.leaves.Slide;

public class Presentation extends GraffNodeComposite {
    public Presentation(String name, GraffNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(GraffNode child) {
        if(child instanceof Slide){
            if(!this.getChildren().contains(child)){
                children.add((Slide)child);
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
        for(GraffNode child : children){
            removeChild(child);
        }
        this.setParent(null);
    }
}
