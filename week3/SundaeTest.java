package week3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SundaeTest {

	@Test
	void testGetToppingName() {
		Sundae p1 = new Sundae("desert", 2, 3.00, "chips", 5.00);
		assertEquals(p1.getToppingName(), "chips");
	}

	@Test
	void testSetToppingName() {
		Sundae p1 = new Sundae("desert", 2, 3.00, "chips", 5.00);
		p1.setToppingName("chocolate");
		assertEquals(p1.getToppingName(), "chocolate");
	}

	@Test
	void testGettoppingPrice() {
		Sundae p1 = new Sundae("desert", 2, 3.00, "chips", 5.00);
		assertEquals(p1.getToppingPrice(), 5.00);
	}

	@Test
	void testSettoppingPrice() {
		Sundae p1 = new Sundae("desert", 2, 3.00, "chips", 5.00);
		p1.setToppingPrice(6.00);
		assertEquals(p1.getToppingPrice(), 6.00);
	}
	@Test
	void testCalculateCost() {
		Sundae p1 = new Sundae("desert", 2, 3.00,"chips", 5.00);
		p1.calculateCost();
	
	}
	@Test
	void testCalculateTax() {
		Sundae p1 = new Sundae("desert", 2, 3.00,"chips", 5.00);
		p1.calculateTax();
	
	}

}