package raf.graffito.dsw.gui.swing;

import raf.graffito.dsw.core.GraffRepository;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.implementations.leaves.compositions.Workspace;

public class GraffRepositoryImplementation implements GraffRepository {
    private Workspace workspace;

    public GraffRepositoryImplementation() {
        workspace = new Workspace("Workspace");
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public void addChild(GraffNode parent, GraffNode child) {
        if(child instanceof GraffNodeComposite) {
            child.setParent(parent);
        }
    }

}
