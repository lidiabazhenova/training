package com.catalog.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TruckBuilderTest {

    @Test
    public void testTruckBuilder() {
        Truck truck = new Truck.TruckBuilder()
                .setId(45364454L).setBrand("Volvo")
                .setModel("FMX")
                .setVelocity(300)
                .setPrice(32000.0)
                .setTrailerBrand("Smitz")
                .setTrailerModel("B1997")
                .setTrailerType(com.catalog.model.Truck.TrailerType.REFRIGARATOR)
                .setCarrying(20)
                .setVolumeOfCargo(92)
                .setLoading(com.catalog.model.Truck.Loading.BACK)
                .build();

        assertEquals(45364454L, truck.getId());
        assertEquals("Volvo", truck.getBrand());
        assertEquals("FMX", truck.getModel());
        assertEquals(300, truck.getVelocity());
        assertEquals(32000.0, truck.getPrice(), 0.01);
        assertEquals("Smitz", truck.getTrailerBrand());
        assertEquals("B1997", truck.getTrailerModel());
        assertEquals(com.catalog.model.Truck.TrailerType.REFRIGARATOR, truck.getTrailerType());
        assertEquals(20, truck.getCarrying());
        assertEquals(92, truck.getVolumeOfCargo());
        assertEquals(com.catalog.model.Truck.Loading.BACK, truck.getLoading());
    }

    @Test(expected = NullPointerException.class)
    public void testTruckValidationId() throws NullPointerException {
        new Truck.TruckBuilder()
                .setBrand("Audi")
                .setModel("A6")
                .setVelocity(300)
                .setPrice(12000.0)
                .build();
    }

    @Test(expected = NullPointerException.class)
    public void testTruckValidationBrand() throws NullPointerException {
        new Truck.TruckBuilder()
                .setId(123456L)
                .setModel("FH-16")
                .setVelocity(300)
                .setPrice(32000.0)
                .build();
    }

    @Test(expected = NullPointerException.class)
    public void testTruckValidationModel() throws NullPointerException {
        new Truck.TruckBuilder()
                .setId(123456L)
                .setBrand("Volvo")
                .setVelocity(300)
                .setPrice(32000.0)
                .build();
    }

    @Test(expected = NullPointerException.class)
    public void testTruckValidationVelocity() throws NullPointerException {
        new Truck.TruckBuilder()
                .setId(123456L)
                .setBrand("Volvo")
                .setModel("FH-16")
                .setPrice(32000.0)
                .build();
    }

    @Test(expected = NullPointerException.class)
    public void testTruckValidationPrice() throws NullPointerException {
        new Truck.TruckBuilder()
                .setId(123456L)
                .setBrand("Volvo")
                .setModel("FH-16")
                .setVelocity(250)
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTruckValidationPriceLower() throws IllegalArgumentException {
        new Truck.TruckBuilder().setPrice(99.0)
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTruckValidationPriceHigher() throws IllegalArgumentException {
        new Truck.TruckBuilder().setPrice(9900000.0)
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTruckValidationVelocityLower() throws IllegalArgumentException {
        new Truck.TruckBuilder().setVelocity(-99)
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTruckValidationVelocityHigher() throws IllegalArgumentException {
        new Truck.TruckBuilder().setVelocity(990)
                .build();
    }
}
