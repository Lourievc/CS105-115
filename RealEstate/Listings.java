package RealEstate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Listings implements Listable {

    //    ATTRIBUTES
    static HashMap<String, Residential> listings;

    //CONSTRUCTOR
    public Listings() {
        listings = new HashMap<String, Residential>();
    }


    @Override
    public HashMap getListings() {
        return listings;
    }

    @Override
    public Residential getListing(String list) {
        return listings.get(list);
    }

    @Override
    public Set<String> getStreetAddresses() {
        return listings.keySet();
    }

    @Override
    public Collection<Residential> getResidences() {
        return listings.values();
    }

    @Override
    public int getListingCount() {
        return listings.size();
    }

    @Override
    public void addListing(String l, Residential a) {
        listings.put(l, a);
    }
}
