package raf.graffito.dsw.controller;

import raf.graffito.dsw.core.ApplicationFramework;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public abstract class AbstractGraffAction extends AbstractAction {

     public Icon loadIcon(String path){
         URL ImageURL = getClass().getResource(path); // URL služi za pronalaženje resursa unutar JAR fajla ili klase
         if (ImageURL != null) {
             Image img = new ImageIcon(ImageURL).getImage(); // Napravimo Image iz ImageIcon
             Image newImg = img.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
             return new ImageIcon(newImg);
         } else {
             ApplicationFramework.getInstance().getMg().generateError("File ne postoji hej");
         }
         return null;
     }

}
