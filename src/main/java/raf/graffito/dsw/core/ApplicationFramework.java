package raf.graffito.dsw.core;
import raf.graffito.dsw.core.logger.ConsoleLogger;
import raf.graffito.dsw.core.logger.FileLogger;
import raf.graffito.dsw.core.logger.LoggerFactory;
import raf.graffito.dsw.core.messageGenerator.Message;
import raf.graffito.dsw.core.messageGenerator.MessageGenerator;
import raf.graffito.dsw.core.messageGenerator.Subscriber;
import raf.graffito.dsw.gui.swing.MainFrame;

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
        MainFrame mainFrame = MainFrame.getInstance();
        mainFrame.setVisible(true);
        messageGenerator.addSubscriber(mainFrame);
        messageGenerator.addSubscriber(loggerFactory.createLogger("ConsoleLogger"));
        messageGenerator.addSubscriber(loggerFactory.createLogger("FileLogger"));
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }
}
