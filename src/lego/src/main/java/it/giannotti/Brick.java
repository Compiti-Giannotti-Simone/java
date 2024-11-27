package it.giannotti;

public class Brick {

    //Attributes
    private int id, red, green, blue, x, y, z;
    private float weight;

    //Constructor method
    public Brick(int id, int red, int green, int blue, int x, int y, int z, float weight) {
        this.id = id;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.x = x;
        this.y = y;
        this.z = z;
        this.weight = weight;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Brick id=" + id + "\t red=" + red + "  \t green=" + green + "\t blue=" + blue + "\t x=" + x + "\t y=" + y
                + "\t z=" + z + "\t weight=" + weight;
    }
    


}
