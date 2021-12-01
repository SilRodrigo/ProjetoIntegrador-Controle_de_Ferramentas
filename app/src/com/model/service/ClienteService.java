package com.model.service;

import com.model.dao.ClienteDao;
import com.model.entity.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteService {

  ClienteDao clienteDao = new ClienteDao();
  final String INDEX_LIST = ("Nome;Endereco;Numero");
  final String ID = "id;";

  public void insert(String name, String address, int addressNumber) {
    Cliente cliente = new Cliente(
      clienteDao.getLastIndex() + 1,
      name,
      address,
      addressNumber
    );
    clienteDao.insert(cliente);
  }

  public void update(int id, int index, String newValue) throws Exception {
    Cliente cliente = getById(id);
    switch (index) {
      case 1: //Nome
        cliente.setName(newValue);
      case 2: //Endereco;
        cliente.setAddress(newValue);
      case 3: //Numero
        int newValueInt = Integer.parseInt(newValue);
        cliente.setAddressNumber(newValueInt);
      default:
        clienteDao.update(cliente);
    }
    return;
  }

  public Cliente getById(int id) {
    return clienteDao.getById(id);
  }

  public List<String> getAllData() {
    List<Cliente> clientes = clienteDao.getAll();
    List<String> clienteList = new ArrayList<>();
    clienteList.add(ID + INDEX_LIST);
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

  public List<String> requestEdit(int id) {
    Cliente cliente = getById(id);
    List<String> clienteList = new ArrayList<>();
    if (cliente == null) return clienteList;
    clienteList.add(INDEX_LIST);
    clienteList.add(
      cliente.getName() +
      ";" +
      cliente.getAddress() +
      ";" +
      cliente.getAddressNumber()
    );
    return clienteList;
  }
}
