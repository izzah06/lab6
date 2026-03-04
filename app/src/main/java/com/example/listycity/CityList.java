package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */

public class CityList {

    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     *
     * @param city
     *      This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }
    /**
     * This returns a sorted list of cities
     *
     * @return
     *      Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        //want to sort the name if cities but trying to sort the city obj - to sort an obj by its properties:
        //make the obj implement the Comparable interface nd override the compareTo() method
        // Lists (and arrays) of objects that implement Comparable interface can be sorted automatically by Collections.sort(),
        //  therefore we also need to implement the compareTo() method.
        return list;
    }
    /**
     * Check if the given city exists in the list
     *
     * @param city the city to check
     * @return true if city exists, false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Delete a city from the list
     *
     * @param city the city to delete
     * @throws IllegalArgumentException if city is not in the list
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City does not exist in the list");
        }
        cities.remove(city);
    }
    /**
     * Count how many cities are in the list
     *
     * @return number of cities
     */
    public int countCities() {
        return cities.size();
    }
}