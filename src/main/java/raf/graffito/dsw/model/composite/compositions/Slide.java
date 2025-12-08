package raf.graffito.dsw.model.composite.compositions;

import raf.graffito.dsw.core.observer.Subscriber;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.composite.GraffNodeLeaf;
import raf.graffito.dsw.model.composite.GraffNode;

import java.util.ArrayList;
import java.util.List;

public class Slide extends GraffNodeComposite {
    private List<Subscriber>subs; ///mozda bi observer za slide bio pametan
    public Slide(String name, GraffNode parent) {
        super(name, parent);
        this.subs = new ArrayList<Subscriber>();
    }
    @Override
    public void addChild(GraffNode child) {
        if(child instanceof GraffNodeLeaf) {
            if(!children.contains(child)) {
                child.setParent(this);
                children.add(child);
            }
        }
    }

    @Override
    public void removeChild(GraffNode child) {
        children.remove(child);
        child.setParent(null);
    }

}
