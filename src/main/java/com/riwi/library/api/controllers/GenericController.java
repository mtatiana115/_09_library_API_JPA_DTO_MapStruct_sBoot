package com.riwi.library.api.controllers;

import org.springframework.http.ResponseEntity;

public interface GenericController <RequestDTO, RequestUpdate, ResponseDTO, responseDetails, ID> {

  public ResponseEntity<ResponseDTO> create(RequestDTO request);

  public ResponseEntity<responseDetails> get(ID id);

  public ResponseEntity<ResponseDTO> update (RequestUpdate request, ID id);
  
  public ResponseEntity<Void> delete(ID id); 
  
}
