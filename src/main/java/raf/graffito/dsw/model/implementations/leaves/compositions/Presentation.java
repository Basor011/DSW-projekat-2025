package raf.graffito.dsw.model.implementations.leaves.compositions;

import raf.graffito.dsw.gui.swing.tree.observer.PPublisher;
import raf.graffito.dsw.gui.swing.tree.observer.PSubscriber;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.implementations.leaves.Slide;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.List;

public class Presentation extends GraffNodeComposite implements PPublisher {

    private List<PSubscriber> psubs = new ArrayList<>();

    public Presentation(String name, GraffNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(GraffNode child) {
        if(child instanceof Slide){
            if(!this.getChildren().contains(child)){
                child.setParent(this);
            }
        }
    }
    @Override
    public void removeChild(GraffNode child) {
        child.setParent(null);
    }
    @Override
    public void removeNode(GraffNode node) {
        for(GraffNode child : children){
            removeChild(child);
            children.remove(child);
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
        for(PSubscriber psubscriber : psubs){
            psubscriber.update(node);
        }
    }
}
