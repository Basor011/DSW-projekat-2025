package raf.graffito.dsw.gui.swing.view;



import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {
    public MyMenuBar() {
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.add(MainFrame.getInstance().getActionManager().getExitAction());

        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);
        editMenu.add(MainFrame.getInstance().getActionManager().getNewChildAction());
        editMenu.add(MainFrame.getInstance().getActionManager().getRemoveChildAction());
        ///editMenu.add(MainFrame.getInstance().get)

        JMenu aboutUs = new JMenu("About");
        aboutUs.setMnemonic(KeyEvent.VK_A);
        aboutUs.add(MainFrame.getInstance().getActionManager().getAboutUsAction());


        this.add(fileMenu);
        this.add(editMenu);
        this.add(aboutUs);
    }

}
