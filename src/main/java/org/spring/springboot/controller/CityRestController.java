package org.spring.springboot.controller;

import org.spring.springboot.aop.Tag;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xli on 2017/3/5.
 */

@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;


    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    @Tag
    @ResponseBody
    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName){
        return cityService.findCityByName(cityName);
    }

    @PostMapping(value = "/api/saveCity")
    public void saveCity(@RequestBody City city){
        cityService.saveCity(city);
    }

    @PostMapping(value = "/api/updateCity")
    public void updateCity(@RequestBody City city){
        cityService.updateCity(city);
    }

    @PostMapping(value = "/api/deleteCity")
    public void deleteCity(@RequestParam(value = "id")Long id ){
        cityService.deleteCity(id);
    }



}
