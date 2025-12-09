package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.controller.state.StateManager;
import raf.graffito.dsw.gui.swing.tree.controller.state_actions.StateActionManager;
import raf.graffito.dsw.gui.swing.tree.observer.TBSubscriber;
import javax.swing.*;
import java.awt.*;


public class RightPane extends JPanel implements TBSubscriber {
    private JLabel projectNameLabel;
    private JLabel presentationNameLabel;

    private JButton addTextFieldButton;
    private JButton addLogoButton;
    private JButton addImageButton;
    private JButton moveButton;

    private StateManager stateManager;
    private SlideView slideView;

    public RightPane(JLabel projectNameLabel, JLabel presentationNameLabel) {
        this.projectNameLabel = projectNameLabel;
        this.presentationNameLabel = presentationNameLabel;
        this.addTextFieldButton = new JButton("TEXT FIELD");
        this.addLogoButton = new JButton("LOGO");
        this.addImageButton = new JButton("IMAGE");
        this.moveButton = new JButton("MOVE");
        addTextFieldButton.addActionListener(e -> startAddTextFieldState());
        addLogoButton.addActionListener(e -> startAddLogoState());
        addImageButton.addActionListener(e -> startAddImageState());
        moveButton.addActionListener(e -> startMoveState());
        stateManager = MainFrame.getInstance().getStateManager();

        setLayout(new BorderLayout());
        JPanel topPanel = new JPanel();

        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(projectNameLabel);
        topPanel.add(presentationNameLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));

        buttonPanel.add(addTextFieldButton);
        buttonPanel.add(addLogoButton);
        buttonPanel.add(addImageButton);

        add(buttonPanel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

    }
    public void startMoveState() {stateManager.setMoveState();}
    public void startAddImageState() {stateManager.setAddImageState("images/bananaleclerc.jpg");}
    public void startAddLogoState() {stateManager.setAddLogoState();}
    public void startAddTextFieldState(){stateManager.setAddTextFieldState();}

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
