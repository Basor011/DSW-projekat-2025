package raf.graffito.dsw.core.model.compositions;

import raf.graffito.dsw.core.model.GraffNode;
import raf.graffito.dsw.core.model.GraffNodeComposite;
import raf.graffito.dsw.core.model.leaves.Slide;

public class Project extends GraffNodeComposite {
    private String autor;
    private int number;
    public Project(String name, GraffNode parent, String autor) {
        super(name, parent);
        this.autor = autor;
        this.number = 0;
    }

    @Override
    public void addChild(GraffNode child) {
        if(child instanceof Presentation || child instanceof Slide){
            children.add(child);
            number++;
        }
        //else message generator
    }

    @Override
    public void removeChild(GraffNode child) {
        children.remove(child);
        number--;
        //message generator error
    }
}
