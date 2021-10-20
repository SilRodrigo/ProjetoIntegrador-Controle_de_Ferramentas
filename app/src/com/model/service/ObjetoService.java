package com.model.service;

import com.model.dao.ObjetoDao;
import com.model.entity.Objeto;
import com.model.entity.TipoObjeto;
import java.util.ArrayList;
import java.util.List;

public class ObjetoService {

  ObjetoDao objetoDao = new ObjetoDao();

  public void insert(
    String name,
    TipoObjeto objectType,
    boolean borrowed,
    boolean inMaintenance
  ) {
    Objeto objeto = new Objeto(
      objetoDao.getLastIndex() + 1,
      name,
      objectType,
      borrowed,
      inMaintenance
    );
    objetoDao.insert(objeto);
  }

  public void getById(int id) {}

  public List<String> getAllData() {
    List<Objeto> tipoObjetos = objetoDao.getAll();
    List<String> objetoList = new ArrayList<>();
    objetoList.add("id;Tipo;Nome;Emprestado;Em Manutencao");
    if (tipoObjetos == null) return objetoList;
    for (Objeto tipoObjeto : tipoObjetos) {
      objetoList.add(
        tipoObjeto.getId() +
        ";" +
        tipoObjeto.getObjectType().getType().toUpperCase() +
        ";" +
        tipoObjeto.getName() +
        ";" +
        tipoObjeto.isBorrowed() +
        ";" +
        tipoObjeto.isInMaintenance()
      );
    }
    return objetoList;
  }
}
