package raf.graffito.dsw.model.state.concrete;

import raf.graffito.dsw.model.state.ElementState;
import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.model.command.DeleteElementCommand;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.abs.GraffNode;
import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.List;

public class DeleteState implements ElementState {

    @Override public void mouseClicked(MouseEvent e, Element element) {}
    @Override
    public void mousePressed(MouseEvent e, SlideView slideView) {
        List<Element> selected = new ArrayList<Element>();

        for(GraffNode gf : slideView.getSlideModel().getChildren()){
            Element el = (Element) gf;
            if(el.isSelected()) selected.add(el);
        }
        if(selected.isEmpty()) return;
        for(Element el : selected) {
            int[][] freeSpace=slideView.getSlideModel().getFreeSpace();
            slideView.getSlideModel().getStrategy().clearOccupied(slideView.getSlideModel(),el);
        }
        ApplicationFramework.getInstance().getCommandManager().executeCommand(new DeleteElementCommand(slideView.getSlideModel(), selected));


        MainFrame.getInstance().getRightPanel().startSelectState();
    }
    @Override public void mouseDragged(MouseEvent e, SlideView slideView) {}
    @Override public void mouseReleased(MouseEvent e, Element element) {}
    @Override public void mouseWheelMoved(MouseWheelEvent e, SlideView slideView) {}
}
