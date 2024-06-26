package com.riwi.library.api.dto.response;

import java.time.LocalDate;

import com.riwi.library.api.dto.response.responseBasic.BookResponse;
import com.riwi.library.api.dto.response.responseBasic.UserResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRespDetails {

  private Long id;
  private LocalDate reservationDate;
  private Boolean status;
  private UserResponse user;
  private BookResponse book;
  
}
