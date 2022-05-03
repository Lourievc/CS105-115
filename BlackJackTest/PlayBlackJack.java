package BlackJackTest;

import BlackJack.BJDeck;
import BlackJack.BJHand;
import BlackJackBase.PGame;

import java.awt.*;

public class PlayBlackJack {

    public static void main(String[] args) {

        PGame.setBackgroundColor(Color.GREEN);
        PGame.setBannerColor(Color.BLACK);
        PGame.setBannerTextColor(Color.WHITE);
        PGame.setButtonColor(Color.BLACK);
        PGame.setButtonHighlightColor(Color.LIGHT_GRAY);
        PGame.setButtonTextColor(Color.WHITE);
        PGame.setFont("Serif");
        PGame.setStatusTextColor(Color.BLUE);

        PGame.run(new BJDeck(), new BJHand(), new BJHand());

        //HandTest.run(new BJDeck(), new BJHand());

        //DeckTest.run(new BJDeck());

		/*
		BJCard b1 = new BJCard(BJCard.FOUR, BJCard.SPADE);
        CardTest.run(b1);
		*/


    }

}
