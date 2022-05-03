package RealEstate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HouseTest {

	@Test
	void testGetYardAcres() {
		House p1 = new House("Heaven's St", "86057", 6, 2.2, 3.3, 4.4);
		assertEquals(p1.getYardAcres(), 4.4);
	}

	@Test
	void testSetYardAcres() {
		House p1 = new House("Heaven's St", "86057", 6, 2.2, 3.3, 4.4);
		p1.setYardAcres(4.5);
		assertEquals(p1.getYardAcres(), 4.5);
	}
	@Test
	void calculateAppraisalPrice() {
		House p1 = new House("Heaven's St", "86057", 6, 2.2, 3.3, 4.4);
		double appraisalPrice;
		appraisalPrice = (Math.floor(p1.getYardAcres()) * 460000) + (p1.getBaths() * 12000) + (p1.getBeds() * 10000) + (p1.getSize() * 97);
		assertEquals(p1.calculateAppraisalPrice(), appraisalPrice);
	}

}
