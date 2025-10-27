package raf.graffito.dsw.core.messageGenerator;


public interface MessagePublisher1 {
  public void addSubscriber(Subscriber subscriber);
  public void removeSubscriber(Subscriber subscriber);
  public void notifyAll(Message message);


}
