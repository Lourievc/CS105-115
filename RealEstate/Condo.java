package RealEstate;

public class Condo extends Residential{

	//attributes 
		private int floorLvl;
		
		//constructors
		
		public Condo(String s, String s1, int i, double v, double v1) {
			super();
			floorLvl = 0;
		}
		
		public Condo(String sA, String z, int bC, double baC, double sF, int fL) {
			super(sA, z, bC, baC, sF);
			floorLvl = fL;
		}
		
		//methods
		
		public double getFloorLvl() {
			return floorLvl;
		}
		
		public void setFloorLvl(int fL) {
			floorLvl = fL;
		}

		public double calculateAppraisalPrice(){
			double appraisalPrice = ((getFloorLvl() - 1) * 5000) + (getBaths() * 10000) + (getBeds() * 8000) + (getSize() * 88);
			this.setAppraisalPrice(appraisalPrice);
			return appraisalPrice;
		}
	public String toString() {
		String finalOutput = "";
		finalOutput += "\n----------------------------------------------------------\n";
		finalOutput += String.format("\nResidence type: %-8s Address: %-15s Zip Code: %-8s", "Condo", this.getStreetAddress(), this.getZip());
		finalOutput += "\n-----------------------------------------------------------------\n";
		finalOutput += String.format("\nSq Footage: %,.0f", this.getSize());
		finalOutput += String.format("\nBedrooms: %d", this.getBeds());
		finalOutput += String.format("\nBathrooms: %,.0f", this.getBaths());
		finalOutput += String.format("\nFloor: %,.0f", this.getFloorLvl());
		finalOutput += "\n-----------------------------------------------------------------\n";
		finalOutput += String.format("\nAppraisal Price: $%,.0f", calculateAppraisalPrice());
		finalOutput += String.format("\nList Price: $%,.0f", this.getListPrice());
		finalOutput += "\n-----------------------------------------------------------\n";

		return finalOutput;

	}//end of toString
}//end of Condo Class
