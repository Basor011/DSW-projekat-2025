package raf.graffito.dsw.controller.state_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.gui.swing.view.PresentationView;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.compositions.Slide;
import raf.graffito.dsw.model.composite.leaves.Element;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RotateElementAction extends AbstractGraffAction {

    @Override
    public void actionPerformed(ActionEvent e)
    {
        boolean clockwise=e.getActionCommand().equals("clockwise");
        SlideView slideView=((PresentationView)(MainFrame.getInstance().getTabbedPane().getSelectedComponent())).getLastSelectedSlide();
        if(slideView == null) return;
        Slide slide=slideView.getSlideModel();

        for (GraffNode child : slide.getChildren()) {
            if (child instanceof Element) {
                Element element = (Element) child;
                if (element.isSelected()) {
                    element.rotate90(clockwise);


                }
            }
        }
        slideView.revalidate();
        slideView.repaint();




    }
}
