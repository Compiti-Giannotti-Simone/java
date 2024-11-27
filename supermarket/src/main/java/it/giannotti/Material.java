package it.giannotti;

public enum Material {
    
    WOOD(false),
    METAL(false),
    GLASS(true),
    PLASTIC(true),
    PAPER(true);
    
    private boolean recyclable;

    private Material(boolean recyclable) {
        this.recyclable = recyclable;
    }

    public boolean isRecyclable() {
        return recyclable;
    }
}
