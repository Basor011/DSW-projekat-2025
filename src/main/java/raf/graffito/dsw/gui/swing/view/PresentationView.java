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
    private JPanel panel;
    private JPanel panel2;
    private int lastVisited;

    public PresentationView(String title, GraffNodeComposite presentation)
    {
        this.setName(title);
        this.presentation = presentation;
        panel= new JPanel();
        lastVisited=0;
        buttonClockwise=new JButton("Rotate 90");
        buttonCClockwise= new JButton("Rotate -90");
       panel.add(buttonCClockwise);
       panel.add(buttonClockwise);
        panel.setPreferredSize(new Dimension(200,100));
        panel2= new JPanel();
        panel2.setPreferredSize(panel.getPreferredSize());
        panel2.setMinimumSize(panel.getPreferredSize());
        panel2.setMaximumSize(panel.getPreferredSize());
        panel2.add(panel, BorderLayout.CENTER);
      // panel2.add(panel);
        slajdovi=new ArrayList<>();
        setLayout(new BorderLayout());
        for(GraffNode child : presentation.getChildren()) {
            if(child instanceof Slide) {
                SlideView toAdd = new SlideView((Slide) child, MainFrame.getInstance().getStateManager());
                slajdovi.add(toAdd);
            }
        }
        if(!slajdovi.isEmpty()) {
            // Create label for top left
            JLabel label = new JLabel(slajdovi.getFirst().getSlideModel().getName());
            label.setFont(new Font("SansSerif", Font.BOLD, 24));

            // Create a container for label (top left) and slideview (below it)
            JPanel leftContainer = new JPanel(new BorderLayout());
            leftContainer.add(label, BorderLayout.NORTH);

            // SlideView that maintains its fixed size
            SlideView slideView = slajdovi.get(lastVisited);
            slideView.setPreferredSize(slideView.getPreferredSize());
            slideView.setMinimumSize(slideView.getPreferredSize());
            slideView.setMaximumSize(slideView.getPreferredSize());

            JPanel slideContainer = new JPanel();
            slideContainer.setLayout(new BoxLayout(slideContainer, BoxLayout.Y_AXIS));
            slideContainer.add(slideView);
            leftContainer.add(slideContainer, BorderLayout.CENTER);

            // Add left container to center of main layout
            add(leftContainer, BorderLayout.CENTER);
        }
       add(panel2, BorderLayout.EAST);
        panel.setVisible(false);
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
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void update(Notification notification, GraffTreeItem node)  ///  node=selektovan slajd
    {
        if (!(notification == Notification.SLIDE_SELECTED)) return;



        GraffNode openProject = MainFrame.getInstance().getTabbedPane().getLatestNode().getGraffNode();
        if (node.getGraffNode().getParent().getParent().equals(openProject)) {
            for (SlideView slajd : slajdovi) {
                if (slajd.getSlideModel().equals(node.getGraffNode())) { // ako je neki slajd u ovom projektu jednak prosledjenom

                    ((GraffTreeImplementation) MainFrame.getInstance().getGraffTree()).sendingToAll(Notification.SWITCH_TABS,node);

                    removeAll();
                    JPanel wrapper = new JPanel(new GridBagLayout());
                    wrapper.add(slajd);
                    JLabel label=new JLabel(slajd.getSlideModel().getName());
                    label.setFont(new Font("SansSerif", Font.BOLD, 24));
                    add(label,BorderLayout.PAGE_START);
                    add(wrapper);
                    revalidate();
                    repaint();
                }
            }


        }
    }
}
