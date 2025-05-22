package it.giannotti.spring_battleships.exceptions;

public class NotYourTurnException extends Exception {
    public NotYourTurnException(String message) {
        super(message);
    }
}
