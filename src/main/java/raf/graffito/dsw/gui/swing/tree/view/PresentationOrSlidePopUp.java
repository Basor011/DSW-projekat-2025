package raf.graffito.dsw.gui.swing.tree.view;

import javax.swing.*;
import java.awt.*;

public class PresentationOrSlidePopUp extends JFrame {
    private JToggleButton buttonPresentation;
    private JToggleButton buttonSlide;

    public PresentationOrSlidePopUp() {
        initialize();
    }
    public void initialize() {
        Toolkit kit = Toolkit.getDefaultToolkit(); // Toolkit omogućava interakciju sa platformom
        Dimension screenSize = kit.getScreenSize(); // Veličina ekrana
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 4, screenHeight / 4);
        setLocationRelativeTo(null); // Centriranje prozora na ekranu
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Zatvaranje aplikacije pri zatvaranju prozora

        Label label = new Label("Do you want to add a new Presentation or a new Slide?");
        add(label, BorderLayout.NORTH);
        this.buttonPresentation = new JRadioButton("Presentation");
        add(buttonPresentation, BorderLayout.WEST);
        this.buttonSlide = new JRadioButton("Slide");
        add(buttonSlide, BorderLayout.EAST);
    }

    public JToggleButton getButtonSlide() {
        return buttonSlide;
    }

    public JToggleButton getButtonPresentation() {
        return buttonPresentation;
    }
}
