package com.model.dao;

import com.model.entity.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

  List<Cliente> clienteList = new ArrayList<Cliente>();

  public void insert(Cliente cliente) {
    this.clienteList.add(cliente);
  }

  public Cliente getById(int id) {
    for (Cliente cliente : this.clienteList) {
      if (cliente.getId() == id) {
        return cliente;
      }
    }
    return null;
  }

  public List<Cliente> getAll() {
    return clienteList;
  }

  public int getLastIndex() {
    return clienteList.size();
  }
}
