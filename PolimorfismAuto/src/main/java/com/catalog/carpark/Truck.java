package com.catalog.carpark;

public abstract class Truck extends Automobile {

    private String trailerBrand;
    private String trailerModel;
    private int carrying;
    private int volumeOfCargo;

    public Truck(long id, String brand, String model, int velocity, String trailerBrand, String trailerModel, int carrying, int volumeOfCargo) {
        //super(id, brand, model, velocity);
        this.trailerBrand = trailerBrand;
        this.trailerModel = trailerModel;
        this.carrying = carrying;
        this.volumeOfCargo = volumeOfCargo;
    }

    @Override
    public String getDescription() {
        final StringBuilder description = new StringBuilder();
        description.append(super.getDescription())
                .append(" \n\r trailerBrand: ")
                .append(trailerBrand)
                .append(" \n\r trailerModel: ")
                .append(trailerModel)
                .append(" \n\r carrying: ")
                .append(carrying)
                .append(" \n\r volumeOfCargo")
                .append(volumeOfCargo)
                .append("\n");

        return description.toString();
    }

    public String getTrailerBrand() {
        return trailerBrand;
    }

    public String getTrailerModel() {
        return trailerModel;
    }

    public int getCarrying() {
        return carrying;
    }

    public int getVolumeOfCargo() {
        return volumeOfCargo;
    }
}
