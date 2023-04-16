package uet.oop.bomberman.graphics;

import static uet.oop.bomberman.BombermanGame.*;
import uet.oop.bomberman.BombermanGame;

import uet.oop.bomberman.entities.Brick;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Grass;
import uet.oop.bomberman.entities.Wall;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class createMap {
    public createMap(String level) {
        System.out.println(System.getProperty("user.dir"));
        final File fileName = new File(level);                      // Create object fileName from class File in File library imported.
        try (FileReader inputFile = new FileReader(fileName)) {     // Try to create new object from class FileReader.
            Scanner ip = new Scanner(inputFile);                    // Create object ip from class Scanner.
            String line = ip.nextLine();                            // Input variable line in string data type.

            StringTokenizer tokens = new StringTokenizer(line);     // Create object tokens from class StringTokenizer in library imported.

            //parseInt(): trả về một int nguyên thủy.
            BombermanGame.level = Integer.parseInt(tokens.nextToken());   // To refer to variable level in main file.
            height = Integer.parseInt(tokens.nextToken());
            width = Integer.parseInt(tokens.nextToken());
            id_objects = new char[width][height];                 // Create new object id_object from main file.
            for(int i = 0; i < height; i++) {
                Arrays.fill(id_objects[i], ' ');
            }

            while (ip.hasNextLine()) {

                for (int i = 0; i < height; ++i) {
                    String lineTile = ip.nextLine();                // Input variable lineTile in string data type.
                    StringTokenizer tokenTile = new StringTokenizer(lineTile);      // Create object tokenTile from class StringTokenizer in library imported.

                    for (int j = 0; j < width; j++) {
                        //char token = lineTile.charAt(j);
                        char token = ' ';
                        if (j < lineTile.length()) {
                            token = lineTile.charAt(j);
                        }

//                    int j= 0;
//                    for(char token : lineTile.toCharArray()){  // for( int j =0; j< width; j++ )
                        Entity entity;                              // Create object entity from class Entity.
                        System.out.print(token);

                        // Câu lệnh chuyển đổi này đang chạy và chúng tôi đã có một bản đồ đầy đủ cho một trò chơi.
                        // lấy bản đồ theo từng vòng lặp mà nó đi qua.
                        switch (token) {
                            case '#':
                                entity = new Wall(j, i, Sprite.wall.getFxImage());          // In case 2, set entity object equal to object wall with scaled size.
                                break;
                            case '*':
                                entity = new Brick(j, i, Sprite.brick.getFxImage());        // In case 3, set entity object equal to object brick with scaled size.
                                break;
                            default:
                                entity = new Grass(j, i, Sprite.grass.getFxImage());
                        }
                        id_objects[j][i] = token;        //
                        block.add(entity);
                     //   j++;
                    }
                       System.out.println();
                }
            }
        } catch (IOException e) {                       // Catch exception
            e.printStackTrace();                        // printStackTrace(): Help to understand where the problem is actually happening.
        }
    }

}
