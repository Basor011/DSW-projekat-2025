package raf.graffito.dsw.model.brigde.controller;

import raf.graffito.dsw.model.brigde.DefaultScaler;
import raf.graffito.dsw.model.brigde.ScaleImplement;
import raf.graffito.dsw.model.brigde.WindowMode;
import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public abstract class AbstractWindowModeAction extends AbstractAction {

    protected AbstractWindowModeAction(String name) {
        super(name);
    }

    protected abstract WindowMode createMode(ScaleImplement scaleImplement);

    @Override
    public void actionPerformed(ActionEvent e) {
        WindowModeController controller = ApplicationFramework.getInstance().getWindowModeController();

        ScaleImplement scaler = new DefaultScaler(MainFrame.getInstance());

        controller.setMode(createMode(scaler));
    }
}
