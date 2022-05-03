package week3;

import java.util.ArrayList;

public class Order implements Payable{
		//attributes
		ArrayList <DessertItem> order ;
		PayType payMethod;

		//constructor 
		public Order () {
			order = new ArrayList<DessertItem>();
			payMethod = PayType.CASH;
		}
		
		//methods
		
		public ArrayList<DessertItem> getOrderList(){
			return order;
		}
		
		public void add(DessertItem d) {

//			for (DessertItem z : order) {
//				if (d instanceof Candy && z instanceof Candy && ((Candy) d).isSameAs((Candy) z)) {
//					((Candy) z).setCandyWeight(((Candy) z).getCandyWeight() + ((Candy) d).getCandyWeight());
//				} else if (d instanceof Cookie && z instanceof Cookie && ((Cookie) d).isSameAs((Cookie) z)) {
//					((Cookie) z).setCookieQty(((Cookie) z).getCookieQty() + ((Cookie) d).getCookieQty());
//				} else


			if (d instanceof Candy) {
				for (DessertItem e : order) {
					if (e instanceof Candy) {
						if (((Candy) d).isSameAs((Candy) e)) {
							((Candy) e).setCandyWeight(((Candy) e).getCandyWeight() + ((Candy) d).getCandyWeight());
							return;
						}
					}
				}
			}
			else if (d instanceof Cookie) {
				for (DessertItem item : order) {
					if (item instanceof Cookie) {
						if (((Cookie) d).isSameAs((Cookie) item)) {
							((Cookie) item).setCookieQty(((Cookie) item).getCookieQty() + ((Cookie) d).getCookieQty());
							return;
						}
					}
				}
			}
			order.add(d);
		}
		public int itemCount() {
			return order.size();
		}
		public double orderCost() {
			double totalCost = 0;
			for(DessertItem e : order) {
		       totalCost = totalCost + e.calculateCost();
			} return totalCost;     
		}                    
		public double orderTax() {
			double totalTax = 0;
			for(DessertItem e : order) {               
				totalTax = totalTax + e.calculateTax();
			} return totalTax;
		}
		public String toString() {
			String finalOutput = "";
			finalOutput += "\n---------------------------Receipt-------------------------------\n";
			for (DessertItem e : this.order) {
				finalOutput += e + "\n";
			}
			finalOutput += "-----------------------------------------------------------------";
			finalOutput += String.format("\nTotal number of items in order: %d", itemCount());
			
			finalOutput += String.format("%-54s$%-8.2f[Tax: $%.2f]\n", "\nOrder Subtotals:", orderCost(), orderTax());
			finalOutput += String.format("%-53s$%-8.2f\n", "Order Total:", orderCost() + orderTax());
			finalOutput += "-----------------------------------------------------------"; 
	        finalOutput += String.format("\nPaid for with %s", getPayType().name());
			return finalOutput;

		}
		
		public PayType getPayType() {
			return payMethod;
		}
		public void setPayType(PayType pT) {
			payMethod = pT;
		}
	}
