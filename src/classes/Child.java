package classes;

import enums.Category;
import enums.Cities;

import java.util.ArrayList;

public abstract class Child {
    private Integer id;
    private String lastName;
    private String firstName;
    private Cities city;
    private Integer age;
    private ArrayList<Category> giftsPreferences = new ArrayList<>();

    /**
     * Returns id
     * @return Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id
     * @param id
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * Returns last name
     * @return Last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name
     * @param lastName
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns first name
     * @return First name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name
     * @param firstName
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the age
     * @return Age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Sets the age
     * @param age
     */
    public void setAge(final Integer age) {
        this.age = age;
    }

    /**
     * Returns the city
     * @return City
     */
    public Cities getCity() {
        return city;
    }

    /**
     * Sets the city
     * @param city
     */
    public void setCity(final Cities city) {
        this.city = city;
    }

    /**
     * Returns all gift preferences
     * @return Gift preferences
     */
    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     * Sets the gift preferences
     * @param giftsPreferences
     */
    public void setGiftsPreferences(final ArrayList<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

}
