package com.fcb.springboot.service;

import com.fcb.springboot.service.dto.UserDTO;

public interface UserService {

    UserDTO getUserById(Long id);
}
