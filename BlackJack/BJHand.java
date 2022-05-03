package BlackJack;

import BlackJackBase.PCard;
import BlackJackBase.PHand;

import java.util.ArrayList;

public class BJHand implements PHand {

    //ATTRIBUTES
    private final ArrayList<BJCard> hand;

    //CONSTRUCTOR

    public BJHand() {
        hand = new ArrayList<>();
        BJDeck deck = new BJDeck();
        addCard(deck.dealCard());
    }

    //METHODS
    @Override
    public int getSize() {
        return hand.size();
    }

    @Override
    public void addCard(PCard card) {
        hand.add((BJCard) card);
    }

    @Override
    public PCard getCard(int index) {
        return (PCard) hand.get(index);
    }

    @Override
    public PCard removeCard(int index) {
        return (PCard) hand.remove(index);
    }

    @Override
    public int getValue() {

        int cardValue = 0;
        int aces = 0;

        /**
         * Conditional statement to determine the value of cards and when ace will be an 11 or 1
         */
        if (hand.isEmpty()) return 0;
        else {

            for(BJCard bjC : hand) {

                if (((BJCard) bjC).getRank() >= 10) {
                    cardValue += 10;
                } else if (((BJCard) bjC).getRank() == 1) {
                    cardValue += 11;
                    aces += 1;

                } else {
                    cardValue += bjC.getRank();
                }
                //for loop for the aces
                for(int i = 0; i < aces; i++) {
                    if(cardValue > 21 && aces >= 1) {
                        cardValue -= 10;
                        aces -= 1;
                    }

                }//end of for loop for the aces

            }//end of for loop (the iteration of all cards)

        }//end of first else (if the hand is not empty)
        return cardValue;
    }//end of getValue

}
