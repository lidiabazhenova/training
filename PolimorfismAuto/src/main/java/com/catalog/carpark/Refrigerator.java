package com.catalog.carpark;

public class Refrigerator extends Truck {

    private int lowTemperatureRegime;
    private int highTemperatureRegime;

    public Refrigerator(long id, String brand, String model, int velocity, String trailerBrand, String trailerModel,
                        int carrying, int volumeOfCargo, int lowTemperatureRegime, int highTemperatureRegime) {
        super(id, brand, model, velocity, trailerBrand, trailerModel, carrying, volumeOfCargo);
        this.lowTemperatureRegime = lowTemperatureRegime;
        this.highTemperatureRegime = highTemperatureRegime;
    }

    public String getDescription() {
         final StringBuilder description = new StringBuilder();
         description.append(super.getDescription())
                 .append("\r LowTemperatureRegime: ")
                 .append(lowTemperatureRegime)
                 .append("\n\r HighTemperatureRegime: ")
                 .append(highTemperatureRegime)
                 .append("\n");

         return description.toString();
    }

    public int getLowTemperatureRegime() {
        return lowTemperatureRegime;
    }

    public int getHighTemperatureRegime() {
        return highTemperatureRegime;
    }
}


