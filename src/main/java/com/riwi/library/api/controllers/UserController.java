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
import com.riwi.library.api.dto.request.UserRequest;
import com.riwi.library.api.dto.response.UserResponse;
import com.riwi.library.infrastructure.abstract_services.IUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserController implements GenericController <UserRequest, UserResponse, Long> {

  @Autowired
  IUserService userService;

  @Operation(summary = "Create user")
  @ApiResponse(responseCode = "400", description = "When the request is not valid", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
  @PostMapping
  public ResponseEntity<UserResponse> create(@Validated @RequestBody UserRequest request) {
    return ResponseEntity.ok(this.userService.create(request));
  }

  @Operation(summary = "Get user by ID number")
  @ApiResponse(responseCode = "400", description = "When the ID is not found", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
  @GetMapping(path = "/{id}")
  public ResponseEntity<UserResponse> get(@PathVariable Long id) {
    return ResponseEntity.ok(this.userService.get(id));
  }

  @Operation(summary = "Update an user by its ID number")
  @ApiResponse(responseCode = "400", description = "When the request is not valid", content = {
          @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
  })
  @PutMapping(path = "/{id}")
  public ResponseEntity<UserResponse> update(@Validated @RequestBody UserRequest request, @PathVariable("id") Long id) {
    return ResponseEntity.ok(this.userService.update(request, id));
  }

  @Operation(summary = "Delete an user by its ID number")
  @ApiResponse(responseCode = "204", description = "User deleted successfully")
  @ApiResponse(responseCode = "400", description = "When the ID is not found", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
  @DeleteMapping(path = "/{id}" )
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    this.userService.delete(id);
    return ResponseEntity.noContent().build();
  }


}
