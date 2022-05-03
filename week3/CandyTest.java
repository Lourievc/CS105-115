package week3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandyTest {

	@Test
	void testGetCandyWeight() {
		Candy p1 = new Candy("desert", 2.00, 3.00);
		assertEquals(p1.getCandyWeight(), 2.00);
	}

	@Test
	void testSetCandyWeight() {
		Candy p1 = new Candy("desert", 2.00, 3.00);
		p1.setCandyWeight(4.00);
		assertEquals(p1.getCandyWeight(), 4.00);
	}

	@Test
	void testGetPricePerPound() {
		Candy p1 = new Candy("desert", 2.00, 3.00);
		assertEquals(p1.getPricePerPound(), 3.00);
	}

	@Test
	void testSetPricePerPound() {
		Candy p1 = new Candy("desert", 2.00, 3.00);
		p1.setPricePerPound(4.00);
		assertEquals(p1.getPricePerPound(), 4.00);
	}
	@Test
	void testCalculateCost() {
		Candy p1 = new Candy("desert", 2.00, 3.00);
		p1.calculateCost();
		assertEquals(p1.calculateCost(), 6.00);

	}
	@Test
	void testCalculateTax() {
		Candy p1 = new Candy("desert", 2.00, 3.00);

	}
	@Test
	void testIsSameAs() {
		Candy p1 = new Candy("desert", 2.00, 3.00);
		Candy p2 = new Candy("desert", 3.00, 3.00);
		assertTrue(p1.isSameAs(p2));
	}
	@Test
	void testisSameAs() {
		Candy p1 = new Candy("desert", 2.00, 3.00);
		Candy p3 = new Candy("desert", 2.00, 4.00);
		assertFalse(p1.isSameAs(p3));

	}
}
