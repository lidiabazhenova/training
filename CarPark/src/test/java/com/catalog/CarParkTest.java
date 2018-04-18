package com.catalog;

import com.catalog.comparator.AutomobilePriceComparator;
import com.catalog.model.Car;
import org.junit.Assert;
import org.junit.Test;

public class CarParkTest {

    @Test
    public void testMostExpensive(){
        AutomobilePriceComparator comparator = new AutomobilePriceComparator();
        CarPark carPark = new CarPark();
        carPark.add(new Car.CarBuilder()
                .setId(123123L).setBrand("Toyota").setModel("Venza")
                .setPrice(34000.0).setVelocity(230).build());
        carPark.add(new Car.CarBuilder()
                .setId(123123L).setBrand("Toyota").setModel("Camry")
                .setPrice(34000.0).setVelocity(230).build());
        //assertArrayEquals(carPark.getTheMostExpensiveAutomobile(), );
    }

}
