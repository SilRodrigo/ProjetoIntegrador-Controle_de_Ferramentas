package com.model.service;

import com.model.dao.EmprestimoDao;
import com.model.entity.Emprestimo;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoService {

  EmprestimoDao emprestimoDao = new EmprestimoDao();

  public void insert(
    int objetoId,
    int clienteId,
    String dateOut,
    String dateIn,
    boolean status
  )
    throws Exception {
    Emprestimo emprestimo = new Emprestimo(
      emprestimoDao.getLastIndex() + 1,
      objetoId,
      clienteId,
      dateOut,
      dateIn,
      status
    );
    emprestimoDao.insert(emprestimo);
  }

  public void getById(int id) {}

  public List<String> getAllData(
    ObjetoService objetoService,
    ClienteService clienteService
  ) {
    List<Emprestimo> emprestimos = emprestimoDao.getAll();
    List<String> emprestimoList = new ArrayList<>();
    emprestimoList.add("id;Data Saida; Data Entrada;Objeto;Usuario;Situacao");
    if (emprestimos == null) return emprestimoList;
    for (Emprestimo emprestimo : emprestimos) {
      emprestimoList.add(
        emprestimo.getId() +
        ";" +
        emprestimo.getDateOut() +
        ";" +
        emprestimo.getDateIn() +
        ";" +
        objetoService.getById(emprestimo.getObjectId()).getName() +
        ";" +
        clienteService.getById(emprestimo.getClienteId()).getName() +
        ";" +
        (emprestimo.getStatus() ? "Emprestado" : "Devolvido")
      );
    }
    return emprestimoList;
  }

  public List<String> getInsertRequiredOnly() {
    List<Emprestimo> emprestimos = emprestimoDao.getAll();
    List<String> emprestimoList = new ArrayList<>();
    emprestimoList.add("id;Objeto;Cliente");
    if (emprestimos == null) return emprestimoList;
    for (Emprestimo emprestimo : emprestimos) {
      emprestimoList.add(
        emprestimo.getId() +
        ";" +
        emprestimo.getObjectId() +
        ";" +
        emprestimo.getClienteId()
      );
    }
    return emprestimoList;
  }
}
