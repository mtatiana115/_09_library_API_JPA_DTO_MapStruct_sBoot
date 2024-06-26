package com.riwi.library.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.library.domain.entities.Book;

@Repository
public interface BookRepository extends JpaRepository <Book, Long>{
  
  /*acá van los métodos personalizados*/

  /*
  *la palabra find para que JPA sepa que yo quiero encontrar, luego le digo cual el parámetro por el cual voy a buscar donde el atributo tiene que llamarse igual que la entidad
  */

  /*
   * Containing sirve para encontrar coincidencias
   */

  public List<Book> findByTitleContainingAndAuthorContainingAndGenreContaining (String title, String author, String genre);

}
