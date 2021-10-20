package com.model.service;

import com.model.dao.MenuDao;
import com.model.entity.Menu;
import com.model.entity.Menu.MenuName;
public class MenuService {

  Menu menu;
  MenuDao menuDao = new MenuDao();

  public MenuService() {
    this.menu = getMenu(MenuName.MAIN);
  }

  private Menu getMenu(MenuName name) {
    return menuDao.get(name);
  }

  public MenuName getMenuName() {
    return menu.getName();
  }

  public String getViewName() {
    return menu.getViewName();
  }

  public Menu navigate(int index) throws Exception {
    MenuName menuName = menu.navigate(index);
    Menu newMenu = getMenu(menuName);
    this.menu = newMenu;
    return newMenu;
  }
}
