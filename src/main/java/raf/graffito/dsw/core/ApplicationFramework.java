package raf.graffito.dsw.core;
import raf.graffito.dsw.core.logger.LoggerFactory;
import raf.graffito.dsw.core.messageGenerator.MessageGenerator;
import raf.graffito.dsw.core.observer.Subscriber;
import raf.graffito.dsw.gui.swing.view.MainFrame;

import java.util.ArrayList;
import java.util.List;

public class ApplicationFramework  {
    // Buduća polja za model celog projekta
    List<Subscriber> subscribers;
    public ApplicationFramework(){
        initialize();
    }

    public void initialize(){
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

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }
}
