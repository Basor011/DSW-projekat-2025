package raf.graffito.dsw.core;
import raf.graffito.dsw.core.messageGenerator.Message;
import raf.graffito.dsw.core.messageGenerator.Subscriber;
import raf.graffito.dsw.gui.swing.MainFrame;

public class ApplicationFramework  {
    // Buduća polja za model celog projekta

    public ApplicationFramework(){
        initialize();
    }

    public void initialize(){
        MainFrame mainFrame = MainFrame.getInstance();
        mainFrame.setVisible(true);

    }

}
