package raf.graffito.dsw.core.model;

import java.util.ArrayList;
import java.util.List;

public abstract class GraffNodeComposite extends GraffNode {
    protected List<GraffNode> children = new ArrayList<>();

    public GraffNodeComposite(String name, GraffNode parent) {
        super(name, parent);
    }

    @Override
    public GraffNode findByName(String name) {
        if(this.getName().equals(name)) return this;
        for(GraffNode child : children) {
            GraffNode result = child.findByName(name);
        }
        return null;
    }
    public abstract void addChild(GraffNode child);

    public abstract void removeChild(GraffNode child);


    public List<GraffNode> getChildren() {
        return children;
    }
}
