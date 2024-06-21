package com.riwi.library.infrastructure.helpers.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.riwi.library.api.dto.request.UserRequest;
import com.riwi.library.api.dto.response.UserResponse;
import com.riwi.library.domain.entities.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "loans", ignore = true)
  @Mapping(target = "reservations", ignore = true)
  User toUserEntity (UserRequest UserRequest);

  @InheritInverseConfiguration
  UserResponse toUserResponse(User user);

  List<UserResponse>  UserListToResponseList (List<User> users);


}
