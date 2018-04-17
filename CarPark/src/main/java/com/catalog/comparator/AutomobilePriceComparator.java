package com.catalog.comparator;

import com.catalog.model.Automobile;

import java.util.Comparator;

/**
 ** Class for comparing automobiles by price
 */
public class AutomobilePriceComparator implements Comparator<Automobile> {

    public int compare(Automobile automobile1, Automobile automobile2) {
        return ((Double) automobile1.getPrice()).compareTo(automobile2.getPrice());
    }

}
