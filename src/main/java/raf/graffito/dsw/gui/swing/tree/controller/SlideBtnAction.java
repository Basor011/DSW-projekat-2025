package raf.graffito.dsw.gui.swing.tree.controller;

import raf.graffito.dsw.gui.swing.tree.view.PresentationOrSlidePopUp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class
SlideBtnAction implements ActionListener {
    private PresentationOrSlidePopUp pop;
    public SlideBtnAction(PresentationOrSlidePopUp pop) {
        this.pop = pop;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pop.isSlide();
        pop.close();
    }
}
