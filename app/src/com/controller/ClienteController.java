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
  public String delete(int id) {
    try {
      this.clienteService.exclude(id);
      return ("Exclusão realizada com sucesso");
    } catch (Exception e) {
      return e.toString();
    }
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

  @Override
  public boolean findId(int id) {
    Cliente cliente = this.clienteService.getById(id);
    if (cliente == null) {
      System.out.println("\nNao existe esse Id cadastrado!");
      Entrada.leiaString("Aperte ENTER para continuar...");
      return false;
    }
    return true;
  }

  @Override
  public List<String> getAvailable() {
    return clienteService.getAllData();
  }

  @Override
  public List<String> requestEdit(int id) {
    return clienteService.requestEdit(id);
  }

  @Override
  public boolean update(int id, int index, String newValue) {
    try {
      clienteService.update(id, index, newValue);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
