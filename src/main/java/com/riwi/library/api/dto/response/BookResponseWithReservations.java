package com.riwi.library.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseWithReservations {

  private Long id;
  private String title;
  private String author;
  private Integer publicationYear;
  private String genre;
  private String isbn;

  private List<ReservationRespWithUser> reservations;
}
