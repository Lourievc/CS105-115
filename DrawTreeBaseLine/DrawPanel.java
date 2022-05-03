package DrawTreeBaseLine;

import Draw.Sun;

import javax.swing.*;
import java.awt.*;

/**
 * Class used to create a DrawPanel where shapes will be drawn by the programmer (via code).
 * 
 * @author Jared N. Plumb
 * @version 1.0
 * @since 2019-11-26
 * @Minor modifications by Jeff Light
 * @since 2019-12-01
 */
public class DrawPanel extends JPanel implements Colors{
	//Attributes
	private static final long serialVersionUID = 6311020027600344213L;
	
	//Landscape Colors
	private final String LIGHT_SKY_BLUE = "87CEFA";
	private final String MIDNIGHT_BLUE = "191970";
	private final String SNOW3 = "CDC9C8";
	private final String WHITE = "FFFFFF";
	private final String MY_WHITE_SMOKE = "F5F5F5";
	private final String LAWN_GREEN = "7CFC00";
	private final String MEDIUM_SPRING_GREEN = "00FA9A";
	private final String SPRING_GREEN = "00FF7F";
	
	//Tree Colors
	private final String BROWN = "A52A2A";
	private final String DARK_GREEN = "006400";
	private final String FOREST_GREEN = "228B22";
	private final String GRAY = "808080";
	private final String GREEN = "008000";
	
	//House Colors
	private final String DARK_SLATE_GRAY = "2F4F4F";
	private final String FIREBRICK = "B22222";
	private final String INDIAN_RED = "CD5C5C";
	private final String MAROON = "800000";
	private final String MOCCASIN = "FFE4B5";
	private final String RED = "FF0000";
	private final String SADDLE_BROWN = "8B4513";
	private final String SIENNA = "A0522D";
	private final String SLATE_GRAY = "708090";
	private final String PERU = "CD853F";
	private final String WHITE_SMOKE = "F5F5F5";
	private final String BURLYWOOD = "DEB887";


	

	public DrawPanel() {
		this.setPreferredSize(new Dimension(1600, 900));	//Sets the dimensions of the DrawPanel.  Change this if your screen doesn't support this size.
		this.setOpaque(true);
		this.setBackground(Color.WHITE);			//Sets the background of the DrawPanel LIGHT_GRAY.  You may change this if desired.
	}
	/**
	 * Overrides the JComponent.paintComponent method.
	 * EVERYTHING that gets drawn to the Component (which sits on the content frame of the JFrame) is drawn in this method.
	 * Draw12b
	 * Draw all your objects here.
	 * Automatically called by the event handler whenever the screen needs to be redrawn.
	 * DO NOT CALL THIS METHOD MANUALLY
	 * 
	 * @param	g	//All drawing in Java must go through a Graphics object
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;			//Allows us to draw using both the Graphics class methods and the Graphics2D class methods

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);	//Makes drawn shapes and fonts clearer

		//DrawTree landscape
		DrawTreeBaseLine.Sky sky = new DrawTreeBaseLine.Sky(g2);
		sky.draw();

		Sun sun = new Sun(g2,100,50,6,6,WHITE_SMOKE,WHITE_SMOKE);
		sun.draw();

		Sun sun1 = new Sun(g2,500,10,3,6,SNOW3,SNOW3);
		sun1.draw();

		g2.setColor(Color.decode("#" + DARK_GREEN));
		g2.fillOval((-600), 350, this.getWidth() + 1200, 700);

		Cloud cloud = new Cloud(g2,100,100,3,3,GRAY,GRAY,GRAY);
		cloud.draw();

		Cloud cloud1 = new Cloud(g2,850,100,4,7,GRAY,GRAY,GRAY);
		cloud1.draw();

		Cloud cloud2 = new Cloud(g2,700,100,.9,2,SLATE_GRAY,SLATE_GRAY,SLATE_GRAY);
		cloud2.draw();


		SpaceShip ss1 = new SpaceShip(g2, 200,10,1);
		g2.rotate(45,200,10);
		ss1.draw();
		g2.rotate(-45,200,10);

		SpaceShip2 ss2 = new SpaceShip2(g2, 400,100,2);
		ss2.draw();

		SpaceShip ss3 = new SpaceShip(g2, 550,150,0.8);
		g2.rotate(100,550,150);
		ss3.draw();
		g2.rotate(-100,550,150);

		SpaceShip2 ss4 = new SpaceShip2(g2, 860,50,4);
		ss4.draw();

		SpaceShip ss5 = new SpaceShip(g2, 1350,0,8);
		ss5.draw();

		//DrawTree Trees
		Tree t1 = new Tree(g2, 50, 400, 1, 3, BROWN , FOREST_GREEN);
		t1.draw();
		
		Tree t2 = new Tree(g2, 200, 375, 1, 5, BROWN , GRAY);
		t2.draw();
		
		Tree t3 = new Tree(g2, 300, 450, 1, 4, BROWN , FOREST_GREEN);
		t3.draw();



		Squirrel s1 = new Squirrel(g2, 200, 400, 1, BROWN);
		s1.draw();



		int xB = 2000;
		int yMinB = 400;
		int yMaxB = 800;

		for(int i = 0; i < 50; i++){
			double randX = (Math.random());
			double randY = (Math.random());
			int randXo = (int)((randX * xB));
			int randYo = (int)(randY *(yMaxB - yMinB)) + yMinB;
			int randValue = (int)((Math.random() * (201 - 87)) + 87);
			String randColor = Integer.toHexString(randValue) + "8731";
			Tree tree = new Tree(g2, randXo, randYo, 1, 4, BROWN, randColor);
			tree.draw();
		}

		for(int i = 0; i < 50; i++){
			double randX = (Math.random());
			double randY = (Math.random());
			int randXo = (int)((randX * xB));
			int randYo = (int)(randY *(yMaxB - yMinB)) + yMinB;
			Squirrel s2 = new Squirrel(g2, randXo, randYo, 1, BROWN);
			g2.rotate(100,400,600);

			s2.draw();
			g2.rotate(-100,400,600);
		}

		for(int i = 0; i < 50; i++){
			double randX = (Math.random());
			double randY = (Math.random());
			int randXo = (int)((randX * xB));
			int randYo = (int)(randY *(yMaxB - yMinB)) + yMinB;
			Squirrel s3 = new Squirrel(g2, randXo, randYo, .8, MAROON);
			s3.draw();
		}

		for(int i = 0; i < 50; i++){
			double randX = (Math.random());
			double randY = (Math.random());
			int randXo = (int)((randX * xB));
			int randYo = (int)(randY *(yMaxB - yMinB)) + yMinB;
			Squirrel s2 = new Squirrel(g2, randXo, randYo, .5, MAROON);
			g2.rotate(100,400,600);

			s2.draw();
			g2.rotate(-100,400,600);
		}

		Tree t4 = new Tree(g2, 1000, 800, 6, 3, BROWN , FOREST_GREEN);
		t4.draw();

		Tree t5 = new Tree(g2, 1100, 800, 7, 4, BROWN , GREEN);
		t5.draw();

		Tree t6 = new Tree(g2, 40, 800, 10, 5, BROWN , GREEN);
		t6.draw();

		Squirrel s4 = new Squirrel(g2, 1100, 650, 2, MAROON);
		s4.draw();
		//Populate the scene with your own trees here!
		
		
	}//end of method paintComponent(Graphics)

}//end of class DrawPanel