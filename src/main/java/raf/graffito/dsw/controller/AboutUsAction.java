package raf.graffito.dsw.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;

public class AboutUsAction extends AbstractGraffAction {
    JFrame jf = new JFrame("About us");

    Box hbox=Box.createHorizontalBox();


    public AboutUsAction()
    {
        putValue(NAME, "About us");
        Icon slika1=loadIcon("/images/kalinaimage.png");
        JLabel label1=new JLabel("Kalina Stojanovic SI 8/2024",slika1, JLabel.CENTER);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.BOTTOM);
        Icon slika2=loadIcon("/images/jugimage.png");
        JLabel label2=new JLabel("Jug Basorovic SI 5/2024",slika2, JLabel.CENTER);

        label2.setHorizontalTextPosition(JLabel.CENTER);
        label2.setVerticalTextPosition(JLabel.BOTTOM);
        jf.setSize(510,300);
        hbox.add(label1);
        hbox.add(hbox.createHorizontalStrut(30));
        hbox.add(label2);
        jf.add(hbox);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }

    @Override
    protected Icon loadIcon(String path){
        Icon icon = null;
        URL ImageURL = getClass().getResource(path); // URL služi za pronalaženje resursa unutar JAR fajla ili klase
        if (ImageURL != null) {
            Image img = new ImageIcon(ImageURL).getImage(); // Napravimo Image iz ImageIcon
            Image newImg = img.getScaledInstance(240, 240, Image.SCALE_DEFAULT);
            icon = new ImageIcon(newImg);
        } else {
            System.err.println("File " + "images/exit.png" + " not found");
        }
        return icon;
    }

}
