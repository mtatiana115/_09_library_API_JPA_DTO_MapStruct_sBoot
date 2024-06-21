package com.riwi.library.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.library.api.dto.request.UserRequest;
import com.riwi.library.api.dto.response.UserResponse;
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
    User user = this.userMapper.toUserEntity(request);
    return this.userMapper.toUserResponse(this.userRepository.save(user));
  }

  @Override
  public UserResponse get(Long id) {
    User user = this.userRepository.findById(id)
    .orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("user")));
    return this.userMapper.toUserResponse(user);
  }

  @Override
  public UserResponse update(UserRequest request, Long id) {
    this.userRepository.findById(id)
    .orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("user")));

    User user = this.userMapper.toUserEntity(request);
    user.setId(id);

    return this.userMapper.toUserResponse(this.userRepository.save(user));

  }

  @Override
  public void delete(Long id) {
    User user = this.userRepository.findById(id)
    .orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("user")));

    this.userRepository.delete(user);
  }

}
