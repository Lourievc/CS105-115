package Draw;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Class used to create a DrawPanel where shapes will be drawn by the programmer (via code).
 *
 * @author Jared N. Plumb
 * @version 1.0
 * @since 2019-11-26
 * @Minor modifications by Jeff Light
 * @since 2019-12-01
 */
public class DrawPanel extends JPanel implements SceneryCFG {

    private static final long serialVersionUID = 6311020027600344213L;
    private static final Random randomizer = new Random();

    public DrawPanel() {
        this.setPreferredSize(new Dimension(SceneryCFG.WIDTH, SceneryCFG.HEIGHT));    //Sets the dimensions of the DrawPanel.  Change this if your screen doesn't support this size.
        this.setOpaque(true);
        this.setBackground(Color.WHITE);            //Sets the background of the DrawPanel LIGHT_GRAY.  You may change this if desired.
    }

    /**
     * Overrides the JComponent.paintComponent method.
     * EVERYTHING that gets drawn to the Component (which sits on the content frame of the JFrame) is drawn in this method.
     * Draw12a all your objectsDraw here.
     * Automatically called by the event handler whenever the screen needs to be redrawn.
     * DO NOT CALL THIS METHOD MANUALLY
     *
     * @param    g    //All drawing in Java must go through a Graphics object
     */
   @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;            //Allows us to draw using both the Graphics class methods and the Graphics2D class methods
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);    //Makes drawn shapes and fonts clearer
        sky(g2, TIME.SUNRISE); //SKY
        g2.setColor(Color.BLACK);
        g2.fill(new Rectangle(0, SceneryCFG.HEIGHT / 2, SceneryCFG.WIDTH, SceneryCFG.HEIGHT / 2));
        for (int i = -1; i < 20; i++)
            mountains(g2, (i * 80), (int) (SceneryCFG.HEIGHT / 1.8), SEASON.SPRING, 1); //MOUNTAINS

        for (int i = 0; i < 18; i++)
            buildings(g2, (i * 100) - 15, SceneryCFG.HEIGHT - 300, 1, (3 + randomizer.nextInt(5)), 4); //BUILDINGS
        for (int i = 0; i < 18; i++)
            buildings(g2, (i * 100) + 5, SceneryCFG.HEIGHT - 200, 1, (3 + randomizer.nextInt(5)), 3); //BUILDINGS
        for (int i = 0; i < 18; i++)
            buildings(g2, i * 110, SceneryCFG.HEIGHT - 100, 1, (3 + randomizer.nextInt(5)), 2); //BUILDINGS
        for (int i = 0; i < 18; i++)
            buildings(g2, (i * 110) + 10, SceneryCFG.HEIGHT, 1, (3 + randomizer.nextInt(5)), 0); //BUILDINGS


    }//end of method paintComponent(Graphics)


    public static void sky(Graphics2D g2, TIME time) {
        Sky sky = new Sky(g2);
        sky.draw();
    }

    public static void mountains(Graphics2D g2, int x, int y, SEASON season, int scale) {
        Mountains mountains = new Mountains(g2, x, y, season, scale);
        mountains.draw();
    }

    public static void buildings(Graphics2D g2, int x, int y, int scale, int floors, int layer) {
        Buildings buildings = new Buildings(g2, x, y, scale, floors, layer);
        buildings.draw();
    }
}

