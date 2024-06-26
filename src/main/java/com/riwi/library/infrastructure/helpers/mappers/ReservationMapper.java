package com.riwi.library.infrastructure.helpers.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import com.riwi.library.api.dto.request.ReservationReqToUpdate;
import com.riwi.library.api.dto.request.ReservationRequest;
import com.riwi.library.api.dto.response.ReservationRespDetails;
import com.riwi.library.api.dto.response.ReservationRespWithUser;
import com.riwi.library.api.dto.response.responseBasic.ReservationResponse;
import com.riwi.library.domain.entities.Reservation;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class, BookMapper.class})
public interface ReservationMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "reservationDate", ignore = true)
  @Mapping(target = "book", ignore = true)
  @Mapping(target = "user", ignore = true)
  @Mapping(target = "status", ignore = true)
  Reservation requestToEntity (ReservationRequest reservationRequest);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "reservationDate", ignore = true)
  @Mapping(target = "book", ignore = true)
  @Mapping(target = "user", ignore = true)
  Reservation requestToEntityUpdate (ReservationReqToUpdate reservationRequest, @MappingTarget Reservation reservation );
  
  ReservationRespDetails entityToResponseDetails (Reservation reservation);
  
  ReservationResponse entityToResponse (Reservation reservation);

  List<ReservationResponse> reservationListToReservationResponsesList (List<Reservation>reservations);


  List<ReservationRespWithUser> reservationListTReservationRespWithUsersList (List<Reservation> reservations);
}
