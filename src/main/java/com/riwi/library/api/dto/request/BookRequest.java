package com.riwi.library.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

  @NotBlank(message = "title is required")
  @Size(min = 1, max = 100)
  @Schema(description = "Title", example = "my_book")
  private String title;

  @NotBlank(message = "author is required")
  @Size(min = 1, max = 100)
  @Schema(description = "Author", example = "Author_name")
  private String author;

  @NotNull(message = "publication year is required")
  private Integer publicationYear;

  @NotBlank(message = "genre is required")
  @Size(min = 1, max = 50)
  private String genre;

  @NotBlank(message = "isbn is required")
  @Size(min = 1, max = 20)
  private String isbn;

}
