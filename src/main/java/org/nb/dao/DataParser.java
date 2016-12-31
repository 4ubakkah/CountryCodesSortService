package org.nb.dao;

import org.nb.model.CountryEntity;

import java.util.List;

/**
 * Created by nikita.biloshytskyi on 12/31/2016.
 */
public interface DataParser {

    /**
     * Returns list of parsed CountryEntity in domain presentation.
     * @param @List<String> line, list of countries metadata in string presentation.
     * @return List<@CountryEntity>
     */
    List<CountryEntity> parseLines(List<String> line);
}
