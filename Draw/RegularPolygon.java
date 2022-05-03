package Draw;

import java.awt.*;


/**
 * RegularPolygon will build a regular polygon (duh) centered in the x,y coordinates, with a r radius.
 * <p>
 * I chose just to calculate values and pass them directly to the Polygon constructor using the trivial
 * geometrical calculations for vertex coords (check any Analytic Geometry book if you don't know how to
 * do the math involved, or just trust me)
 */
public class RegularPolygon extends Polygon {

    public RegularPolygon(int x, int y, int r, int vertexCount) {
        this(x, y, r, vertexCount, 0);
    }

    public RegularPolygon(int x, int y, int r, int vertexCount, double startAngle) {
        super(getXCoordinates(x, y, r, vertexCount, startAngle), getYCoordinates(x, y, r, vertexCount, startAngle), vertexCount);
    }

    /**
     * @param x           x coordinate of center
     * @param y           y coordinate of center
     * @param r           radius of polygon
     * @param vertexCount if you've gotten to this point in life, I take it I don't need to explain it...
     * @param startAngle  in case you want a "crooked" polygon...
     * @return array of x coordinates to be passed to Polygon constructor above
     */
    private static int[] getXCoordinates(int x, int y, int r, int vertexCount, double startAngle) {
        int res[] = new int[vertexCount];
        double addAngle = 2 * Math.PI / vertexCount, angle = startAngle;
        for (int i = 0; i < vertexCount; i++) {
            res[i] = (int) Math.round(r * Math.cos(angle)) + x;
            angle += addAngle;
        }
        return res;
    }

    /**
     * @param x           x coordinate of center
     * @param y           y coordinate of center
     * @param r           radius of polygon
     * @param vertexCount if you've gotten to this point in life, I take it I don't need to explain it...
     * @param startAngle  in case you want a "crooked" polygon...
     * @return array of y coordinates to be passed to Polygon constructor above
     */
    private static int[] getYCoordinates(int x, int y, int r, int vertexCount, double startAngle) {
        int res[] = new int[vertexCount];
        double addAngle = 2 * Math.PI / vertexCount, angle = startAngle;
        for (int i = 0; i < vertexCount; i++) {
            res[i] = (int) Math.round(r * Math.sin(angle)) + y;
            angle += addAngle;
        }
        return res;
    }
}