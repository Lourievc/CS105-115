package RealEstate;

public abstract class Property {

	//Attributes 
	private String streetAddress;
	private String zip;
	private double listPrice;
	private double appraisalPrice;
	
	//Constructors 
	public Property() {
		streetAddress = "";
		zip = "";
	}
	public Property(String sA, String z) {
		streetAddress = sA;
		zip = z;
	}
	
	//Methods
	public String getStreetAddress() {
		return streetAddress;
	}
	
	public void setSreetAddress(String sA) {
		streetAddress = sA;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String z) {
		zip = z;
	}
	public double getListPrice(){
		return listPrice;
	}
	public void setListPrice(double lP){
		listPrice = lP;
	}
	public double getAppraisalPrice(){
		return appraisalPrice;
	}
	protected void setAppraisalPrice(double aP){
		appraisalPrice = aP;
	}
	public abstract double calculateAppraisalPrice();

}
