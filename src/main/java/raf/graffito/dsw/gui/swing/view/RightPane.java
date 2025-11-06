package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.gui.swing.tree.observer.TBSubscriber;
import javax.swing.*;
import java.awt.*;


public class RightPane extends JPanel implements TBSubscriber {
    private JLabel projectNameLabel;
    private JLabel presentationNameLabel;

    public RightPane(JLabel projectNameLabel, JLabel presentationNameLabel) {
        this.projectNameLabel=projectNameLabel;
        this.presentationNameLabel=presentationNameLabel;

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();

        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(projectNameLabel);
        topPanel.add(presentationNameLabel);

        add(topPanel, BorderLayout.NORTH);
    }

    @Override
    public void update(String presentationName, String projectName) {

       if(presentationName == null) this.projectNameLabel.setText(projectName);
       else if(projectName == null) this.presentationNameLabel.setText(presentationName);

       else{
            this.projectNameLabel.setText(projectName);
            this.presentationNameLabel.setText(presentationName);
       }



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
