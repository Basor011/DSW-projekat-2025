package raf.graffito.dsw.gui.swing.model.implementations.leaves;

import raf.graffito.dsw.gui.swing.model.composite.GraffNodeLeaf;
import raf.graffito.dsw.gui.swing.model.composite.GraffNode;

public class Slide extends GraffNodeLeaf {
    public Slide(String name, GraffNode parent) {
        super(name, parent);
    }

    @Override
    public void removeNode(GraffNode node) {
        this.setParent(null);
    }
}
