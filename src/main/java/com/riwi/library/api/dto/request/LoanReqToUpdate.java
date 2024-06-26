package com.riwi.library.api.dto.request;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanReqToUpdate {

  @NotNull(message = "Return date is required")
  @Schema(description = "Return date", example = "yyyy-MM-dd")
  private LocalDate returnDate;

  @Schema(description = "True is available and false is unavailable", example = "true")
  private Boolean status;


}
