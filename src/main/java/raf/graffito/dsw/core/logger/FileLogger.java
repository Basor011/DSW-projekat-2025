package raf.graffito.dsw.core.logger;

import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.core.messageGenerator.Message;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger{
    @Override
    public void ispisiPoruku(Message message) {
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter("src/main/resources/logger.txt",true));
            bw.write(message.toString());
            bw.newLine();
            bw.close();
        } catch (IOException e) {

            ApplicationFramework.getInstance().getMg().generateError("Greska sa fajlom bro");
        }

    }
}
