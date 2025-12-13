package raf.graffito.dsw.gui.swing.view;


import raf.graffito.dsw.gui.swing.tree.GraffTreeImplementation;
import raf.graffito.dsw.gui.swing.tree.GraffTreeItem;
import raf.graffito.dsw.gui.swing.tree.observer.Notification;
import raf.graffito.dsw.gui.swing.tree.observer.PSubscriber;
import raf.graffito.dsw.model.composite.GraffNode;
import raf.graffito.dsw.model.composite.GraffNodeComposite;
import raf.graffito.dsw.model.composite.compositions.Slide;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PresentationView extends JPanel implements  PSubscriber {

    private GraffNodeComposite presentation;
    private List<SlideView> slajdovi;
    private JButton buttonCClockwise;
    private  JButton buttonClockwise;
    private JPanel buttonContainer;
    private JPanel leftContainer;
    private SlideView lastSelectedSlide;
    private JLabel titleLabel;
    private JPanel titleContainer;
    private JPanel slideContainer;

    public PresentationView(String title, GraffNodeComposite presentation)
    {
        this.setName(title);
        this.presentation = presentation;

        slajdovi=new ArrayList<>();
        for(GraffNode child : presentation.getChildren()) {
            if(child instanceof Slide) {
                SlideView toAdd = new SlideView((Slide) child, MainFrame.getInstance().getStateManager());
                slajdovi.add(toAdd);
            }
        }
        initUI();

        if(!slajdovi.isEmpty()){
            lastSelectedSlide =slajdovi.getFirst();
            showSlide(lastSelectedSlide);
            ((GraffTreeImplementation) MainFrame.getInstance().getGraffTree()).setSelectedNode(lastSelectedSlide);
        }

        buttonContainer.setVisible(false);

    }

    private void initUI()
    {
        removeAll();
        setLayout(new BorderLayout());
      buttonClockwise=new JButton("Rotate 90");buttonCClockwise=new JButton("Rotate -90");
      buttonContainer=new JPanel(); buttonContainer.add(buttonClockwise);buttonContainer.add(buttonCClockwise);
      titleLabel= new JLabel();titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));

      slideContainer=new JPanel();
      slideContainer.setLayout(new BoxLayout(slideContainer, BoxLayout.Y_AXIS));

      leftContainer=new JPanel(new BorderLayout());
      leftContainer.add(titleLabel,BorderLayout.PAGE_START);
      leftContainer.add(slideContainer,BorderLayout.WEST);

        add(leftContainer,BorderLayout.CENTER);
        add(buttonContainer, BorderLayout.EAST);
    }

    public void showSlide(SlideView slideView){
        titleLabel.setText(slideView.getSlideModel().getName());
        slideContainer.removeAll();
        slideContainer.add(slideView);
        slideContainer.repaint();
        slideContainer.revalidate();
        lastSelectedSlide=slideView;

        this.repaint();
        this.revalidate();
    }

    @Override
    public void update(Notification notification, GraffTreeItem node)  ///  node=selektovan slajd
    {
        if (!(notification == Notification.SLIDE_SELECTED)) return;


        GraffNode currentlyOpenProject = MainFrame.getInstance().getTabbedPane().getLatestNode().getGraffNode();
        GraffNode slideParent=node.getGraffNode().getParent();

        if (node.getGraffNode().getParent().getParent().equals(currentlyOpenProject)) { // slajd pripada trenutno otvorenom projektu
            for (SlideView slajd : slajdovi) {
                if (slajd.getSlideModel().equals(node.getGraffNode())) { // trenutna prezentacija ima ovaj slajd

                    ((GraffTreeImplementation) MainFrame.getInstance().getGraffTree()).sendingToAll(Notification.SWITCH_TABS,node);
                    showSlide(slajd);

                    System.out.println("Selecting slide "+  slajd.getSlideModel().getName());
                    System.out.println(lastSelectedSlide.getSlideModel().getName());

                    revalidate();
                    repaint();
                }
            }
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
}
