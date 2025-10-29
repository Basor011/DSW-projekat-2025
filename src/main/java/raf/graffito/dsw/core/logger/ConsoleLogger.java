package raf.graffito.dsw.core.logger;

import raf.graffito.dsw.core.messageGenerator.Message;

public class ConsoleLogger implements  Logger{
    @Override
    public void ispisiPoruku(Message message) {
        System.out.println(message.toString());
    }
}
