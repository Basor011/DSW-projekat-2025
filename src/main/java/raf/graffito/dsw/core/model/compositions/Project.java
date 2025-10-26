package raf.graffito.dsw.core.model.compositions;

import raf.graffito.dsw.core.model.GraffNode;
import raf.graffito.dsw.core.model.GraffNodeComposite;

public class Project extends GraffNodeComposite {
    private String autor;

    public Project(String name, GraffNode parent) {
        super(name, parent);
    }
}
