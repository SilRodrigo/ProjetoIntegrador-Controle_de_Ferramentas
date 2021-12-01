package com.model.dao;

import com.model.entity.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

  static List<Cliente> clienteList = new ArrayList<Cliente>();

  public void insert(Cliente cliente) {
    ClienteDao.clienteList.add(cliente);
  }

  public Cliente getById(int id) {
    for (Cliente cliente : ClienteDao.clienteList) {
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

  public boolean update(Cliente cliente) {
    for (Cliente clienteOld : ClienteDao.clienteList) {
      if (clienteOld.getId() == cliente.getId()) {
        clienteOld = cliente;
        return true;
      }
    }
    return false;
  }
}
