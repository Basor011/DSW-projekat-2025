package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.controller.state.StateManager;
import raf.graffito.dsw.gui.swing.tree.observer.TBSubscriber;
import javax.swing.*;
import java.awt.*;


public class RightPane extends JPanel implements TBSubscriber {
    private JLabel projectNameLabel;
    private JLabel presentationNameLabel;

    private JButton addTextFieldButton;
    private JButton addLogoButton;
    private JButton addImageButton;

    private StateManager stateManager;
    private SlideView slideView;

    public RightPane(JLabel projectNameLabel, JLabel presentationNameLabel) {
        this.projectNameLabel = projectNameLabel;
        this.presentationNameLabel = presentationNameLabel;
        this.addTextFieldButton = new JButton("TEXT FIELD");
        this.addLogoButton = new JButton("LOGO");
        this.addImageButton = new JButton("IMAGE");
        stateManager = new StateManager();

        setLayout(new BorderLayout());
        JPanel topPanel = new JPanel();

        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(projectNameLabel);
        topPanel.add(presentationNameLabel);
        topPanel.add(new JButton(MainFrame.getInstance().getStateActionManager().getMoveAction()));
        topPanel.add(new JButton(MainFrame.getInstance().getStateActionManager().getAddImageButton()));
        topPanel.add(new JButton(MainFrame.getInstance().getStateActionManager().getAddTextFieldButton()));
        topPanel.add(new JButton(MainFrame.getInstance().getStateActionManager().getAddLogoButton()));

        add(topPanel, BorderLayout.NORTH);

    }
    public void startMoveState() {
        this.stateManager.setMoveState();
    }
    public void startAddImageState() {
        this.stateManager.setAddImageState("images/bananaleclerc.jpg");
    }
    public void startAddLogoState() {
        this.stateManager.setAddLogoState();
    }
    public void startAddTextFieldState(){
        this.stateManager.setAddTextFieldState();
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
