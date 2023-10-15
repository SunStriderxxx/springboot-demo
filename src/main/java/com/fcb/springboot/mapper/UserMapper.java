package com.fcb.springboot.mapper;

import com.fcb.springboot.dto.UserDTO;
import com.fcb.springboot.pojo.UserPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    UserDTO poToDto(UserPO userPO);
}
