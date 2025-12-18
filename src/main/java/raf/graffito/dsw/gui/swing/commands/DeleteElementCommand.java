package raf.graffito.dsw.gui.swing.commands;

import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.composite.leaves.Element;

import java.util.ArrayList;
import java.util.List;

public class DeleteElementCommand implements Command {
    private GraffNodeComposite parent;
    private List<Element> elements;

    public DeleteElementCommand(GraffNodeComposite graffNodeComposite, List<Element> elements) {
        this.parent = graffNodeComposite;
        this.elements = elements;
    }

    @Override
    public void execute() {
        for(Element element : elements) {
            parent.removeChild(element);
        }
        MainFrame.getInstance().repaint();
    }

    @Override
    public void undo() {
        for(Element element : elements) {
            parent.addChild(element);
        }
        MainFrame.getInstance().repaint();
    }
}
