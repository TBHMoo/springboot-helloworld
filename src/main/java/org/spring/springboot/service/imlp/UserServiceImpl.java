package org.spring.springboot.service.imlp;

import org.spring.springboot.dao.cluster.UserDao;
import org.spring.springboot.dao.master.CityDao;
import org.spring.springboot.domain.City;
import org.spring.springboot.domain.User;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xli on 2017/5/19.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private CityDao cityDao;

    @Override
    public User findByName(String userName) {
        User user = userDao.findByName(userName);
        City city = cityDao.findByName("香港");
        user.setDescription(city.getCityName());
        return user;
    }
}
