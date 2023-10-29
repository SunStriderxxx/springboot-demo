package com.fcb.springboot.dao;

import com.fcb.springboot.dao.pojo.UserPO;

public interface UserDao {

    UserPO getUserById(Long id);
}
