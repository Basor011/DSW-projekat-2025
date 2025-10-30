package raf.graffito.dsw.gui.swing;



import raf.graffito.dsw.controller.AboutUsAction;
import raf.graffito.dsw.controller.ExitAction;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {
    private MainFrame mainFrame;
    public MyMenuBar(MainFrame mainFrame) {
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        this.mainFrame = mainFrame;

        fileMenu.add(mainFrame.getActionManager().getExitAction());
        fileMenu.add(mainFrame.getActionManager().getAboutUsAction());

        add(fileMenu);

    }

}
