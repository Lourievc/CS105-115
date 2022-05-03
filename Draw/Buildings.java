package Draw;

import java.awt.*;

public class Buildings extends LandscapeObject implements SceneryCFG {

    private int floors;
    private int layer;
    private int floorHeight = 30;
    private int BASE_FLOOR = 30;
    private int buildingWidth = 90;
    private int doorWidth = 20;
    private int doorHeight = 20;
    private int windowDimension = 10;


    public Buildings(Graphics2D g2, int x, int y, double scale, int floors, int layer) {
        super(g2, x, y, scale);
        this.floors = floors;
        this.layer = layer;
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
        drawBuildings();
        drawWindows();
        drawExtras();
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
        this.BASE_FLOOR *= this.getScale();
        this.floorHeight *= this.getScale();
        this.buildingWidth *= this.getScale();
        this.doorWidth *= this.getScale();
        this.doorHeight *= this.getScale();
        this.windowDimension *= this.getScale();
    }

    public void drawBuildings() {
        int finalHeight = BASE_FLOOR+(floors*floorHeight);
        switch (layer) {
            case 0 -> g2.setColor(Color.DARK_GRAY);
            case 1 -> g2.setColor(new Color(73, 72, 72));
            case 2 -> g2.setColor(Color.GRAY);
            case 3 -> g2.setColor(new Color(104, 102, 102));
            case 4 -> g2.setColor(Color.LIGHT_GRAY);
        }

        g2.fill(new Rectangle(this.getStartX(),this.getStartY()-finalHeight,buildingWidth,finalHeight));
    }

    public void drawWindows() {
        int finalHeight = BASE_FLOOR+(floors*floorHeight);
        //FIRST, A DOOR
        g2.setColor(Color.WHITE);
        g2.fill(new Rectangle(this.getStartX()+(int)(0.4*buildingWidth),this.getStartY()-doorHeight, doorWidth, doorHeight ));

        //THEN, THE WINDOWS
        this.currentX = this.getStartX()+windowDimension;
        this.currentY = this.getStartY()-finalHeight+windowDimension;
        for (int i = 1; i <= floors; i++) {
            g2.fill(new Rectangle(this.currentX,this.currentY,windowDimension,windowDimension));
            g2.fill(new Rectangle(this.currentX+(windowDimension*2),this.currentY,windowDimension,windowDimension));
            g2.fill(new Rectangle(this.currentX+(windowDimension*4),this.currentY,windowDimension,windowDimension));
            g2.fill(new Rectangle(this.currentX+(windowDimension*6),this.currentY,windowDimension,windowDimension));
            this.currentY += windowDimension*3;
        }
    }

    public void drawExtras(){
        // randomize extras
    }
}
