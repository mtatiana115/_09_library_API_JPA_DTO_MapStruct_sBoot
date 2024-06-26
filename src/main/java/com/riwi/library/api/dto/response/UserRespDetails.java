package com.riwi.library.api.dto.response;

import java.util.List;

import com.riwi.library.api.dto.response.responseBasic.LoanResponse;
import com.riwi.library.api.dto.response.responseBasic.ReservationResponse;
import com.riwi.library.util.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRespDetails {
  private Long id;
  private String userName;
  private String password;
  private String email;
  private String fullName;
  private Role role;
  private List <ReservationResponse> reservations;
  private List<LoanResponse> loans;

}
