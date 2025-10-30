package raf.graffito.dsw.core.composite;

public abstract class GraffNodeLeaf extends GraffNode {
    public GraffNodeLeaf(String name, GraffNode parent) {
        super(name, parent);
    }

    @Override
    public GraffNode findByName(String name) {
        if(this.getName().equals(name)) return this;
        return null;
    }
}
