package DrawTreeBaseLine;

import Draw.LandscapeObject;

import java.awt.*;
import java.util.Random;

/**
 * Draws a sky, including (when applicable:
 * Sun
 * Moon
 * Stars
 * Sky with colors
 *
 * @author Ricardo Prins
 */
public class Sky extends LandscapeObject implements Colors {

    private GradientPaint skyColors;
    private static Random randomizer = new Random();

    /**
     * Just to spare code.
     */
    class SkyGradient extends GradientPaint {
        public SkyGradient(Color color1, Color color2) {
            super(ORIGIN, color1, DESTINY, color2);
        }
    }
    /**
     * Primary Constructor.
     * Sets all class attributes.
     *
     * @param g2 The Graphics2D interface.
     * @return void
     */
    public Sky(Graphics2D g2) {
        super(g2, 0, 0, SCALE);

        skyColors = new SkyGradient(EVENING_ORANGE, NIGHT_BLUE);


    }


    private void drawSky() {
        g2.setPaint(skyColors);
        g2.fillRect(0, 0, WIDTH, HEIGHT);
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
        drawSky();

    }

    /**
     * Must be implemented in all subclasses
     * Applies the scale multiplier to all shape dimensions for the object.
     * Called by draw()
     */
    @Override
    public void applyScale() {

    }
}