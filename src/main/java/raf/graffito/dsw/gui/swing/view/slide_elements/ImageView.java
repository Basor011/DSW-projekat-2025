package raf.graffito.dsw.gui.swing.view.slide_elements;

import raf.graffito.dsw.model.composite.leaves.Element;
import raf.graffito.dsw.model.composite.leaves.ImageElement;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageView extends ElementView{
    private BufferedImage image;
    public ImageView(ImageElement element) {
        super(element);
        try{
            image = ImageIO.read(new File(element.getImagePath()));
        }
        catch (Exception e){
            image = null;
        }
    }

    @Override
    public void paint(Graphics2D g) {
        ImageElement e = (ImageElement) element;
        if(image != null){
            g.drawImage(image, e.getLocation().x, e.getLocation().y, e.getDimension().width, e.getDimension().height, null);
        }
        paintSelection(g);
    }
}
