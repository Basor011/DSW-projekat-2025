package raf.graffito.dsw.controller.radio_buttons;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.strategy.SumStrategy;

import java.awt.event.ActionEvent;

public class SumNacin extends AbstractGraffAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getTabbedPane().getSelectedPresentation().getLastSelectedSlide().getSlideModel().setStrategy(new SumStrategy());
    }
}
