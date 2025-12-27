package raf.graffito.dsw.controller.state_actions;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.model.command.RotateElementCommand;
import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.gui.swing.view.PresentationView;
import raf.graffito.dsw.gui.swing.view.SlideView;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.compositions.Slide;
import raf.graffito.dsw.model.composite.leaves.Element;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class RotateElementAction extends AbstractGraffAction {

    @Override
    public void actionPerformed(ActionEvent e)
    {
        boolean clockwise=e.getActionCommand().equals("clockwise");
        SlideView slideView=((PresentationView)(MainFrame.getInstance().getTabbedPane().getSelectedComponent())).getLastSelectedSlide();
        if(slideView == null) return;
        Slide slide=slideView.getSlideModel();

        List<Element> selectedElements=new ArrayList<>();
        for (GraffNode child : slide.getChildren()) {
            if (child instanceof Element) {
                Element element = (Element) child;
                if (element.isSelected()) {
                    selectedElements.add(element);
                }
            }
        }
        if (selectedElements.isEmpty()) return;

        RotateElementCommand command = new RotateElementCommand(selectedElements);
        command.apply(clockwise);
        command.captureAfterRotations();

        ApplicationFramework.getInstance().getCommandManager().executeCommand(command);
        slideView.revalidate();
        slideView.repaint();
    }
}
