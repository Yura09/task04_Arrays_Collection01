package com.epam.collections.stringContainer.country;

import java.util.Objects;

public class Country {
    private String country;
    private String capital;

    public Country(String country, String capital) {
        if (country.equals("") ||
                capital.equals("")) {
            throw new NullPointerException();
        }
        this.country = country;
        this.capital = capital;
    }

    public String getCountry() {
        return country;
    }

    public String getCapital() {
        return capital;
    }


   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country1 = (Country) o;
        return country.equals(country1.country) &&
                capital.equals(country1.capital);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, capital);
    }
*/
    @Override
    public String toString() {
        return "Country{" +
                "country='" + country + '\'' +
                ", capital='" + capital + '\'' +
                '}';
    }

}

