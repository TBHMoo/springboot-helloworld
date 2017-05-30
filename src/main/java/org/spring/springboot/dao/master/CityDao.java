package org.spring.springboot.dao.master;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.City;

import java.util.List;

/**
 * Created by xli on 2017/3/5.
 */
@Mapper
public interface CityDao {
    City findByName(@Param("cityName") String cityName);

    List<City> findAllCity();

    City findById(@Param("id") Long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);
}
