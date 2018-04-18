package com.catalog.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarBuilderTest {

    @Test
    public void testCarBuilder() {
        Car car = new Car.CarBuilder()
                .setId(45364454L)
                .setBrand("Audi")
                .setModel("A6")
                .setVelocity(300)
                .setPrice(12000.0)
                .setBootVolume(2)
                .setBodywork(Car.Bodywork.SEDAN)
                .build();

        assertEquals(45364454L, car.getId());
        assertEquals("Audi", car.getBrand());
        assertEquals("A6", car.getModel());
        assertEquals(300, car.getVelocity());
        assertEquals(12000.0, car.getPrice(), 0.01);
        assertEquals(2, car.getBootVolume());
        assertEquals(Car.Bodywork.SEDAN, car.getBodywork());
    }
}
