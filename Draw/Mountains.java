package Draw;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.Random;

public class Mountains extends LandscapeObject implements SceneryCFG {

    private int mountainWidth = 200;
    private static final Random randomizer = new Random();
    private final GeneralPath mountainPath = new GeneralPath();
    private GradientPaint mountainColor;

    public Mountains(Graphics2D g2, int x, int y, SEASON season, int scale) {
        super(g2, x, y, scale);
        switch (season){
            case SUMMER -> mountainColor = new GradientPaint(x+(mountainWidth/2),y-(mountainWidth*2),new Color(63, 137, 36, 255), x + (mountainWidth / 2),y,new Color(128, 82, 51));
            case SPRING -> mountainColor = new GradientPaint(x+(mountainWidth/2),y-(mountainWidth*2),new Color(168, 236, 123), x + (mountainWidth / 2),y,new Color(66, 113, 32));
            case FALL ->  mountainColor = new GradientPaint(x+(mountainWidth/2),y-(mountainWidth*2),new Color(250, 144, 72), x + (mountainWidth / 2),y,new Color(104, 65, 24));
            case WINTER -> mountainColor = new GradientPaint(x+(mountainWidth/2),y-(mountainWidth*2),new Color(255, 255, 255), x + (mountainWidth / 2),y,new Color(109, 109, 109));
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
        applyScale();
        drawMountain();
        drawWeather();
    }

    /**
     * Must be implemented in all subclasses
     * Applies the scale multiplier to all shape dimensions for the object.
     * Called by draw()
     *
     */
    @Override
    public void applyScale() {
        mountainWidth*=this.getScale();
    }

    private void drawMountain() {

        Point2D origin = new Point(this.getStartX(), this.getStartY());
        mountainPath.moveTo(origin.getX(),origin.getY());

        for (int i = 0;i <= this.mountainWidth;i++) {
            if (i <= this.mountainWidth/2) origin.setLocation(origin.getX()+1,origin.getY()-randomizer.nextInt(5));
            else {
                double y = origin.getY()+randomizer.nextInt(5);
                while (y>this.getStartY()) y-=1;
                origin.setLocation(origin.getX()+1,y);
            }
            mountainPath.lineTo(origin.getX(),origin.getY());
        }
        mountainPath.lineTo(origin.getX()+1,this.getStartY());
        mountainPath.closePath();
        g2.setPaint(mountainColor);
        g2.fill(mountainPath);

    }

    private void drawWeather() {

    }
}