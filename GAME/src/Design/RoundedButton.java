package Design;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;

public class RoundedButton extends JButton {
    private int arc; // 角の半径

    public RoundedButton(String text, int arc) {
        super(text);
        this.arc = arc;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Shape shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
        g2.setColor(getBackground());
        g2.fill(shape);

        g2.setColor(getForeground());
        g2.drawString(getText(), 10, (getHeight() + g2.getFontMetrics().getAscent()) / 2);

        g2.dispose();
    }

}