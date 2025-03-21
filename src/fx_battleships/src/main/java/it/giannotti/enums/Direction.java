package it.giannotti.enums;

public enum Direction {

    HORIZONTAL(true),
    VERTICAL(false);

    public final boolean IS_HORIZONTAL;

    private Direction(boolean b) {
        this.IS_HORIZONTAL = b;
    }
}
