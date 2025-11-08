package raf.graffito.dsw.model.composite;

public abstract class GraffNode{
    private String name;
    private GraffNode parent;

    public GraffNode(String name, GraffNode parent) {
        this.name = name;
        this.parent = null; //videcemo
    }
    public abstract GraffNode findByName(String name);

    public abstract void removeNode(GraffNode node); ///za brisanje cvorova

    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name;}

    public GraffNode getParent() {return parent;}

    public void setParent(GraffNode parent) {this.parent = parent;}
}
