package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

public abstract class Animal extends  Entity{
    protected int is_move;        // jump with pixel
    protected int swap;           // swap image
    protected String direction;   // hướng đi của player
    protected int count;          // count step of a jump
    protected int count_to_run;   // run after count frame
    protected boolean life;       // kiểm tra sống

    public Animal(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public Animal(int is_move, int swap, String direction, int count, int count_to_run) {
        this.is_move = is_move;
        this.swap = swap;
        this.direction = direction;
        this.count = count;
        this.count_to_run = count_to_run;
    }

    public Animal(boolean life) {
        this.life = life;
    }

    public Animal() {

    }

    public boolean isLife() {
        return life;
    }

    public void setLife(boolean life) {
        this.life = life;
    }

    public int getIsMove() {
        return is_move;
    }

    public void setIsMove(int is_move) {
        this.is_move = is_move;
    }

    public int getSwap() {
        return swap;
    }

    public void setSwap(int swap) {
        this.swap = swap;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCountToRun() {
        return count_to_run;
    }

    public void setCountToRun(int count_to_run) {
        this.count_to_run = count_to_run;
    }

    @Override
    public void update() {

    }
}
