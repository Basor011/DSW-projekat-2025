package raf.graffito.dsw.gui.swing.model.factory;

import raf.graffito.dsw.gui.swing.model.composite.GraffNode;

public interface GraffNodeFactory {
    GraffNode createNode (GraffNode parent);
}
