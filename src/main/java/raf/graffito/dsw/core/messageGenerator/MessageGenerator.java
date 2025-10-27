package raf.graffito.dsw.core.messageGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MessagePublisher implements MessageGenerator {
    private List<Subscriber> subscriberList=new ArrayList<>();

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscriberList.remove(subscriber);
    }

    @Override
    public void notifyAll(Message message) {
         for(Subscriber s : subscriberList)
         {
             s.update(message);
         }
    }

    public void generateError(String content)
    {
        LocalDateTime time = LocalDateTime.now();
        Message message=new Message(content,"GRESKA",time);
        notifyAll(message);
    }
    public void generateWarning(String content)
    {
        LocalDateTime time = LocalDateTime.now();
        Message message=new Message(content,"UPOZORENJE",time);
        notifyAll(message);
    }
    public void generateInfo(String content)
    {
        LocalDateTime time = LocalDateTime.now();
        Message message=new Message(content,"OBAVESTENJE",time);
        notifyAll(message);
    }
}
