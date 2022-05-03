package RealEstate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResidentialTest {

	@Test
	void testGetBeds() {
		Condo p1 = new Condo("Heaven's St", "86057", 6, 2.2, 3.3);
		assertEquals(p1.getBeds(), 6);
	}

	@Test
	void testSetBeds() {
		Condo p1 = new Condo("Heaven's St", "86057", 6, 2.2, 3.3);
		p1.setBeds(5);
		assertEquals(p1.getBeds(), 5);
	}

	@Test
	void testGetBaths() {
		Condo p1 = new Condo("Heaven's St", "86057", 6, 2.2, 3.3);
		assertEquals(p1.getBaths(), 6.0);
	}

	@Test
	void testSetBaths() {
		Condo p1 = new Condo("Heaven's St", "86057", 6, 2.2, 3.3);
		p1.setBaths(2.5);
		assertEquals(p1.getBaths(), 6.0);
	}

	@Test
	void testGetSize() {
		Condo p1 = new Condo("Heaven's St", "86057", 6, 2.2, 3.3);
		assertEquals(p1.getSize(), 3.3);
	}

	@Test
	void testSetSize() {
		Condo p1 = new Condo("Heaven's St", "86057", 6, 2.2, 3.3);
		p1.setSize(3.5);
		assertEquals(p1.getSize(), 3.5);
	}

}
