package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import uet.oop.bomberman.control.menu;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.control.Move;
import uet.oop.bomberman.graphics.createMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class BombermanGame extends Application {

    public static final int WIDTH = 25;//31;//20; // rộng
    public static final int HEIGHT = 15;//14; // dài
    public static int width = 0; // chieu rộng của mảng id_object, mảng này lưu trứ các đôi tượng tường, cỏ...
    public static int height = 0;// chieu dài của mảng id_object
    public static int level = 1;// level ban đầu =1 , được gọi lần đầu trong creatmap()
    public static final List<Entity> block = new ArrayList<>();     // Chứa các thực thể cố định
    public static char[][] id_objects; // mảng 2 chiều chứa ID của các đối tượng trên màn hình game.
    public static Animal player;
    public static boolean running;

    private GraphicsContext gc;

    private Canvas canvas; //CTN: sử duụng GraphicsContext và  Canvas để vẽ các đối tượng lên màn hình



    @Override
    public void start(Stage stage) {
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT); // khởi tạo canvas
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group(); // khởi tạo Group trống
        menu.createMenu(root);
        root.getChildren().add(canvas);


        Scene scene = new Scene(root);

        scene.setOnKeyReleased(event -> { // giữ phím
            if(player.isLife()) {
                switch (event.getCode()) {
                    case DOWN:
                        System.out.println("down");
                        Move.down(player);
                        break;
                    case UP:
                        System.out.println("up");
                        Move.up(player);
                        break;
                    case LEFT:
                        System.out.println("left");
                        Move.left(player);
                        break;
                    case RIGHT:
                        System.out.println("right");
                        Move.right(player);
                        break;
                    /** xử lý thêm các nút như space, esc ...*/
                    //default:
                      //  break;
                }
            }
        });

        // Thêm scene vao stage
        stage.setScene(scene);
        stage.show(); // hiển thị stage lên màn hình

        AnimationTimer timer = new AnimationTimer() { //CTN: cập nhật và hiển thị khung hình thường xuyên
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };
        timer.start();

        player = new Bomber(1, 2, Sprite.player_right_2.getFxImage());
        player.setLife(false);

    }

    /*public void createMap(){
        File file = new File("res/levels/level 1.txt").getAbsoluteFile();
        try (FileReader inputFile = new FileReader(file)) {     // Cố gắng tạo đối tượng mới từ lớp FileReader.
            Scanner ip = new Scanner(inputFile);                    // Tạo ip đối tượng từ class Scanner.
            String line = ip.nextLine();                            // Đầu vào dòng biến trong kiểu dữ liệu chuỗi.

            StringTokenizer tokens = new StringTokenizer(line);     // Tạo object token từ class StringTokenizer trong thư viện imported.

            //parseInt(): Phương thức phân tích cú pháp đối số chuỗi và trả về một int nguyên thủy.
            BombermanGame.level = Integer.parseInt(tokens.nextToken());   // To refer to variable level in main file.
            height = Integer.parseInt(tokens.nextToken());
            width = Integer.parseInt(tokens.nextToken());

            while (ip.hasNextLine()) {
                id_objects = new int[width][height];                 // Create new object id_object from main file.
              //  list_kill = new int[width][height];                  // Create new object lít_kill from main file.   Main file: RunBomberman.java
                for (int i = 0; i < height; ++i) {
                    String lineTile = ip.nextLine();                // Input variable lineTile in string data type.
                    StringTokenizer tokenTile = new StringTokenizer(lineTile);      // Create object tokenTile from class StringTokenizer in library imported.
                    for (int j = 0; j < width; j++) {
                       // int token = Integer.parseInt(tokenTile.nextToken());
                        char token = lineTile.charAt(j);

                        Entity entity;                              // Create object entity from class Entity.

                        // This switch statement running, and we got a full map for a game.
                        // Through the program, in the for-loop statement, we can get the map according to each loop it passed.
                        switch (token) {
//                            case 1:
//                                entity = new Portal(j, i, Sprite.grass.getFxImage());       // In case 1, set entity object equal to object portal with scaled size.
//                                token = 0;
//                                break;
                            case '#':
                                entity = new Wall(j, i, Sprite.wall.getFxImage());          // In case 2, set entity object equal to object wall with scaled size.
                                break;
                            case '*':
                                entity = new Brick(j, i, Sprite.brick.getFxImage());        // In case 3, set entity object equal to object brick with scaled size.
                                break;
//                            case 6:
//                                entity = new SpeedItem(j, i, Sprite.brick.getFxImage());
//                                break;
//                            case 7:
//                                entity = new FlameItem(j, i, Sprite.brick.getFxImage());
//                                break;
                            default:
                                entity = new Grass(j, i, Sprite.grass.getFxImage());
                        }
                        id_objects[j][i] = token;        //
                        block.add(entity);              //
                    }

                }
            }
        } catch (IOException e) {                       // Catch exception
            e.printStackTrace();                        // printStackTrace(): Help to understand where the problem is actually happening.
        }
    } */

    public void update() { //CTN: cập nhật thông tin mới nhất về các đối tượng
       // entities.forEach(Entity::update); //CTN: duyệt qua từng đối tượng trong entities
        block.forEach(Entity::update);
        player.update();

        player.setCountToRun(player.getCountToRun() + 1);
        if (player.getCountToRun() == 4) {
            Move.checkRun(player);
            player.setCountToRun(0);
        }

    }
    public void render() { //CTN: vẽ các đối tượng đã được cập nhật lên khung hình.
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()); //CTN: xóa bỏ khung hình trước đó
        block.forEach(g -> g.render(gc));
        //stillObjects.forEach(g -> g.render(gc)); //CTN:  vẽ đối tượng trong stillObjects
        //entities.forEach(g -> g.render(gc)); // CTN:vẽ đối tượng trong entities
        player.render(gc);
    }

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }
}



