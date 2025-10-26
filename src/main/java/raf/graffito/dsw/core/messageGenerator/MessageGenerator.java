package raf.graffito.dsw.core.messageGenerator;


public interface MessageGenerator {
  public void addSubscriber(Subscriber subscriber);
  public void removeSubscriber(Subscriber subscriber);
  public void notifyAll(Message message);


}
