package com.riwi.library.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationReqToUpdate {

  @Schema(description = "True is available and false is unavailable", example = "true")
  private Boolean status;
}
