package com.lidiabazhenova;

/**
 * Class that represent user
 *
 * @author lidia
 * @version 1.0
 */
public class Person {

    private String firstName;
    private String lastName;
    private int age;
    public String sex;

    /**
     * Create new object with parameters:
     * @param firstName
     * @param lastName
     * @param age
     * @param sex
     */
    public Person(String firstName, String lastName, int age, String sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    /**
     * Method for getting field value
     * @return users first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Method for getting field value
     * @return users last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method for getting field value
     * @return users age
     */
    public int getAge() {
        return age;
    }

    /**
     * Method for getting field value
     * @return users sex
     */
    public String getSex() {
        return sex;
    }
}
