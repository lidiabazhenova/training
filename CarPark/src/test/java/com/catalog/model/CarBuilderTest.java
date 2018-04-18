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

    @Test(expected = NullPointerException.class)
    public void testCarValidationId() throws NullPointerException {
        new Car.CarBuilder()
                .setBrand("Audi")
                .setModel("A6")
                .setVelocity(300)
                .setPrice(12000.0)
                .build();
    }

    @Test(expected = NullPointerException.class)
    public void testCarValidationBrand() throws NullPointerException {
        new Car.CarBuilder()
                .setId(123456L)
                .setModel("A6")
                .setVelocity(300)
                .setPrice(12000.0)
                .build();
    }

    @Test(expected = NullPointerException.class)
    public void testCarValidationModel() throws NullPointerException {
        new Car.CarBuilder()
                .setId(123456L)
                .setBrand("Audi")
                .setVelocity(300)
                .setPrice(12000.0)
                .build();
    }

    @Test(expected = NullPointerException.class)
    public void testCarValidationVelocity() throws NullPointerException {
        new Car.CarBuilder()
                .setId(123456L)
                .setBrand("Audi")
                .setModel("A6")
                .setPrice(12000.0)
                .build();
    }

    @Test(expected = NullPointerException.class)
    public void testCarValidationPriceNotNull() throws NullPointerException {
        new Car.CarBuilder()
                .setId(123456L)
                .setBrand("Audi")
                .setModel("A6")
                .setVelocity(250)
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCarValidationPriceLower() throws IllegalArgumentException {
        new Car.CarBuilder().setPrice(99.0)
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCarValidationPriceHigher() throws IllegalArgumentException {
        new Car.CarBuilder().setPrice(9900000.0)
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCarValidationVelocityLower() throws IllegalArgumentException {
        new Car.CarBuilder().setVelocity(-99)
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCarValidationVelocityHigher() throws IllegalArgumentException {
        new Car.CarBuilder().setVelocity(990)
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCarValidationBootVolumeLower() throws IllegalArgumentException {
        new Car.CarBuilder().setBootVolume(-90)
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCarValidationsBootVolumeHigher() throws IllegalArgumentException {
        new Car.CarBuilder().setBootVolume(990)
                .build();
    }
}
