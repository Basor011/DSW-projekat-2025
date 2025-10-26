package raf.graffito.dsw.core.model;

import java.util.ArrayList;
import java.util.List;

public abstract class GraffNodeComposite extends GraffNode {
    private List<GraffNode> children;
    public GraffNodeComposite(String name, GraffNode parent) {
        super(name, parent);
        this.children = new ArrayList<GraffNode>();
    }

    @Override
    public GraffNode findByName(String name) {
        if(this.getName().equals(name)) return this;
        for(GraffNode child : children) {
            GraffNode result = child.findByName(name);
        }
        return null;
    }
    public abstract void addChild(GraffNode part);

    public abstract void removeChild(GraffNode part);


    public List<GraffNode> getChildren() {
        return children;
    }
}
