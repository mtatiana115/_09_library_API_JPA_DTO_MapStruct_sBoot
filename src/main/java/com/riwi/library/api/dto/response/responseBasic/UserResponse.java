package com.riwi.library.api.dto.response.responseBasic;

import com.riwi.library.util.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
  private Long id;
  private String userName;
  private String password;
  private String email;
  private String fullName;
  private Role role;

}
