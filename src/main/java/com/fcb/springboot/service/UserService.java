package com.fcb.springboot.service;

import com.fcb.springboot.dto.UserDTO;

public interface UserService {

    UserDTO getUserById(Long id);
}
