package com.riwi.library.infrastructure.abstract_services;

//REQUPDATE ES SIN ROL POR SOLICITUD DEL EJERCICIO
public interface CrudService <RQ, REQUPDATE, RESPDETAILS, RS,ID> {

  public RS create(RQ request);

  public RESPDETAILS get(ID id);

  public RS update(REQUPDATE request, ID id);

  public void delete(ID id);
}
