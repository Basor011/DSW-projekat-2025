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

        Font font = new Font("Arial", Font.PLAIN, e.getFontSize());
        g.setFont(font);
        FontMetrics metrics = g.getFontMetrics(font);

        int x = e.getLocation().x;
        int y = e.getLocation().y;
        g.setColor(Color.BLACK);
        g.drawString(e.getText(), x, y + metrics.getAscent());

        paintSelection(g);
    }

    @Override
    public void paintSelection(Graphics2D g) {
        if (!element.isSelected()) return;

        TextFieldElement e = (TextFieldElement) element;

        Font font = new Font("Arial", Font.PLAIN, e.getFontSize());
        g.setFont(font);
        FontMetrics metrics = g.getFontMetrics(font);
        int w = metrics.stringWidth(e.getText());
        int h = metrics.getHeight();

        int x = e.getLocation().x;
        int y = e.getLocation().y;

        g.setColor(Color.BLUE);
        g.setStroke(new BasicStroke(2));
        g.drawRect(x, y, w, h);
    }

    @Override
    public Rectangle getBounds() {
        TextFieldElement e = (TextFieldElement) element;

        Font font = new Font("Arial", Font.PLAIN, e.getFontSize());
        FontMetrics fm = Toolkit.getDefaultToolkit().getFontMetrics(font);

        int w = fm.stringWidth(e.getText());
        int h = fm.getHeight();

        int x = e.getLocation().x;
        int y = e.getLocation().y;

        return new Rectangle(x, y, w, h);
    }

    @Override
    public Rectangle getScaledBounds(double scaleFactor) {
        TextFieldElement e = (TextFieldElement) element;

        Font font = new Font("Arial", Font.PLAIN, e.getFontSize());
        FontMetrics fm = Toolkit.getDefaultToolkit().getFontMetrics(font);

        int w = fm.stringWidth(e.getText());
        int h = fm.getHeight();

        int x = e.getLocation().x;
        int y = e.getLocation().y;

        return new Rectangle((int)(x * scaleFactor), (int)(y * scaleFactor), (int)(w * scaleFactor), (int)(h * scaleFactor));

    }
}
