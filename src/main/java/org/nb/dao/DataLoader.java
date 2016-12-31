package org.nb.dao;

import org.nb.model.CountryEntity;

import java.io.IOException;
import java.util.List;

/**
 * Created by nikita.biloshytskyi on 12/31/2016.
 */
public interface DataLoader {
    /**
     * Loads CountryEntity list from provided file.
     * @param filePath, path to file containing list of country entities.
     * @return List<@String> list of country entities in  presentation.
     */
    List<String> loadData(String filePath) throws IOException;
}
