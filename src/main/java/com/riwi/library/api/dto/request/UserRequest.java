package com.riwi.library.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

  @NotBlank(message = "Username is required")
  @Size(min = 1, max = 50)
  @Schema(description = "Username", example = "your_name")
  private String userName;

  @NotBlank(message = "Password is required")
  @Size(min = 6, max = 100)
  @Schema(description = "Password", example = "password123")
  private String password;

  @NotBlank(message = "Email is required")
  @Email(message = "email is invalid")
  @Size(max=100)
  @Schema(description = "Email", example = "your_email@email.com")
  private String email;

  @NotBlank(message = "Fullname is required")
  @Schema(description = "fullname", example = "name_lastname")
  private String fullName;


  @NotBlank(message = "Role is required")
  @Schema(description = "role", example = "LIBRARIAN or STUDENT")
  private String role;
}
