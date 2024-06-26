package com.riwi.library.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.library.api.dto.error.ErrorResponse;
import com.riwi.library.api.dto.request.ReservationReqToUpdate;
import com.riwi.library.api.dto.request.ReservationRequest;
import com.riwi.library.api.dto.response.ReservationRespDetails;
import com.riwi.library.api.dto.response.responseBasic.ReservationResponse;
import com.riwi.library.infrastructure.abstract_services.IReservationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/reservations")
public class ReservationController implements GenericController <ReservationRequest, ReservationReqToUpdate, ReservationResponse,ReservationRespDetails, Long> {

  @Autowired
  IReservationService reservationService;

  @Operation(summary = "Create reservation")
  @ApiResponse(responseCode = "400", description = "When the request is not valid", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
  @PostMapping
  public ResponseEntity<ReservationResponse> create(@Validated @RequestBody ReservationRequest request) {
    return ResponseEntity.ok(this.reservationService.create(request));
  }

  @Operation(summary = "Get reservation by ID number")
  @ApiResponse(responseCode = "400", description = "When the ID is not found", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
  @GetMapping(path = "/{id}")
  public ResponseEntity<ReservationRespDetails> get(@PathVariable Long id) {
    return ResponseEntity.ok(this.reservationService.get(id));
  }

  @Operation(summary = "Update an reservation by its ID number")
  @ApiResponse(responseCode = "400", description = "When the request is not valid", content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
  })
  @PutMapping(path = "/{id}")
  public ResponseEntity<ReservationResponse> update(@Validated @RequestBody ReservationReqToUpdate request, @PathVariable("id") Long id) {
    return ResponseEntity.ok(this.reservationService.update(request, id));
  }

  @Operation(summary = "Delete an reservation by its ID number")
  @ApiResponse(responseCode = "204", description = "Reservation deleted successfully")
  @ApiResponse(responseCode = "400", description = "When the ID is not found", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
  @DeleteMapping(path = "/{id}" )
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    this.reservationService.delete(id);
    return ResponseEntity.noContent().build();
  }


}
