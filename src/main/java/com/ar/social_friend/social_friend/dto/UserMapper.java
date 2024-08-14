package com.ar.social_friend.social_friend.dto;

import com.ar.social_friend.social_friend.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "username", target = "username")
    User userSearchDtoToUser(UserSearchDTO userSearchDTO);

    UserSearchDTO userToUserSearchDTO(User user);
}
