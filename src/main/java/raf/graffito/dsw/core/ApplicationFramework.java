package raf.graffito.dsw.core;
import raf.graffito.dsw.core.logger.LoggerFactory;
import raf.graffito.dsw.core.messageGenerator.MessageGenerator;
import raf.graffito.dsw.core.observer.Subscriber;
import raf.graffito.dsw.gui.swing.view.MainFrame;

import java.util.ArrayList;
import java.util.List;

public class ApplicationFramework  {
    // Buduća polja za model celog projekta
    private static ApplicationFramework instance;

    List<Subscriber> subscribers;
    public Gui gui;
    protected GraffRepository gr;

    private ApplicationFramework(){};
    public static ApplicationFramework getInstance(){
        if(instance == null){
            instance = new ApplicationFramework();
        }
        return instance;
    }

    public void initialize(Gui gui, GraffRepository gr){
        this.gui = gui;
        this.gr =  gr;
        subscribers =  new ArrayList<Subscriber>();
        MessageGenerator messageGenerator = new MessageGenerator(subscribers);
        LoggerFactory loggerFactory = new LoggerFactory();

        MainFrame mainFrame = MainFrame.getInstance(); ///napravili mf
        mainFrame.setVisible(true);

        messageGenerator.addSubscriber(mainFrame);
        /// nisam sigurna
        messageGenerator.addSubscriber(loggerFactory.createLogger("consoleLogger"));
        messageGenerator.addSubscriber(loggerFactory.createLogger("fileLogger"));
    }
    public void run(){
        this.gui.start();
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    public Gui getGui() {
        return gui;
    }

    public GraffRepository getGr() {
        return gr;
    }
}
