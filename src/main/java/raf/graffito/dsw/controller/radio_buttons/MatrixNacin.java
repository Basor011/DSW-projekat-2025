package raf.graffito.dsw.controller.radio_buttons;

import raf.graffito.dsw.controller.AbstractGraffAction;
import raf.graffito.dsw.gui.swing.view.MainFrame;
import raf.graffito.dsw.model.strategy.MatrixStrategy;

import java.awt.event.ActionEvent;

public class MatrixNacin extends AbstractGraffAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getTabbedPane().getSelectedPresentation().getLastSelectedSlide().getSlideModel().setStrategy(new MatrixStrategy());
    }
}
