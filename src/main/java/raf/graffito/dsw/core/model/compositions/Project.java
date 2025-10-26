package raf.graffito.dsw.core.model.compositions;

import raf.graffito.dsw.core.model.GraffNode;
import raf.graffito.dsw.core.model.GraffNodeComposite;
import raf.graffito.dsw.core.model.leaves.Slide;

public class Project extends GraffNodeComposite {
    private String autor;

    public Project(String name, GraffNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(GraffNode child) {
        if(child instanceof Presentation || child instanceof Slide){
            children.add(child);
        }
        //else message generator
    }

    @Override
    public void removeChild(GraffNode child) {
        children.remove(child);
    }
}
