package org.spring.springboot.service;

import org.spring.springboot.domain.User;

/**
 * Created by xli on 2017/5/19.
 */
public interface UserService {
    User findByName(String userName);
}
