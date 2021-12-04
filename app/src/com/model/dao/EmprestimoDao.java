package com.model.dao;

import com.model.entity.Emprestimo;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDao {

  static List<Emprestimo> emprestimoList = new ArrayList<Emprestimo>();

  public Emprestimo getById(int id) {
    for (Emprestimo emprestimo : EmprestimoDao.emprestimoList) {
      if (emprestimo.getId() == id) {
        return emprestimo;
      }
    }
    return null;
  }

  public void exclude(int id) {
    EmprestimoDao.emprestimoList.remove(this.getById(id));
  }

  public int getLastIndex() {
    return emprestimoList.size();
  }

  public List<Emprestimo> getAll() {
    return EmprestimoDao.emprestimoList;
  }

  public void insert(Emprestimo objeto) {
    EmprestimoDao.emprestimoList.add(objeto);
  }
}
