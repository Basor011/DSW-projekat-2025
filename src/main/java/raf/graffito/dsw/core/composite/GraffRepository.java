package raf.graffito.dsw.core.composite;

import raf.graffito.dsw.core.composite.compositions.Workspace;

public interface GraffRepository {
    public Workspace getWorkspace();
    public void addChild(GraffNode parent, GraffNode child);
}
