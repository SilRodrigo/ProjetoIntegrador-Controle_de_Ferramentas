package com.controller;

import com.model.entity.Menu.MenuName;
import com.model.service.MenuService;

public class MenuController {

  MenuService menuService = new MenuService();

  public boolean navigate(int index) {
    try {
      menuService.navigate(index);
      if (menuService.getMenuName() == MenuName.LOGOUT) return true;
    } catch (Exception e) {
      System.out.println("Erro inesperado: " + e);
      return true;
    }
    return false;
  }

  public MenuName getMenuName() {
    return menuService.getMenuName();
  }

  public String getMenuViewName() {
    return menuService.getViewName();
  }
}
