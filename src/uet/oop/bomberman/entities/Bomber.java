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

public class Bomber extends Animal {

    private int direction; // Thuộc tính lưu giữ hướng di chuyển của Bomber sẽ được sd ở render
    private Image image;

    public Bomber(int is_move, int swap, String direction, int count, int count_to_run) {
        super(8, 1, "down", 0, 0);
    }
    public Bomber(int x, int y, Image img) {
        super(x, y, img);
    }
    public Bomber() { }


  /*  public void moveUp(){

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


   */

  /*  public void render(GraphicsContext gc) {
        switch (direction) {
            case 0:
                if( y % 3 == 0) loadImageUp();
                if( y % 3 == 1) loadImageUp1();
                if( y % 3 == 2) loadImageUp2();
                break;
            case 1:

                if( x% 3 == 0 ) loadImageRight();
                if( x% 3 == 1 ) loadImageRight1();
                if( x% 3 == 2 ) loadImageRight2();
                break;
            case 2:
                if( y % 3 == 0) loadImageDown();
                if( y % 3 == 1) loadImageDown1();
                if( y % 3 == 2) loadImageDown2();
                break;
            case 3:

                if( x % 3 == 0) loadImageLeft();
                if( x % 3 == 1) loadImageLeft1();
                if( x % 3 == 2) loadImageLeft1();
                break;
        }
        System.out.println(x+ " "+ y);
        gc.drawImage( image, x, y );

    }

    public void loadImageUp() {
        image =  Sprite.player_up.getFxImage();
    }
    public void loadImageUp1() {
        image =  Sprite.player_up_1.getFxImage();
    }
    public void loadImageUp2() {
        image =  Sprite.player_up_2.getFxImage();
    }

    public void loadImageLeft() {
        image = Sprite.player_left.getFxImage();
    }
    public void loadImageLeft1() {
        image = Sprite.player_left_1.getFxImage();
    }
    public void loadImageLeft2() {
        image = Sprite.player_left_2.getFxImage();
    }

    public void loadImageRight() {
        image = Sprite.player_right.getFxImage();
    }
    public void loadImageRight1() {
        image = Sprite.player_right_1.getFxImage();
    }
    public void loadImageRight2() {
        image = Sprite.player_right_2.getFxImage();
    }
    public void loadImageDown() {
        image = Sprite.player_down.getFxImage();
    }
    public void loadImageDown1() {
        image = Sprite.player_down_1.getFxImage();
    }
    public void loadImageDown2() {
        image = Sprite.player_down_2.getFxImage();
    }

   */
    

    @Override
    public void update() {

    }


}
