package com.fcb.springboot.service;

import com.fcb.springboot.dao.UserDao;
import com.fcb.springboot.dto.UserDTO;
import com.fcb.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDTO getUserById(Long id) {
        return UserMapper.MAPPER.poToDto(userDao.getUserById(id));
    }
}
