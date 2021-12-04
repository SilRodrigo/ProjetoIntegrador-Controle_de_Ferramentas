package com.model.service;

import com.model.dao.EmprestimoDao;
import com.model.entity.Emprestimo;
import com.model.entity.Objeto;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

  public void update(int id, int index, String newValue) throws Exception {
    Emprestimo emprestimo = getById(id);
    switch (index) {
      case 1: //Status
        newValue = newValue.toUpperCase();
        if (newValue.equals("D") || newValue.equals("DEVOLVIDO")) {
          emprestimo.setStatus(false);
          DateTimeFormatter dtf = DateTimeFormatter.ofPattern(
            "dd/MM/yyyy HH:mm:ss"
          );
          LocalDateTime now = LocalDateTime.now();
          emprestimo.setDateIn(dtf.format(now));
          ObjetoService objetoService = new ObjetoService();
          Objeto objeto = objetoService.getById(emprestimo.getObjetoId());
          objeto.setBorrowed(false);
          objetoService.update(objeto);
        }
      default:
        emprestimoDao.update(emprestimo);
    }
    return;
  }

  public void exclude(int id) throws Exception {
    throw new Exception("Exclusão não habilitada para esse módulo");
    /* emprestimoDao.exclude(id); */
  }

  public Emprestimo getById(int id) {
    return emprestimoDao.getById(id);
  }

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
        objetoService.getById(emprestimo.getObjetoId()).getName() +
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
        emprestimo.getObjetoId() +
        ";" +
        emprestimo.getClienteId()
      );
    }
    return emprestimoList;
  }

  public List<String> requestEdit(int id) {
    Emprestimo emprestimo = getById(id);
    List<String> emprestimoList = new ArrayList<>();
    if (emprestimo == null) return emprestimoList;
    emprestimoList.add(
      "Situacao (Digite (D)evolvido para encerrar o emprestimo)"
    );
    emprestimoList.add((emprestimo.getStatus() ? "Emprestado" : "Devolvido"));
    return emprestimoList;
  }
}
