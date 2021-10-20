package com.controller;

import com.model.entity.Cliente;
import com.model.service.ClienteService;
import java.util.List;

public class ClienteController implements IController {

  ClienteService clienteService = new ClienteService();

  public Cliente getById(int id) {
    return clienteService.getById(id);
  }

  @Override
  public List<String> getAll() {
    return clienteService.getAllData();
  }

  @Override
  public String[] requestInsert() {
    String fields = this.getAll().get(0);
    return fields.split(";");
  }

  @Override
  public String delete() {
    return null;
  }

  @Override
  public String insert(List<String> list) {
    try {
      clienteService.insert(
        list.get(0),
        list.get(1),
        Integer.parseInt(list.get(2))
      );
      return "\nCadastrado com sucesso!";
    } catch (Exception e) {
      return "\nDados Invalidos para cadastro!";
    }
  }

  @Override
  public String getControllerBaseName() {
    return "Cliente";
  }
}
