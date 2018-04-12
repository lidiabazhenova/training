package com.catalog.carpark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CarPark {
    private List<Automobile> automobiles;

    public CarPark() {
        automobiles = new ArrayList<Automobile>();
    }

    public Collection<Automobile> getAutomobiles() {
        return Collections.unmodifiableList(new ArrayList<Automobile>(automobiles));
        //return Collections.unmodifiableList(automobiles);
    }

    public void add(Automobile automobile) {
        automobiles.add(automobile);
    }

    public void sell(Automobile automobile) {
        automobiles.remove(automobile);
    }

    public void printList() {
        if (automobiles.isEmpty())
            System.out.println("Empty list of automobiles");

        else {
            for (Automobile car : automobiles) {
                System.out.print(car.getDescription());
                System.out.println("***");
            }
        }
    }

}
