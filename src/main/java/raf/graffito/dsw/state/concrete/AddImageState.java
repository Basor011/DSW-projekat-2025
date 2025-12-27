package raf.graffito.dsw.state.concrete;

import raf.graffito.dsw.state.ElementState;
import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.GraffRepositoryImplementation;
import raf.graffito.dsw.command.AddElementCommand;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.leaves.Element;
import raf.graffito.dsw.model.composite.leaves.TipElementa;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.List;

public class AddImageState implements ElementState {
    private String imagePath;
    public AddImageState(String imagePath) {
        this.imagePath = imagePath;
    }
    public void setImagePath(String path) {
        this.imagePath = path;
    }
    @Override
    public void mousePressed(MouseEvent e, SlideView slideView) {
        if (imagePath == null) return;

        Point p = e.getPoint();
        GraffRepositoryImplementation repo = (GraffRepositoryImplementation) ApplicationFramework.getInstance().getGr();

        Element img = (Element) repo.createElement(slideView.getSlideModel(), TipElementa.IMAGE, p, imagePath);

        ApplicationFramework.getInstance().getCommandManager().executeCommand(new AddElementCommand(slideView.getSlideModel(), List.of(img)));

        MainFrame.getInstance().getRightPanel().startSelectState();
    }
    @Override public void mouseDragged(MouseEvent e, SlideView slideView) {}
    @Override public void mouseReleased(MouseEvent e, Element element) {}
    @Override public void mouseClicked(MouseEvent e, Element element) {}
    @Override public void mouseWheelMoved(MouseWheelEvent e, SlideView slideView) {}
}
