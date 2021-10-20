package com.model.service;

import com.model.dao.ClienteDao;
import com.model.entity.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteService {

  ClienteDao clienteDao = new ClienteDao();

  public void insert(String name, String address, int addressNumber) {
    Cliente cliente = new Cliente(
      clienteDao.getLastIndex() + 1,
      name,
      address,
      addressNumber
    );
    clienteDao.insert(cliente);
  }

  public Cliente getById(int id) {
    return clienteDao.getById(id);
  }

  public List<String> getAllData() {
    List<Cliente> clientes = clienteDao.getAll();
    List<String> clienteList = new ArrayList<>();
    clienteList.add("id;Nome;Endereco;Numero");
    if (clientes == null) return clienteList;
    for (Cliente cliente : clientes) {
      clienteList.add(
        cliente.getId() +
        ";" +
        cliente.getName() +
        ";" +
        cliente.getAddress() +
        ";" +
        cliente.getAddressNumber()
      );
    }
    return clienteList;
  }
}
