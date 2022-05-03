package week3;


import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

//import week1.Employee;

public class DessertShop {

	static HashMap<String, Customer> customerDB = new HashMap<String, Customer>();

	public static void main(String[] args) {
		boolean closed = false;
		while(!closed) {

			Order oL1 = new Order();

			Scanner sIn = new Scanner(System.in);
			String choice;
			DessertItem orderItem;
			String paymentMethod = "";

			boolean done = false;
			while (!done) {
				System.out.println("\n1: Candy");
				System.out.println("2: Cookie");
				System.out.println("3: Ice Cream");
				System.out.println("4: Sunday");

				System.out.print("\nWhat would you like to add to the order? (1-4, Enter for done): ");
				choice = sIn.nextLine();

				if (choice.equals("")) {
					done = true;
				} else {
					switch (choice) {
						case "1":
							orderItem = userPromptCandy();
							oL1.add(orderItem);
							break;
						case "2":
							orderItem = userPromptCookie();
							oL1.add(orderItem);
							break;
						case "3":
							orderItem = userPromptIceCream();
							oL1.add(orderItem);
							break;
						case "4":
							orderItem = userPromptSundae();
							oL1.add(orderItem);
							break;
					}// end of switch (choice)
				} // end of if (choice.equals(""))
			} // end of while (!done)
			System.out.println("\n");

			Candy c1 = new Candy("Candy Corn", 1.5, .25);
			oL1.add(c1);

			Candy c2 = new Candy("Gummy Bears", .25, .35);
			oL1.add(c2);

			Cookie c3 = new Cookie("Chocolate Chip", 6, 3.99);
			oL1.add(c3);

			IceCream i1 = new IceCream("Pistachio", 2, .79);
			oL1.add(i1);

			Sundae s1 = new Sundae("Vanilla", 3, .69, "Hot Fudge", 1.29);
			oL1.add(s1);

			Cookie c4 = new Cookie("Oatmeal Raisin", 2, 3.45);
			oL1.add(c4);

			String input;
			System.out.print("Enter the customer name: ");
			input = sIn.nextLine();

			if(!customerDB.containsKey(input)){
				Customer p1 = new Customer(input);
				customerDB.put(input, p1);

				customerDB.get(input).addToHistory(oL1);
			} else {
				customerDB.get(input).addToHistory(oL1);
			}



			boolean valid = false;
			while(!valid) {
				System.out.print("What form of payment will be used? (CASH, CARD, PHONE): ");
				paymentMethod = sIn.nextLine();
				for(Payable.PayType s : Payable.PayType.values()) {
					if(paymentMethod.equalsIgnoreCase(s.name())) {
						valid = true;
						oL1.setPayType(s);

					}
				} if(!valid) {
					System.out.println("That's not a valid form of payment.\n");
				}
			}

			Collections.sort(oL1.order);

			System.out.println(oL1.toString());
			int i = 1;
			for (String c : customerDB.keySet()) {
				if(input.equals(c)) i++;
			}
			System.out.println("----------------------------------------------------------");
			System.out.printf("Customer Name: %-15s  Customer ID: %-20d  Total Orders: %d", customerDB.get(input).getName(),
					customerDB.get(input).getID(), i);

			String answer ="";
			System.out.print("\nHit enter to start a new order ");
			answer = sIn.nextLine();
			if(!answer.equals("")) closed = true;





	/*	for (DessertItem p : oL1.getOrderList()) {

			System.out.printf("%-25s$%-8.2f[Tax: $%.2f]\n", p.getName(), p.calculateCost(), p.calculateTax());
*/

		}//end of while

	}
	private static DessertItem userPromptCandy() {
		Scanner in = new Scanner(System.in);
		String answer = "";
		String answer2 = "";
		double weight = 0.0;
		double pound = 0.0;
		boolean done = false;

		Order oL1 = new Order();

		System.out.print("\n\nEnter the type of candy: ");
		answer = in.nextLine();

		// answer2 = getValidDouble("Enter the weight purchased: ","Please enter a valid
		// number.");

		while (!done) {
			System.out.print("Enter the weight purchased: ");
			answer2 = in.nextLine();

			try {
				weight = Double.parseDouble(answer2);
				done = true;
			} catch (Exception e) {
				System.out.println("Please enter a valid number.\n");
			}
		}

		while (done) {
			System.out.print("Enter the price per pound: ");
			answer2 = in.nextLine();

			try {
				pound = Double.parseDouble(answer2);
				done = false;
			} catch (Exception e) {
				System.out.println("Please enter a valid number.\n");
			}
		}
		Candy c = new Candy(answer, weight, pound);

		return c;
	}

	private static DessertItem userPromptCookie() {
		Scanner in = new Scanner(System.in);
		String answer = "";
		String answer2 = "";
		int quantity = 0;
		double dozen = 0.0;
		boolean done = false;

		Order oL1 = new Order();

		System.out.print("\n\nEnter the type of cookie: ");
		answer = in.nextLine();

		// answer2 = getValidDouble("Enter the weight purchased: ","Please enter a valid
		// number.");

		while (!done) {
			System.out.print("Enter the quantity purchased: ");
			answer2 = in.nextLine();

			try {
				quantity = Integer.parseInt(answer2);
				done = true;
			} catch (Exception e) {
				System.out.println("Please enter a valid number.\n");
			}
		}

		while (done) {
			System.out.print("Enter the price per dozen: ");
			answer2 = in.nextLine();

			try {
				dozen = Double.parseDouble(answer2);
				done = false;
			} catch (Exception e) {
				System.out.println("\nPlease enter a valid number.\n");
			}
		}
		Cookie c = new Cookie(answer, quantity, dozen);

		return c;

	}

	private static DessertItem userPromptIceCream() {
		Scanner in = new Scanner(System.in);
		String answer = "";
		String answer2 = "";
		int scoop = 0;
		double pScoop = 0.0;
		boolean done = false;

		Order oL1 = new Order();

		System.out.print("\n\nEnter the type of ice cream: ");
		answer = in.nextLine();

		// answer2 = getValidDouble("Enter the weight purchased: ","Please enter a valid
		// number.");

		while (!done) {
			System.out.print("Enter the number scoops: ");
			answer2 = in.nextLine();

			try {
				scoop = Integer.parseInt(answer2);
				done = true;
			} catch (Exception e) {
				System.out.println("\nPlease enter a valid number.\n");
			}
		}

		while (done) {
			System.out.print("Enter the price per scoop: ");
			answer2 = in.nextLine();

			try {
				pScoop = Double.parseDouble(answer2);
				done = false;
			} catch (Exception e) {
				System.out.println("\nPlease enter a valid number.\n");
			}
		}
		IceCream c = new IceCream(answer, scoop, pScoop);

		return c;
	}

	private static DessertItem userPromptSundae() {
		Scanner in = new Scanner(System.in);
		String answer = "";
		String answer2 = "";
		String tName = "";
		double topping = 0.0;
		int scoop = 0;
		double pScoop = 0.0;
		boolean done = false;

		Order oL1 = new Order();

		System.out.print("\n\nEnter the type of ice cream: ");
		answer = in.nextLine();


		//answer2 = getValidDouble("Enter the weight purchased: ","Please enter a valid number.");



		while (!done) {
			System.out.print("Enter the number scoops: ");
			answer2 = in.nextLine();

			try {
				scoop = Integer.parseInt(answer2);
				done = true;
			}catch (Exception e) {
				System.out.print("\nPlease enter a valid number.\n");
			}
		}

		while (done) {
			System.out.print("Enter the price per scoop: ");
			answer2 = in.nextLine();

			try {
				pScoop = Double.parseDouble(answer2);
				done = false;
			}catch (Exception e) {
				System.out.print("Please enter a valid number.\n");
			}

		}

		System.out.print("Enter the topping name: ");
		tName = in.nextLine();

		while (!done) {
			System.out.print("Enter the topping price: ");
			answer2 = in.nextLine();

			try {
				topping = Double.parseDouble(answer2);
				done = true;
			}catch (Exception e) {
				System.out.print("Please enter a valid number.\n");
			}
		}



		Sundae s1 = new Sundae(answer, scoop, pScoop, tName, topping);


		return s1;


	}
}