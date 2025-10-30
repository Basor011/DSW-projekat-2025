package raf.graffito.dsw.gui.swing;

import raf.graffito.dsw.controller.ActionManager;
import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.core.messageGenerator.Message;
import raf.graffito.dsw.core.messageGenerator.Subscriber;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Flow;

public class MainFrame extends JFrame implements Subscriber {

    // Buduća polja za sve komponente view-a na glavnom prozoru
    private ActionManager actionManager;
    private static MainFrame instance;

    private MainFrame() {
        actionManager = new ActionManager();
        instance = this;
        initialize();

    }
    public static MainFrame getInstance() {
        if(instance== null) {
            instance=new MainFrame();
        }
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

    public ActionManager getActionManager() {
        return actionManager;
    }

    @Override
    public void ispisiPoruku(Message message) {
        if (message.getType().equals("GRESKA") || message.getType().equals("OBAVESTENJE")){
            JOptionPane.showMessageDialog(null, message.toString() + " " + message.getType());
        }
        else return;
    }
}
