package RealEstate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public interface Listable {
    HashMap getListings();
    Residential getListing(String list);
    Set<String> getStreetAddresses();
    Collection<Residential> getResidences();
    int getListingCount();
    void addListing(String l, Residential a);
}
