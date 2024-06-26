package com.riwi.library.api.dto.response.responseBasic;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponse {

  private Long id;
  private LocalDate reservationDate;
  private Boolean status;

}
