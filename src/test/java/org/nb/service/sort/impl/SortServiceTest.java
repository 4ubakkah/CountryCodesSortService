package org.nb.service.sort.impl;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.nb.model.CountryEntity;
import org.nb.service.sort.SortService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by nikita.biloshytskyi on 12/31/2016.
 */
@RunWith(JUnit4.class)
public class SortServiceTest {

    private SortService service;

    @Before
    public void setUp() {
        service = new SortServiceImpl();
    }

    @Test
    public void shouldSortAscendingByDutchName() {
        CountryEntity dummyCountry1 = new CountryEntity("UA", "Ukraina", "Ukraine");
        CountryEntity dummyCountry2 = new CountryEntity("RU", "Rusland", "Russia");
        CountryEntity dummyCountry3 = new CountryEntity("EE", "Estland", "Estonia");

        Set<CountryEntity> countries = new HashSet<>(
                Arrays.asList(dummyCountry1, dummyCountry2, dummyCountry3, dummyCountry1));

        Map<String, String> sortedCountriesMap = service.sortAscendingByDutchName(countries);

        assertThat(sortedCountriesMap).hasSize(countries.size());
        assertThat(sortedCountriesMap.keySet()).contains("EE", "RU", "UA");
    }

}