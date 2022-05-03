package RealEstate;

import java.util.*;
import java.util.stream.IntStream;

public class REO {

    static Listings reoListings = new Listings();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean valid = false;
        String inMenu = "";

        String answer = "";


        while (!valid) {

            System.out.print("\n----------------------------------------------------------------");
            System.out.print("\n                       Main Menu                                ");
            System.out.print("\n----------------------------------------------------------------\n");

            System.out.print("\n1: Listings");
            System.out.print("\n2: Bids\n");

            System.out.print("\nWhat would you like to do? (1-2): ");
            answer = in.nextLine();

            if (answer.equals("")) {
                valid = true;
            } else {
                switch (answer) {
                    case "1":
                        listingsMenu();
                        break;
                    case "2":
                        bidsMenu();
                        break;
                } //end of switch
            }//end of else
        }//end of while loop


    }//end of main

    private static void bidsMenu() {
        Scanner in = new Scanner(System.in);
        boolean valid = false;
        String inMenu = "";
        String answer = "";


        while (!valid) {

            System.out.print("\n----------------------------------------------------------------");
            System.out.print("\n                       Bids Menu                                ");
            System.out.print("\n----------------------------------------------------------------\n");
            System.out.print("\n1: Add New Bid");
            System.out.print("\n2: Show Existing Bids");
            System.out.print("\n3: Auto Populate Bids (Dev Tool)");
            System.out.print("\nENTER: Exit back to previous menu\n");

            System.out.print("\nWhat would you like to do? (1-3): ");
            answer = in.nextLine();

            if (answer.equals("")) {
                valid = true;
            } else {
                switch (answer) {
                    case "1":
                       addBid();
                        break;
                    case "2":
                        showBids();
                        break;
                    case "3":
                        autoPopulateBids();
                } //end of switch
            }//end of else
        }//end of while loop
    }//end of listingsMenu

    private static void addBid() {
        Scanner in = new Scanner(System.in);
        List<Residential> properties = new ArrayList<>(reoListings.getResidences());
        int index = 0;

        String tHeader = "\n" +
                "Current Listings for REO:\n" +
                "No.      Property (bids)\n" +
                "---------------------------\n" +
                "\n";

        System.out.println(tHeader);

        for (Residential r : properties) {
            System.out.println((index + 1) + ": " + r.getStreetAddress() + " (" + r.getBidCount() + ")");
            index += 1;
        }
        System.out.println("ENTER: Exit back to previous menu\n");

        System.out.print("\nFor which property would you like to add a bid? ");
        index = Integer.parseInt(in.nextLine());
        System.out.println(properties.get(index - 1));
        System.out.println(properties.get(index - 1).detailedBids());

        System.out.print("\nPlease enter the name of the bidder: ");
        String bidderName = in.nextLine();
        System.out.print("\nPlease enter the new bid: ");
        String bidValue = in.nextLine();
        properties.get(index - 1).newBid(bidderName, Double.parseDouble(bidValue));
        System.out.println("\nNew bid for property '" + properties.get(index - 1).getStreetAddress() + "' added.");
    }

    private static void showBids() {
        Scanner in = new Scanner(System.in);
        List<Residential> properties = new ArrayList<>(reoListings.getResidences());
        int index = 0;


            String tHeader = "\n" +
                    "Current Listings for REO:\n" +
                    "No.      Property (bids)\n" +
                    "---------------------------\n" +
                    "\n";

            System.out.println(tHeader);

            for (Residential r : properties) {
                System.out.println((index + 1) + ": " + r.getStreetAddress() + " (" + r.getBidCount() + ")");
                index += 1;
            }
            System.out.println("ENTER: Exit back to previous menu\n");

            System.out.print("\nFor which property would you like to see the current bids? ");
            index = in.nextInt();
            System.out.println(properties.get(index - 1));
            System.out.println("\n\n");
            System.out.println(properties.get(index - 1).detailedBids());
    }

    private static void autoPopulateBids() {
        List<Residential> residences = new ArrayList<>(reoListings.getResidences());
        Random random = new Random();

        String[] autoBidders= {"Patric Stewart","Walter Koenig","William Shatner","Leonard Nimoy","DeForect Kelley","James Doohan","George Takei","Majel Barrett","Nichelle Nichol","Jonathan Frank"
                ,"Marina Sirtis","Brent Spiner","Gates McFadden","Michael Dorn","LeVar Burton","Wil Wheaton","Colm Meaney","Michelle Forbes"};

        residences.forEach(r -> {
            int numberOfBids = random.nextInt(6) + 1;
            IntStream
                    .range(0, numberOfBids)
                    .map(i -> random.nextInt(autoBidders.length - 1) + 1)
                    .forEach(index -> r.newBid(autoBidders[index], r.calculateAppraisalPrice() * (1 + (Math.random() + 0.2) / 4)));
            System.out.println(numberOfBids + " new bids have been added to listing " + r.getStreetAddress());
        });
    }

    private static void listingsMenu() {
        Scanner in = new Scanner(System.in);
        boolean valid = false;
        String inMenu = "";
        String answer = "";


        while (!valid) {

            System.out.print("\n----------------------------------------------------------------");
            System.out.print("\n                       Listing Menu                                ");
            System.out.print("\n----------------------------------------------------------------\n");
            System.out.print("\n1: Add Listing");
            System.out.print("\n2: Show Listings");
            System.out.print("\n3: Auto Populate Listings (Dev tool)");
            System.out.print("\nENTER: Exit back to previous menu\n");

            System.out.print("\nWhat would you like to do? (1-3): ");
            answer = in.nextLine();

            if (answer.equals("")) {
                valid = true;
            } else {
                switch (answer) {
                    case "1":
                        addListing();
                        break;
                    case "2":
                        showListings();
                        break;
                    case "3":
                        autoPopulate();
                } //end of switch
            }//end of else
        }//end of while loop
    }//end of listingsMenu

    private static void showListings() {
        Collection<Residential> cResidential = reoListings.getResidences();

        System.out.println("Current Listings for REO:\n");
        int i=1;
        for(Residential r : cResidential) {
            System.out.println("Listing No: "+i);
            System.out.println(r+"\n\n");
            i++;
        }

    }

    private static void addListing() {
        Scanner in = new Scanner(System.in);
        boolean valid = false;
        String inMenu = "";
        String answer = "";


        while (!valid) {

            System.out.print("\n----------------------------------------------------------------");
            System.out.print("\n                       Add Listing Menu                                ");
            System.out.print("\n----------------------------------------------------------------\n");
            System.out.print("\n1: Add House");
            System.out.print("\n2: Add Condo");
            System.out.print("\nENTER: Exit back to previous menu\n");

            System.out.print("\nWhat would you like to do? (1-2): ");
            answer = in.nextLine();

            if (answer.equals("")) {
                valid = true;
            } else {
                switch (answer) {
                    case "1":
                        addHouse();
                        break;
                    case "2":
                        addCondo();
                        break;
                } //end of switch
            }//end of else
        }//end of while loop
    }//end of listingsMenu

    private static void addCondo() {
        Scanner in = new Scanner(System.in);
        String sAddress = "";
        String zCode = "";
        int nBed = 0;
        double nBath = 0.0;
        double sqFeet = 0.0;
        int fLevel = 0;
        double lPrice = 0.0;
        boolean done = false;

        System.out.print("\nPlease enter the street address for the residence: ");
        sAddress = in.nextLine();
        System.out.print("\nPlease enter the zip code for the residence: ");
        zCode = in.nextLine();

        while (!done) {
            System.out.print("\nPlease enter the number of bedrooms: ");
            String input2 = in.nextLine();

            try {
                nBed = Integer.parseInt(input2);
                done = true;
            } catch (Exception e) {
                System.out.println("Please enter a valid number.\n");
            }
        }

        while (done) {
            System.out.print("\nPlease enter the number of bathrooms: ");
            String input2 = in.nextLine();

            try {
                nBath = Double.parseDouble(input2);
                done = false;
            } catch (Exception e) {
                System.out.println("Please enter a valid number.\n");
            }
        }

        while (!done) {
            System.out.print("\nPlease enter the square footage of the residence: ");
            String input2 = in.nextLine();

            try {
                sqFeet = Double.parseDouble(input2);
                done = true;
            } catch (Exception e) {
                System.out.println("Please enter a valid number.\n");
            }
        }

        while (done) {
            System.out.print("\nPlease enter the floor level of the condo: ");
            String input2 = in.nextLine();

            try {
                fLevel = Integer.parseInt(input2);
                done = false;
            } catch (Exception e) {
                System.out.println("Please enter a valid number.\n");
            }
        }

        Condo c = new Condo(sAddress, zCode, nBed, nBath, sqFeet, fLevel);
        reoListings.addListing(c.getStreetAddress(), c);

        System.out.printf("\nAppraisal Price for this property is: $%,.0f", c.calculateAppraisalPrice());

        System.out.print("\nPlease enter the List Price for the property: ");
        c.setListPrice(Double.parseDouble(in.nextLine()));

        System.out.print("\n\nYou have created a new listing!");
        System.out.println(c);

    }

    private static void addHouse() {
        Scanner in = new Scanner(System.in);
        String sAddress = "";
        String zCode = "";
        int nBed = 0;
        double nBath = 0.0;
        double sqFeet = 0.0;
        double nYard = 0.0;
        double lPrice = 0.0;
        boolean done = false;

        System.out.print("\nPlease enter the street address for the residence: ");
        sAddress = in.nextLine();
        System.out.print("\nPlease enter the zip code for the residence: ");
        zCode = in.nextLine();

        while (!done) {
            System.out.print("\nPlease enter the number of bedrooms: ");
            String input2 = in.nextLine();

            try {
                nBed = Integer.parseInt(input2);
                done = true;
            } catch (Exception e) {
                System.out.println("\nPlease enter a valid number.\n");
            }
        }

        while (done) {
            System.out.print("\nPlease enter the number of bathrooms: ");
            String input2 = in.nextLine();

            try {
                nBath = Double.parseDouble(input2);
                done = false;
            } catch (Exception e) {
                System.out.println("\nPlease enter a valid number.\n");
            }
        }

        while (!done) {
            System.out.print("\nPlease enter the square footage of the residence: ");
            String input2 = in.nextLine();

            try {
                sqFeet = Double.parseDouble(input2);
                done = true;
            } catch (Exception e) {
                System.out.println("\nPlease enter a valid number.\n");
            }
        }

        while (done) {
            System.out.print("\nPlease enter the size of the yard in acres: ");
            String input2 = in.nextLine();

            try {
                nYard = Double.parseDouble(input2);
                done = false;
            } catch (Exception e) {
                System.out.println("\nPlease enter a valid number.\n");
            }
        }

        House h = new House(sAddress, zCode, nBed, nBath, sqFeet, nYard);
        reoListings.addListing(h.getStreetAddress(), h);

        System.out.printf("\nAppraisal Price for this property is: $%,.0f", h.calculateAppraisalPrice());

        System.out.print("\nPlease enter the List Price for the property: ");
        h.setListPrice(Double.parseDouble(in.nextLine()));


        System.out.print("\n\nYou have created a new listing!");
        System.out.println(h);

    }//end of addCondo
    public static void autoPopulate(){
        int currentSize = reoListings.getListings().size();
        House house1 = new House("34 Elm","95129", 3, 2, 2200, .2);
        house1.setListPrice(house1.calculateAppraisalPrice() * 1.1);
        reoListings.addListing("34 Elm", house1);
        House house2 = new House("42 Hitchhikers","95136", 4, 3, 2800, .3);
        house2.setListPrice(house2.calculateAppraisalPrice() * 1.1);
        reoListings.addListing("42 Hitchhikers", house2);
        Condo condo1 = new Condo("4876 Industrial", "95177", 3, 1, 1800, 3);
        condo1.setListPrice(condo1.calculateAppraisalPrice() * 1.1);
        reoListings.addListing("4876 Industrial", condo1);
        House house3 = new House("2654 Oak","84062", 5, 53, 4200, .5);
        house3.setListPrice(house3.calculateAppraisalPrice() * 1.1);
        reoListings.addListing("2654 Oak", house3);
        Condo condo2 = new Condo("9875 Lexington","84063", 2, 1, 1500, 1);
        condo2.setListPrice(condo2.calculateAppraisalPrice() * 1.1);
        reoListings.addListing("9875 Lexington", condo2);
        Condo condo3 = new Condo("3782 Market", "84066", 3, 1, 1800, 2);
        condo3.setListPrice(condo3.calculateAppraisalPrice() * 1.1);
        reoListings.addListing("3782 Market", condo3);
        House house4 = new House("7608 Glenwood", "84055", 6, 3, 3900, .4);
        house4.setListPrice(house4.calculateAppraisalPrice() * 1.1);
        reoListings.addListing("7608 Glenwood", house4);
        House house5 = new House("1220 Apple", "84057", 8, 7, 7900, 1);
        house5.setListPrice(house5.calculateAppraisalPrice() * 1.1);
        reoListings.addListing("1220 Apple", house5);

        System.out.print("\n8 residences have been added to the listings for testing purposes.");
    }

}//end of REO class