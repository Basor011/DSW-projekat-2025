package raf.graffito.dsw.core;
import raf.graffito.dsw.core.logger.LoggerFactory;
import raf.graffito.dsw.core.messageGenerator.MessageGenerator;
import raf.graffito.dsw.core.observer.Subscriber;
import raf.graffito.dsw.gui.swing.GraffRepositoryImplementation;
import raf.graffito.dsw.gui.swing.tree.GraffTreeImplementation;
import raf.graffito.dsw.gui.swing.view.MainFrame;

import java.util.ArrayList;
import java.util.List;

public class ApplicationFramework  {
    // Buduća polja za model celog projekta
    private static ApplicationFramework instance;


    List<Subscriber> subscribers;

    protected GraffRepository gr;
    private MessageGenerator mg;

    private ApplicationFramework(){};
    public static ApplicationFramework getInstance(){
        if(instance == null){
            instance = new ApplicationFramework();
        }
        return instance;
    }

    public void initialize(GraffRepository gr){

        this.gr=gr;
        subscribers =  new ArrayList<Subscriber>();
        this.mg = new MessageGenerator(subscribers);
        LoggerFactory loggerFactory = new LoggerFactory();

        MainFrame mainFrame = MainFrame.getInstance(); ///napravili mf
        mainFrame.setVisible(true);

        mg.addSubscriber(mainFrame);
        mg.addSubscriber(loggerFactory.createLogger("consoleLogger"));
        mg.addSubscriber(loggerFactory.createLogger("fileLogger"));
    }


    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    public GraffRepository getGr() {
        return gr;
    }

    public MessageGenerator getMg() {
        return mg;
    }
}
