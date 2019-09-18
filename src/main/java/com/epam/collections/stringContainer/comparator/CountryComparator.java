package com.epam.collections.stringContainer.comparator;

import com.epam.collections.stringContainer.country.Country;

import java.util.Comparator;

public class CountryComparator implements Comparator<Country> {

    @Override
    public int compare(Country o1, Country o2) {
        return o1.getCountry().compareTo(o2.getCountry());
    }

}
