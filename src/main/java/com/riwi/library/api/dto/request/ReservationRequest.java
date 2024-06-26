package com.riwi.library.api.dto.request;

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
public class ReservationRequest {

  @NotNull(message = "User id is required")
  @Schema(description = "User id", example = "number") 
  private Long userId;

  @NotNull(message = "Book id is required")
  @Schema(description = "Book id", example = "number") 
  private Long bookId;
}
