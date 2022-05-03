package DrawTreeBaseLine;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class SpaceShip extends LandscapeObject {

    private int shipWidth = 30;            //The trunk width in pixels.  Default of 10 for a scale of 1.  Modified by applyScale method().
    private int shipHeight = 35;            //The trunk height in pixels.  Default of 15 for a scale of 1.  Modified by applyScale method().
    private int capWidth = 30;            //The branch width in pixels.  Default of 30 for a scale of 1.  Modified by applyScale method().
    private int capHeight = 30;            //The branch height in pixels.  Default of 30 for a scale of 1.  Modified by applyScale method().
    private int beamWidth = 30;            //The branch width in pixels.  Default of 30 for a scale of 1.  Modified by applyScale method().
    private int beamHeight = 30;
    private final BasicStroke treeStroke = new BasicStroke(1);    //Stroke of 1 pixel use to outline each shape of the tree.


    /**
     * Primary Constructor.
     * Sets all class attributes.
     *
     * @param g2    The Graphics2D interface.
     * @param x     An int.  The startX coordinate.  currentX is also set to x upon object creation.
     * @param y     An int.  The startY coordinate.  currentX is also set to y upon object creation.
     * @param scale A double.  Scale multiplier for the object.
     */
    public SpaceShip(Graphics2D g2, int x, int y, double scale) {
        super(g2, x, y, scale);
    }


    @Override
    public void draw() {
        applyScale();
        drawCap();
        drawBeam();
    }

    private void drawCap() {
        int xO = super.getStartX();
        int yO = super.getStartY();
        var cap = new Ellipse2D.Double(currentX, currentY, capWidth, capHeight);
        var ship = new Ellipse2D.Double(currentX - (shipWidth >> 1), currentY + (shipWidth >> 1), shipWidth * 2,shipHeight - (shipHeight >> 1));
        g2.setColor(Color.DARK_GRAY);
        g2.fill(cap);
        g2.fill(ship);
    }

    private void drawBeam() {
        int xO = super.getStartX();
        int yO = super.getStartY();
        int width = beamWidth;
        double beamM = beamHeight;
        int[] xPoints = {xO, xO + width, xO + (width/5)};
        int[] yPoints = {yO + 100, yO + 100, yO + 100};
        var beam = new Polygon(xPoints, yPoints, 3);
        g2.setColor(Color.YELLOW);
        g2.fill(beam);
    }

    @Override
    public void applyScale() {
        shipWidth = (int) (shipWidth * getScale());
        shipHeight = (int) (shipHeight * getScale());
        capWidth = (int) (capWidth * getScale());
        capHeight = (int) (capHeight * getScale());
        beamWidth = (int) (beamWidth * getScale());
        beamHeight = (int) (beamHeight * getScale());
    }
}
