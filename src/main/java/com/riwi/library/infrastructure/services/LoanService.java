package com.riwi.library.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.library.api.dto.request.LoanReqToUpdate;
import com.riwi.library.api.dto.request.LoanRequest;
import com.riwi.library.api.dto.response.LoanRespDetails;
import com.riwi.library.api.dto.response.responseBasic.LoanResponse;
import com.riwi.library.domain.entities.Loan;
import com.riwi.library.domain.repositories.LoanRepository;
import com.riwi.library.infrastructure.abstract_services.ILoanService;
import com.riwi.library.infrastructure.helpers.mappers.LoanMapper;
import com.riwi.library.util.exceptions.BadRequestException;
import com.riwi.library.util.messages.ErrorMessage;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoanService implements ILoanService {
  
  @Autowired
  LoanRepository loanRepository;

  @Autowired
  LoanMapper loanMapper;
  
  @Override
  public LoanResponse create(LoanRequest request) {
    Loan loan = loanMapper.requestToEntity(request);
    return loanMapper.entityToResponse(loanRepository.save(loan));
  }

  @Override
  public LoanRespDetails get(Long id) {
    return loanMapper.entityToResponseDetails(findLoan(id));
  }

  @Override
  public LoanResponse update(LoanReqToUpdate request, Long id) {
    Loan loan = findLoan(id);
    Loan loanToUpdate = loanMapper.requestToEntityUpdate(request, loan);
    return loanMapper.entityToResponse(loanRepository.save(loanToUpdate));
  }

  @Override
  public void delete(Long id) {
    loanRepository.delete(findLoan(id));
  }

  private Loan findLoan (Long id){
    return loanRepository.findById(id).orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("loan")));
  }


}
