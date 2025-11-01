package raf.graffito.dsw.gui.swing.view;

import javax.swing.*;
import java.awt.*;

public class PresentationOrSlidePopUp extends JFrame {
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

        TextField textField = new TextField("Do you want to add a new Presentation of a new Slide?");
        add(textField, BorderLayout.NORTH);
        Button buttonPresentation = new Button("Presentation");
        add(buttonPresentation, BorderLayout.WEST);
        Button buttonSlide = new Button("Slide");
        add(buttonSlide, BorderLayout.EAST);
    }
}
