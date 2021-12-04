package com.view;

import com.controller.ClienteController;
import com.controller.EmprestimoController;
import com.controller.ManutencaoController;
import com.controller.MenuController;
import com.controller.ObjetoController;
import com.controller.TipoObjetoController;
import com.controller.UserController;
import java.util.ArrayList;
import java.util.Arrays;

public class Screen {

  UserController user;
  MenuController menu;

  ClienteController cliente = new ClienteController();
  TipoObjetoController tipoObjeto = new TipoObjetoController();
  ObjetoController objeto = new ObjetoController();
  ManutencaoController manutencao = new ManutencaoController();
  EmprestimoController emprestimo = new EmprestimoController();
  Graphics graphics;
  Navigation navigation;

  public Screen(UserController user, MenuController menu) {
    this.user = user;
    this.menu = menu;
    this.graphics = new Graphics(menu);
    this.navigation = new Navigation(menu);
  }

  public boolean render() {
    switch (menu.getMenuName()) {
      case MAIN:
        mainMenu();
        break;
      /* ------------------------------------- */
      case CADASTROS:
        cadastroMenu();
        break;
      /* ------------------------------------- */
      case CADASTRO_CLIENTE:
        cadastroClienteMenu();
        break;
      /* ------------------------------------- */
      case CADASTRO_TIPO_OBJETO:
        cadastroTipoObjetoMenu();
        break;
      /* ------------------------------------- */
      case CADASTRO_OBJETO:
        cadastroObjetoMenu();
        break;
      /* ------------------------------------- */
      case EMPRESTIMO:
        emprestimoMenu();
        break;
      /* ------------------------------------- */
      case MANUTENCAO:
        manutencaoMenu();
        break;
      /* ------------------------------------- */
      default:
        notImplementedMenu();
        break;
    }
    return false;
  }

  private void mainMenu() {
    graphics.mainMenuHeader();
    graphics.displayNavigationOptions(
      new ArrayList<String>(
        Arrays.asList("Cadastros", "Emprestimos", "Manutencao")
      ),
      "    0 - para Sair"
    );
    if (navigation.navigate()) user.setLogged(false);
  }

  private void cadastroMenu() {
    graphics.splitterLine();
    graphics.displayHeader();
    graphics.displayNavigationOptions(
      new ArrayList<String>(
        Arrays.asList("Cliente", "Tipo de Objetos", "Objetos")
      ),
      null
    );
    navigation.navigate();
  }

  private void cadastroClienteMenu() {
    graphics.splitterLine();
    graphics.displayHeader();
    graphics.displayRegisterOptions();
    graphics.displayRegisters(
      cliente.getAll(),
      Arrays.asList(5, 20, 20, 10),
      1
    );
    navigation.registerNavigation(cliente, null, graphics);
  }

  private void cadastroTipoObjetoMenu() {
    graphics.splitterLine();
    graphics.displayHeader();
    graphics.displayRegisterOptions();
    graphics.displayRegisters(tipoObjeto.getAll(), Arrays.asList(5, 20), 1);
    navigation.registerNavigation(tipoObjeto, null, graphics);
  }

  private void cadastroObjetoMenu() {
    graphics.splitterLine();
    graphics.displayHeader();
    graphics.displayRegisterOptions();
    graphics.displayRegisters(
      objeto.getAll(),
      Arrays.asList(5, 15, 20, 10, 15, 10),
      1
    );
    navigation.registerNavigation(objeto, Arrays.asList(tipoObjeto), graphics);
  }

  private void emprestimoMenu() {
    graphics.splitterLine();
    graphics.displayHeader();
    graphics.displayRegisterOptions();
    graphics.displayReportOption();
    graphics.displayRegisters(
      emprestimo.getAll(objeto, cliente),
      Arrays.asList(5, 25, 25, 15, 15, 10),
      1
    );
    navigation.registerNavigation(
      emprestimo,
      Arrays.asList(objeto, cliente),
      graphics
    );
  }

  private void manutencaoMenu() {
    graphics.splitterLine();
    graphics.displayHeader();
    graphics.displayRegisterOptions();
    graphics.displayRegisters(
      manutencao.getAll(),
      Arrays.asList(5, 15, 15, 15),
      1
    );
    navigation.registerNavigation(manutencao, Arrays.asList(objeto), graphics);
  }

  private void notImplementedMenu() {
    graphics.notImplementedScreen();
    navigation.navigate();
  }
}
