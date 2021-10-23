package com.model.entity;

import java.util.List;

public class Menu {

  public enum MenuName {
    LOGOUT,
    MAIN,
    CADASTROS,
    CADASTRO_CLIENTE,
    CADASTRO_TIPO_OBJETO,
    CADASTRO_OBJETO,
    CADASTRO_MANUTENCAO,
    EMPRESTIMO,
    MANUTENCAO,
  }

  MenuName name;
  String viewName;
  MenuName parentMenu;
  List<MenuName> childMenus;
  List<MenuName> relyMenus;

  public Menu(
    String viewName,
    MenuName main,
    MenuName parentMenu,
    List<MenuName> childMenus
  ) {
    this.viewName = viewName;
    this.name = main;
    this.parentMenu = parentMenu;
    this.childMenus = childMenus;
  }

  public Menu(
    String viewName,
    MenuName main,
    MenuName parentMenu,
    List<MenuName> childMenus,
    List<MenuName> relyMenus
  ) {
    this.viewName = viewName;
    this.name = main;
    this.parentMenu = parentMenu;
    this.childMenus = childMenus;
    this.relyMenus = relyMenus;
  }

  public MenuName getName() {
    return name;
  }

  public String getViewName() {
    return viewName;
  }

  public MenuName getParentMenu() {
    return parentMenu;
  }

  public MenuName navigate(int index) {
    if (index == 0) return parentMenu;
    if (index < 0 || index > childMenus.size()) return name;
    return childMenus.get(index - 1);
  }
}
