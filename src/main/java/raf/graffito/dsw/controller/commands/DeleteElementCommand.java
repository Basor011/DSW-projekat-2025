package raf.graffito.dsw.controller.commands;

import raf.graffito.dsw.gui.swing.tree.GraffTreeImplementation;
import raf.graffito.dsw.gui.swing.tree.GraffTreeItem;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.composite.leaves.Element;

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
        GraffTreeImplementation gft = (GraffTreeImplementation) MainFrame.getInstance().getGraffTree();
        for(Element element : elements) {
            parent.removeChild(element);
            GraffTreeItem gti = gft.findItemForNode(element);
            gft.removeElement(gti);
        }
        MainFrame.getInstance().revalidate();
        MainFrame.getInstance().repaint();
    }

    @Override
    public void undo() {
        for(Element element : elements) {
            parent.addChild(element);
            MainFrame.getInstance().getGraffTree().addElement(new GraffTreeItem(element));
        }
        MainFrame.getInstance().revalidate();
        MainFrame.getInstance().repaint();
    }
}
