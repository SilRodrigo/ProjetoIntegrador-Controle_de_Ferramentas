package com.util;

public class Texting {

  public static final String registerSuccessful = "\nCadastrado com sucesso!";
  public static final String registerFailure =
    "\nDados invalidos para cadastro!";

  public static final String backText = " 0 - para Voltar";
  public static final String noRecords = "--Nada cadastrado ainda.";

  public static final String invalidColumnSize =
    "Tamanho da coluna não informado!";

  public static final String emptyRelyRegister(
    String relyName,
    String register
  ) {
    return (
      "\n\n\n\n\n\n\n\n ********************************************** \n" +
      "Nenhum " + relyName + " cadastrado ou disponível," +
      "\nVerifique antes de continuar o processo" +
      "\n ********************************************** "
    );
  }
}
