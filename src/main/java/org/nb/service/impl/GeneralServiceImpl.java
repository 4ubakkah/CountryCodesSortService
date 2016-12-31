package org.nb.service.impl;

import org.nb.dao.DataLoader;
import org.nb.dao.DataParser;
import org.nb.model.CountryEntity;
import org.nb.model.exception.ParseException;
import org.nb.service.GeneralService;
import org.nb.service.sort.SortService;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Created by nikita.biloshytskyi on 12/31/2016.
 */
public class GeneralServiceImpl implements GeneralService {

    public GeneralServiceImpl(SortService sortService, DataLoader dataLoader, DataParser dataParser) {
        this.sortService = sortService;
        this.dataLoader = dataLoader;
        this.dataParser = dataParser;
    }

    private SortService sortService;

    private DataLoader dataLoader;

    private DataParser dataParser;

    @Override
    public Map<String, String> getSortedCountries(String filePath) {
        Map<String, String> result = null;
        try {
            List<String> dataLines = dataLoader.loadData(filePath);
            List<CountryEntity> countries = dataParser.parseLines(dataLines);
            result = sortService.sortAscendingByDutchName(new HashSet<>(countries));
        } catch (FileNotFoundException ex) {
            System.out.println("File is not found.");
        } catch (ParseException ex) {
            System.out.println("Could not parse input testdata.");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return result;
    }
}
