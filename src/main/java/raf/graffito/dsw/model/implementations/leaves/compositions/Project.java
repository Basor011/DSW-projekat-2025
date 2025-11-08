package raf.graffito.dsw.model.implementations.leaves.compositions;

import raf.graffito.dsw.gui.swing.tree.observer.PPublisher;
import raf.graffito.dsw.gui.swing.tree.observer.PSubscriber;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.implementations.leaves.Slide;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.List;

public class Project extends GraffNodeComposite implements PPublisher {

    private List<PSubscriber> psubs;

    private String autor;
    private int number; /// br slajdova
    public Project(String name, GraffNode parent, String autor) {
        super(name, parent);
        this.autor = autor;
        this.number = 0;
        psubs = new ArrayList<PSubscriber>();
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

    @Override
    public void addSub(PSubscriber subscriber) {
        psubs.add(subscriber);
    }

    @Override
    public void removeSub(PSubscriber subscriber) {
        psubs.remove(subscriber);
    }

    @Override
    public void notify(DefaultMutableTreeNode node) {
        for(PSubscriber ps : psubs){
            ps.update(node);
        }
    }
}
