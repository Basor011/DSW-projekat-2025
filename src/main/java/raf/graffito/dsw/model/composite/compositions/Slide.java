package raf.graffito.dsw.model.composite.compositions;

import raf.graffito.dsw.core.observer.Subscriber;
import raf.graffito.dsw.gui.swing.tree.observer.SSubscriber;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.composite.GraffNodeLeaf;
import raf.graffito.dsw.model.composite.GraffNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

public class Slide extends GraffNodeComposite {
    private List<SSubscriber>subs= new ArrayList<>(); ///mozda bi observer za slide bio pametan
    protected Slide(){}
    public Slide(String name, GraffNode parent) {
        super(name, parent);
    }
    @Override
    public void addChild(GraffNode child) {
        if(child instanceof GraffNodeLeaf) {
            if(!children.contains(child)) {
                child.setParent(this);
                children.add(child);
                notifySubscribers();
            }
        }
    }
    @Override
    public void removeChild(GraffNode child) {
        children.remove(child);
        child.setParent(null);
        notifySubscribers();
    }

    public void addSubscriber(SSubscriber s) {subs.add(s);}
    public void removeSubscriber(SSubscriber s) {subs.remove(s);}
    public void notifySubscribers() {
        for (SSubscriber s : subs) {
            s.update();
        }
    }
}
