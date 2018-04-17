package com.catalog.comparator;

import com.catalog.model.Automobile;

import java.util.Comparator;

/**
 * Class for comparing automobiles by velocity
 */
public class AutomobileVelocityComparator implements Comparator<Automobile> {


    public int compare(Automobile automobile1, Automobile automobile2) {
        return ((Integer) automobile1.getVelocity()).compareTo(automobile2.getVelocity());
    }

}

