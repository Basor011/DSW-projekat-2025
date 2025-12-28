package raf.graffito.dsw.model.command;

import raf.graffito.dsw.gui.swing.tree.GraffTreeImplementation;
import raf.graffito.dsw.gui.swing.tree.GraffTreeItem;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.composite.abs.GraffNodeComposite;
import raf.graffito.dsw.model.composite.compositions.Slide;
import raf.graffito.dsw.model.composite.leaves.Element;
import raf.graffito.dsw.model.strategy.SpaceStrategy;

import java.util.List;

public class AddElementCommand implements Command {
    private GraffNodeComposite parent;
    private List<Element> elements;

    public AddElementCommand(GraffNodeComposite slide, List<Element> elements) {
        this.parent = slide;
        this.elements = elements;
    }

    @Override
    public void execute() {
        for(Element element : elements) {
            parent.addChild(element);
            MainFrame.getInstance().getGraffTree().addElement(new GraffTreeItem(element));
        }

        if (parent instanceof Slide slide ) {
            int[][] freeSpace = slide.getFreeSpace();
            if (freeSpace != null) {
                SpaceStrategy matrixStrategy =  slide.getStrategy();
                for (Element element : elements) {
                    matrixStrategy.markOccupied(slide, element);
                }
            }
        }
    }

    @Override
    public void undo() {
        GraffTreeImplementation gft = (GraffTreeImplementation) MainFrame.getInstance().getGraffTree();
        int[][]freeSpace=((Slide)parent).getFreeSpace();
        for(Element element : elements) {
            ((Slide)parent).getStrategy().clearOccupied((Slide)parent,element);
            parent.removeChild(element);
            GraffTreeItem gti = gft.findItemForNode(element);
            gft.removeElement(gti);
        }
    }
}
