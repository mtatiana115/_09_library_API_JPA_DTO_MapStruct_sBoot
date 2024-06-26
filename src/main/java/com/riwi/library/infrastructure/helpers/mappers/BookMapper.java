package com.riwi.library.infrastructure.helpers.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import com.riwi.library.api.dto.request.BookRequest;
import com.riwi.library.api.dto.response.BookResponseDetails;
import com.riwi.library.api.dto.response.BookResponseWithReservations;
import com.riwi.library.api.dto.response.responseBasic.BookResponse;
import com.riwi.library.domain.entities.Book;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ReservationMapper.class, LoanMapper.class})
public interface BookMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "loans", ignore = true)
  @Mapping(target = "reservations", ignore = true)
  Book requestToEntity (BookRequest bookRequest);

  BookResponse entityToResponse (Book book);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "loans", ignore = true)
  @Mapping(target = "reservations", ignore = true)
  Book requestToEntityUpdate (BookRequest bookRequest, @MappingTarget Book book );

  BookResponseDetails entityToResponseDetails (Book book);

  List<BookResponse> bookListToBookResponsesList (List<Book>books);

  BookResponseWithReservations entityToResponseWithReservations (Book book);


}
