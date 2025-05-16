package it.giannotti.spring_battleships.exceptions;

public class AlreadyAttackedException extends Exception {
    public AlreadyAttackedException(String msg) {
        super(msg);
    }
}
