package com.catalog;

import com.catalog.carpark.*;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExampleTest {

    @Test
    public void carParkList() {
        CarPark carPark = new CarPark();

        carPark.add(new Car.CarBuilder().setId(45354454L).setBrand("Audi").setModel("A6").setVelocity(300)
                .setPrice(12346.5).setBootVolume(2).setBodywork(Car.Bodywork.SEDAN).build());


        Car carForSale = new Car.CarBuilder().setId(45354454L).setBrand("Audi").setModel("A6").setVelocity(300)
                .setPrice(12346.5).setBootVolume(2).setBodywork(Car.Bodywork.SEDAN).build();
        //carPark.sell(carForSale);

        carPark.printList();


        //UnmodifiableCollection operations:
        Collection<Automobile> unmodifiableList = carPark.getAutomobiles();
        //unmodifiableList.clear();
        System.out.println(unmodifiableList.size());

        carPark.add(new Car.CarBuilder().setId(45354454L).setBrand("Audi").setModel("A6").setVelocity(300)
                .setPrice(12346.5).setBootVolume(2).setBodywork(Car.Bodywork.SEDAN).build());
        carPark.printList();

        System.out.println(unmodifiableList.size());
    }

}



