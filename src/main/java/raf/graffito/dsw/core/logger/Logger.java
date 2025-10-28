package raf.graffito.dsw.core.logger;
import raf.graffito.dsw.core.messageGenerator.Message;
import raf.graffito.dsw.core.messageGenerator.Subscriber;



public interface Logger extends Subscriber {
    @Override
    default void ispisiPoruku(Message message) {

    }
}
