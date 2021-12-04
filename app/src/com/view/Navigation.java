package com.view;

import com.controller.Entrada;
import com.controller.IController;
import com.controller.MenuController;
import com.util.Texting;
import java.util.ArrayList;
import java.util.List;

public class Navigation {

  final String chooseOption = "Digite a opcao desejada: ";
  final String chooseNumberText = "Digite o numero da opcao: ";

  MenuController menu;
  Graphics navGraphics = new Graphics(menu);

  public Navigation(MenuController menu) {
    this.menu = menu;
  }

  protected boolean navigate() {
    int selected = Entrada.leiaInt(chooseNumberText);
    return menu.navigate(selected);
  }

  private void backToParentMenu() {
    navGraphics.index = 0;
    menu.navigate(0);
  }

  protected void registerNavigation(
    IController controller,
    List<IController> relyMenus,
    Graphics graphics
  ) {
    char input = Entrada.leiaChar(chooseOption);
    switch (input) {
      case '0':
        backToParentMenu();
        break;
      case 'I':
      case 'i':
        if (relyMenus == null) {
          insertNavigation(controller);
        } else {
          insertNavigationRelying(controller, relyMenus);
        }
        break;
      case 'E':
      case 'e':
        editNavegation(controller);
      case 'X':
      case 'x':
        excludeNavegation(controller);
      case '+':
        graphics.paginateRegisters(1);
        break;
      case '-':
        graphics.paginateRegisters(-1);
        break;
      default:
        break;
    }
  }

  private void insertNavigation(IController controller) {
    System.out.println("Novo " + menu.getMenuViewName() + "\n");
    String[] fields = controller.requestInsert();
    List<String> register = new ArrayList<>();
    for (int i = 1; i < fields.length; i++) {
      String consoleInput = String.valueOf(
        Entrada.leiaString("Digite o " + fields[i] + ": ")
      );
      register.add(consoleInput);
    }
    System.out.println(controller.insert(register));
    Entrada.leiaString("Aperte ENTER para continuar...");
  }

  private void insertNavigationRelying(
    IController controller,
    List<IController> relyRegisters
  ) {
    System.out.println("Novo " + menu.getMenuViewName() + "\n");
    String[] fields = controller.requestInsert();
    List<String> register = new ArrayList<>();
    for (int i = 1; i < fields.length; i++) {
      String consoleInput;
      Boolean cont = false;
      for (int j = 0; j < relyRegisters.size(); j++) {
        IController relyRegister = relyRegisters.get(j);
        if (
          relyRegister
            .getControllerBaseName()
            .equals(fields[i] + controller.getControllerBaseName())
        ) {
          System.out.println(" **********************************************");
          List<String> relyItems = relyRegister.getAvailable();
          if (relyItems.size() == 1) {
            System.out.println(
              Texting.emptyRelyRegister(
                relyRegister.getControllerBaseName(),
                controller.getControllerBaseName()
              )
            );
            Entrada.leiaString("Aperte ENTER para continuar...");
            return;
          }
          System.out.println(
            "\n\nCONSULTA DE " +
            relyRegister.getControllerBaseName().toUpperCase()
          );
          navGraphics.displayRegisters(relyRegister.getAvailable(), null, 1);
          System.out.println(
            "\n\n **********************************************"
          );
          consoleInput = menuRelyingNavigation(relyRegister);
          if (
            consoleInput.equals("0") ||
            !relyRegister.findId(Integer.parseInt(consoleInput))
          ) return; else register.add(consoleInput);
          cont = true;
        }
        if (cont) break;
      }
      if (cont) continue;
      consoleInput =
        String.valueOf(Entrada.leiaString("Digite o " + fields[i] + ": "));
      register.add(consoleInput);
    }
    System.out.println(controller.insert(register));
    Entrada.leiaString("Aperte ENTER para continuar...");
  }

  private String menuRelyingNavigation(IController relyRegister) {
    while (true) {
      String input = Entrada.leiaString(
        "Digite o Id do " + relyRegister.getControllerBaseName() + ": "
      );
      switch (input) {
        case "+":
          navGraphics.paginateRegisters(1);
          continue;
        case "-":
          navGraphics.paginateRegisters(-1);
          continue;
        case "0":
          return input;
        default:
          try {
            Integer.parseInt(input);
            return input;
          } catch (Exception e) {
            break;
          }
      }
    }
  }

  private void editNavegation(IController controller) {
    int consoleInput = Entrada.leiaInt("Digite o id para editar: ");
    List<String> response = controller.requestEdit(consoleInput);
    if (response.size() == 0) {
      System.out.println("Id inválido!");
      Entrada.leiaString("Aperte ENTER para continuar...");
      return;
    }
    String[] header = response.get(0).split(";");
    String[] editItem = response.get(1).split(";");
    System.out.println("---");
    for (int i = 0; i < header.length; i++) {
      System.out.println(
        "(" + (i + 1) + ") - " + header[i] + ": " + editItem[i]
      );
    }
    System.out.println("---");
    System.out.println("0 - Cancelar");
    System.out.println("");
    int index = Entrada.leiaInt("Digite o numero que deseja editar: ");
    switch (consoleInput) {
      case 0:
        return;
      default:
        Boolean updated = controller.update(
          consoleInput,
          index,
          Entrada.leiaString("Digite o novo valor do campo: ")
        );
        if (updated) System.out.println(
          "Atualizado com Sucesso!"
        ); else System.out.println("Erro na atualizacao do cadastro!");
    }
    return;
  }

  private void excludeNavegation(IController controller) {
    int consoleInput = Entrada.leiaInt("Digite o id que deseja excluir: ");
    String response = controller.delete(consoleInput);
    System.out.println(response);
  }
}
