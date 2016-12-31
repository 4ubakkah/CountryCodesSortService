package org.nb.service.sort.impl;

import org.nb.service.sort.SortService;
import org.nb.model.CountryEntity;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by nikita.biloshytskyi on 12/31/2016.
 */
public class SortServiceImpl implements SortService {

    public Map<String, String> sortAscendingByDutchName(Set<CountryEntity> countries) {

        Map<String, String> sortedCountries = new TreeMap<String, String>();

        countries.stream().forEach(country -> sortedCountries.put(country.getCountryCodeIsoAlpha2(), country.getCountryNameDutch()));

        return sortedCountries;
    }
}
