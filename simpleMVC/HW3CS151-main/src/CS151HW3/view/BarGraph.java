package CS151HW3.view;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class BarGraph extends JComponent {
    Rectangle r;
    Rectangle gr;
    Rectangle b;
    Graphics2D g2;
    int rHeight;
    int gHeight;
    int bHeight;
    public BarGraph(String red, String green, String blue)
    {
        rHeight=Integer.valueOf(red);
        gHeight=Integer.valueOf(green);
        bHeight=Integer.valueOf(blue);

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D) g;

        r = new Rectangle(100, 300-(5+rHeight*25), 50, 5+rHeight*25);

        g2.setColor(Color.RED);
        g2.fillRect(100,300-(5+rHeight*25),50,5+rHeight*25);
        // draw the rectangle
        g2.draw(r);

         gr = new Rectangle(200, 300-(5+gHeight*25), 50, 5+gHeight*25);

        g2.setColor(Color.GREEN);
        g2.fillRect(200,300-(5+gHeight*25),50,5+gHeight*25);
        // draw the rectangle
        g2.draw(gr);

         b = new Rectangle(300,300-(5+bHeight*25),50,5+bHeight*25);

        g2.setColor(Color.BLUE);
        g2.fillRect(300,300-(5+bHeight*25),50,5+bHeight*25);
        // draw the rectangle
        g2.draw(b);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }

   public void update(String red, String green, String blue)
   {
       rHeight=Integer.valueOf(red);
       gHeight=Integer.valueOf(green);
       bHeight=Integer.valueOf(blue);
       repaint();
   }



}
