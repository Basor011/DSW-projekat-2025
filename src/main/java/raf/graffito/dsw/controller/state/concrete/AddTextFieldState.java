package raf.graffito.dsw.controller.state.concrete;

import raf.graffito.dsw.controller.state.ElementState;
import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.GraffRepositoryImplementation;
import raf.graffito.dsw.gui.swing.tree.GraffTreeItem;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.leaves.Element;
import raf.graffito.dsw.model.composite.leaves.TextFieldElement;
import raf.graffito.dsw.model.composite.leaves.TipElementa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class AddTextFieldState implements ElementState {

    @Override
    public void mousePressed(MouseEvent e, SlideView slideView) {
        Point p = e.getPoint();

        String text = JOptionPane.showInputDialog(
                slideView,
                "Enter text:",
                "Text Input",
                JOptionPane.PLAIN_MESSAGE
        );

        if (text == null || text.trim().isEmpty()) {
            return;
        }

        GraffRepositoryImplementation repo = (GraffRepositoryImplementation) ApplicationFramework.getInstance().getGr();

        Element txf = (Element) repo.createElement(slideView.getSlideModel(), TipElementa.TEXT_FIELD, p, text);
        slideView.getSlideModel().addChild(txf);
        slideView.addElement(txf);
        MainFrame.getInstance().getGraffTree().addElement(new GraffTreeItem(txf));
        slideView.repaint();
        MainFrame.getInstance().getRightPanel().startSelectState();

        slideView.addElement(txf);
        slideView.repaint();
    }

    @Override public void mouseDragged(MouseEvent e, SlideView slideView) {}
    @Override public void mouseReleased(MouseEvent e, Element element) {}
    @Override public void mouseClicked(MouseEvent e, Element element) {}
    @Override public void mouseWheelMoved(MouseWheelEvent e, SlideView slideView) {}
}
