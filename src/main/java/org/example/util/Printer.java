package org.example.util;

public class Printer {
    public static void print(String text) {
        print(text, Color.BLUE);
    }

    public static void print(String text, String color) {
        System.out.print(color + text + Color.RESET);
    }
    public static void println(String text) {
        println(text, Color.BLUE);
    }

    public static void println(String text, String color) {
        System.out.println(color + text + Color.RESET);
    }
}
