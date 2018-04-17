package com.catalog.model;

/**
 * Abstract class for objects with properties:
 * <b>id</b>, <b>brand</b>, <b>model</b>, <b>velocity</b>, <b>price</b>.
 *
 * @author lidia
 * @version 1.0
 */
public abstract class Automobile {
    private long id;
    private String brand;
    private String model;
    private int velocity;
    private double price;

    /**
     * Method for getting field value
     *
     * @return identification number
     */
    public long getId() {
        return id;
    }

    /**
     * Method for getting field value
     *
     * @return brand name
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Method for getting field value
     *
     * @return automobile model
     */
    public String getModel() {
        return model;
    }

    /**
     * Method for getting field value
     *
     * @return automobile velocity
     */
    public int getVelocity() {
        return velocity;
    }

    /**
     * Method for getting field value
     *
     * @return automobile price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Create new object with parameters from Builder Class
     *
     * @param automobileBuilder builder
     * @see AutomobileBuilder
     * @see #Automobile()
     */
    public Automobile(AutomobileBuilder automobileBuilder) {
        this.id = automobileBuilder.id;
        this.brand = automobileBuilder.brand;
        this.model = automobileBuilder.model;
        this.velocity = automobileBuilder.velocity;
        this.price = automobileBuilder.price;
    }

    /**
     * Create new empty object
     */
    public Automobile() {
    }

    /**
     * Method for getting description of automobile
     *
     * @return String description
     */
    public String getDescription() {
        final StringBuilder description = new StringBuilder();
        description.append("\r Id: ").append(id)
                .append("\n\r Brand: ")
                .append(brand)
                .append("\n\r Model: ")
                .append(model)
                .append("\n\r Velocity: ")
                .append(velocity)
                .append("\n\r Price: ")
                .append(price);

        return description.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Automobile that = (Automobile) o;

        return id == that.id;
    }

    /**
     * Abstract Builder Class for objects with properties:
     * <b>id</b>, <b>brand</b>, <b>model</b>, <b>velocity</b>, <b>price</b>.
     *
     * @version 1.0
     */
    public static abstract class AutomobileBuilder<T extends AutomobileBuilder> {
        private Long id;
        private String brand;
        private String model;
        private Integer velocity;
        private Double price;

        /**
         * Method for setting id of automobile in AutomobileBuilder
         *
         * @param id automobile identifier
         * @return current object
         */
        public T setId(Long id) {
            this.id = id;

            return (T) this;
        }

        /**
         * Method for setting brand of automobile in AutomobileBuilder
         *
         * @param brand brand name
         * @return current object
         */
        public T setBrand(String brand) {
            this.brand = brand;

            return (T) this;
        }

        /**
         * Method for setting model of automobile in AutomobileBuilder
         *
         * @param model automobile model
         * @return current object
         */
        public T setModel(String model) {
            this.model = model;

            return (T) this;
        }

        /**
         * Method for setting velocity of automobile in AutomobileBuilder
         *
         * @param velocity automobile velocity
         * @return current object
         */
        public T setVelocity(Integer velocity) {
            if (velocity < 0 || velocity > 400) {
                throw new IllegalArgumentException("Please, enter correct velocity");
            }

            this.velocity = velocity;

            return (T) this;
        }

        /**
         * Method for setting price of automobile in AutomobileBuilder
         *
         * @param price price of automobile
         * @return current object
         */
        public T setPrice(Double price) {
            if (price < 100 || price > 500000) {
                throw new IllegalArgumentException("Please, enter correct price");
            }

            this.price = price;

            return (T) this;
        }

        /**
         * Method for validation values of automobile in AutomobileBuilder
         */
        protected void validateRequiredFields() {
            if (id == null) {
                throw new NullPointerException("Please, enter id");
            }

            if (brand == null) {
                throw new NullPointerException("Please, enter brand");
            }

            if (model == null) {
                throw new NullPointerException("Please, enter model");
            }

            if (velocity == null) {
                throw new NullPointerException("Please, enter velocity");
            }
        }

    }
}
