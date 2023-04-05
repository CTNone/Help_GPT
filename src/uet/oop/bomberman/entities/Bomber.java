package uet.oop.bomberman.entities;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import uet.oop.bomberman.graphics.Sprite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Bomber extends Entity {

    public Bomber(int x, int y, Image img) {
        super( x, y, img);
    }
    private int direction; // Thuộc tính lưu giữ hướng di chuyển của Bomber sẽ được sd ở render
    private Image image; // Thuộc tính để lưu trữ hình ảnh của Bomber tại mỗi thời điểm

    public void moveUp(){

        y-=5;
        direction = 0; //len
    }
    public void moveDown(){
        y+=5;
        direction = 2; // xuong
    }
    public void moveLeft(){
        x-=5;
        direction = 3; // trai
    }
    public void moveRight(){
        x+=5;
        direction = 1; // phải
    }


    public void render(GraphicsContext gc) {
        switch (direction) {
            case 0:
                loadImageUp();
                break;
            case 1:
                loadImageRight();
                break;
            case 2:
                loadImageDown();
                break;
            case 3:
                loadImageLeft();
                break;
        }
        gc.drawImage( image, x, y );
    }

    public void loadImageUp() {
        image =  Sprite.player_up.getFxImage();
    }

    public void loadImageLeft() {
        image = Sprite.player_left.getFxImage();
    }

    public void loadImageRight() {
        image = Sprite.player_right.getFxImage();
    }
    public void loadImageDown() {
        image = Sprite.player_down.getFxImage();
    }

    @Override
    public void update() {

    }
}
