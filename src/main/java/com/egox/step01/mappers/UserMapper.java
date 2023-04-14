package com.egox.step01.mappers;

import com.egox.step01.dtos.UserMsDto;
import com.egox.step01.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    //User to UserMmDto
    @Mapping(source = "curp", target = "emailAdr")
    UserMsDto userToUserDto(User user);

    //List<User> to List<UserDto>
    List<UserMsDto> usersToUsersDto(List<User> users);
}
