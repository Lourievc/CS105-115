package BlackJack;

import BlackJackBase.PCard;
import BlackJackBase.PDeck;

import java.util.ArrayList;
import java.util.Collections;


public class BJDeck implements PDeck {

    //ATTRIBUTES
    private final ArrayList<BJCard> cards;

    //CONSTRUCTOR
    public BJDeck() {
        cards = new ArrayList<>();

        //for loop to add all 56 cards to the array
        for(int a = 1; a <= 14; a++) {
            for(int b = 1; b <= 4; b++) {
                cards.add(new BJCard(a,b));
            }
        }
    }//end of BJDeck constructor


    //METHODS
    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public void addCard(PCard card) {
       //  BJCard newCard = new BJCard(1, 1);
        cards.add((BJCard) card);
    }

    /* Remove a card from the end of the deck, and return null if the deck is empty */
    @Override
    public PCard dealCard() {

        if (cards.size() != 0) {
            BJCard card = cards.remove(cards.size() - 1);
            return card;
        } else {
            return null;
        }
    }//end of dealCard()

    @Override
    public PCard dealHiddenCard() {
        if (cards.size() != 0) {
            BJCard card = cards.remove(cards.size() - 1);
            card.hideCard();
            return card;
        } else {
            return null;
        }
    }

    @Override
    public int cardCount() {
        return cards.size();
    }

}
