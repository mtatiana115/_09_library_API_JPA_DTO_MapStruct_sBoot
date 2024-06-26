package com.riwi.library.infrastructure.abstract_services;

import com.riwi.library.api.dto.request.LoanReqToUpdate;
import com.riwi.library.api.dto.request.LoanRequest;
import com.riwi.library.api.dto.response.LoanRespDetails;
import com.riwi.library.api.dto.response.responseBasic.LoanResponse;

public interface ILoanService extends CrudService <LoanRequest, LoanReqToUpdate, LoanRespDetails, LoanResponse, Long> {

}
