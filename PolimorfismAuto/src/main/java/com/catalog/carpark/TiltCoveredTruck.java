package com.catalog.carpark;

public class TiltCoveredTruck extends Truck {

    private boolean sideLoading;
    private boolean topLoading;

    public TiltCoveredTruck(long id, String brand, String model, int velocity, String trailerBrand, String trailerModel,
                            int carrying, int volumeOfCargo, boolean sideLoading, boolean topLoading) {
        super(id, brand, model, velocity, trailerBrand, trailerModel, carrying, volumeOfCargo);
        this.sideLoading = sideLoading;
        this.topLoading = topLoading;
    }

    public String getDescription() {
        final StringBuilder description = new StringBuilder();
        description.append(super.getDescription())
                .append("\r SideLoading: ")
                .append(sideLoading)
                .append("\r\n TopLoading: ")
                .append(topLoading)
                .append("\n");

        return description.toString();
    }

    public boolean isSideLoading() {
        return sideLoading;
    }

    public boolean isTopLoading() {
        return topLoading;
    }
}
