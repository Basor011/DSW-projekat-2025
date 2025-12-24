package raf.graffito.dsw.gui.swing.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RightPaneButtonMouseListener extends MouseAdapter {
    private final JButton button;

    public RightPaneButtonMouseListener(JButton button) {
        this.button = button;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        button.setBackground(new Color(220, 220, 220));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (!button.getModel().isPressed() && !button.getModel().isSelected()) button.setBackground(new Color(240, 240, 240));
    }
}
