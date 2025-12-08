package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.gui.swing.tree.observer.TBSubscriber;
import javax.swing.*;
import java.awt.*;


public class RightPane extends JPanel implements TBSubscriber {
    private JLabel projectNameLabel;
    private JLabel presentationNameLabel;
    private JButton addTextFieldButton;
    private JButton addLogoButton;
    private JButton addImageButton;

    public RightPane(JLabel projectNameLabel, JLabel presentationNameLabel) {
        this.projectNameLabel = projectNameLabel;
        this.presentationNameLabel = presentationNameLabel;
        this.addTextFieldButton = new JButton("TEXT FIELD");
        this.addLogoButton = new JButton("LOGO");
        this.addImageButton = new JButton("IMAGE");

        setLayout(new BorderLayout());
        JPanel topPanel = new JPanel();

        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(projectNameLabel);
        topPanel.add(presentationNameLabel);
        topPanel.add(addTextFieldButton);
        topPanel.add(addLogoButton);
        topPanel.add(addImageButton);

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
