package org.nb.dao.impl;

import org.nb.dao.DataParser;
import org.nb.model.CountryEntity;
import org.nb.model.exception.ParseException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class SimpleDataParser implements DataParser {

    private static final String DELIMITER = "\t";
    private static final int HEADER_LINES_COUNT = 1;
    private static final String INVALID_DATA_FORMAT_MESSAGE = "Invalid data format is provided.";

    @Override
    public List<CountryEntity> parseLines(List<String> line) {
        try {
            if(line.size() <= 1) {
                throw new Exception(INVALID_DATA_FORMAT_MESSAGE);
            }
            return line.stream().skip(HEADER_LINES_COUNT).map(l -> parseLine(l)).collect(Collectors.toList());
        } catch (Exception ex) {
            throw new ParseException(ex.getMessage(), ex);
        }
    }

    private CountryEntity parseLine(String line) {
        String[] metadata = line.split(DELIMITER);

        return new CountryEntity(metadata[0], metadata[1], metadata[2]);
    }
}
