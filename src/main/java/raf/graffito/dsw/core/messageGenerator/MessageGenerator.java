package raf.graffito.dsw.core.messageGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MessageGenerator implements MessagePublisher {
    private List<Subscriber> subscriberList =new ArrayList<>();

    public MessageGenerator(List<Subscriber> subscriberList) {
        this.subscriberList = subscriberList;
    }

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
             s.ispisiPoruku(message);
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

    public List<Subscriber> getSubscriberList() {
        return subscriberList;
    }
}
