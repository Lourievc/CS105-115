package DrawTreeBaseLine;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Cloud extends LandscapeObject{
	//Attributes
	private int layers;						
	private String cloudColor; 				
	private String cloud2Color;
	private String cloud3Color;
	private int cloudWidth = 30;			
	private int cloudHeight = 30;			
	private int cloud2Width = 40;			
	private int cloud2Height = 35;
	private int cloud3Width = 35;
	private int cloud3Height = 30;
	private BasicStroke cloudStroke = new BasicStroke(1);	//Stroke of 1 pixel use to outline each shape of the tree.

	
	/**
	 * Primary Constructor.
	 * Sets all class attributes.
	 * 
	 * @param	g2				The Graphics2D interface.
	 * @param	x				int.  The startX coordinate.  currentX is also set to x upon object creation.
	 * @param	y				int.  The startY coordinate.  currentX is also set to y upon object creation.
	 * @param	levels			int indicating how many levels (branch triangles) the tree will have.
	 * @param	scale			double.  Scale multiplier for the object.
	 * @param	s_trunkColor	A String representing the Hex code for the color used for the trunk of the tree.
	 * @param	s_branchColor	A String representing the Hex code for the color used for the branches of the tree.
	 *  
	 * @return	void
	 */
	public Cloud(Graphics2D g2, int x, int y, double scale, int layers, String s_cloudColor, String s_cloud2Color, String s_cloud3Color) {
		super(g2, x, y, scale);
		this.layers = layers;
		this.cloudColor = "#" + s_cloudColor;
		this.cloud2Color = "#" + s_cloud2Color;
		this.cloud3Color = "#" + s_cloud3Color;
	}//end of Constructor Tree
	
	
	//Methods
	public void draw() {
		applyScale();
		for(int i = 1; i <= layers; i++) {
		currentX = (int) (currentX + (45 * getScale()));
		drawCloud2();
		drawCloud();
		drawCloud3();
		}
	}//end of method draw()
	
	public void applyScale() {
		cloudWidth = (int)(cloudWidth * getScale());
		cloudHeight = (int)(cloudHeight * getScale());
		cloud2Width = (int)(cloud2Width * getScale());
		cloud2Height = (int)(cloud2Height * getScale());
		cloud3Width = (int)(cloud3Width * getScale());
		cloud3Height = (int)(cloud3Height * getScale());
	}//end of method applyScale()
	
	private void drawCloud() {
		var cloud = new Ellipse2D.Double(currentX, currentY, cloudWidth, cloudHeight);
		g2.setColor(Color.decode(cloudColor));
		g2.fill(cloud);
	}//end of method drawTrunk()
	
	private void drawCloud2() {
		var cloud2 = new Ellipse2D.Double((currentX + (15 * getScale())), (currentY - (5 * getScale())), cloud2Width, cloud2Height);
		g2.setColor(Color.decode(cloud2Color));
		g2.fill(cloud2);
		
	}//end of method drawCoud2()
	
	private void drawCloud3() {
		var cloud3 = new Ellipse2D.Double((currentX + (30 * getScale())), (currentY + (5 * getScale())), cloud3Width, cloud3Height);
		g2.setColor(Color.decode(cloud3Color));
		g2.fill(cloud3);		
	}
	
}//end of class Cloud
