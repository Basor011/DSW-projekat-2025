package raf.graffito.dsw.gui.swing.commands;

import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.composite.leaves.Element;

import java.util.List;

public class AddElementCommand implements Command {
    private GraffNodeComposite parent;
    private List<Element> elements;
    @Override
    public void execute() {
        for(Element element : elements) {
            parent.addChild(element);
        }
    }

    @Override
    public void undo() {
        for(Element element : elements) {
            parent.removeChild(element);
        }
    }
}
