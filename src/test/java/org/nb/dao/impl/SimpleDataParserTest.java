package org.nb.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.nb.dao.DataParser;
import org.nb.model.CountryEntity;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleDataParserTest {

    private DataParser dataParser;

    private static final String HEADER_DATA = "CountryCode ISO Alpha2\tCountryName Dutch\tCountryName English";

    @Before
    public void setUp() {
        dataParser = new SimpleDataParser();
    }

    @Test(expected = Exception.class)
    public void shouldFailParseData_whenNoHeaderIsPresent() throws Exception {
        String invalidInputData = "EE, Estland, Estonia";

        dataParser.parseLines(Arrays.asList(invalidInputData));
    }

    @Test(expected = Exception.class)
    public void shouldFailParseData_whenWrongDelimiterUsedInData() throws Exception {
        String invalidInputData = "EE, Estland, Estonia";

        dataParser.parseLines(Arrays.asList(HEADER_DATA, invalidInputData));
    }

    @Test(expected = Exception.class)
    public void shouldFailParseData_whenDataIsNotConsistent() throws Exception {
        String invalidInputData = "EE\tEstland";

        List<CountryEntity> test = dataParser.parseLines(Arrays.asList(HEADER_DATA, invalidInputData));
    }

    @Test
    public void shouldSucceedParseData_ofValidFormat() throws Exception {
        String validInputData = "EE\tEstland\tEstonia";

        List<CountryEntity> result = dataParser.parseLines(Arrays.asList(HEADER_DATA, validInputData));

        assertThat(result).hasSize(1);

        CountryEntity parsedCountry = result.get(0);
        assertThat(parsedCountry.getCountryCodeIsoAlpha2()).isEqualTo("EE");
        assertThat(parsedCountry.getCountryNameDutch()).isEqualTo("Estland");
        assertThat(parsedCountry.getCountryNameEnglish()).isEqualTo("Estonia");
    }
}