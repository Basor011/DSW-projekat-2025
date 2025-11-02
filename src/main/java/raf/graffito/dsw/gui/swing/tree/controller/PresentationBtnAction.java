package raf.graffito.dsw.gui.swing.tree.controller;

import raf.graffito.dsw.gui.swing.tree.view.PresentationOrSlidePopUp;
import raf.graffito.dsw.model.implementations.leaves.compositions.Presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PresentationBtnAction implements ActionListener {
    private PresentationOrSlidePopUp pop;

    public PresentationBtnAction(PresentationOrSlidePopUp pop) {
        this.pop = pop;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pop.isPresentation();
        pop.close();
    }
}
