package week3;

//week3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DessertItemTest {

	@Test
	void testGetName() {
		Candy p1 = new Candy ("desert", 0.00 ,0.00);
		assertEquals(p1.getName(), "desert");
	}

	@Test
	void testSetName() {
		Candy p1 = new Candy ("desert", 0.00 ,0.00);
		p1.setName("yammy");
		assertEquals(p1.getName(), "yammy");
	}
	@Test
	void testGetTaxPercent() {
		Candy p1 = new Candy ("desert", 0.00 ,0.00);
		assertEquals(p1.getTaxPercent(), 7.25);

	}

	@Test
	void testSetTaxPercent() {
		Candy p1 = new Candy ("desert", 0.00 ,0.00);
		p1.setTaxPercent(5.00);
		assertEquals(p1.getTaxPercent(), 5.00);
	}
	@Test
	void testCompareTo() {
		Candy p1 = new Candy ("desert", 3.00 ,1.00);
		Candy p2 = new Candy ("desert", 0.00 ,1.00);
		Candy p3 = new Candy ("desert", 1.00 ,1.00);

		assertEquals(p1.compareTo(p2), 1);
		assertEquals(p2.compareTo(p3), -1);
		assertEquals(p1.compareTo(p1), 0);
	}

}
