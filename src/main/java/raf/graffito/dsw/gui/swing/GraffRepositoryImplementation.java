package raf.graffito.dsw.gui.swing;

import raf.graffito.dsw.core.GraffRepository;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.factory.GraffNodeFactory;
import raf.graffito.dsw.model.factory.factories.PresentationFactory;
import raf.graffito.dsw.model.factory.factories.ProjectFactory;
import raf.graffito.dsw.model.factory.factories.WorkspaceFactory;
import raf.graffito.dsw.model.implementations.leaves.compositions.Presentation;
import raf.graffito.dsw.model.implementations.leaves.compositions.Project;
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

    private GraffNodeFactory getGraffNodeFactory(GraffNode parent) {
        if(parent instanceof Workspace) return new WorkspaceFactory();
        else if(parent instanceof Project) return new ProjectFactory();
        else if(parent instanceof Presentation) return new PresentationFactory();
        else return null;
    }

    @Override
    public void addChild(GraffNode parent, GraffNode child) {
        if(parent instanceof GraffNodeComposite) {
            ((GraffNodeComposite) parent).addChild(child);
        }
    }

    public GraffNode createChild(GraffNode parent){ //parent = grafftreeitem.getGraffNode
        GraffNodeFactory factory = getGraffNodeFactory(parent);
        return factory.createNode(parent);
    }

}
