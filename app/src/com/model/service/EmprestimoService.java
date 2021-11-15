package com.model.service;

import com.model.dao.EmprestimoDao;
import com.model.entity.Emprestimo;
import com.model.entity.Objeto;
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
    ObjetoService objetoService = new ObjetoService();
    Objeto objeto = objetoService.getById(objetoId);
    if (
      !objeto.getStatus() || objeto.isBorrowed() || objeto.isInMaintenance()
    ) throw new Exception(
      "Objeto não pode ser emprestado.\nVerifique sua situação antes de continuar."
    );
    objeto.setBorrowed(true);
    objetoService.update(objeto);
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
