package com.example.lab8;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    @Before
    public void createList() {
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void check_addCity() {
        int listSize = list.getCount();
        list.addCity(new City("Edmonton", "AB"));
        int updated = list.getCount();
        assertEquals(listSize + 1, updated);
    }

    @Test
    public void check_hasCity() {
        City newCity = new City("Vancouver", "BC");
        list.addCity(newCity);
        boolean result = list.hasCity(newCity);
        assertEquals(true, result);
    }

    @Test
    public void check_deleteCity() {
        City newCity1 = new City("Toronto", "ON");
        City newCity2 = new City("Vancouver", "BC");
        list.addCity(newCity1);
        list.addCity(newCity2);
        int prevSize = list.getCount();

        list.deleteCity(newCity2);
        int newSize = list.getCount();
        boolean hasCity2 = list.hasCity(newCity2);

        assertEquals(false, hasCity2);
        assertEquals(prevSize - 1, newSize);

    }

}
