package org.spring.springboot.dao;


import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.City;

/**
 * Created by xli on 2017/3/5.
 */
public interface CityDao {

    City findByName(@Param("cityName") String cityName);
}
