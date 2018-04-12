package com.catalog.carpark;

public class Car extends Automobile {

    public enum Bodywork {
        SEDAN,
        COUPE;
    }

    //optional parameters
    private int bootVolume;
    private Bodywork bodywork;

    public int getBootVolume() {
        return bootVolume;
    }

    public Bodywork getBodywork() {
        return bodywork;
    }

    public Car(CarBuilder carBuilder) {
        super(carBuilder);
        this.bootVolume = carBuilder.bootVolume;
        this.bodywork = carBuilder.bodywork;
    }


    public String getDescription() {
        final StringBuilder description = new StringBuilder();
        description.append(super.getDescription())
                .append("\n\r bootVolume: ")
                .append(bootVolume)
                .append("\n\r bodywork: ")
                .append(bodywork)
                .append("\n");

        return description.toString();
    }

    //Builder Class
    public static class CarBuilder extends AutomobileBuilder<CarBuilder> {

        // optional parameters
        private Integer bootVolume;
        private Bodywork bodywork;

        public CarBuilder setBootVolume(Integer bootVolume) {
            if(bootVolume == 0 || bootVolume >50){
                throw  new IllegalArgumentException("Set correct boot volume");
            }
            this.bootVolume = bootVolume;

            return this;
        }

        public CarBuilder setBodywork(Bodywork bodywork) {
            this.bodywork = bodywork;
            return this;
        }

        public Car build() {
            validateRequiredFields();
            return new Car(this);
        }

        protected void validateRequiredFields() {
            super.validateRequiredFields();
        }
    }
}
