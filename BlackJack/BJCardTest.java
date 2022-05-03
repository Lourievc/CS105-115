package BlackJack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BJCardTest {

    @Test
    void getRank() {
        BJCard b1 = new BJCard(BJCard.HEART, BJCard.FIVE);
        assertEquals(b1.getRank(), BJCard.HEART);
    }

    @Test
    void setRank() {
        BJCard b1 = new BJCard(BJCard.HEART, BJCard.FIVE);
        b1.setRank(BJCard.DIAMOND);
        assertEquals(b1.getRank(), BJCard.DIAMOND);

    }

    @Test
    void getSuit() {
        BJCard b1 = new BJCard(BJCard.HEART, BJCard.FIVE);
        assertEquals(b1.getSuit(), BJCard.FIVE);
    }

    @Test
    void setSuit() {
        BJCard b1 = new BJCard(BJCard.HEART, BJCard.FIVE);
        b1.setSuit(BJCard.FOUR);
        assertEquals(b1.getSuit(), BJCard.FOUR);
    }
}