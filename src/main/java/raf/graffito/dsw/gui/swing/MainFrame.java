package raf.graffito.dsw.gui.swing;

import raf.graffito.dsw.core.messageGenerator.Message;
import raf.graffito.dsw.core.messageGenerator.MessageGenerator;
import raf.graffito.dsw.core.messageGenerator.Subscriber;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame implements Subscriber  {

    // Buduća polja za sve komponente view-a na glavnom prozoru

    private static MainFrame instance;
    private List<Subscriber> subs=new ArrayList<>();
    private MainFrame() {
        initialize();
        subs.add(this);

    MessageGenerator mg=new MessageGenerator(subs);
    }

    public static MainFrame getInstance() {
        if(instance== null)  instance=new MainFrame();
        return instance;


    }

    private void initialize() {
        Toolkit kit = Toolkit.getDefaultToolkit(); // Toolkit omogućava interakciju sa platformom
        Dimension screenSize = kit.getScreenSize(); // Veličina ekrana
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null); // Centriranje prozora na ekranu
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Zatvaranje aplikacije pri zatvaranju prozora
        setTitle("Graffito"); // Naslov prozora

        MyMenuBar menu = new MyMenuBar(); // Kreiranje menija
        setJMenuBar(menu); // Postavljanje menija na prozor

        MyToolBar toolBar = new MyToolBar(); // Kreiranje toolbar-a
        add(toolBar, BorderLayout.NORTH); // Postavljanje toolbar-a na vrh prozora
    }


    @Override
    public void ispisiPoruku(Message message) {

    }
}
