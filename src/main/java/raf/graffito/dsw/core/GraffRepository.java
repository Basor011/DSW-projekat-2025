package raf.graffito.dsw.core;

import raf.graffito.dsw.core.composite.GraffNode;
import raf.graffito.dsw.core.composite.compositions.Workspace;

public interface GraffRepository {
    public Workspace getWorkspace();
    public void addChild(GraffNode parent, GraffNode child);
}
