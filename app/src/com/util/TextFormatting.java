package com.util;

public class TextFormatting {

  public static String paddingRight(String text, int length) {
    for (int i = text.length(); i < length; i++) {
      text = text + " ";
    }
    return text;
  }
}
