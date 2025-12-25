package raf.graffito.dsw.gui.swing.view;


import raf.graffito.dsw.controller.ActionManager;
import raf.graffito.dsw.controller.radio_buttons.MatrixNacin;
import raf.graffito.dsw.controller.radio_buttons.SumNacin;
import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.gui.swing.tree.GraffTreeImplementation;
import raf.graffito.dsw.gui.swing.tree.GraffTreeItem;
import raf.graffito.dsw.gui.swing.tree.observer.Notification;
import raf.graffito.dsw.gui.swing.tree.observer.PSubscriber;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.composite.compositions.Presentation;
import raf.graffito.dsw.model.composite.compositions.Project;
import raf.graffito.dsw.model.composite.compositions.Slide;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PresentationView extends JPanel implements  PSubscriber {

    private GraffNodeComposite presentation;
    private List<SlideView> slajdovi;
    private SlideView lastSelectedSlide;
    private JButton buttonCClockwise,buttonClockwise;
    private JRadioButton matrica,sabiranje;
    private ButtonGroup buttonGroup;
    private JPanel buttonContainer,radioButtonContainer,leftContainer,slideContainer;
    private JLabel titleLabel;
    private ActionManager actionManager;

    public PresentationView(String title, GraffNodeComposite presentation)
    {
        this.setName(title);
        this.presentation = presentation;
        actionManager=new ActionManager();
        slajdovi=new ArrayList<>();

        if(presentation instanceof Slide slide)
        {
            System.out.println("dodat");
            SlideView toAdd= new SlideView(slide,MainFrame.getInstance().getStateManager());
            slajdovi.add(toAdd);
        }
        for(GraffNode child : presentation.getChildren()) {
            if(child instanceof Slide) {
                SlideView toAdd = new SlideView((Slide) child, MainFrame.getInstance().getStateManager());
                slajdovi.add(toAdd);
            }
        }
        initUI();
/*
        if(!slajdovi.isEmpty()){
            lastSelectedSlide =slajdovi.getFirst();
            showSlide(lastSelectedSlide);
            ((GraffTreeImplementation) MainFrame.getInstance().getGraffTree()).setSelectedNode(lastSelectedSlide);
        }
        */
        buttonCClockwise.setActionCommand("counterclockwise");
       buttonCClockwise.addActionListener(actionManager.getRotateElementAction());
        buttonClockwise.setActionCommand("clockwise");
        buttonClockwise.addActionListener(actionManager.getRotateElementAction());
        buttonContainer.setVisible(false);

    }

    private void initUI()
    {
        removeAll();
        setLayout(new BorderLayout());
        buttonClockwise = new JButton("Rotate 90");
        buttonCClockwise = new JButton("Rotate -90");
        buttonContainer = new JPanel();
        buttonContainer.setLayout(new BoxLayout(buttonContainer,BoxLayout.Y_AXIS));
        buttonContainer.add(buttonClockwise);
        buttonContainer.add(buttonCClockwise);
        titleLabel = new JLabel();
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        matrica = new JRadioButton();matrica.setAction(new MatrixNacin());;matrica.setText("Nacin matrice");
        sabiranje = new JRadioButton();sabiranje.setAction(new SumNacin());sabiranje.setText("Nacin sabiranja");
        buttonGroup = new ButtonGroup();
        buttonGroup.add(matrica);
        buttonGroup.add(sabiranje);
        radioButtonContainer=new JPanel();
        radioButtonContainer.add(matrica);
        radioButtonContainer.add(sabiranje);
        matrica.setSelected(true);


      slideContainer=new JPanel();
      slideContainer.setLayout(new BoxLayout(slideContainer, BoxLayout.Y_AXIS));

      leftContainer=new JPanel(new BorderLayout());
      leftContainer.add(titleLabel,BorderLayout.PAGE_START);
      leftContainer.add(slideContainer,BorderLayout.WEST);

        add(leftContainer,BorderLayout.CENTER);
        add(buttonContainer, BorderLayout.EAST);
    }

    public void showSlide(SlideView slideView){
        if(slideView==null)
        {
            slideContainer.removeAll();
            titleLabel.setText("");
            slideContainer.repaint();
            slideContainer.revalidate();
            lastSelectedSlide=slajdovi.getFirst();
            return;
        }
        titleLabel.setText(slideView.getSlideModel().getName());
        slideContainer.removeAll();
        slideContainer.add(slideView);
        slideContainer.repaint();
        slideContainer.revalidate();
        slideContainer.add(radioButtonContainer,BorderLayout.SOUTH);
        lastSelectedSlide=slideView;

        this.repaint();
        this.revalidate();
    }

    @Override
    public void update(Notification notification, GraffTreeItem node)  ///  node=selektovan slajd
    {
        if (!(notification == Notification.SLIDE_SELECTED || notification == Notification.SLIDE_DELETED)) return;
       //System.out.println("usao");

        GraffNode currentlyOpenProject = MainFrame.getInstance().getTabbedPane().getLatestNode().getGraffNode();
        GraffNode slideParent = node.getGraffNode().getParent();
        if (notification == Notification.SLIDE_SELECTED) {
            if (node.getGraffNode().getParent().getParent().equals(currentlyOpenProject) || slideParent.equals(currentlyOpenProject)) { // slajd pripada trenutno otvorenom projektu
                for (SlideView slajd : slajdovi) {
                    if (slajd.getSlideModel().equals(node.getGraffNode())) { // trenutna prezentacija ima ovaj slajd

                        ((GraffTreeImplementation) MainFrame.getInstance().getGraffTree()).sendingToAll(Notification.SWITCH_TABS, node);
                        showSlide(slajd);

                        System.out.println("Selecting slide " + slajd.getSlideModel().getName());
                        System.out.println(lastSelectedSlide.getSlideModel().getName());

                        revalidate();
                        repaint();
                        return;
                    }
                }
            }
            return;

        }
            GraffNode parent= node.getGraffNode().getParent();
            if (parent instanceof Project project ) {
                if(node.getParent().getChildCount() == 1 ) {ApplicationFramework.getInstance().getMg().generateInfo("Projekat mora imati barem jedno dete"); return;}
               project.setIzmenjen(true);
            } //// TREBA DA SE IZMENI PROJECT.IZMENJEN AKO JE PREZENTACIJA
            else if (parent.getParent().equals(currentlyOpenProject)) { // slajd pripada trenutno otvorenom projektu
                for (SlideView slajd : slajdovi) {
                    if (slajd.getSlideModel().equals(node.getGraffNode())) { // trenutna prezentacija ima ovaj slajd
                        if(node.getParent()!=null) {
                            showSlide(null);
                        }
                    }
                }
            }
            if(node.getParent()!= null){
                MainFrame.getInstance().getGraffTree().removeNode(node);
            }
    }

    public String getTitle() {
        return this.getName();
    }
    public GraffNodeComposite getPresentation() {
        return presentation;
    }
    public List<SlideView> getSlajdovi() {
        return slajdovi;
    }
    public JPanel getButtonContainer() {
        return buttonContainer;
    }
    public JPanel getSlideContainer() {
        return slideContainer;
    }
    public JLabel getTitleLabel() {
        return titleLabel;
    }
    public SlideView getLastSelectedSlide() {
        return lastSelectedSlide;
    }
}
