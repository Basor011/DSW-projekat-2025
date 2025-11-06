package raf.graffito.dsw.gui.swing.model.implementations.leaves.compositions;

import raf.graffito.dsw.gui.swing.model.composite.GraffNode;
import raf.graffito.dsw.gui.swing.model.composite.GraffNodeComposite;
import raf.graffito.dsw.gui.swing.model.implementations.leaves.Slide;

import java.util.List;

public class Presentation extends GraffNodeComposite {

    private List<Slide> slides;
    public Presentation(String name, GraffNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(GraffNode child) {
        if(child instanceof Slide){
            if(!this.getChildren().contains(child)){
                children.add((Slide)child);
                child.setParent(this);
            }
        }
    }
    @Override
    public void removeChild(GraffNode child) {
        children.remove(child);
        child.setParent(null);
    }
    @Override
    public void removeNode(GraffNode node) {
        for(GraffNode child : children){
            removeChild(child);
            slides.remove((Slide)child);
            children.remove(child);
        }
        this.setParent(null);
    }
    public void transferSlide(int oldIndx, int newIndx) {
        Slide slide = slides.remove(oldIndx);
        slides.add(newIndx, slide);
    }
}
