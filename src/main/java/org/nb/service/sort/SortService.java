package org.nb.service.sort;

import org.nb.model.CountryEntity;

import java.util.Map;
import java.util.Set;

/**
 * Created by nikita.biloshytskyi on 12/31/2016.
 */
public interface SortService {

    Map<String, String> sortAscendingByDutchName(Set<CountryEntity> countries);
}
