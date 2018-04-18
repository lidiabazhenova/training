package com.catalog.model;

/**
 * Class that represent truck
 *
 * @author lidia
 * @version 1.0
 */
public class Truck extends Automobile {

    /**
     * represent a fixed set of trailer type
     */
    public enum TrailerType {
        REFRIGARATOR,
        TILTCOVEREDTRUCK
    }

    /**
     * represent a fixed set of loading
     */
    public enum Loading {
        SIDE,
        TOP,
        BACK
    }

    private String trailerBrand;
    private String trailerModel;
    private int carrying;
    private int volumeOfCargo;
    private TrailerType trailerType;
    private Loading loading;

    /**
     * Method for getting field value
     *
     * @return trailerModel of truck
     */
    public String getTrailerModel() {
        return trailerModel;
    }

    /**
     * Method for getting field value
     *
     * @return trailerBrand of truck
     */
    public String getTrailerBrand() {
        return trailerBrand;
    }

    /**
     * Method for getting field value
     *
     * @return carrying of truck
     */
    public int getCarrying() {
        return carrying;
    }

    /**
     * Method for getting field value
     *
     * @return volumeOfCargo of truck
     */
    public int getVolumeOfCargo() {
        return volumeOfCargo;
    }

    /**
     * Method for getting field value
     *
     * @return trailerType of truck
     */
    public TrailerType getTrailerType() {
        return trailerType;
    }

    /**
     * Method for getting field value
     *
     * @return loading of truck
     */
    public Loading getLoading() {
        return loading;
    }

    /**
     * Create new object with parameters from Builder Class
     *
     * @param truckBuilder builder
     * @see TruckBuilder
     */
    public Truck(TruckBuilder truckBuilder) {
        super(truckBuilder);
        this.trailerBrand = truckBuilder.trailerBrand;
        this.trailerModel = truckBuilder.trailerModel;
        this.carrying = truckBuilder.carrying;
        this.volumeOfCargo = truckBuilder.volumeOfCargo;
        this.trailerType = truckBuilder.trailerType;
        this.loading = truckBuilder.loading;
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
                .append(" \n\r volumeOfCargo: ")
                .append(volumeOfCargo)
                .append(" \n\r trailerType: ")
                .append(trailerType)
                .append(" \n\r loading: ")
                .append(loading)
                .append("\n");

        return description.toString();
    }

    /**
     * Builder Class for objects with properties:
     * <b>id</b>, <b>brand</b>, <b>model</b>, <b>velocity</b>, <b>price</b>,
     * <b>trailerBrand</b>, <b>trailerModel</b>, <b>carrying</b>,
     * <b>volumeOfCargo</b>, <b>trailerType</b>, <b>loading</b>.
     *
     * @version 1.0
     */
    public static class TruckBuilder extends AutomobileBuilder<TruckBuilder> {
        private String trailerBrand;
        private String trailerModel;
        private int carrying;
        private int volumeOfCargo;
        private TrailerType trailerType;
        private Loading loading;

        /**
         * Method for setting trailerBrand of truck in TruckBuilder
         *
         * @param trailerBrand trailer brand
         * @return current object
         */
        public TruckBuilder setTrailerBrand(String trailerBrand) {
            this.trailerBrand = trailerBrand;

            return this;
        }

        /**
         * Method for setting trailerModel of truck in TruckBuilder
         *
         * @param trailerModel trailer model
         * @return current object
         */
        public TruckBuilder setTrailerModel(String trailerModel) {
            this.trailerModel = trailerModel;

            return this;
        }

        /**
         * Method for setting carrying of truck in TruckBuilder
         *
         * @param carrying truck carrying
         * @return current object
         */
        public TruckBuilder setCarrying(int carrying) {
            if ((carrying < 3) || (carrying > 100)) {
                throw new IllegalArgumentException("Set correct carrying");
            }

            this.carrying = carrying;

            return this;
        }

        /**
         * Method for setting volumeOfCargo of truck in TruckBuilder
         *
         * @param volumeOfCargo volume of cargo
         * @return current object
         */
        public TruckBuilder setVolumeOfCargo(int volumeOfCargo) {
            if ((volumeOfCargo < 10) || (volumeOfCargo > 120)) {
                throw new IllegalArgumentException("Set correct volumeOfCargo");
            }

            this.volumeOfCargo = volumeOfCargo;

            return this;
        }

        /**
         * Method for setting trailerType of truck in TruckBuilder
         *
         * @param trailerType trailer type
         * @return current object
         */
        public TruckBuilder setTrailerType(TrailerType trailerType) {
            this.trailerType = trailerType;

            return this;
        }

        /**
         * Method for setting loading of truck in TruckBuilder
         *
         * @param loading trailer loading
         * @return current object
         */
        public TruckBuilder setLoading(Loading loading) {
            this.loading = loading;

            return this;
        }

        /**
         * Method for finish creating truck object in TruckBuilder
         *
         * @return new object
         */
        public Truck build() {
            validateRequiredFields();

            return new Truck(this);
        }

        @Override
        protected void validateRequiredFields() {
            super.validateRequiredFields();
        }
    }
}
