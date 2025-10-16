package raf.graffito.dsw.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AboutUsAction extends AbstractAction {
    JFrame jf = new JFrame("About us");

    Box hbox=Box.createHorizontalBox();


    public AboutUsAction()
    {
        jf.setSize(520,450);
        ImageIcon slika1=new ImageIcon(getClass().getResource("/images/kalinaimage.png"));
        JLabel label1=new JLabel("Kalina Stojanovic SI 8/2024",slika1, JLabel.CENTER);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.BOTTOM);
        ImageIcon slika2=new ImageIcon(getClass().getResource("/images/jugimage.png"));
        JLabel label2=new JLabel("Jug Basorovic SI 5/2024",slika2, JLabel.CENTER);
        label2.setHorizontalTextPosition(JLabel.CENTER);
        label2.setVerticalTextPosition(JLabel.BOTTOM);
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
}
