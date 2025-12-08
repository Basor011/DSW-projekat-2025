package raf.graffito.dsw.gui.swing.view.slide_elements;

import raf.graffito.dsw.model.composite.leaves.Element;

public abstract class ElementView implements Painter {
    protected Element element;

    public ElementView(Element element) {
        this.element = element;
    }
}
