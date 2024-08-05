package org.example.view;

import org.example.util.Color;
import org.example.util.Printer;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class PrintedItemView {

    public static void mainMenu() {
        Printer.println("\n\tWelcome!");
        Printer.println("Print Items Warehouse 0.1");
        Printer.println("Developed by Rakhimova Shokhista");
        Printer.println("Contacts: shokhista_rakhimova@student.itpu.uz");
        Printer.println("\tMenu:");
        Printer.println("1. Search 2. List all 0. Exit", Color.YELLOW);
        Printer.print(">>> ", Color.WHITE);

    }

    public static void printOptions(List<String> names) {
        int i = 1;
        for (String name : names) {
            Printer.println(i++ + ". " + name, Color.YELLOW);
        }
        Printer.println(i + ". Back", Color.YELLOW);
    }

    public static void wrongInputMessage() {
        Printer.println("You have out of the given options exception :) \n " +
                "Please, enter only 1,2 or 3 commands", Color.RED);
    }

    public static void enterValueOfParameterMessage(String parameterName) {
        Printer.print("Enter value for this parameter \"" + parameterName + "\" :", Color.PURPLE);
    }

    public static void printError(String text) {
        Printer.println(text, Color.RED);
    }

    public static void exitMessage() {
        Printer.println("Come back again to use our service", Color.PURPLE);
    }

    public static void printOptionsAndHelpText(List<String> keys) {
        int i = 1;
        for (String name : keys) {
            Printer.println(i++ + ". " + name, Color.YELLOW);
        }
        Printer.println("Enter only number which u wanna search categories");
        Printer.println("Ex: 1,2,4,6");
        Printer.print(">>> ", Color.WHITE);
    }

    public static void printResult(Collection<?> service) {
        int i = 1;
        for (Object item : service) {
            Printer.println(i++ + ". " + item, Color.YELLOW);
        }
    }
}
