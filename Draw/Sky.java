package Draw;

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
public class Sky extends LandscapeObject implements SceneryCFG {

    private TIME time;
    private GradientPaint skyColors;
    private static Random randomizer = new Random();
    private boolean hasStars = false;
    private boolean hasSun = false;
    private boolean hasMoon = false;

    /**
     * Just to spare code.
     */
    public class SkyGradient extends GradientPaint {
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
        this.time = time;
        switch (time) {
            case SUNRISE -> {
                skyColors = new SkyGradient(SUNRISE_BLUE, SUNRISE_YELLOW);
                hasSun = true;
            }
            case MORNING -> {
                skyColors = new SkyGradient(MORNING_BLUE_1, MORNING_BLUE_2);
                hasSun = true;
            }
            case MIDDAY -> {
                skyColors = new SkyGradient(MIDDAY_BLUE_1, MIDDAY_BLUE_2);
                hasSun = true;
            }
            case AFTERNOON -> {
                skyColors = new SkyGradient(AFTERNOON_BLUE_1, AFTERNOON_BLUE_2);
                hasSun = true;
            }
            case SUNSET -> {
                skyColors = new SkyGradient(SUNSET_YELLOW, SUNSET_ORANGE);
                hasSun = true;
                hasMoon = true;
            }
            case EVENING -> {
                skyColors = new SkyGradient(EVENING_RED, EVENING_ORANGE);
                hasStars = true;
                hasMoon = true;
            }
            case NIGHT -> {
                skyColors = new SkyGradient(Color.BLACK, NIGHT_BLUE);
                hasStars = true;
                hasMoon = true;
            }
        }
    }


    private void drawSky() {
        g2.setPaint(skyColors);
        g2.fillRect(0, 0, WIDTH, HEIGHT);
    }

    private void drawSun() {
        Shape sun = null;
        if (hasSun) {
            g2.setColor(Color.YELLOW);
            switch(time) {
                case SUNRISE -> sun = new RegularPolygon((int)((WIDTH/3)*2.5),HEIGHT/3,100,99);
                case MORNING -> sun = new RegularPolygon((WIDTH/3)*2,HEIGHT/5,100,99);
                case MIDDAY -> sun = new RegularPolygon(WIDTH/2,HEIGHT/7,100,99);
                case AFTERNOON -> sun = new RegularPolygon(WIDTH/4,HEIGHT/5,100,99);
                case SUNSET -> sun = new RegularPolygon(WIDTH/5,HEIGHT/3,100,99);
            }
            g2.fill(sun);
        }

    }

    private void drawMoon() {
        Shape moon = null;
        if (hasMoon) {
            g2.setColor(Color.WHITE);
            switch(time){
                case SUNSET -> moon = new RegularPolygon((WIDTH/3)*2,HEIGHT/5,45,99);
                case EVENING -> moon = new RegularPolygon(WIDTH/2,HEIGHT/7,60,99);
                case NIGHT -> moon = new RegularPolygon(WIDTH/4,HEIGHT/3,80,99);
            }
            g2.fill(moon);
        }
    }

    private void drawStars() {
        if (hasStars) {
            g2.setColor(Color.WHITE);
            for (int i = 0; i <= 100; i++) {
                Shape star = new StarPolygon(randomizer.nextInt(WIDTH), randomizer.nextInt(HEIGHT / 5), 1, 1, 5);
                g2.draw(star);
            }
        }
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
        drawSun();
        drawMoon();
        drawStars();
    }

    /**
     * Must be implemented in all subclasses
     * Applies the scale multiplier to all shape dimensions for the object.
     * Called by draw()
     */
    @Override
    public void applyScale() {
        //Foo!
    }
}