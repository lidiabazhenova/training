package com.catalog.comparator;

import com.catalog.model.Car;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AutomobilePriceComparatorTest {

    @Test
    public void testEquals(){
        AutomobilePriceComparator comparator = new AutomobilePriceComparator();
        int result = comparator.compare(getCarForTest(100),
                getCarForTest(100));

        assertTrue(result == 0);
    }

    @Test
    public void testFirstGreater(){
        AutomobilePriceComparator comparator = new AutomobilePriceComparator();
        int result = comparator.compare(getCarForTest(101),
                getCarForTest(100));

        assertTrue(result > 0);
    }

    @Test
    public void testSecondGreater(){
        AutomobilePriceComparator comparator = new AutomobilePriceComparator();
        int result = comparator.compare(getCarForTest(100),
                getCarForTest(101));

        assertTrue(result < 0);
    }

    private Car getCarForTest(double price) {
        return new Car.CarBuilder()
                .setId(45364454L).setBrand("Audi")
                .setModel("A6")
                .setVelocity(300)
                .setPrice(price)
                .setBootVolume(2)
                .setBodywork(Car.Bodywork.SEDAN)
                .build();
    }
}
