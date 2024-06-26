package com.riwi.library.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.library.api.dto.error.ErrorResponse;
import com.riwi.library.api.dto.request.LoanReqToUpdate;
import com.riwi.library.api.dto.request.LoanRequest;
import com.riwi.library.api.dto.response.LoanRespDetails;
import com.riwi.library.api.dto.response.responseBasic.LoanResponse;
import com.riwi.library.infrastructure.abstract_services.ILoanService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/loans")
public class LoanController implements GenericController <LoanRequest, LoanReqToUpdate, LoanResponse,LoanRespDetails, Long> {

  @Autowired
  ILoanService loanService;

  @Operation(summary = "Create loan")
  @ApiResponse(responseCode = "400", description = "When the request is not valid", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
  @PostMapping
  public ResponseEntity<LoanResponse> create(@Validated @RequestBody LoanRequest request) {
    return ResponseEntity.ok(this.loanService.create(request));
  }

  @Operation(summary = "Get loan by ID number")
  @ApiResponse(responseCode = "400", description = "When the ID is not found", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
  @GetMapping(path = "/{id}")
  public ResponseEntity<LoanRespDetails> get(@PathVariable Long id) {
    return ResponseEntity.ok(this.loanService.get(id));
  }

  @Operation(summary = "Update an loan by its ID number")
  @ApiResponse(responseCode = "400", description = "When the request is not valid", content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
  })
  @PutMapping(path = "/{id}")
  public ResponseEntity<LoanResponse> update(@Validated @RequestBody LoanReqToUpdate request, @PathVariable("id") Long id) {
    return ResponseEntity.ok(this.loanService.update(request, id));
  }

  @Operation(summary = "Delete an loan by its ID number")
  @ApiResponse(responseCode = "204", description = "Loan deleted successfully")
  @ApiResponse(responseCode = "400", description = "When the ID is not found", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
  @DeleteMapping(path = "/{id}" )
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    this.loanService.delete(id);
    return ResponseEntity.noContent().build();
  }


}
