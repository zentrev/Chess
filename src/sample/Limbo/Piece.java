package sample.Limbo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//Pieces types and position
public class Piece {

    public enum Type {Pawn,Rook,Knight,Bishop,Queen,King}
    public enum Color{Black,White}

    int col;
    int row;
    Type worior;
    Color color;
    ImageView img;
    boolean firstMove;

    public Piece(Type type, int colum, int rows, Color cor){
        this.worior = type;
        this.col = colum;
        this.row = rows;
        this.color = cor;
        this.img = new ImageView (new Image(getClass().getResourceAsStream("/sample/Assets/Shit_Pawn.png")));
        this.firstMove = false;
    }


    public void setImg(){
        switch(this.worior){
            case Pawn:
                if(this.color.equals(Color.Black)) {
                    this.firstMove = true;
                    this.img = new ImageView (new Image(getClass().getResourceAsStream("/sample/Assets/blackPawn.png")));
                }else if(this.color.equals(Color.White)){
                    this.firstMove = true;
                    this.img = new ImageView (new Image(getClass().getResourceAsStream("/sample/Assets/whitePawn.png")));
                }
                break;
            case Rook:
                if(this.color.equals(Color.Black)) {
                    this.img = new ImageView (new Image(getClass().getResourceAsStream("/sample/Assets/blackRook.png")));
                }else if(this.color.equals(Color.White)){
                    this.img = new ImageView (new Image(getClass().getResourceAsStream("/sample/Assets/whiteRook.png")));
                }
                break;
            case Knight:
                if(this.color.equals(Color.Black)) {
                    this.img = new ImageView (new Image(getClass().getResourceAsStream("/sample/Assets/blackKnight.png")));
                }else if(this.color.equals(Color.White)){
                    this.img = new ImageView (new Image(getClass().getResourceAsStream("/sample/Assets/whiteKnight.png")));
                }
                break;
            case Bishop:
                if(this.color.equals(Color.Black)) {
                    this.img = new ImageView (new Image(getClass().getResourceAsStream("/sample/Assets/blackBishop.png")));
                }else if(this.color.equals(Color.White)){
                    this.img = new ImageView (new Image(getClass().getResourceAsStream("/sample/Assets/whiteBishop.png")));
                }
                break;
            case King:
                if(this.color.equals(Color.Black)) {
                    this.img = new ImageView (new Image(getClass().getResourceAsStream("/sample/Assets/blackKing.png")));
                }else if(this.color.equals(Color.White)){
                    this.img = new ImageView (new Image(getClass().getResourceAsStream("/sample/Assets/whiteKing.png")));
                }
                break;
            case Queen:
                if(this.color.equals(Color.Black)) {
                    this.img = new ImageView (new Image(getClass().getResourceAsStream("/sample/Assets/blackQueen.png")));
                }else if(this.color.equals(Color.White)){
                    this.img = new ImageView (new Image(getClass().getResourceAsStream("/sample/Assets/whiteQueen.png")));
                }
                break;
            default:
                this.img = new ImageView (new Image(getClass().getResourceAsStream("/sample/Assets/Shit_Pawn.png")));
        }
    }

    public ImageView getImg(){
        return img;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getPos(){
        return "("+this.col+":"+this.row+")";
    }

    public void setPos(int col, int row){
        this.col = col;
        this.row = row;
    }

    public Type getWorior() {
        return worior;
    }

    public void setWorior(Type worior) {
        this.worior = worior;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public static Type creatType(int i, Color col){
            switch (i) {
                case 0:
                case 7:
                    return Piece.Type.Rook;
                case 1:
                case 6:
                    return Piece.Type.Knight;
                case 2:
                case 5:
                    return Piece.Type.Bishop;
                case 3:
                    if(col.equals(Color.Black)){
                        return Piece.Type.King;
                    } else {
                        return Piece.Type.Queen;
                    }
                case 4:
                    if(col.equals(Color.Black)){
                        return Piece.Type.Queen;
                    } else {
                        return Piece.Type.King;
                    }
                default:
                    return Piece.Type.Pawn;
            }
    }

    public boolean getFirstMove(){
        return this.firstMove;
    }

    public void setFirstMove(boolean bool){
        this.firstMove = bool;
    }


}