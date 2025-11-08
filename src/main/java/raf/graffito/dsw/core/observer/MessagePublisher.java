package raf.graffito.dsw.core.observer;


import raf.graffito.dsw.core.messageGenerator.Message;

public interface MessagePublisher {
  public void addSubscriber(Subscriber subscriber);
  public void removeSubscriber(Subscriber subscriber);
  public void notifyAll(Message message);
}
