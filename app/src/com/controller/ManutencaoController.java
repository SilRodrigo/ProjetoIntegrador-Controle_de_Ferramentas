package com.controller;

import com.model.service.ManutencaoService;
import java.util.List;

public class ManutencaoController implements IController {

  ManutencaoService manutencaoService = new ManutencaoService();

  public List<String> getInsertRequiredOnly() {
    return manutencaoService.getInsertRequiredOnly();
  }

  @Override
  public String[] requestInsert() {
    String fields = this.getInsertRequiredOnly().get(0);
    return fields.split(";");
  }

  @Override
  public List<String> getAll() {
    return manutencaoService.getAllData();
  }

  @Override
  public boolean findId(int id) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public String insert(List<String> list) {
    try {
      manutencaoService.insert(list.get(0), Integer.parseInt(list.get(1)), false);
      return "\nCadastrado com sucesso!";
    } catch (Exception e) {
      return "\nDados Invalidos para cadastro!";
    }
  }

  @Override
  public String delete(int id) {
    try {
      this.manutencaoService.exclude(id);
      return ("Exclusão realizada com sucesso");
    } catch (Exception e) {
      return e.toString();
    }
  }

  @Override
  public String getControllerBaseName() {
    return "";
  }

  @Override
  public List<String> getAvailable() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<String> requestEdit(int id) {
    return manutencaoService.requestEdit(id);
  }

  @Override
  public boolean update(int id, int index, String newValue) {
    try {
      manutencaoService.update(id, index, newValue);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
