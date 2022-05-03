package BlackJack;

import BlackJackBase.PCard;
import java.awt.*;

public class BJCard extends PCard{

    //	    ATTRIBUTES
    int rank;
    int suit;
    boolean hidden = true;
    Color color;

    public static final int ACE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int SEVEN = 7;
    public static final int EIGHT = 8;
    public static final int NINE = 9;
    public static final int TEN = 10;
    public static final int JACK = 11;
    public static final int KNIGHT = 12;
    public static final int QUEEN = 13;
    public static final int KING = 14;

    public static final int SPADE = 1;
    public static final int HEART = 2;
    public static final int DIAMOND = 3;
    public static final int CLUB = 4;

    //	    CONSTRUCTORS
    public BJCard(int r, int s) {
        rank = r;
        suit = s;
        hidden = false;
        if (suit == 2 || suit == 3) {
            color = Color.RED;
        } else {
            color = Color.BLACK;
        }
    }//BJCard constructor

    //	      METHODS
    public int getRank() {
        return rank;
    }//getRank

    public void setRank(int r){
        rank = r;
    }//setRank

    public int getSuit() {
        return suit;
    }//getSuit

    public void setSuit(int s){
        suit = s;
    }//setSuit


    @Override
    public void hideCard() {
        hidden = true;
    }//hideCard

    @Override
    public void showCard() {
        hidden = false;
    }//showCard

    @Override
    public boolean isHidden() {
        return hidden;
    }//isHidden

    @Override
    public String getText() {

        String lSuit = "";
        String lRank = "";

        switch(suit){
            case 1:
                lSuit = "\u2660";
                break;
            case 2:
                lSuit = "\u2665";
                break;
            case 3:
                lSuit = "\u2666";
                break;
            case 4:
                lSuit = "\u2663";
                break;
        }//end of switch lSuit

        switch (rank){
            case 1:
                lRank = "A";
                break;
            case 2:
                lRank = "2";
                break;
            case 3:
                lRank = "3";
                break;
            case 4:
                lRank = "4";
                break;
            case 5:
                lRank = "5";
                break;
            case 6:
                lRank = "6";
                break;
            case 7:
                lRank = "7";
                break;
            case 8:
                lRank = "8";
                break;
            case 9:
                lRank = "9";
                break;
            case 10:
                lRank = "10";
                break;
            case 11:
                lRank = "J";
                break;
            case 12:
                lRank = "KN";
                break;
            case 13:
                lRank = "Q";
                break;
            case 14:
                lRank = "K";
                break;
        }

        return lRank + lSuit;
    }//getText

    public Color getFontColor() {
        return color;
    }

    //OVERRIDE METHODS
    public Color getBackColor() {
        return Color.BLUE;
    }

    /** Returns the color of an 8 pixel border around the edge of the card. */
    public Color getBorderColor() {
        return Color.BLACK;
    }

    /** Returns the alternative color used on the cards background. */
    public Color getStripeColor() {
        return Color.RED;
    }

}//BJCard Class

