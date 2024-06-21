package com.riwi.library.api.controllers;

import org.springframework.http.ResponseEntity;

public interface GenericController <RequestDTO, ResponseDTO> {

  public ResponseEntity<ResponseDTO> create(RequestDTO request);

  public ResponseEntity<ResponseDTO> get(Long id);

  public ResponseEntity<ResponseDTO> update (RequestDTO request, Long id);
  
  public ResponseEntity<Void> delete(Long id); 
  
}
