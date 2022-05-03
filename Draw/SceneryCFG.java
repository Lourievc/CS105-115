package Draw;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * This interface holds general config fields for the scene.
 */
public interface SceneryCFG {

    Color SUNRISE_BLUE = new Color(41,128,194),
            SUNRISE_YELLOW = new Color(243,232,8),
            MORNING_BLUE_1 = new Color(113,197,245),
            MORNING_BLUE_2 = new Color(59,124,201),
            MIDDAY_BLUE_1 = new Color(41, 128, 194),
            MIDDAY_BLUE_2 = new Color(150, 197, 229),
            AFTERNOON_BLUE_1 = new Color(25, 102, 160),
            AFTERNOON_BLUE_2 = new Color(117, 199, 224),
            SUNSET_YELLOW = new Color(245, 188, 49),
            SUNSET_ORANGE = new Color(154, 87, 28),
            EVENING_RED = new Color(92, 2, 2),
            EVENING_ORANGE = new Color(196, 5, 43),
            NIGHT_BLUE = new Color(41, 68, 163);

    int WIDTH = 1600,
            HEIGHT = 900,
            SCALE = 1;

    Point2D ORIGIN = new Point(WIDTH / 2,0),
            DESTINY = new Point (WIDTH/2, (int)(HEIGHT*0.514));

    enum TIME {
        SUNRISE,
        MORNING,
        MIDDAY,
        AFTERNOON,
        SUNSET,
        EVENING,
        NIGHT
    }
    enum SEASON {
        SPRING,
        SUMMER,
        WINTER,
        FALL
    }
}