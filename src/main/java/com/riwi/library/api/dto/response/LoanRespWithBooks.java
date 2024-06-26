package com.riwi.library.api.dto.response;

import com.riwi.library.api.dto.response.responseBasic.BookResponse;
import com.riwi.library.api.dto.response.responseBasic.LoanResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class LoanRespWithBooks extends LoanResponse {

  private BookResponse book;
}
