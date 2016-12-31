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
import org.nb.service.impl.GeneralServiceImpl;
import org.nb.service.sort.SortService;
import org.nb.service.sort.impl.SortServiceImpl;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by nikita.biloshytskyi on 12/31/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class GeneralServiceImplTest {

    @InjectMocks
    private GeneralServiceImpl service;

    @Mock
    private SortServiceImpl sortService;

    @Mock
    private SimpleDataLoader dataLoader;

    @Mock
    private SimpleDataParser dataParser;

    @Before
    public void setUp() {
        service = new GeneralServiceImpl(sortService, dataLoader, dataParser);
    }

    @Test
    public void shouldDelegateActivitiesToServices() throws Exception{
        String dummyFilePath = "DUMMY_PATH";
        List<String> retrievedLines = new ArrayList<>();
        List<CountryEntity> parsedCountries = new ArrayList<>();
        Set<CountryEntity> parsedCountriesWithoutDuplicates = new HashSet<>();
        Map<String, String> sortedCountriesMap = new TreeMap<>();

        Mockito.when(dataLoader.loadData(dummyFilePath)).thenReturn(retrievedLines);
        Mockito.when(dataParser.parseLines(retrievedLines)).thenReturn(parsedCountries);
        Mockito.when(sortService.sortAscendingByDutchName(Mockito.anySetOf(CountryEntity.class))).thenReturn(sortedCountriesMap);

        Map<String, String> result = service.getSortedCountries(dummyFilePath);

        Mockito.verify(dataLoader).loadData(dummyFilePath);
        Mockito.verify(dataParser).parseLines(retrievedLines);
        Mockito.verify(sortService).sortAscendingByDutchName(parsedCountriesWithoutDuplicates);

        assertThat(result).isEqualTo(sortedCountriesMap);
    }
}
