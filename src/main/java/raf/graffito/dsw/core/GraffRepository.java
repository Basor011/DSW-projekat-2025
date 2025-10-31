package raf.graffito.dsw.core;

import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.implementations.leaves.compositions.Workspace;

public interface GraffRepository {
    public Workspace getWorkspace();
    public void addChild(GraffNode parent, GraffNode child);
}
