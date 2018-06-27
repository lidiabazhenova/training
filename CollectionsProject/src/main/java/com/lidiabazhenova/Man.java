package com.lidiabazhenova;

/**
 * Class that represent user
 *
 * @author lidia
 * @version 1.0
 */
public class Man {

    private long id;
    private String name;
    private int age;
    public String sex;

    /**
     * Create new object with parameters:
     * @param id
     * @param name
     * @param age
     * @param sex
     */
    public Man(long id, String name, int age, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    /**
     * Method for getting field value
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * Method for getting field value
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method for getting field value
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Method for getting field value
     * @return sex
     */
    public String getSex() {
        return sex;
    }
}
