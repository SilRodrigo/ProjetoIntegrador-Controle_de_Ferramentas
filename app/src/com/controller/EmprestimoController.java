package com.controller;

import com.model.service.EmprestimoService;
import com.util.Texting;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EmprestimoController implements IController {

  EmprestimoService emprestimoService = new EmprestimoService();

  @Override
  public List<String> getAll() {
    return null;
  }

  public List<String> getAll(
    ObjetoController objetoController,
    ClienteController clienteController
  ) {
    return emprestimoService.getAllData(
      objetoController.objetoService,
      clienteController.clienteService
    );
  }

  public List<String> getInsertRequiredOnly() {
    return emprestimoService.getInsertRequiredOnly();
  }

  @Override
  public String[] requestInsert() {
    String fields = this.getInsertRequiredOnly().get(0);
    return fields.split(";");
  }

  @Override
  public String delete() {
    return null;
  }

  @Override
  public String insert(List<String> list) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    try {
      emprestimoService.insert(
        Integer.parseInt(list.get(0)),
        Integer.parseInt(list.get(1)),
        dtf.format(now),
        "",
        true
      );      
      return Texting.registerSuccessful;
    } catch (Exception e) {
      System.out.println(e);
      return Texting.registerFailure;
    }
  }

  @Override
  public String getControllerBaseName() {
    return "";
  }

  @Override
  public boolean findId(int id) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public List<String> getAvailable() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<String> requestEdit(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean update(int id, int index, String newValue) {
    // TODO Auto-generated method stub
    return false;
  }
}
