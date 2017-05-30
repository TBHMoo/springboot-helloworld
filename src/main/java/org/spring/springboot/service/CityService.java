package org.spring.springboot.service;

import org.spring.springboot.domain.City;

/**
 * Created by xli on 2017/3/5.
 */
public interface CityService {
    City findCityByName(String cityName);

    Long saveCity(City city);

    City findCityById(Long id);

    Long updateCity(City city);

    Long deleteCity(Long id);

}
