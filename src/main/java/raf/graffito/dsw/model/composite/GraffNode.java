package raf.graffito.dsw.model.composite;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class GraffNode{
    private String name;
    @JsonIgnore
    private GraffNode parent;

    public GraffNode(String name, GraffNode parent) {
        this.name = name;
        this.parent = null; //videcemo
    }
    public abstract GraffNode findByName(String name);

    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name;}
    @JsonIgnore
    public GraffNode getParent() {return parent;}

    public void setParent(GraffNode parent) {this.parent = parent;}

    @Override
    public String toString() {
        return "GraffNode{" +
                "name='" + name + '\'' +
                ", parent=" + parent +
                '}';
    }
}
