package raf.graffito.dsw.gui.swing.tree.view;

import raf.graffito.dsw.gui.swing.tree.controller.PresentationBtnAction;
import raf.graffito.dsw.gui.swing.tree.controller.SlideBtnAction;

import javax.swing.*;
import java.awt.*;

public class PresentationOrSlidePopUp extends JDialog {
    private JToggleButton buttonPresentation;
    private JToggleButton buttonSlide;

    public PresentationOrSlidePopUp(JFrame parent) {
        super(parent, "Add presentation or slide?", true);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());
        setSize(300,80);

        JPanel panel = new JPanel();
        this.buttonPresentation = new JToggleButton("Presentation");
        this.buttonPresentation.setBackground(Color.WHITE);
        this.buttonSlide = new JToggleButton("Slide");
        this.buttonSlide.setBackground(Color.WHITE);
        add(panel, BorderLayout.CENTER);
        panel.add(buttonPresentation);
        panel.add(buttonSlide);

        buttonPresentation.addActionListener(new PresentationBtnAction(this));
        buttonSlide.addActionListener(new SlideBtnAction(this));
    }

    public boolean isPresentation() {
        return buttonPresentation.isSelected();
    }
    public boolean isSlide() {
        return buttonSlide.isSelected();
    }
    public void close(){
        dispose();
    }
    public JToggleButton getButtonSlide() {
        return buttonSlide;
    }

    public JToggleButton getButtonPresentation() {
        return buttonPresentation;
    }
}
