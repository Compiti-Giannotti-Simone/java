package it.giannotti.exceptions;

public class AlreadyAttackedException extends Exception {
    public AlreadyAttackedException(String msg) {
        super(msg);
    }
}
