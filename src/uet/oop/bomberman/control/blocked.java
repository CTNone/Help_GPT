package uet.oop.bomberman.control;

import uet.oop.bomberman.entities.Entity;
import static uet.oop.bomberman.BombermanGame.*;
public class blocked {

    public static boolean block_down(Entity entity) {   //Tạo một khối ngăn chặn tất cả mob đi xuống thông qua đối tượng
        /** nếu ô vuông không chứa đối tượng nào: ( == 0) trả về true
         *
         */
        System.out.println("4");
        return id_objects[entity.getX() / 32][entity.getY() / 32 + 1] == ' ';
    }

    public static boolean block_up(Entity entity) {     //Create a blocked that prevent all mob go up through the object
        System.out.println("2");
        return id_objects[entity.getX() / 32][entity.getY() / 32 - 1] == ' ';
    }

    public static boolean block_left(Entity entity) {   //Create a blocked that prevent all mob go left through the object
        System.out.println("1");
        return id_objects[entity.getX() / 32 - 1][entity.getY() / 32] == ' ';
    }

    public static boolean block_right(Entity entity) {   //Create a blocked that prevent all mob go right through the object
        System.out.println("3");
        return id_objects[entity.getX() / 32 + 1][entity.getY() / 32] == ' ';
    }
}