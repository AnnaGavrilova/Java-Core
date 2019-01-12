package Exceptions;

import Dialoges.ExceptionQuantity;

public class TeamException extends Exception {

    public TeamException(String text) {
        super(text);
        ExceptionQuantity.errorBox(text, "ОШИБКА");
    }
}
