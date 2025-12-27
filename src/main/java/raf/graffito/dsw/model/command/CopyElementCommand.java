package raf.graffito.dsw.model.command;

import raf.graffito.dsw.gui.swing.tree.GraffTreeImplementation;
import raf.graffito.dsw.gui.swing.tree.GraffTreeItem;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.composite.leaves.Element;

import java.util.ArrayList;
import java.util.List;

public class CopyElementCommand implements Command {
    private GraffNodeComposite parent;
    private List<Element> elements;
    private List<Element> copies;

    public CopyElementCommand(GraffNodeComposite graffNodeComposite, List<Element> elements) {
        this.parent = graffNodeComposite;
        this.elements = elements;
        this.copies = new ArrayList<Element>();
    }

    @Override
    public void execute() {
        copies.clear();

        for(Element element : elements) {
            Element copy = element.clone();
            copies.add(copy);
            parent.addChild(copy);
            MainFrame.getInstance().getGraffTree().addElement(new GraffTreeItem(copy));
        }
    }

    @Override
    public void undo() {
        GraffTreeImplementation gft = (GraffTreeImplementation) MainFrame.getInstance().getGraffTree();
        for(Element element : copies) {
            parent.removeChild(element);
            GraffTreeItem gti = gft.findItemForNode(element);
            if(gti != null) gft.removeElement(gti);
        }
    }
}
