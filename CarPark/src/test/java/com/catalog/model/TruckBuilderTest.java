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
                //.setVolumeOfCargo(92)
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
       // assertEquals(92, truck.getVolumeOfCargo());
        assertEquals(com.catalog.model.Truck.Loading.BACK, truck.getLoading());


    }
}
