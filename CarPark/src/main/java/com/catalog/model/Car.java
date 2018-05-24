package com.catalog.model;

/**
 * Class that represent car
 *
 * @author lidia
 * @version 1.0
 */
public class Car extends Automobile {

    /**
     * represent a fixed set of bodywork
     */
    public enum Bodywork {
        SEDAN,
        COUPE,
        VAN,
        MINIVAN
    }

    private int bootVolume;
    private Bodywork bodywork;

    /**
     * Create new object with parameters from Builder Class
     *
     * @param carBuilder builder
     * @see CarBuilder
     */
    private Car(CarBuilder carBuilder) {
        super(carBuilder);
        this.bootVolume = carBuilder.bootVolume;
        this.bodywork = carBuilder.bodywork;
    }

    /**
     * Method for getting field value
     *
     * @return bootVolume of car
     */
    public int getBootVolume() {
        return bootVolume;
    }

    /**
     * Method for getting field value
     *
     * @return bodywork of car
     */
    public Bodywork getBodywork() {
        return bodywork;
    }

    @Override
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

    /**
     * Builder Class for objects with properties:
     * <b>id</b>, <b>brand</b>, <b>model</b>, <b>velocity</b>, <b>price</b>,
     * <b>bootVolume</b>, <b>bodywork</b>.
     *
     * @version 1.0
     */
    public static class CarBuilder extends AutomobileBuilder<CarBuilder> {
        private int bootVolume;
        private Bodywork bodywork;

        /**
         * Method for setting bootVolume of car in CarBuilder
         *
         * @param bootVolume car boot volume
         * @return current object
         */
        public CarBuilder setBootVolume(int bootVolume) {
            if ((bootVolume <= 0) || (bootVolume > 50)) {
                throw new IllegalArgumentException("Set correct boot volume");
            }

            this.bootVolume = bootVolume;

            return this;
        }

        /**
         * Method for setting bodywork of car in CarBuilder
         *
         * @param bodywork car bodywork
         * @return current object
         */
        public CarBuilder setBodywork(Bodywork bodywork) {
            this.bodywork = bodywork;

            return this;
        }

        /**
         * Method for finish creating car object in CarBuilder
         *
         * @return new object
         */
        public Car build() {
            validateRequiredFields();

            return new Car(this);
        }

        @Override
        protected void validateRequiredFields() {
            super.validateRequiredFields();
        }
    }
}
