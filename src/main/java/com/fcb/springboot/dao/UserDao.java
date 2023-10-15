package com.fcb.springboot.dao;

import com.fcb.springboot.pojo.UserPO;

public interface UserDao {

    UserPO getUserById(Long id);
}
