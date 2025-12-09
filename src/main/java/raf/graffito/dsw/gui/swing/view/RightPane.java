    package raf.graffito.dsw.gui.swing.view;

    import raf.graffito.dsw.controller.state.StateManager;
    import raf.graffito.dsw.gui.swing.tree.observer.TBSubscriber;
    import javax.swing.*;
    import java.awt.*;


    public class RightPane extends JPanel implements TBSubscriber {
        private JLabel projectNameLabel;
        private JLabel presentationNameLabel;

        private StateManager stateManager;
        private JButton buttonAddImage;
        private JButton buttonAddTextField;
        private JButton buttonAddLogo;
        private JButton buttonMoveElement;

        public RightPane(JLabel projectNameLabel, JLabel presentationNameLabel) {
            this.projectNameLabel = projectNameLabel;
            this.presentationNameLabel = presentationNameLabel;
            stateManager = MainFrame.getInstance().getStateManager();
            setLayout(new BorderLayout());

            JPanel topPanel = new JPanel();
            topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
            topPanel.add(projectNameLabel);
            topPanel.add(presentationNameLabel);
            add(topPanel, BorderLayout.NORTH);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
            this.buttonAddImage = new JButton(MainFrame.getInstance().getActionManager().getAddImageButton());
            this.buttonAddTextField = new JButton(MainFrame.getInstance().getActionManager().getAddTextFieldButton());
            this.buttonAddLogo = new JButton(MainFrame.getInstance().getActionManager().getAddLogoButton());
            this.buttonMoveElement = new JButton(MainFrame.getInstance().getActionManager().getMoveAction());
            buttonPanel.add(buttonAddImage);
            buttonPanel.add(buttonAddTextField);
            buttonPanel.add(buttonAddLogo);
            buttonPanel.add(buttonMoveElement);

            add(buttonPanel, BorderLayout.CENTER);
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
