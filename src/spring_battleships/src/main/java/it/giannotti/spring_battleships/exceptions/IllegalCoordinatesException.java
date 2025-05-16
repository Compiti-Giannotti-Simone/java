package it.giannotti.spring_battleships.exceptions;

public class IllegalCoordinatesException extends Exception {
    public IllegalCoordinatesException(String msg) {
        super(msg);
    }
}
