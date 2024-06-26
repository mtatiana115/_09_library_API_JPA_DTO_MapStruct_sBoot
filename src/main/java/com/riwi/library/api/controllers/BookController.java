package com.riwi.library.api.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.library.api.dto.error.ErrorResponse;
import com.riwi.library.api.dto.request.BookRequest;
import com.riwi.library.api.dto.response.BookResponseDetails;
import com.riwi.library.api.dto.response.BookResponseWithReservations;
import com.riwi.library.api.dto.response.responseBasic.BookResponse;
import com.riwi.library.infrastructure.abstract_services.IBookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/books")
public class BookController implements GenericController <BookRequest,BookRequest, BookResponse,BookResponseDetails, Long> {

  @Autowired
  IBookService bookService;

  @Operation(summary = "Create book")
  @ApiResponse(responseCode = "400", description = "When the request is not valid", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
  @PostMapping
  public ResponseEntity<BookResponse> create(@Validated @RequestBody BookRequest request) {
    return ResponseEntity.ok(this.bookService.create(request));
  }

  @Operation(summary = "Get book by ID number")
  @ApiResponse(responseCode = "400", description = "When the ID is not found", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
  @GetMapping(path = "/{id}")
  public ResponseEntity<BookResponseDetails> get(@PathVariable Long id) {
    return ResponseEntity.ok(this.bookService.get(id));
  }

  @Operation(summary = "Update an book by its ID number")
  @ApiResponse(responseCode = "400", description = "When the request is not valid", content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
  })
  @PutMapping(path = "/{id}")
  public ResponseEntity<BookResponse> update(@Validated @RequestBody BookRequest request, @PathVariable("id") Long id) {
    return ResponseEntity.ok(this.bookService.update(request, id));
  }

  @Operation(summary = "Delete an book by its ID number")
  @ApiResponse(responseCode = "204", description = "Book deleted successfully")
  @ApiResponse(responseCode = "400", description = "When the ID is not found", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
  @DeleteMapping(path = "/{id}" )
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    this.bookService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @Operation(summary = "Filter books by title, author or genre")
  @GetMapping(path = "/{id}")
  public ResponseEntity<List<BookResponse>> filter(@RequestParam(defaultValue = "",required = false) String title,
  @RequestParam(defaultValue = "",required = false) String author,
  @RequestParam(defaultValue = "",required = false) String genre) {
    return ResponseEntity.ok(this.bookService.getAllBooks(title, author, genre));
  }

  @Operation(summary = "Get book with reservations by ID number")
  @GetMapping(path = "/{id}/reservations")
  public ResponseEntity<BookResponseWithReservations> getAllReservations(@PathVariable Long id) {
    return ResponseEntity.ok(this.bookService.getBookWithReservations(id));
  }

}
