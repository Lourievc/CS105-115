package RealEstate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CondoTest {

	@Test
	void testGetFloorLvl() {
		Condo p1 = new Condo("Heaven's St", "86057", 6, 2.2, 3.3, 3);
		assertEquals(p1.getFloorLvl(), 3);
	}

	@Test
	void testSetFloorLvl() {
		Condo p1 = new Condo("Heaven's St", "86057", 6, 2.2, 3.3, 3);
		p1.setFloorLvl(2);
		assertEquals(p1.getFloorLvl(), 2);
	}
	@Test
	void calculateAppraisalPrice() {
		Condo p1 = new Condo("Heaven's St", "86057", 6, 2.2, 3.3, 3);
		double appraisalPrice;
		appraisalPrice = ((p1.getFloorLvl() - 1) * 5000) + (p1.getBaths() * 10000) + (p1.getBeds() * 8000) + (p1.getSize() * 88);
		assertEquals(p1.calculateAppraisalPrice(), appraisalPrice);
	}

}
