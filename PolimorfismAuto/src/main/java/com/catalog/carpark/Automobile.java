package com.catalog.carpark;

public abstract class Automobile {

    // optional parameters
    private long id;
    private String brand;
    private String model;
    private Integer velocity;
    private double price;



    public long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getVelocity() {
        return velocity;
    }

    public double getPrice() {
        return price;
    }

    public Automobile(AutomobileBuilder automobileBuilder) {
        this.id = automobileBuilder.id;
        this.brand = automobileBuilder.brand;
        this.model = automobileBuilder.model;
        this.velocity = automobileBuilder.velocity;
        this.price = automobileBuilder.price;
    }

    public Automobile() {
    }

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Automobile that = (Automobile) o;

        return id == that.id;
    }

    //Builder Class
    public static abstract class AutomobileBuilder<T extends AutomobileBuilder> {

        // optional parameters
        private Long id;
        private String brand;
        private String model;
        private Integer velocity;
        private Double price;

        public T setId(Long id) {
            this.id = id;

            return (T) this;
        }

        public T setBrand(String brand) {
            this.brand = brand;

            return (T) this;
        }

        public T setModel(String model) {
            this.model = model;

            return (T) this;
        }

        public T setVelocity(Integer velocity) {
            if (velocity < 0 || velocity > 400) {
                throw new IllegalArgumentException("Please, enter correct velocity");
            }
            this.velocity = velocity;

            return (T) this;
        }

        public T setPrice(Double price) {
            if (price < 100 || price > 500000) {
                throw new IllegalArgumentException("Please, enter correct price");
            }
            this.price = price;

            return (T) this;
        }

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
