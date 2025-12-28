package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.model.mediator.ConcreteMediator;

import javax.swing.*;

public class WindowModeRadioButtons extends JPanel {
    private JRadioButton defaultMode;
    private JRadioButton fullMode;
    private JRadioButton smallMode;
    private ButtonGroup group;

    private ConcreteMediator mediator;

    public WindowModeRadioButtons() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        mediator=new ConcreteMediator(ApplicationFramework.getInstance().getWindowModeController());

        defaultMode = new JRadioButton("Default Mode");
        fullMode = new JRadioButton("Full Mode");
        smallMode = new JRadioButton("Small Mode");

        fullMode.addActionListener(e ->
                mediator.notify("FULL")
        );

        smallMode.addActionListener(e ->
                mediator.notify("SMALL")
        );

        defaultMode.addActionListener(e ->
                mediator.notify("NORMAL")
        );

        group = new ButtonGroup();
        group.add(defaultMode);
        group.add(fullMode);
        group.add(smallMode);

        add(defaultMode);
        add(fullMode);
        add(smallMode);

        defaultMode.setText("default");
        fullMode.setText("full");
        smallMode.setText("small");

        defaultMode.setSelected(true);
    }
    public ButtonGroup getGroup() {
        return group;
    }
}
