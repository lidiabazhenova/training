package com.catalog.comparator;

import com.catalog.model.Automobile;

import java.util.Comparator;

public class AutomobilePriceComparator implements Comparator<Automobile> {

    public int compare(Automobile o1, Automobile o2) {
        return ((Double)o1.getPrice()).compareTo((Double)o2.getPrice());
    }

}
