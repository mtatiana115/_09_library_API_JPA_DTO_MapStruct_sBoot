package com.riwi.library.infrastructure.helpers.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import com.riwi.library.api.dto.request.LoanReqToUpdate;
import com.riwi.library.api.dto.request.LoanRequest;
import com.riwi.library.api.dto.response.LoanRespDetails;
import com.riwi.library.api.dto.response.LoanRespWithBooks;
import com.riwi.library.api.dto.response.responseBasic.LoanResponse;
import com.riwi.library.domain.entities.Loan;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class, BookMapper.class})
public interface LoanMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "loanDate", ignore = true)
  @Mapping(target = "book", ignore = true)
  @Mapping(target = "user", ignore = true)
  @Mapping(target = "status", ignore = true)
  Loan requestToEntity (LoanRequest loanRequest);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "user", ignore = true)
  @Mapping(target = "book", ignore = true)
  @Mapping(target = "loanDate", ignore = true)
  Loan requestToEntityUpdate (LoanReqToUpdate loanRequest, @MappingTarget Loan loan );
  
  LoanRespDetails entityToResponseDetails (Loan loan);
  
  LoanResponse entityToResponse (Loan loan);

  List<LoanResponse> loanListToLoanResponsesList (List<Loan>loans);

  List<LoanRespWithBooks> loanListToLoanRespWithBooksList (List<Loan> loans);

}
