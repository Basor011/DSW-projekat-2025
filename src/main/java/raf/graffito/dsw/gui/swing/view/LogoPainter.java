package raf.graffito.dsw.gui.swing.view;

import raf.graffito.dsw.model.composite.leaves.LogoElement;

import javax.swing.*;
import java.awt.*;

public class LogoPainter extends PrimodialPainter {
    private LogoElement model;

    public LogoPainter(LogoElement logoElement) {
        super(logoElement);
        this.model = logoElement;

        Point p = model.getLokacija();
        Dimension d = model.getDimenzija();
        this.shape = new Rectangle(p.x, p.y, d.width, d.height);
    }

    @Override
    public void paint(Graphics2D g, Object object, int width, int height) {
        g.drawImage(model.getLogo(), model.getLokacija().x, model.getLokacija().y, model.getDimenzija().width, model.getDimenzija().height, null );
    }
}
