package week3;

import java.util.ArrayList;

public class Customer {
    //attributes
    private String custName = "";
    ArrayList<Order> orderHistory;
    private int custID;
    private static int nextCustID = 1000;

    //constructors
    public Customer(String cN) {
        custName = cN;
        orderHistory = new ArrayList<Order>();
        custID = nextCustID;
        nextCustID ++;
    }
    //methods
    public String getName() {
        return custName;
    }
    public int getID() {
        return custID;
    }
    public ArrayList<Order> getOrderHistory(){
        return orderHistory;
    }
    public void setName(String cN) {
        custName = cN;
    }
    public void addToHistory(Order o) {
        orderHistory.add(o);
    }
}
