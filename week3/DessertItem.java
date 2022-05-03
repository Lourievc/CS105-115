package week3;

public abstract class DessertItem implements Packaging, Comparable<DessertItem> {
	//attributes
	private String name;
	private double taxPercent = 7.25;
	private String packaging = "";

	//constructors
	public DessertItem() {

		name = "";
	}

	public DessertItem(String n) {

		name = n;
	}

	//Methods
	public String getName() {

		return name;
	}

	public void setName(String n) {

		name = n;
	}

	public double getTaxPercent() {

		return taxPercent;
	}

	public void setTaxPercent(double e) {

		taxPercent = e;
	}

	public abstract double calculateCost();

	public double calculateTax() {
		return taxPercent / 100 * calculateCost();
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String sP) {
		packaging = sP;
	}

	public int compareTo(DessertItem oL1) {

		if (this.calculateCost() > oL1.calculateCost()) return 1;
		if (this.calculateCost() < oL1.calculateCost()) return -1;
		else return 0;


	}

}
