package raf.graffito.dsw.gui.swing;

import raf.graffito.dsw.core.GraffRepository;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.composite.leaves.Element;
import raf.graffito.dsw.model.composite.leaves.TipElementa;
import raf.graffito.dsw.model.factory.GraffNodeFactory;
import raf.graffito.dsw.model.factory.factories.*;
import raf.graffito.dsw.model.composite.compositions.Slide;
import raf.graffito.dsw.model.composite.compositions.Presentation;
import raf.graffito.dsw.model.composite.compositions.Project;
import raf.graffito.dsw.model.composite.compositions.Workspace;

import java.awt.*;
import java.lang.annotation.ElementType;

import static raf.graffito.dsw.model.composite.leaves.TipElementa.*;

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
    public Element createElement(Slide slide, TipElementa et, Point location, String imagePath) {
        ElementNodeFactory factory = null;

        switch(et) {
            case IMAGE -> factory = new ImageElementNodeFactory(imagePath);
            case LOGO -> factory = new LogoElementNodeFactory();
            case TEXT_FIELD -> factory = new TextFieldElementNodeFactory();
        }
        return factory != null ? factory.createElement(slide, location) : null;
    }

    @Override
    public void addChild(GraffNode parent, GraffNode child) {
        if(parent instanceof GraffNodeComposite) {
            ((GraffNodeComposite) parent).addChild(child);
        }
    }
    public GraffNode createChild(GraffNode parent){ //parent = grafftreeitem.getGraffNode
        if(parent instanceof Slide) return null;
        GraffNodeFactory factory = getGraffNodeFactory(parent);
        return factory.createNode(parent);
    }
}
