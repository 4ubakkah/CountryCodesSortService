package org.nb.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.nb.dao.impl.SimpleDataLoader;
import org.nb.dao.impl.SimpleDataParser;
import org.nb.model.CountryEntity;
import org.nb.service.GeneralService;
import org.nb.service.sort.impl.SortServiceImpl;

import java.io.File;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by nikita.biloshytskyi on 12/31/2016.
 */

public class GeneralServiceImplITest {

    private GeneralService service;

    @Before
    public void setUp() {
        service = new GeneralServiceImpl(new SortServiceImpl(), new SimpleDataLoader(), new SimpleDataParser());
    }

    @Test
    public void shouldGetSortedCountriesMap() throws Exception{
        String fileName = "country-codes.csv";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        Map<String, String> result = service.getSortedCountries(file.getAbsolutePath());

        assertThat(result).hasSize(244);

        String[] keys = new String[result.size()];
        result.keySet().toArray(keys);
        assertThat(keys[0]).isEqualTo("AC");
        assertThat(keys[243]).isEqualTo("ZW");
    }
}
