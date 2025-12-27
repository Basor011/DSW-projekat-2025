package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.brigde.ScaleImplement;
import raf.graffito.dsw.brigde.controller.WindowModeController;
import raf.graffito.dsw.core.ApplicationFramework;

import javax.swing.*;

public class WindowModeRadioButtons extends JToolBar {
    private JRadioButton defaultMode;
    private JRadioButton fullMode;
    private JRadioButton smallMode;

    public WindowModeRadioButtons(WindowModeController controller, ScaleImplement scale) {
        setFloatable(false);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        defaultMode = new JRadioButton("Default Mode");
        fullMode = new JRadioButton("Full Mode");
        smallMode = new JRadioButton("Small Mode");

        ButtonGroup group = new ButtonGroup();
        group.add(defaultMode);
        group.add(fullMode);
        group.add(smallMode);

        add(defaultMode);
        add(fullMode);
        add(smallMode);

        defaultMode.setAction(MainFrame.getInstance().getActionManager().getNormalModeAction());
        fullMode.setAction(MainFrame.getInstance().getActionManager().getFullModeAction());
        smallMode.setAction(MainFrame.getInstance().getActionManager().getSmallModeAction());

        defaultMode.setText("default");
        fullMode.setText("full");
        smallMode.setText("small");

        defaultMode.setSelected(true);
    }
}
