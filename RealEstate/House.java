package RealEstate;

public class House extends Residential{

	//attributes 
	private double yardAcres;
	
	//constructors
	
	public House() {
		super();
		yardAcres = 0.0;
	}
	
	public House(String sA, String z, int bC, double baC, double sF, double yA) {
		super(sA, z, bC, baC, sF);
		yardAcres = yA;
	}
	
	//methods
	
	public double getYardAcres() {
		return yardAcres;
	}
	
	public void setYardAcres(double yA) {
		yardAcres = yA;
	}

	public double calculateAppraisalPrice(){
		double appraisalPrice = (getYardAcres() * 460000) + (getBaths() * 12000) + (getBeds() * 10000) + (getSize() * 97);
		this.setAppraisalPrice(appraisalPrice);
		return appraisalPrice;
	}

	public String toString() {
		String finalOutput = "";
		finalOutput += "\n-----------------------------------------------------------------\n";
		/*for (Listings e : reoListing) {
			finalOutput += e + "\n";
		}*/
		finalOutput += String.format("\nResidence type: %-9s Address: %-20s Zip Code: %-9s", "House", this.getStreetAddress(), this.getZip());
		finalOutput += "\n-----------------------------------------------------------------\n";
		finalOutput += String.format("\nSq Footage: %,.0f", this.getSize());
		finalOutput += String.format("\nBedrooms: %d", this.getBeds());
		finalOutput += String.format("\nBathrooms: %,.0f", this.getBaths());
		finalOutput += String.format("\nYard Size (Acres): %,.2f", this.getYardAcres());
		finalOutput += "\n-----------------------------------------------------------------\n";
		finalOutput += String.format("\nAppraisal Price: $%,.0f", calculateAppraisalPrice());
		finalOutput += String.format("\nList Price: $%,.0f", this.getListPrice());
		finalOutput += "\n-----------------------------------------------------------------\n";

		return finalOutput;

	}//end of toString
}//end of House Class
