package com.catalog.product;

public class MobilePhone extends Product {

    private static final String DEFAULT_IMAGE = "mobile phone default image";

    private int coreNumber;
    private int memory;
    private int weight;

    private MobilePhone() {
    }

    private MobilePhone(long id, String title, String description, double price, double quantity, int coreNumber, int memory, int weight,
                        String image) {
        super(id, title, description, price, quantity, image);
        this.coreNumber = coreNumber;
        this.memory = memory;
        this.weight = weight;
    }

    public String getDetails() {
        return super.getDetails()
                + "Core number: " + coreNumber + "\r\n "
                + "Memory: " + memory + "\r\n "
                + "Weight: " + weight + "\r\n ";
    }

    public int getCoreNumber() {
        return coreNumber;
    }

    public void setCoreNumber(int coreNumber) {
        this.coreNumber = coreNumber;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public static String getDefaultImage() {
        return DEFAULT_IMAGE;
    }

    public static MobilePhone createItem() {
        return new MobilePhone();
    }

    public static MobilePhone createItem(long id, String title, String description, double price, double quantity, int coreNumber, int memory, int weight,
                                         String image) {
        return new MobilePhone(id, title, description, price, quantity, coreNumber, memory, weight, image);
    }

}

