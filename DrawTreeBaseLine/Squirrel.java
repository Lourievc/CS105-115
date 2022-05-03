package DrawTreeBaseLine;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Squirrel extends LandscapeObject{

    private String squirrelColor; 				// The Hex color of the trunk, including the preceding '#'. Set in the constructor.
    private int bodyWidth = 5;			//The trunk width in pixels.  Default of 10 for a scale of 1.  Modified by applyScale method().
    private int bodyHeight = 10;			//The trunk height in pixels.  Default of 15 for a scale of 1.  Modified by applyScale method().
    private int headWidth = 10;			//The branch width in pixels.  Default of 30 for a scale of 1.  Modified by applyScale method().
    private int headHeight = 10;			//The branch height in pixels.  Default of 30 for a scale of 1.  Modified by applyScale method().
    private BasicStroke treeStroke = new BasicStroke(1);	//Stroke of 1 pixel use to outline each shape of the tree.



    /**
     * Primary Constructor.
     * Sets all class attributes.
     *
     * @param    g2            The Graphics2D interface.
     * @param    x            An int.  The startX coordinate.  currentX is also set to x upon object creation.
     * @param    y            An int.  The startY coordinate.  currentX is also set to y upon object creation.
     * @param    scale        A double.  Scale multiplier for the object.
     * @return void
     */
    public Squirrel(Graphics2D g2, int x, int y, double scale, String s_SquirrelColor) {
        super(g2, x, y, scale);
        this.squirrelColor = "#" + s_SquirrelColor;

    }

    @Override
    public void draw() {
        applyScale();
        drawBody();
        drawhHead();
    }

    private void drawhHead() {
        int xO = super.getStartX();
        int yO = super.getStartY();
        var head = new Ellipse2D.Double(currentX - (headWidth/2), currentY - (headHeight/2), headWidth, headHeight);
        var ear = new Ellipse2D.Double(currentX + (headWidth/Math.PI), currentY - (headHeight/2), headWidth/2, headHeight/2);
        var eye = new Ellipse2D.Double(currentX - (headWidth/2), currentY - (headHeight/2), headWidth - (headWidth/2), headHeight - (headHeight/2));
        g2.setColor(Color.decode(squirrelColor));
        g2.fill(head);
        g2.fill(ear);
        g2.setColor(Color.BLACK);
        g2.fill(eye);

    }

    private void drawBody() {
        var body = new Rectangle2D.Double(currentX - (bodyWidth/2), currentY, bodyWidth, bodyHeight);
        var body2 = new Ellipse2D.Double(currentX - (bodyWidth/2), currentY + (bodyWidth/2), bodyWidth * 2, bodyHeight);
        var leg = new Ellipse2D.Double(currentX - (bodyHeight - 4), currentY + (bodyHeight - 2), bodyWidth * 2,bodyHeight - (bodyHeight/2));
        var tail = new Ellipse2D.Double(currentX + (bodyWidth*3), currentY - (bodyWidth*2), bodyWidth*2, bodyHeight*2);
        g2.setColor(Color.decode(squirrelColor));
        g2.rotate(45,currentX + (bodyWidth*2),currentY - (bodyWidth/2));
        g2.fill(tail);
        g2.rotate(-45,currentX + (bodyWidth*2),currentY - (bodyWidth/2));
        g2.fill(body);
        g2.fill(body2);
        g2.fill(leg);

    }

    @Override
    public void applyScale() {
        bodyWidth = (int)(bodyWidth * getScale());
        bodyHeight = (int)(bodyHeight * getScale());
        headWidth = (int)(headWidth * getScale());
        headHeight = (int)(headHeight * getScale());
    }
}
