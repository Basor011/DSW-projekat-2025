package raf.graffito.dsw.gui.swing.view.slide_elements;

import raf.graffito.dsw.model.composite.leaves.Element;
import raf.graffito.dsw.model.composite.leaves.TextFieldElement;

import java.awt.*;

public class TextFieldVIew extends ElementView{
    public TextFieldVIew(Element element) {
        super(element);
    }

    @Override
    public void paint(Graphics2D g) {
        TextFieldElement e = (TextFieldElement) element;
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.drawString(e.getText(),e.getLocation().x,e.getLocation().y + e.getFontSize());
    }
}
