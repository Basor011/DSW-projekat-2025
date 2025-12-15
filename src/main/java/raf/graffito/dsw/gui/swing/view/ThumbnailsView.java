package raf.graffito.dsw.gui.swing.view;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ThumbnailsView extends JPanel
{
     private List<ImageIcon> slike;


    public ThumbnailsView() {
        init();
    }
    private void init()
    {
        slike=new ArrayList<>();
    }
}
