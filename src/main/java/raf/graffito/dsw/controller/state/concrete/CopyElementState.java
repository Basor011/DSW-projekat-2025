package raf.graffito.dsw.controller.state.concrete;

import raf.graffito.dsw.controller.commands.AddElementCommand;
import raf.graffito.dsw.controller.commands.CopyElementCommand;
import raf.graffito.dsw.controller.state.ElementState;
import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.tree.GraffTreeItem;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.gui.swing.view.slide_elements.ElementView;
import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.List;

public class CopyElementState implements ElementState {
    @Override
    public void mousePressed(MouseEvent e, SlideView slideView) {
        ElementView view = slideView.getElementAt(e.getPoint());
        if (view == null) return;

        Element original = view.getElement();
        if (!original.isSelected()) return;

        //Element copy = original.clone();
        //slideView.addElement(copy);
        ApplicationFramework.getInstance().getCommandManager().executeCommand(new CopyElementCommand(slideView.getSlideModel(), List.of(original)));
        //MainFrame.getInstance().getGraffTree().addElement(new GraffTreeItem(copy));

        //slideView.repaint();
        MainFrame.getInstance().getRightPanel().startSelectState();
    }

    @Override public void mouseDragged(MouseEvent e, SlideView slideView) {}
    @Override public void mouseReleased(MouseEvent e, Element element) {}
    @Override public void mouseClicked(MouseEvent e, Element element) {}
    @Override public void mouseWheelMoved(MouseWheelEvent e, SlideView slideView) {}
}
