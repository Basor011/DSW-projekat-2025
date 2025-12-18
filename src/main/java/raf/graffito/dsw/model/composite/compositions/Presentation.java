package raf.graffito.dsw.model.composite.compositions;

import raf.graffito.dsw.gui.swing.tree.observer.PSubscriber;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.GraffNodeComposite;

import java.util.ArrayList;
import java.util.List;

public class Presentation extends GraffNodeComposite  {

    private List<PSubscriber> psubs = new ArrayList<>();

    public Presentation(String name, GraffNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(GraffNode child) {
        if(child instanceof Slide){
            if(!this.getChildren().contains(child)){
                child.setParent(this);
                children.add(child);
            }
        }
    }
    @Override
    public void removeChild(GraffNode child) {
        child.setParent(null);
        children.remove(child);
    }
    
}
