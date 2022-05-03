package Draw;

import java.awt.*;
import java.util.Random;

/**
 *
 */
public class Clouds extends LandscapeObject {

    private Color color;
    private int levels;
    private int defaultRadiusX = 30;
    private int defaultRadiusY = 30;
    private Random randomizer = new Random();

    public Clouds(Graphics2D g2, int x, int y, double scale, Color color, int levels) {
        super(g2, x, y, scale);
        this.color = color;
        this.levels = levels;
    }

    /**
     * Must be implemented in all subclasses
     * Calls applyScale to apply the scale multiplier to all shape dimensions for the object.
     * Draws the object
     *
     * @return void.
     */
    @Override
    public void draw() {
        applyScale();
        drawClouds();
    }

    /**
     * Must be implemented in all subclasses
     * Applies the scale multiplier to all shape dimensions for the object.
     * Called by draw()
     *
     * @return void.
     */

    @Override
    public void applyScale() {
        this.defaultRadiusX*=this.getScale();
        this.defaultRadiusX*=this.getScale();

    }

    private void drawClouds() {
        g2.setColor(color);
        g2.fillOval(this.getStartX(),this.getStartY(),defaultRadiusX, defaultRadiusY);
        currentX=this.getStartX()+randomizer.nextInt(15);
        currentY=this.getStartY();
        for (int i=1;i<=levels;i++){
            if (i % 2 != 0) {
                g2.fillOval(currentX,currentY,defaultRadiusX+randomizer.nextInt(25), defaultRadiusY+randomizer.nextInt(25));
                currentX+=randomizer.nextInt(15);
                currentY-=randomizer.nextInt(20)+15;
            } else {
                g2.fillOval(currentX,currentY,defaultRadiusX+randomizer.nextInt(25), defaultRadiusY+randomizer.nextInt(25));
                currentX+=randomizer.nextInt(15);
                currentY+=randomizer.nextInt(20);
            }

        }

    }
}