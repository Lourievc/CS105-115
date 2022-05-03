package week3;

public class IceCream extends DessertItem{
	private int scoopCount;
	private double pricePerScoop;
	
	
	//constructors
	public IceCream() {
		super();
		scoopCount = 0;
		pricePerScoop = 0.0;
		setPackaging("");
	}
	
	public IceCream(String n, int sC, double pS) {
		super(n);
		scoopCount = sC;
		pricePerScoop = pS;
		setPackaging("Bowl");
	}
	
	//Methods
	public int getScoopCount() {
		return scoopCount;
	}
	
	public void setScoopCount(int sC) {
		scoopCount = sC;
	}
	public double getPricePerScoop() {
		return pricePerScoop;
	}
	
	public void setPricePerScoop(double pS) {
		pricePerScoop = pS;
	}
	public double calculateCost() {
		return scoopCount * pricePerScoop;
	}
	public String toString() {
		String line1 = String.format("%s ice cream (%s)", this.getName(), this.getPackaging());
		String line2_1 = String.format("%d scoops @ $%.2f/scoop:", this.getScoopCount(),this.getPricePerScoop());
		String line2_2 = String.format("$%.2f",this.calculateCost());
		String line2_3 = String.format("[Tax: $%.2f]", this.calculateTax());
		String outputVar = String.format("%s\n\t%-45s%s%17s", line1, line2_1, line2_2, line2_3);
		return outputVar;
	}
}