package week3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CookieTest {

	@Test
	void testGetCookieQty() {
		Cookie p1 = new Cookie("desert", 2, 2.00);
		assertEquals(p1.getCookieQty(), 2);
	}

	@Test
	void testSetCookieQty() {
		Cookie p1 = new Cookie("desert", 2, 2.00);
		p1.setCookieQty(3);
		assertEquals(p1.getCookieQty(), 3);
	}

	@Test
	void testGetPricePerDozen() {
		Cookie p1 = new Cookie("desert", 2, 2.00);
		assertEquals(p1.getCookieQty(), 2.00);
	}

	@Test
	void testSetPricePerDozen() {
		Cookie p1 = new Cookie("desert", 2, 2.00);
		p1.setPricePerDozen(3.00);
		assertEquals(p1.getPricePerDozen(), 3.00);
	}
	@Test
	void testCalculateCost() {
		Cookie p1 = new Cookie("desert", 2, 3.00);
		p1.calculateCost();

	}
	@Test
	void testCalculateTax() {
		Cookie p1 = new Cookie("desert", 2, 3.00);
		p1.calculateTax();

	}
	@Test
	void testIsSameAs() {
		Cookie p1 = new Cookie("desert", 2, 3.00);
		Cookie p2 = new Cookie("desert", 4, 3.00);
		assertTrue(p1.isSameAs(p2));
	}
	@Test
	void testisSameAs() {
		Cookie p1 = new Cookie("desert", 2, 3.00);
		Cookie p3 = new Cookie("desert", 2, 5.00);
		assertFalse(p1.isSameAs(p3));

	}

}
