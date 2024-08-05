package org.example.exception;

public class WrongInputException extends CustomException {
    public WrongInputException(String methodName) {
        this("You have out of the given options exception :)\n" +
                "Please, enter only 1,2 or 3 commands", methodName);
    }


    public WrongInputException(String text, String methodName) {
        super(text, methodName);
    }
}
