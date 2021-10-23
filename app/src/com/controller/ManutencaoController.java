package com.controller;

import com.model.service.ManutencaoService;
import java.util.List;

public class ManutencaoController implements IController {

  ManutencaoService manutencaoService = new ManutencaoService();

  @Override
  public String[] requestInsert() {
    String fields = this.getAll().get(0);
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
      manutencaoService.insert(list.get(0));
      return "\nCadastrado com sucesso!";
    } catch (Exception e) {
      return "\nDados Invalidos para cadastro!";
    }
  }

  @Override
  public String delete() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getControllerBaseName() {
    return "Manutencao";
  }
}
