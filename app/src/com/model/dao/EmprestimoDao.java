package com.model.dao;

import com.model.entity.Emprestimo;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDao {

  List<Emprestimo> emprestimoList = new ArrayList<Emprestimo>();

  public void getById(int id) {}

  public int getLastIndex() {
    return emprestimoList.size();
  }

  public List<Emprestimo> getAll() {
    return this.emprestimoList;
  }

  public void insert(Emprestimo objeto) {
    this.emprestimoList.add(objeto);
  }
}
