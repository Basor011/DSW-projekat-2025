package raf.graffito.dsw.controller.state.concrete;

import raf.graffito.dsw.controller.state.ElementState;
import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.GraffRepositoryImplementation;
import raf.graffito.dsw.gui.swing.commands.AddElementCommand;
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
import java.util.List;

public class AddTextFieldState implements ElementState {

    @Override
    public void mousePressed(MouseEvent e, SlideView slideView) {
        Point p = e.getPoint();

        String text = JOptionPane.showInputDialog(slideView, "Enter text:", "Text Input", JOptionPane.PLAIN_MESSAGE);

        if (text == null || text.trim().isEmpty()) {
            return;
        }

        GraffRepositoryImplementation repo = (GraffRepositoryImplementation) ApplicationFramework.getInstance().getGr();

        Element txf = (Element) repo.createElement(slideView.getSlideModel(), TipElementa.TEXT_FIELD, p, text);

        ApplicationFramework.getInstance().getCommandManager().executeCommand(new AddElementCommand(slideView.getSlideModel(), List.of(txf)));

        MainFrame.getInstance().getRightPanel().startSelectState();
    }

    @Override public void mouseDragged(MouseEvent e, SlideView slideView) {}
    @Override public void mouseReleased(MouseEvent e, Element element) {}
    @Override public void mouseClicked(MouseEvent e, Element element) {}
    @Override public void mouseWheelMoved(MouseWheelEvent e, SlideView slideView) {}
}
