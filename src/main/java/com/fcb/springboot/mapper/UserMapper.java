package com.fcb.springboot.mapper;

import com.fcb.springboot.service.dto.UserDTO;
import com.fcb.springboot.dao.pojo.UserPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    UserDTO poToDto(UserPO userPO);
}
