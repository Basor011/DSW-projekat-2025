package raf.graffito.dsw.gui.swing.model.implementations.leaves.compositions;

import raf.graffito.dsw.gui.swing.model.composite.GraffNode;
import raf.graffito.dsw.gui.swing.model.composite.GraffNodeComposite;
import raf.graffito.dsw.gui.swing.model.implementations.leaves.Slide;

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
        if(!this.getChildren().contains(child)){
            if(child instanceof Presentation){
                children.add((Presentation)child);
                child.setParent(this);
            }
            else if(child instanceof Slide){
                children.add((Slide)child);
                child.setParent(this);
                number++;
            }
        }
    }

    @Override
    public void removeChild(GraffNode child) {
        if(child instanceof Slide){
            number--;
        }
        children.remove(child);
        child.setParent(null);
    }

    @Override
    public void removeNode(GraffNode node) {
        for(GraffNode child : children){
            removeChild(child);
        }
        this.setParent(null);
    }
}
