package raf.graffito.dsw.gui.swing.view;



import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {
    public MyMenuBar(MainFrame mainFrame) {
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.add(mainFrame.getActionManager().getExitAction());

        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);
        editMenu.add(mainFrame.getActionManager().getNewChildAction());
        editMenu.add(mainFrame.getActionManager().getRemoveChildAction());
        editMenu.addSeparator();

        JMenu aboutUs = new JMenu("About");
        aboutUs.setMnemonic(KeyEvent.VK_A);
        aboutUs.add(mainFrame.getActionManager().getAboutUsAction());


        this.add(fileMenu);
        this.add(editMenu);
        this.add(aboutUs);
    }

}
