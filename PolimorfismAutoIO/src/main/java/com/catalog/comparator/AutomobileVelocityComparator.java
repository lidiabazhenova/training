package com.catalog.comparator;

import com.catalog.model.Automobile;

import java.util.Comparator;

public class AutomobileVelocityComparator implements Comparator<Automobile> {

    public int compare(Automobile o1, Automobile o2) {
        return o1.getVelocity().compareTo(o2.getVelocity());
    }

}

