package Draw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;

public class Sun extends LandscapeObject{
	//Attributes	
	private int rays;
	private String sunColor; 				
	private String rayColor;
	private int sunWidth = 50;			
	private int sunHeight = 50;			
	private int rayWidth = 10;			
	private int rayHeight = 60;
	private double sunCenter = ((currentX + (sunWidth / 2)) + (currentY + (sunHeight / 2)));
	private BasicStroke sunStroke = new BasicStroke(1);	//Stroke of 1 pixel use to outline each shape of the tree.

	
	/**
	 * Primary Constructor.
	 * Sets all class attributes.
	 * 
	 * @param	levels			int indicating how many levels (branch triangles) the tree will have.
	 * @param	s_trunkColor	A String representing the Hex code for the color used for the trunk of the tree.
	 * @param	s_branchColor	A String representing the Hex code for the color used for the branches of the tree.
	 *
	 * @param    g2                The Graphics2D interface.
	 * @param    x                int.  The startX coordinate.  currentX is also set to x upon object creation.
	 * @param    y                int.  The startY coordinate.  currentX is also set to y upon object creation.
	 * @param    scale            double.  Scale multiplier for the object.
	 * @param s_sunColor
	 * @param s_rayColor
	 * @return	void
	 */
	public Sun(Graphics2D g2, int x, int y, double scale, int rays, String s_sunColor, String s_rayColor) {
		super(g2, x, y, scale);
		this.rays = rays;
		this.sunColor = "#" + s_sunColor;
		this.rayColor = "#" + s_rayColor;
	}//end of Constructor Sun()
	
	
	//Methods
	public void draw() {
		applyScale();
		drawRay();
		drawSun();
	}//end of method draw()
	
	public void applyScale() {
		sunWidth = (int)(sunWidth * getScale());
		sunHeight = (int)(sunHeight * getScale());
		rayWidth = (int)(rayWidth * getScale());
		rayHeight = (int)(rayHeight * getScale());
	}//end of method applyScale()
	
	private void drawSun() {
		var sun = new Ellipse2D.Double(currentX, currentY, sunWidth, sunHeight);
		g2.setColor(Color.decode(sunColor));
		g2.fill(sun);
	}//end of method drawSun()
	
	private void drawRay() {
		
		for(int i = 0; i < rays; i++) {	
		int[] xPoints = {currentX, currentX + (rayWidth / 2), (currentX + rayWidth)};
		int[] yPoints = {currentY, currentY + rayHeight, currentY};
		var ray = new Polygon(xPoints, yPoints, 3);
		g2.rotate(Math.toRadians(360 / rays), ((currentX + (currentX + (rayWidth / 2)) + (currentX + rayWidth)) / 3), ((currentY + (currentY + rayHeight) + currentY) / 3));
		g2.setColor(Color.decode(rayColor));
		g2.fill(ray);
		}
	}//end of method drawRay()
	
}//end of class Cloud
