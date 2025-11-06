package raf.graffito.dsw.model.factory;

import raf.graffito.dsw.model.composite.GraffNode;

public interface GraffNodeFactory {
    GraffNode createNode (GraffNode parent);
}
