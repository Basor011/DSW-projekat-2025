package raf.graffito.dsw.model.composite.compositions;

import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.composite.GraffNodeLeaf;
import raf.graffito.dsw.model.composite.GraffNode;

public class Slide extends GraffNodeComposite {
    public Slide(String name, GraffNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(GraffNode child) {
        if(child instanceof GraffNodeLeaf) {
            if(!children.contains(child)) {
                child.setParent(this);
                children.add(child);
            }
        }
    }

    @Override
    public void removeChild(GraffNode child) {
        children.remove(child);
        child.setParent(null);
    }

}
