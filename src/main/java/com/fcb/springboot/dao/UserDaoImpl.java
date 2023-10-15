package com.fcb.springboot.dao;

import com.fcb.springboot.pojo.UserPO;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public UserPO getUserById(Long id) {
        return UserPO.builder().id(id).name("编号" + id).age(18).build();
    }
}
