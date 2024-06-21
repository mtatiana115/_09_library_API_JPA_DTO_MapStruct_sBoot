package com.riwi.library.api.controllers;

import org.springframework.http.ResponseEntity;

public interface GenericController <RequestDTO, ResponseDTO, ID> {

  public ResponseEntity<ResponseDTO> create(RequestDTO request);

  public ResponseEntity<ResponseDTO> get(ID id);

  public ResponseEntity<ResponseDTO> update (RequestDTO request, ID id);
  
  public ResponseEntity<Void> delete(ID id); 
  
}
