package com.riwi.library.infrastructure.abstract_services;

import java.util.List;

import com.riwi.library.api.dto.request.UserReqToUpdate;
import com.riwi.library.api.dto.request.UserRequest;
import com.riwi.library.api.dto.response.UserRespDetails;
import com.riwi.library.api.dto.response.UserRespWithLoans;
import com.riwi.library.api.dto.response.UserRespWithReservations;
import com.riwi.library.api.dto.response.responseBasic.UserResponse;

public interface IUserService extends CrudService<UserRequest, UserReqToUpdate, UserRespDetails, UserResponse, Long> {

  public UserRespWithLoans getUserWithLoans (Long id);

  public UserRespWithReservations getUserWithReservations (Long id);
}
