package raf.graffito.dsw.model.command;

import raf.graffito.dsw.gui.swing.tree.GraffTreeImplementation;
import raf.graffito.dsw.gui.swing.tree.GraffTreeItem;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.composite.abs.GraffNodeComposite;
import raf.graffito.dsw.model.composite.compositions.Slide;
import raf.graffito.dsw.model.composite.leaves.Element;
import raf.graffito.dsw.model.strategy.SpaceStrategy;

import java.util.ArrayList;
import java.util.List;

public class DeleteElementCommand implements Command {
    private GraffNodeComposite parent;
    private List<Element> elements;
    private List<GraffTreeItem> treeItems;

    public DeleteElementCommand(GraffNodeComposite graffNodeComposite, List<Element> elements) {
        this.parent = graffNodeComposite;
        this.elements = new ArrayList<>(elements);
        this.treeItems = new ArrayList<>();
    }

    @Override
    public void execute() {
        treeItems.clear();
        GraffTreeImplementation gft = (GraffTreeImplementation) MainFrame.getInstance().getGraffTree();

        if (parent instanceof Slide slide) {
            int[][] freeSpace = slide.getFreeSpace();
            if (freeSpace != null) {
                SpaceStrategy strategy = slide.getStrategy();
                for (Element element : elements) {
                    strategy.clearOccupied(slide, element);
                }
            }
        }
        for (Element element : elements) {
            GraffTreeItem item = gft.findItemForNode(element);
            treeItems.add(item);

            parent.removeChild(element);
            gft.removeElement(item);
        }
    }

    @Override
    public void undo() {
        GraffTreeImplementation gft = (GraffTreeImplementation) MainFrame.getInstance().getGraffTree();
        for (int i = 0; i < treeItems.size(); i++) {
            Element element = elements.get(i);
            GraffTreeItem item = treeItems.get(i);

            parent.addChild(element);
            gft.addElement(item);
        }

        if (parent instanceof Slide slide) {
            int[][] freeSpace = slide.getFreeSpace();
            if (freeSpace != null) {
                SpaceStrategy strategy = slide.getStrategy();
                for (Element element : elements) {
                    strategy.clearOccupied(slide,element);
                }
            }
        }
    }
}