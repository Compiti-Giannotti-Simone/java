package it.giannotti.spring_battleships.exceptions;

public class InvalidShipException extends Exception {
    public InvalidShipException(String msg) {
        super(msg);
    }
}
