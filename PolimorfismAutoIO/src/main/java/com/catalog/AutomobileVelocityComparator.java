package com.catalog;

import java.util.Comparator;

public class AutomobileVelocityComparator implements Comparator<Automobile> {
    public int compare(Automobile o1, Automobile o2) {
        return ((Integer)o1.getVelocity()).compareTo((Integer) o2.getVelocity());
    }
}

