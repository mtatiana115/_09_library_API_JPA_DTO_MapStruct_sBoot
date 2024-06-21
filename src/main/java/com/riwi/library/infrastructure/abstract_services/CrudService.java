package com.riwi.library.infrastructure.abstract_services;

public interface CrudService <RQ,RS,ID> {

  public RS create(RQ request);

  public RS get(ID id);

  public RS update(RQ request, ID id);

  public void delete(ID id);
}
