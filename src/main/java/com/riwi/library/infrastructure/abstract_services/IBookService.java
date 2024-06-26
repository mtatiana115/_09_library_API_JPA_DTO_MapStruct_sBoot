package com.riwi.library.infrastructure.abstract_services;

import java.util.List;

import com.riwi.library.api.dto.request.BookRequest;
import com.riwi.library.api.dto.response.BookResponseDetails;
import com.riwi.library.api.dto.response.BookResponseWithReservations;
import com.riwi.library.api.dto.response.responseBasic.BookResponse;

public interface IBookService extends CrudService <BookRequest, BookRequest , BookResponseDetails, BookResponse, Long> {

  public List<BookResponse> getAllBooks (String title, String author, String genre); 

  public BookResponseWithReservations getBookWithReservations (Long id);
}
