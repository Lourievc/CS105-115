package RealEstate;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public abstract class Residential extends Property implements Biddable{
	
	//attributes
	private int bedCount;
	private double bathCount;
	private double sqFootage;
	private HashMap<String, Double> bids = new HashMap<String,Double>();
	
	//constructors
	public Residential() {
		super();
		bedCount = 0;
		bathCount = 0.0;
		sqFootage = 0.0;
	}
	
	public Residential(String sA, String z, int bC, double baC, double sF) {
		super(sA,z);
		bedCount = bC;
		bathCount = baC;
		sqFootage = sF;
		
	}
	
	//methods
	public int getBeds() {
		return bedCount;
	}
	
	public void setBeds(int bC) {
		bedCount = bC;
	}
	public double getBaths() {
		return bathCount;
	}
	public void setBaths(double baC) {
		bathCount = baC;
	}
	public double getSize() {
		return sqFootage;
	}
	
	public void setSize(double sF) {
		sqFootage = sF;
	}

	@Override
	public HashMap<String, Double> getBids() {
		return bids;
	}

	@Override
	public Double getBid(String bidder) {
		return bids.get(bidder);
	}

	@Override
	public Set<String> getBidders() {
		return bids.keySet();
	}

	@Override
	public int getBidCount() {
		return bids.size();
	}

	@Override
	public void newBid(String bidder, Double bid) {
		if (bids.get(bidder) == null) bids.put(bidder, bid);
		else bids.replace(bidder, bid);
	}

	public String detailedBids() {
		String macGyver = "";
		ArrayList<String> bidders = new ArrayList<String>(bids.keySet());
		DecimalFormat formatValue = new DecimalFormat("$###,###,###.00");

		System.out.println("Current bids for this listing: ");
		System.out.println("---------------------------------------------");
		System.out.printf("%10s%20s\n","Bidder","Bids");
		System.out.println("---------------------------------------------\n");

		if (bids.size()==0) return "No Bids\n";
		for (String b : bidders) macGyver += String.format("%6s%18s\n", b, formatValue.format(bids.get(b)));
		return macGyver;
	}

	public abstract double calculateAppraisalPrice();
}

