package com.catalog.comparator;

import com.catalog.model.Car;
import org.junit.Assert;
import org.junit.Test;

public class AutomobileVelocityComparatorTest {

    @Test
    public void testEqualsSpeed() {
        AutomobileVelocityComparator comparator =
                new AutomobileVelocityComparator();
        int result = comparator.compare(getCarForTest(230),
                getCarForTest(230));

        Assert.assertTrue(result == 0);
    }

    @Test
    public void testFirstMoreSpeed() {
        AutomobileVelocityComparator comparator =
                new AutomobileVelocityComparator();
        int result = comparator.compare(getCarForTest(230),
                getCarForTest(200));

        Assert.assertTrue(result > 0);
    }

    @Test
    public void testSecondMoreSpeed() {
        AutomobileVelocityComparator comparator =
                new AutomobileVelocityComparator();
        int result = comparator.compare(getCarForTest(230),
                getCarForTest(240));

        Assert.assertTrue(result < 0);
    }

    private Car getCarForTest(int velocity) {
        return new Car.CarBuilder()
                .setId(45364454L).setBrand("Audi")
                .setModel("A6")
                .setVelocity(velocity)
                .setPrice(12000.0)
                .setBootVolume(2)
                .setBodywork(Car.Bodywork.SEDAN)
                .build();
    }

}
