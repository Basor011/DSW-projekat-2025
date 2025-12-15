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

        Element txt = new TextFieldElement(
                "Text",
                slideView.getSlideModel(),
                new Point(p.x, p.y),
                new Dimension(150, 30),
                text
        );

        slideView.addElement(txt);
        slideView.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e, SlideView slideView) {

    }

    @Override
    public void mouseReleased(MouseEvent e, Element element) {

    }

    @Override
    public void mouseClicked(MouseEvent e, Element element) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e, SlideView slideView) {

    }
}
