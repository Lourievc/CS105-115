package RealEstate;

import java.util.*;

public interface Biddable {

    HashMap<String,Double> getBids();
    Double getBid(String bidder);
    Set<String> getBidders();
    int getBidCount();
    void newBid(String bidder, Double bid);

}