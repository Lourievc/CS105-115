package week3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IceCreamTest {

	@Test
	void testGetScoopCount() {
		IceCream p1 = new IceCream("desert", 2, 3.00);
		assertEquals(p1.getScoopCount(), 2);
	}

	@Test
	void testSetScoopCount() {
		IceCream p1 = new IceCream("desert", 2, 3.00);
		p1.setScoopCount(4);
		assertEquals(p1.getScoopCount(), 4);
	}

	@Test
	void testGetPricePerScoop() {
		IceCream p1 = new IceCream("desert", 2, 3.00);
		assertEquals(p1.getPricePerScoop(), 3.00);
	}

	@Test
	void testSetPricePerScoop() {
		IceCream p1 = new IceCream("desert", 2, 3.00);
		p1.setPricePerScoop(5.00);
		assertEquals(p1.getPricePerScoop(), 5.00);
	}
	@Test
	void testCalculateCost() {
		IceCream p1 = new IceCream("desert", 2, 3.00);
		p1.calculateCost();
	
	}
	@Test
	void testCalculateTax() {
		IceCream p1 = new IceCream("desert", 2, 3.00);
		p1.calculateTax();
	
	}

}

