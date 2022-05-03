package week3;

public class Cookie extends DessertItem implements SameItem<Cookie>{
	private int cookieQty;
	private double pricePerDozen;
	
	
	//constructors
	public Cookie() {
		super();
		cookieQty = 0;
		pricePerDozen = 0.0;
		setPackaging("");
	}
	
	public Cookie(String n, int q, double pD) {
		super(n);
		cookieQty = q;
		pricePerDozen = pD;
		setPackaging("Box");
	}
	
	//Methods
	public int getCookieQty() {
		return cookieQty;
	}
	
	public void setCookieQty(int q) {
		cookieQty = q;
	}
	public double getPricePerDozen() {
		return pricePerDozen;
	}
	
	public void setPricePerDozen(double pD) {
		pricePerDozen = pD;
	}
	public double calculateCost() {
		return cookieQty * (pricePerDozen/12);
	}
	public String toString() {
		String line1 = String.format("%s cookies (%s)", this.getName(), this.getPackaging());
		String line2_1 = String.format("%d cookies @ $%.2f/dozen:", this.getCookieQty(),this.getPricePerDozen());
		String line2_2 = String.format("$%.2f",this.calculateCost());
		String line2_3 = String.format("[Tax: $%.2f]", this.calculateTax());
		String outputVar = String.format("%s\n\t%-45s%s%17s", line1, line2_1, line2_2, line2_3);
		return outputVar;
	}
	public boolean isSameAs(Cookie other){
		return(this.getName().equals(other.getName()) && (this.getPricePerDozen() == (other.getPricePerDozen())));
	}

}