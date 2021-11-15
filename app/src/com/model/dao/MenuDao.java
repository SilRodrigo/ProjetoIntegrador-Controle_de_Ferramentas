package com.model.dao;

import com.model.entity.Menu;
import com.model.entity.Menu.MenuName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuDao {

  List<Menu> menuList = new ArrayList<Menu>();

  public MenuDao() {
    createMenus();
  }

  private void addMenu(Menu menu) {
    menuList.add(menu);
  }

  public Menu get(Menu.MenuName menuName) {
    for (Menu menu : this.menuList) {
      if (menu.getName().equals(menuName)) {
        return menu;
      }
    }
    return null;
  }

  private void createMenus() {
    /* CADASTRO MANUAL DE TELAS */

    final Menu logout = new Menu("Logout", MenuName.LOGOUT, null, null);
    addMenu(logout);

    /*  */

    final Menu main = new Menu(
      "Menu Principal",
      MenuName.MAIN,
      MenuName.LOGOUT,
      Arrays.asList(
        MenuName.CADASTROS,
        MenuName.EMPRESTIMO,
        MenuName.MANUTENCAO
      )
    );
    addMenu(main);

    /*  */

    final Menu cadastros = new Menu(
      "Cadastros",
      MenuName.CADASTROS,
      MenuName.MAIN,
      new ArrayList<MenuName>(
        Arrays.asList(
          MenuName.CADASTRO_CLIENTE,
          MenuName.CADASTRO_TIPO_OBJETO,
          MenuName.CADASTRO_OBJETO
        )
      )
    );
    addMenu(cadastros);

    /*  */

    final Menu cadastroCliente = new Menu(
      "Cadastro de Cliente",
      MenuName.CADASTRO_CLIENTE,
      MenuName.CADASTROS,
      new ArrayList<MenuName>()
    );
    addMenu(cadastroCliente);

    /*  */

    final Menu cadastroTipoObjeto = new Menu(
      "Cadastros de Tipos de Objetos",
      MenuName.CADASTRO_TIPO_OBJETO,
      MenuName.CADASTROS,
      new ArrayList<MenuName>()
    );
    addMenu(cadastroTipoObjeto);

    /*  */

    final Menu cadastroObjeto = new Menu(
      "Cadastro de Objeto",
      MenuName.CADASTRO_OBJETO,
      MenuName.CADASTROS,
      new ArrayList<MenuName>(),
      new ArrayList<MenuName>(Arrays.asList(MenuName.CADASTRO_TIPO_OBJETO))
    );
    addMenu(cadastroObjeto);

    /*  */

/*     final Menu cadastroManutencao = new Menu(
      "Cadastros de Manutencoes",
      MenuName.CADASTRO_MANUTENCAO,
      MenuName.CADASTROS,
      new ArrayList<MenuName>()
    );
    addMenu(cadastroManutencao); */

    /*  */

    final Menu emprestimo = new Menu(
      "Emprestimos",
      MenuName.EMPRESTIMO,
      MenuName.MAIN,
      new ArrayList<MenuName>()
    );
    addMenu(emprestimo);

    /*  */

    final Menu manutencao = new Menu(
      "Manutencao",
      MenuName.MANUTENCAO,
      MenuName.MAIN,
      new ArrayList<MenuName>()
    );
    addMenu(manutencao);
  }
}
