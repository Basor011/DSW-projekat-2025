package raf.graffito.dsw.core.composite.compositions;

import raf.graffito.dsw.core.composite.GraffNode;
import raf.graffito.dsw.core.composite.GraffNodeComposite;
import raf.graffito.dsw.core.composite.leaves.Slide;

public class Project extends GraffNodeComposite {
    private String autor;
    private int number; /// br slajdova
    public Project(String name, GraffNode parent, String autor) {
        super(name, parent);
        this.autor = autor;
        this.number = 0;
    }

    @Override
    public void addChild(GraffNode child) {
        if(child instanceof Presentation || child instanceof Slide){
            children.add(child);
            child.setParent(this);
            if(child instanceof Slide){
                number++;
            }
        }
        //else message generator
    }

    @Override
    public void removeChild(GraffNode child) {
        children.remove(child);
        if(child instanceof Slide){
            number--;
        }
        child.setParent(null);
    }
}
