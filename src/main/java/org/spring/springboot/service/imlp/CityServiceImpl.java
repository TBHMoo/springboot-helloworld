package org.spring.springboot.service.imlp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.dao.master.CityDao;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by xli on 2017/3/5.
 */
@Service
public class CityServiceImpl implements CityService{

    private static final Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private CityDao cityDao;

    /*
    * 获取尘世的缓存逻辑
    *  如果缓存存在，取缓存返回
    *  如果缓存不存在，查DB，有结果的话，存缓存并返回。
    *
    * */

    @Override
    public City findCityByName(String cityName) {
        String key = "city_" + cityName;
        ValueOperations<String ,City> operations = redisTemplate.opsForValue();

        //缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey){
            City city = operations.get(key);

            logger.info("CityServiceImpl.findCityByName() : 从缓存中获取了城市 >>" +city.getCityName());
            return city;
        }

        //从DB中拿到数据
        City city = cityDao.findByName(cityName);

        //插入缓存
        operations.set(key,city,10, TimeUnit.MINUTES);
        logger.info("\nCityServiceImpl.findCityByName() : 城市插入缓存 >>" +city.getCityName());
        return city;
    }

    @Override
    public Long saveCity(City city) {
        return cityDao.saveCity(city);
    }

    @Override
    public City findCityById(Long id) {
        return cityDao.findById(id);
    }

    @Override
    public Long updateCity(City city) {

        Long id = cityDao.updateCity(city);

        //缓存存在，删除缓存
        String key = "city_"+city.getCityName();
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey){
            redisTemplate.delete(key);
            logger.info("CityServiceImpl.findCityByName() : 从缓存中删除 >>" +city.getCityName());
        }
        return id;

    }

    @Override
    public Long deleteCity(Long id) {
        City byId = cityDao.findById(id);
        String key = "city_"+byId.getCityName();
        Long ret =cityDao.deleteCity(id);

        //缓存存在，删除缓存
       // String key = "city_"+byId.getCityName();
        System.out.println("city : " + id);
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey){
            redisTemplate.delete(key);
            logger.info("CityServiceImpl.findCityByName() : 从缓存中删除 >>" +byId.getCityName());
        }
        return ret;
    }
}
