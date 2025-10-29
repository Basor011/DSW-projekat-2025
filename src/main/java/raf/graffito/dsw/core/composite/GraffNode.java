package raf.graffito.dsw.core.composite;

public abstract class GraffNode {
    private String name;
    private GraffNode parent;


    public GraffNode(String name, GraffNode parent) {
        this.name = name;
        this.parent = null;
    }
    public abstract GraffNode findByName(String name);

    public String getName() {
        return name;
    }
}
