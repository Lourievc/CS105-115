package week3;

public class Sundae extends IceCream {
	private String toppingName;
	private double toppingPrice;

	// constructors
	public Sundae() {
		super();
		toppingName = "";
		toppingPrice = 0.0;
		setPackaging("");
	}

	public Sundae(String n, int sC, double pS, String t, double tP) {
		super(n, sC, pS);
		toppingName = t;
		toppingPrice = tP;
		setPackaging("Boat");
	}

	// Methods
	public String getToppingName() {
		return toppingName;
	}

	public void setToppingName(String t) {
		toppingName = t;
	}

	public double getToppingPrice() {
		return toppingPrice;
	}

	public void setToppingPrice(double tP) {
		toppingPrice = tP;
	}

	public double calculateCost() {
		return toppingPrice + (getScoopCount() * getPricePerScoop());
	}

	public String toString() {
		String line1 = String.format("%s %s Sundae (%s)\n\t%d scoops of %s ice cream @ $%.2f/scoop", this.getToppingName(), this.getName(),this.getPackaging(), this.getScoopCount(),
				this.getName(), this.getPricePerScoop());
		String line2_1 = String.format("%s topping @ $%.2f", this.getToppingName(), this.getToppingPrice());
		String line2_2 = String.format("$%.2f", this.calculateCost());
		String line2_3 = String.format("[Tax: $%.2f]", this.calculateTax());
		String outputVar = String.format("%s\n\t%-45s%s%17s", line1, line2_1, line2_2, line2_3);
		return outputVar;
	}
}