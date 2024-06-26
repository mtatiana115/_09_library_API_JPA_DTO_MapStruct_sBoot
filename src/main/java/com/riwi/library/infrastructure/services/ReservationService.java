package com.riwi.library.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.library.api.dto.request.ReservationReqToUpdate;
import com.riwi.library.api.dto.request.ReservationRequest;
import com.riwi.library.api.dto.response.ReservationRespDetails;
import com.riwi.library.api.dto.response.responseBasic.ReservationResponse;
import com.riwi.library.domain.entities.Reservation;
import com.riwi.library.domain.repositories.ReservationRepository;
import com.riwi.library.infrastructure.abstract_services.IReservationService;
import com.riwi.library.infrastructure.helpers.mappers.ReservationMapper;
import com.riwi.library.util.exceptions.BadRequestException;
import com.riwi.library.util.messages.ErrorMessage;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {
  
  @Autowired
  ReservationRepository reservationRepository;

  @Autowired
  ReservationMapper reservationMapper;
  
  @Override
  public ReservationResponse create(ReservationRequest request) {
    Reservation reservation = reservationMapper.requestToEntity(request);
    return reservationMapper.entityToResponse(reservationRepository.save(reservation));
  }

  @Override
  public ReservationRespDetails get(Long id) {
    return reservationMapper.entityToResponseDetails(findReservation(id));
  }

  @Override
  public ReservationResponse update(ReservationReqToUpdate request, Long id) {
    Reservation reservation = findReservation(id);
    Reservation reservationToUpdate = reservationMapper.requestToEntityUpdate(request, reservation);
    return reservationMapper.entityToResponse(reservationRepository.save(reservationToUpdate));
  }

  @Override
  public void delete(Long id) {
    reservationRepository.delete(findReservation(id));
  }

  private Reservation findReservation (Long id){
    return reservationRepository.findById(id).orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("reservation")));
  }

}
