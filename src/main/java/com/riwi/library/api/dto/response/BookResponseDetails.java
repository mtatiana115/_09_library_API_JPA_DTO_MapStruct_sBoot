package com.riwi.library.api.dto.response;

import java.util.List;

import com.riwi.library.api.dto.response.responseBasic.LoanResponse;
import com.riwi.library.api.dto.response.responseBasic.ReservationResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDetails {

  private Long id;
  private String title;
  private String author;
  private Integer publicationYear;
  private String genre;
  private String isbn;

  private List<ReservationResponse> reservations;
  private List<LoanResponse> loans;
}
