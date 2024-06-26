package com.riwi.library.infrastructure.helpers.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import com.riwi.library.api.dto.request.UserReqToUpdate;
import com.riwi.library.api.dto.request.UserRequest;
import com.riwi.library.api.dto.response.UserRespDetails;
import com.riwi.library.api.dto.response.UserRespWithLoans;
import com.riwi.library.api.dto.response.UserRespWithReservations;
import com.riwi.library.api.dto.response.responseBasic.UserResponse;
import com.riwi.library.domain.entities.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ReservationMapper.class, LoanMapper.class})
public interface UserMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "loans", ignore = true)
  @Mapping(target = "reservations", ignore = true)
  User requestToEntity (UserRequest userRequest);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "loans", ignore = true)
  @Mapping(target = "reservations", ignore = true)
  @Mapping(target = "role", ignore = true)
  User requestToEntityUpdate (UserReqToUpdate userRequest, @MappingTarget User user);

  UserResponse entityToResponse(User user);
  UserRespDetails entityToUserRespDetails(User user);

  List<UserResponse>  userListToResponseList (List<User> users);

  UserRespWithLoans  userListToResponseUserWithLoansList (User users);

  UserRespWithReservations userListToResponseUserWithReservatios (User user);


}
