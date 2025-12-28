package raf.graffito.dsw.model.composite.abs;

import com.fasterxml.jackson.annotation.*;
import raf.graffito.dsw.model.composite.compositions.Presentation;
import raf.graffito.dsw.model.composite.compositions.Project;
import raf.graffito.dsw.model.composite.compositions.Slide;
import raf.graffito.dsw.model.composite.compositions.Workspace;
import raf.graffito.dsw.model.composite.leaves.ImageElement;
import raf.graffito.dsw.model.composite.leaves.LogoElement;
import raf.graffito.dsw.model.composite.leaves.TextFieldElement;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Workspace.class, name = "WORKSPACE"),
        @JsonSubTypes.Type(value = Project.class, name = "PROJECT"),
        @JsonSubTypes.Type(value = Presentation.class, name = "PRESENTATION"),
        @JsonSubTypes.Type(value = Slide.class, name = "SLIDE"),
        @JsonSubTypes.Type(value = TextFieldElement.class, name = "TEXTFIELD"),
        @JsonSubTypes.Type(value = ImageElement.class, name = "IMAGE"),
        @JsonSubTypes.Type(value = LogoElement.class, name = "LOGO")

})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "name"
)
public abstract class GraffNode{
    private String name;
    @JsonIgnore
    private GraffNode parent;

    protected GraffNode(){}



    public GraffNode(String name, GraffNode parent) {
        this.name = name;
        this.parent = null; //videcemo
    }
    public abstract GraffNode findByName(String name);

    public String getName() {
        return name;
    }
    public void setName(String name) {this.name = name;}
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
