package Draw;

import javax.swing.*;
import java.awt.*;

public class DrawMandelbrot extends JPanel {

    private static final long serialVersionUID = 3141592653589793238L;
    private static final int max = 255;   // maximum number of iterations
    private static final double xc   = -0.5d;
    private static final double yc   = 0d;
    private static final double size = 3d;
    private static final int n = 900; // screen size
    public DrawMandelbrot(int n) {
        this.setPreferredSize(new Dimension(n, n));
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
    }

    /**
     *
     *
     *
     * @param z0
     * @param max
     * @return number of iterations to check if c = a + ib is in Mandelbrot set
     */
    public static int mandelbrot(Complex z0, int max) {
        Complex z = z0;
        for (int t = 0; t < max; t++) {
            if (z.abs() > 2.0) return t;
            z = z.multiply(z).add(z0);
        }
        return max;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                double x0 = xc - size/2 + size*x/n;
                double y0 = yc - size/2 + size*y/n;
                Complex z0 = new Complex(x0, y0);
                int gray = mandelbrot(z0, max);
                Color color = new Color(102,gray,255);
                paintPixel(g2,x,n-1-y,color);
            }
        }
    }
    public void paintPixel(Graphics2D g2,int x, int y, Color color){
        g2.setColor(color);
        g2.drawRect(x,y,1,1);
    }
    public static void main(String[] args)  {

        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setTitle("Draw Mandelbrot");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setLocationByPlatform(true);
            frame.setContentPane(new DrawMandelbrot(n));
            frame.pack();
            frame.setVisible(true);
        });



    }
}