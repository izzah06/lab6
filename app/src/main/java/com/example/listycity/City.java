package com.example.listycity;

/**
 * This is a class that defines a City with a name and province.
 */
public class City implements Comparable<City> {

    private String city;
    private String province;

    /**
     * Constructor to create a new City object.
     *
     * @param city     the name of the city
     * @param province the province the city belongs to
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Get the name of the city.
     *
     * @return the city name
     */
    String getCityName() {
        return this.city;
    }

    /**
     * Get the name of the province.
     *
     * @return the province name
     */
    String getProvinceName() {
        return this.province;
    }

    /**
     * Compare this City to another City for sorting.
     * Cities are compared lexicographically by their name.
     *
     * @param other the other City to compare with
     * @return a negative integer, zero, or a positive integer
     *         as this city is less than, equal to, or greater than the other city
     */
    @Override
    public int compareTo(City other) {
        return this.city.compareTo(other.getCityName());
    }

    /**
     * Checks if this City is equal to another object.
     * Two cities are considered equal if their name and province are equal.
     *
     * @param obj the object to compare with
     * @return true if the cities are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        City other = (City) obj;
        return city.equals(other.city) && province.equals(other.province);
    }

    /**
     * Returns a hash code value for the City object.
     * Ensures consistency with equals().
     *
     * @return hash code of the city
     */
    @Override
    public int hashCode() {
        return city.hashCode() * 31 + province.hashCode();
    }
}