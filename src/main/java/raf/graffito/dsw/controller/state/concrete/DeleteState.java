package raf.graffito.dsw.controller.state.concrete;

import raf.graffito.dsw.controller.state.ElementState;
import raf.graffito.dsw.gui.swing.tree.GraffTreeImplementation;
import raf.graffito.dsw.gui.swing.tree.GraffTreeItem;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.gui.swing.view.slide_elements.ElementView;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.List;

public class DeleteState implements ElementState {

    @Override
    public void mouseClicked(MouseEvent e, Element element) {
        System.out.println("testing 123");

        GraffNodeComposite parent = (GraffNodeComposite) element.getParent();
        parent.removeChild(element);
    }
    @Override
    public void mousePressed(MouseEvent e, SlideView slideView) {
        List<Element> selected = new ArrayList<Element>();

        for(GraffNode gf : slideView.getSlideModel().getChildren()){
            Element el = (Element) gf;
            if(el.isSelected()){
                selected.add(el);
            }
        }
        if(selected.size() == 0) return;

        GraffTreeImplementation tree = (GraffTreeImplementation) MainFrame.getInstance().getGraffTree();
        for(Element el : selected){
            GraffNodeComposite parent = (GraffNodeComposite) el.getParent();
            parent.removeChild(el);

            GraffTreeItem toDelete = tree.findItemForNode(el);
            if(toDelete != null) tree.removeElement(toDelete);

            slideView.getElementViewMap().remove(el);
        }

        slideView.revalidate();
        slideView.repaint();
        MainFrame.getInstance().getRightPanel().startSelectState();
    }
    @Override public void mouseDragged(MouseEvent e, SlideView slideView) {}
    @Override public void mouseReleased(MouseEvent e, Element element) {}
    @Override public void mouseWheelMoved(MouseWheelEvent e, SlideView slideView) {}
}
