package it.giannotti;

import java.util.Random;

public class Product {
    
    private int id;
    private int brickCount;
    private Brick[] bricks;

    //constructor
    public Product(int id) {
        this.id = id;
        bricks = new Brick[150];
        brickCount = 0;
    }

    //methods
    public void addBrick(Brick brick) {
        bricks[brickCount] = brick;
        brickCount++;
    }

    public void generateBricks(int amount) {
        Random random = new Random();
        for(int i = 0;i<amount;i++) {
            int id = random.nextInt(50);
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);
            int x = random.nextInt(1000);
            int y = random.nextInt(1000);
            int z = random.nextInt(1000);
            float w = random.nextFloat(1000);
            Brick brick = new Brick(id, r, g, b, x, y, z, w);
            addBrick(brick);
        }
    }

    public float totalWeight() {
        int temp = 0;
        for(int i = 0;i<brickCount;i++) {
            temp+=bricks[i].getWeight();
        }
        return temp;
    }

    public void listBricksColor(int r, int g, int b) {
        for(int i = 0;i<brickCount;i++) {
            if(bricks[i].getRed() == r && bricks[i].getGreen() == g && bricks[i].getBlue() == b) printBrick(i);
        }
    }

    public int countBricksWithId(int id) {
        int temp=0;
        for(int i = 0;i<brickCount;i++) {
            if(bricks[i].getId() == id) temp++;
        }
        return temp;
    }

    public void listBricks() {
        for(int i = 0;i<brickCount;i++) {
            printBrick(i);
        }
    }

    public void printBrick(int index) {
        System.out.println(bricks[index].toString());
    }

    public int getBrickCount() {
        return brickCount;
    }

}
