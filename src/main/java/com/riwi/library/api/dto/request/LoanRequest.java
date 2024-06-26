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
public class LoanRequest {

  @NotNull(message = "Return date is required")
  @Schema(description = "Return date", example = "yyyy-MM-dd")
  private LocalDate returnDate;

  @NotNull(message = "User id is required")
  @Schema(description = "User id", example = "number")  
  private Long userId;

  @NotNull(message = "Book id is required")
  @Schema(description = "Book id", example = "number")
  private Long bookId;
}
