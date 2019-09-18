package com.epam.collections.stringContainer;

import com.epam.collections.stringContainer.comparator.CapitalComparator;
import com.epam.collections.stringContainer.comparator.CountryComparator;
import com.epam.collections.stringContainer.country.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ContainerExample {
    private static Logger logger = LogManager.getLogger(ContainerExample.class);

    public static void main(String[] args) {
        StringContainer container = new StringContainer(500);
        List<String> countryList = new ArrayList<>(500);
        compareAdding(container, countryList);
        compareGetting(container, countryList);
        List<Country> countries = generateCountry();

        Comparator<Country> countryComparator = new CountryComparator();
        countries.sort(countryComparator);
        System.out.println("\nsorted by country\n");
        countries.stream()
                .sorted(countryComparator)
                .forEach(System.out::println);

        List<Country> capitals = generateCountry();
        Comparator<Country> capitalComparator = new CapitalComparator();
        System.out.println("\nsorted by capital\n");
        capitals.stream()
                .sorted(capitalComparator)
                .forEach(System.out::println);
        System.out.println(Collections.binarySearch(capitals, new Country("Spain", "Madrid"), capitalComparator));
    }

    public static ArrayList<Country> generateCountry() {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country("Ukraine", "Kyiv"));
        countries.add(new Country("Great Britian", "London"));
        countries.add(new Country("Spain", "Madrid"));
        countries.add(new Country("Italy", "Rome"));
        return countries;
    }

    private static void compareAdding(StringContainer container, List<String> list) {
        long start, end;
        start = System.nanoTime();
        for (int i = 0; i < 500; i++) {
            container.add(String.valueOf(i));
        }
        end = System.nanoTime();
        logger.info("The time of adding 500 elements in string container: " + (end - start) + "ns");

        start = System.nanoTime();
        for (int i = 0; i < 500; i++) {
            list.add(String.valueOf(i));
        }
        end = System.nanoTime();
        logger.info("The time of adding 500 elements in ArrayList: " + (end - start) + "ns");
    }

    private static void compareGetting(StringContainer container, List<String> list) {
        long start, end;
        start = System.nanoTime();
        for (int i = 0; i < 500; i++) {
            container.get(i);
        }
        end = System.nanoTime();
        logger.info("The time of getting 500 elements in string container: " + (end - start) + "ns");

        start = System.nanoTime();
        for (int i = 0; i < 500; i++) {
            list.get(i);
        }
        end = System.nanoTime();
        logger.info("The time of getting 500 elements in ArrayList: " + (end - start) + "ns");

    }
}
