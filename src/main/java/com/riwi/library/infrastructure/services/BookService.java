package com.riwi.library.infrastructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.library.api.dto.request.BookRequest;
import com.riwi.library.api.dto.response.BookResponseDetails;
import com.riwi.library.api.dto.response.BookResponseWithReservations;
import com.riwi.library.api.dto.response.responseBasic.BookResponse;
import com.riwi.library.domain.entities.Book;
import com.riwi.library.domain.repositories.BookRepository;
import com.riwi.library.infrastructure.abstract_services.IBookService;
import com.riwi.library.infrastructure.helpers.mappers.BookMapper;
import com.riwi.library.util.exceptions.BadRequestException;
import com.riwi.library.util.messages.ErrorMessage;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookService implements IBookService {
  
  @Autowired
  BookRepository bookRepository;

  @Autowired
  BookMapper bookMapper;
  
  @Override
  public BookResponse create(BookRequest request) {
    Book book = bookMapper.requestToEntity(request);
    return bookMapper.entityToResponse(bookRepository.save(book));
  }

  @Override
  public BookResponseDetails get(Long id) {
    return bookMapper.entityToResponseDetails(findBook(id));
  }

  @Override
  public BookResponse update(BookRequest request, Long id) {
    Book book = findBook(id);
    Book bookToUpdate = bookMapper.requestToEntityUpdate(request, book);
    return bookMapper.entityToResponse(bookRepository.save(bookToUpdate));
  }

  @Override
  public void delete(Long id) {
    bookRepository.delete(findBook(id));
  }

  private Book findBook (Long id){
    return bookRepository.findById(id).orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("book")));
  }

  @Override
  public List<BookResponse> getAllBooks(String title, String author, String genre) {

    return bookMapper.bookListToBookResponsesList(bookRepository.findByTitleContainingAndAuthorContainingAndGenreContaining(title, author, genre));
  }

  @Override
  public BookResponseWithReservations getBookWithReservations(Long id) {
    return bookMapper.entityToResponseWithReservations(findBook(id));
  }

}
