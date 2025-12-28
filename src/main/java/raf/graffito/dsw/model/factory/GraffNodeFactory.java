package raf.graffito.dsw.model.factory;

import raf.graffito.dsw.model.composite.abs.GraffNode;

public interface GraffNodeFactory {
    GraffNode createNode (GraffNode parent);
}
