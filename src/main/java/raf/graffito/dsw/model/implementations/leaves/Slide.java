package raf.graffito.dsw.model.implementations.leaves;

import raf.graffito.dsw.model.composite.GraffNodeLeaf;
import raf.graffito.dsw.model.composite.GraffNode;

public class Slide extends GraffNodeLeaf {
    public Slide(String name, GraffNode parent) {
        super(name, parent);
    }

    @Override
    public void removeNode(GraffNode node) {
        this.setParent(null);
    }
}
