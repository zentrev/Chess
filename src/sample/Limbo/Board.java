package sample.Limbo;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//Creates board
public class Board{

    enum cooler {Black,White}

    static cooler[][] defu = new cooler[8][8];
    public static Rectangle[][] rec = new Rectangle[8][8];

    public void CreatBoard (GridPane Board) {
        for (int x = 0; x < 8; x++) {
            for (int j = 0; j < 8; j++) {
                rec[x][j] = new Rectangle(70,70);

                if ((x + j) % 2 == 1) {
                    rec[x][j].setFill(Color.web("424242"));
                    defu[x][j] = cooler.Black;
                } else {
                    rec[x][j].setFill(Color.WHITESMOKE);
                    defu[x][j] = cooler.White;
                }

                Board.add(rec[x][j],x,j);
            }
        }
    }

    public static void reset (){
        for (int x = 0; x < 8; x++) {
            for (int j = 0; j < 8; j++) {
                if ((x + j) % 2 == 1) {
                    rec[x][j].setFill(Color.web("424242"));
                    defu[x][j] = cooler.Black;
                } else {
                    rec[x][j].setFill(Color.WHITESMOKE);
                    defu[x][j] = cooler.White;
                }
            }
        }
    }

}
