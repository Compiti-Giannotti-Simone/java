package it.giannotti.spring_battleships.exceptions;

public class AlreadyPlacedException extends Exception {
    public AlreadyPlacedException(String msg) {
        super(msg);
    }
}
