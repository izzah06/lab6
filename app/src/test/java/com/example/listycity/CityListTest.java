package com.example.listycity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }


    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }


    private CityList cityList;
    private City city1;
    private City city2;

    @BeforeEach
    void setUp() {
        cityList = new CityList();
        city1 = new City("Toronto", "Ontario");
        city2 = new City("Vancouver", "BC");
    }

    @Test
    void testHasCity() {
        cityList.add(city1);
        assertTrue(cityList.hasCity(city1));
        assertFalse(cityList.hasCity(city2));
    }

    @Test
    void testDeleteExistingCity() {
        cityList.add(city1);
        cityList.delete(city1);
        assertFalse(cityList.hasCity(city1));
    }

    @Test
    void testDeleteNonExistingCityThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city2);
        });
        assertEquals("City does not exist in the list", exception.getMessage());
    }

    @Test
    void testCountCities() {
        assertEquals(0, cityList.countCities());
        cityList.add(city1);
        assertEquals(1, cityList.countCities());
        cityList.add(city2);
        assertEquals(2, cityList.countCities());
    }

}