package com.riwi.library.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.library.api.dto.request.UserReqToUpdate;
import com.riwi.library.api.dto.request.UserRequest;
import com.riwi.library.api.dto.response.UserRespDetails;
import com.riwi.library.api.dto.response.UserRespWithLoans;
import com.riwi.library.api.dto.response.UserRespWithReservations;
import com.riwi.library.api.dto.response.responseBasic.UserResponse;
import com.riwi.library.domain.entities.User;
import com.riwi.library.domain.repositories.UserRepository;
import com.riwi.library.infrastructure.abstract_services.IUserService;
import com.riwi.library.infrastructure.helpers.mappers.UserMapper;
import com.riwi.library.util.exceptions.BadRequestException;
import com.riwi.library.util.messages.ErrorMessage;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
  
  @Autowired
  UserRepository userRepository;

  @Autowired
  UserMapper userMapper;

  @Override
  public UserResponse create(UserRequest request) {
    User user = userMapper.requestToEntity(request);
    return userMapper.entityToResponse(userRepository.save(user));
  }

  @Override
  public UserRespDetails get(Long id) {
    return userMapper.entityToUserRespDetails(findUser(id));
  }

  @Override
  public UserResponse update(UserReqToUpdate request, Long id) {
    User user = findUser(id);
    User userToUpdate = userMapper.requestToEntityUpdate(request, user);
    return userMapper.entityToResponse(userRepository.save(userToUpdate));
  }

  @Override
  public void delete(Long id) {
    userRepository.delete(findUser(id));
  }

  private User findUser (Long id){
    return userRepository.findById(id).orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("user")));

  }

  @Override
  public UserRespWithLoans getUserWithLoans(Long id) {
    return userMapper.userListToResponseUserWithLoansList(findUser(id));
  }

  @Override
  public UserRespWithReservations getUserWithReservations(Long id) {
    return userMapper.userListToResponseUserWithReservatios(findUser(id));
  }

}
