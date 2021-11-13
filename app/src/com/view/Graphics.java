package com.view;

import com.controller.IController;
import com.controller.MenuController;
import com.util.TextFormatting;
import com.util.Texting;
import java.util.ArrayList;
import java.util.List;

public class Graphics {

  final int maxPageRecord = 2;

  MenuController menu;

  List<String> dataList;
  List<Integer> columnSizes;
  int index = 0;
  IController currentController;

  Graphics(MenuController menu) {
    this.menu = menu;
  }

  protected void mainMenuHeader() {
    System.out.println(
      "\n" +
      "    /////////////////////////\n" +
      "   _ __ ____    __ _ ___ _  _\n" +
      "  | |_ ` _  | / _ | /| | | | |\n" +
      "  | | | | | ||  __/| | | |_| |\n" +
      "  |_| |_| |_||___|_| |_|___ _|\n\n" +
      "    /////////////////////////\n\n" +
      "     SISTEMA DE EMPRESTIMOS\n" +
      "    E MANUTENCAO DE OBJETOS"
    );
  }

  protected void notImplementedScreen() {
    System.out.println(
      "\n" +
      menu.getMenuViewName().toUpperCase() +
      "\n" +
      "   __________________________\n" +
      "  |                          |\n" +
      "  |     NAO IMPLEMENTADO     |\n" +
      "  |                          |\n" +
      "  |                          |\n" +
      "   --------------------------\n" +
      Texting.backText +
      "\n"
    );
  }

  protected void displayNavigationOptions(
    List<String> optionList,
    String footerText
  ) {
    String text = ("   __________________________\n");

    for (int i = 0; i < optionList.size(); i++) {
      String option = optionList.get(i);
      option = "  | " + (i + 1) + " - " + option;
      option = TextFormatting.paddingRight(option, 29);
      option += "|\n";
      text += option;
    }
    text += "   --------------------------";

    System.out.println(text);
    if (footerText != null) System.out.println(
      footerText
    ); else System.out.println(Texting.backText);
    System.out.println();
  }

  protected void displayHeader() {
    System.out.println("\n-- " + menu.getMenuViewName().toUpperCase());
  }

  protected void displayRegisterOptions() {
    String text = (" ________________________________________________\n");
    text += "| (I) - Inserir | (C) - Editar | (X) - Excluir|\n";
    text += " ------------------------------------------------";
    System.out.println(text);
    System.out.println();
  }

  protected void displayRegisters(
    List<String> list,
    List<Integer> columnSizes,
    int index
  ) {
    this.dataList = list;
    if (columnSizes == null) {
      String[] columnText = this.dataList.get(0).split(";");
      columnSizes = new ArrayList<>();
      for (String string : columnText) {
        columnSizes.add(string.length() + 1);
      }
    }
    this.columnSizes = columnSizes;

    if (this.index == 0) this.index = index;
    displayRegistratedItems();
  }

  protected void paginateRegisters(int index) {
    this.index += index;
    displayRegistratedItems();
  }

  protected void displayRegistratedItems() {
    int lastPage = (int) Math.floor(
      ((dataList.size() - 2) / maxPageRecord) + 1
    );

    if (this.index > lastPage) this.index = lastPage;
    if (this.index < 1) this.index = 1;

    int pagination = (index * maxPageRecord) - maxPageRecord + 1;
    int maxPagination = pagination + maxPageRecord;
    if (dataList.size() < maxPagination) maxPagination = dataList.size();
    String text = "";
    String[] parts = dataList.get(0).split(";");
    for (int i = 0; i < parts.length; i++) {
      try {
        text +=
          "| " + TextFormatting.paddingRight(parts[i], columnSizes.get(i));
      } catch (Exception e) {
        System.out.println(Texting.invalidColumnSize);
      }
    }
    text += "|";
    System.out.println(text);

    text = "";
    for (int i = pagination; i < maxPagination; i++) {
      parts = dataList.get(i).split(";");
      for (int j = 0; j < parts.length; j++) {
        try {
          text +=
            "| " + TextFormatting.paddingRight(parts[j], columnSizes.get(j));
        } catch (Exception e) {
          System.out.println(Texting.invalidColumnSize);
        }
      }
      text += "|\n";
    }

    if (dataList.size() == 1) System.out.println(
      "\n" + Texting.noRecords + "\n"
    ); else System.out.println(text);
    System.out.println(
      "------------------------------------------------- Pag < (-) " +
      this.index +
      "/" +
      lastPage +
      " (+) >"
    );
    System.out.println();
    System.out.println(Texting.backText);
    System.out.println();
  }

  protected void splitterLine() {
    System.out.println();
    System.out.println(
      "---------------------------------------------------------------------"
    );
  }
}
