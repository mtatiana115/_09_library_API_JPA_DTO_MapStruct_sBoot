package com.riwi.library.infrastructure.abstract_services;

import com.riwi.library.api.dto.request.ReservationReqToUpdate;
import com.riwi.library.api.dto.request.ReservationRequest;
import com.riwi.library.api.dto.response.ReservationRespDetails;
import com.riwi.library.api.dto.response.responseBasic.ReservationResponse;

public interface IReservationService extends CrudService <ReservationRequest, ReservationReqToUpdate, ReservationRespDetails, ReservationResponse, Long> {

}
