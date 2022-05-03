package week3;

public class Candy extends DessertItem implements SameItem<Candy> {
    private double candyWeight;
    private double pricePerPound;


    //constructors
    public Candy() {
        super();
        candyWeight = 0.0;
        pricePerPound = 0.0;
        setPackaging("");
    }

    public Candy(String n, double c, double p) {
        super(n);
        candyWeight = c;
        pricePerPound = p;
        setPackaging("Bag");
    }

    //Methods
    public double getCandyWeight() {
        return candyWeight;
    }

    public void setCandyWeight(double c) {
        candyWeight = c;
    }

    public double getPricePerPound() {
        return pricePerPound;
    }

    public void setPricePerPound(double p) {
        pricePerPound = p;
    }

    public double calculateCost() {
        return candyWeight * pricePerPound;
    }

    public String toString() {
        String line1 = String.format("%s (%s)", this.getName(), this.getPackaging());
        String line2_1 = String.format("%.2f lbs. @ $%.2f/lb.:", this.getCandyWeight(), this.getPricePerPound());
        String line2_2 = String.format("$%.2f", this.calculateCost());
        String line2_3 = String.format("[Tax: $%.2f]", this.calculateTax());
        String outputVar = String.format("%s\n\t%-45s%s%17s", line1, line2_1, line2_2, line2_3);
        return outputVar;
    }

    public boolean isSameAs(Candy other){
        return (this.getName().equals(other.getName()) && (this.getPricePerPound() == (other.getPricePerPound())));
    }

}
