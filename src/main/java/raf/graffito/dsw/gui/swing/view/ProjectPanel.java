package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.gui.swing.view.observer.ProjectObserver;
import javax.swing.*;
import java.awt.*;


public class ProjectPanel extends JPanel implements ProjectObserver {
    private JLabel projectNameLabel;
    private JLabel presentationNameLabel;


    public ProjectPanel(JLabel projectNameLabel, JLabel presentationNameLabel) {
        this.projectNameLabel=projectNameLabel;
        this.presentationNameLabel=presentationNameLabel;

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();

        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS)); // stack vertically
        topPanel.add(projectNameLabel);
        topPanel.add(presentationNameLabel);

        add(topPanel, BorderLayout.NORTH);
    }

    @Override
    public void update(String presentationName, String projectName) {

        this.projectNameLabel.setText(projectName);
        this.presentationNameLabel.setText(presentationName);


    }

    public JLabel getProjectNameLabel() {
        return projectNameLabel;
    }

    public void setProjectNameLabel(JLabel projectNameLabel) {
        this.projectNameLabel = projectNameLabel;
    }

    public JLabel getPresentationNameLabel() {
        return presentationNameLabel;
    }

    public void setPresentationNameLabel(JLabel presentationNameLabel) {
        this.presentationNameLabel = presentationNameLabel;
    }
}
