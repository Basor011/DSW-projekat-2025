package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.gui.swing.view.observer.PanelSubscriber;

import javax.swing.*;

public class ProjectPanel extends JPanel implements PanelSubscriber {
    private JLabel projectNameLabel;
    private JLabel authorNameLabel;

    public ProjectPanel(JLabel projectNameLabel, JLabel authorNameLabel) {
        this.projectNameLabel = projectNameLabel;
        this.authorNameLabel = authorNameLabel;
    }

    @Override
    public void update() {
        //projectNameLabel.setText();
       //authorNameLabel.setText();

    }
}
