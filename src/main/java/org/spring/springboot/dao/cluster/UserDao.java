package org.spring.springboot.dao.cluster;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.User;

/**
 * Created by xli on 2017/5/19.
 */
@Mapper
public interface UserDao {
    User findByName(@Param("userName") String userName);
}
