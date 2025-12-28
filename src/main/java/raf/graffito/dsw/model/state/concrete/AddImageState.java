package raf.graffito.dsw.model.state.concrete;

import raf.graffito.dsw.model.state.ElementState;
import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.GraffRepositoryImplementation;
import raf.graffito.dsw.model.command.AddElementCommand;
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
        Point modelPoint=slideView.toModelDelta(p);
        GraffRepositoryImplementation repo = (GraffRepositoryImplementation) ApplicationFramework.getInstance().getGr();

        Element img = (Element) repo.createElement(slideView.getSlideModel(), TipElementa.IMAGE, modelPoint, imagePath);
        int[][] freeSpace=slideView.getSlideModel().getFreeSpace();
        if(slideView.getSlideModel().getStrategy().hasEnoughSpace(slideView.getSlideModel(),List.of(img))) {
            ApplicationFramework.getInstance().getCommandManager().executeCommand(new AddElementCommand(slideView.getSlideModel(), List.of(img)));

            MainFrame.getInstance().getRightPanel().startSelectState();
        } else ApplicationFramework.getInstance().getMg().generateError("Nema mesta");
    }
    @Override public void mouseDragged(MouseEvent e, SlideView slideView) {}
    @Override public void mouseReleased(MouseEvent e, Element element) {}
    @Override public void mouseClicked(MouseEvent e, Element element) {}
    @Override public void mouseWheelMoved(MouseWheelEvent e, SlideView slideView) {}
}
