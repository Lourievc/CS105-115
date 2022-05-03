package RealEstate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PropertyTest {

	@Test
	void getStreetAddress() {
		Condo p1 = new Condo("Heaven's St", "86057", 2, 2, 1000, 2);
		assertEquals(p1.getStreetAddress(), "Heaven's St");
	}

	@Test
	void setSreetAddress() {
		Condo p1 = new Condo("Heaven's St", "86057", 2, 2, 1000, 2);
		p1.setSreetAddress("Paradise's St");
		assertEquals(p1.getStreetAddress(), "Paradise's St");
	}

	@Test
	void getZip() {
		Condo p1 = new Condo("Heaven's St", "86057", 2, 2, 1000, 2);
		assertEquals(p1.getZip(), "86057");
	}

	@Test
	void setZip() {
		Condo p1 = new Condo("Heaven's St", "86057", 2, 2, 1000, 2);
		p1.setZip("86056");
		assertEquals(p1.getZip(), "86056");
	}

	@Test
	void getListPrice() {
		Condo p1 = new Condo("Heaven's St", "86057", 2, 2, 1000, 2);
		assertEquals(p1.getListPrice(), 0.0);
	}

	@Test
	void setListPrice() {
		Condo p1 = new Condo("Heaven's St", "86057", 2, 2, 1000, 2);
		p1.setListPrice(0.1);
		assertEquals(p1.getListPrice(), 0.1);
	}

	@Test
	void getAppraisalPrice() {
		Condo p1 = new Condo("Heaven's St", "86057", 2, 2, 1000, 2);
		assertEquals(p1.getAppraisalPrice(), 0.0);
	}

	@Test
	void setAppraisalPrice() {
		Condo p1 = new Condo("Heaven's St", "86057", 2, 2, 1000, 2);
		p1.setAppraisalPrice(0.1);
		assertEquals(p1.getAppraisalPrice(), 0.1);
	}

}
