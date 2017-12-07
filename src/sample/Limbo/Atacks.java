package sample.Limbo;

import javafx.scene.control.Button;
import sample.Controller;

import java.util.Random;

import static sample.Controller.turn;
import static sample.Limbo.Piece.Type.King;
import static sample.Limbo.Piece.Type.Queen;
import static sample.Limbo.Piece.Type.Rook;

public class Atacks {

    public static int WhiteStr = 0;
    public static int BlackStr = 0;
    public static int WhiteDef = 0;
    public static int BlackDef = 0;
    public static int WhiteHeal = 0;
    public static int BlackHeal = 0;
    public static int WhiteAgl = 0;
    public static int BlackAgl = 0;
    public static int WhiteHealth = 0;
    public static int BlackHealth = 0;
    public static int WhitePawns = 8;
    public static int BlackPawns = 8;


    private static int dammage = 0;

    public static void setStats(Piece white, Piece black) {

        WhitePawns = 0;
        BlackPawns = 0;
        for (int i = 0; i < 16; i++) {
            if (Controller.WhitePieces[i].getWorior() == Piece.Type.Pawn && (Controller.WhitePieces[i].getCol() < 8)) {
                WhitePawns++;
            }
            if (Controller.BlackPieces[i].getWorior() == Piece.Type.Pawn && Controller.BlackPieces[i].getCol() < 8) {
                BlackPawns++;
            }
        }

        switch (white.getWorior()) {
            case Pawn:
                WhiteStr = 80 / WhitePawns;
                WhiteDef = 1;
                WhiteHeal = 10;
                WhiteAgl = 15;
                WhiteHealth = 80;
                break;
            case Rook:
                WhiteStr = 30;
                WhiteDef = 4;
                WhiteHeal = 8;
                WhiteAgl = 20;
                WhiteHealth = 100;
                break;
            case Knight:
                if(black.getWorior() == Queen && !turn){
                    WhiteStr = 60;
                    WhiteDef = 3;
                    WhiteHeal = 8;
                    WhiteAgl = 40;
                    WhiteHealth = 110;
                } else {
                    WhiteStr = 25;
                    WhiteDef = 2;
                    WhiteHeal = 5;
                    WhiteAgl = 20;
                    WhiteHealth = 90;
                }
                break;
            case Bishop:
                if(black.getWorior() == Rook){
                    WhiteStr = 50;
                    WhiteDef = 3;
                    WhiteHeal = 12;
                    WhiteAgl = 35;
                    WhiteHealth = 100;
                } else {
                    WhiteStr = 30;
                    WhiteDef = 2;
                    WhiteHeal = 10;
                    WhiteAgl = 25;
                    WhiteHealth = 100;
                }
                break;
            case Queen:
                if(black.getWorior() == King){
                    WhiteStr = 7 * WhitePawns;
                    WhiteDef = 2;
                    WhiteHeal = 10;
                    WhiteAgl = 15;
                    WhiteHealth = 100;
                } else {
                    WhiteStr = 8 * WhitePawns;
                    WhiteDef = 3;
                    WhiteHeal = 15;
                    WhiteAgl = 20;
                    WhiteHealth = 110;
                }
                break;
            case King:
                WhiteStr = 30;
                WhiteDef = 4;
                WhiteHeal = 10;
                WhiteAgl = 20;
                WhiteHealth = 120;
                break;
            default:
                System.out.println("Error while setting stats");
        }
        switch (black.getWorior()) {
            case Pawn:
                BlackStr = 80 / BlackPawns;
                BlackDef = 1;
                BlackHeal = 10;
                BlackAgl = 15;
                BlackHealth = 80;
                break;
            case Rook:
                BlackStr = 30;
                BlackDef = 4;
                BlackHeal = 8;
                BlackAgl = 20;
                BlackHealth = 100;
                break;
            case Knight:
                if(white.getWorior() == Queen && turn){
                    BlackStr = 60;
                    BlackDef = 3;
                    BlackHeal = 8;
                    BlackAgl = 40;
                    BlackHealth = 110;
                } else {
                    BlackStr = 25;
                    BlackDef = 2;
                    BlackHeal = 5;
                    BlackAgl = 20;
                    BlackHealth = 90;
                }
                break;
            case Bishop:
                if(white.getWorior() == Rook){
                    BlackStr = 50;
                    BlackDef = 3;
                    BlackHeal = 12;
                    BlackAgl = 35;
                    BlackHealth = 100;
                } else {
                    BlackStr = 30;
                    BlackDef = 2;
                    BlackHeal = 10;
                    BlackAgl = 25;
                    BlackHealth = 100;
                }
                break;
            case Queen:
                if(white.getWorior() == King){
                    BlackStr = 7 * BlackPawns;
                    BlackDef = 2;
                    BlackHeal = 10;
                    BlackAgl = 15;
                    BlackHealth = 100;
                } else {
                    BlackStr = 8 * BlackPawns;
                    BlackDef = 3;
                    BlackHeal = 15;
                    BlackAgl = 20;
                    BlackHealth = 110;
                }
                break;
            case King:
                BlackStr = 30;
                BlackDef = 4;
                BlackHeal = 10;
                BlackAgl = 20;
                BlackHealth = 120;
                break;
            default:
                System.out.println("Error while setting stats");
        }
    }
    



    public static int Atack(Button button, Piece wor){


        Random r = new Random();

        if (wor.getColor().equals(Piece.Color.White)) {
                switch (button.getText()){
                    case "Melee":
                        switch (wor.getWorior()){
                            case Pawn:
                            case Queen:
                            case Knight:
                            case Bishop:
                            case King:
                                dammage = (r.nextInt((WhiteStr))+1)/(r.nextInt(BlackDef)+1);
                                break;
                        }
                        break;
                    case "Ranged":
                        switch(wor.getWorior()){
                            case Pawn:
                            case Rook:
                            case Knight:
                            case Bishop:
                            case Queen:
                            case King:
                                dammage = (r.nextInt((WhiteAgl))+(WhiteAgl/2))/(r.nextInt(BlackDef)+1);
                                break;
                        }
                        break;
                    case "Defend":
                        switch (wor.getWorior()){
                            case Rook:
                                WhiteDef += (r.nextInt((BlackDef))+1);
                                dammage = 0;
                                break;
                            case Knight:
                                if(BlackDef > 1) {
                                    BlackDef--;
                                }
                                dammage = 0;
                                break;
                            case Pawn:
                            case Bishop:
                            case Queen:
                            case King:
                                WhiteDef++;
                                dammage = 0;
                                break;
                        }
                        break;
                    case "Heal":
                        switch (wor.getWorior()){
                            case Pawn:
                            case Rook:
                            case Knight:
                            case Bishop:
                            case Queen:
                            case King:
                                WhiteHealth += (r.nextInt((WhiteHeal))+1)*2;
                                if (WhiteHeal > 1) {
                                    WhiteHeal--;
                                }
                                dammage = 0;
                                break;
                                default:
                                    System.out.println("Error in attack");
                        }
                        break;
                }
        }
        if (wor.getColor().equals(Piece.Color.Black)) {
            switch (button.getText()) {
                case "Melee":
                    switch (wor.getWorior()) {
                        case Pawn:
                        case Queen:
                        case Knight:
                        case Bishop:
                        case King:
                            dammage = (r.nextInt((BlackStr)) + 1) / (r.nextInt(WhiteDef) + 1);
                            break;
                    }
                    break;
                case "Ranged":
                    switch (wor.getWorior()) {
                        case Pawn:
                        case Rook:
                        case Knight:
                        case Bishop:
                        case Queen:
                        case King:
                            dammage = (r.nextInt((BlackAgl)) + (BlackAgl/2)) / (r.nextInt(WhiteDef) + 1);
                            break;
                    }
                    break;
                case "Defend":
                    switch (wor.getWorior()) {
                        case Rook:
                            BlackDef += (r.nextInt((WhiteDef)) + 1);
                            dammage = 0;
                            break;
                        case Knight:
                            if (WhiteDef > 1) {
                                WhiteDef--;
                            }
                            dammage = 0;
                            break;
                        case Pawn:
                        case Bishop:
                        case Queen:
                        case King:
                            BlackDef++;
                            dammage = 0;
                            break;
                    }
                    break;
                case "Heal":
                    switch (wor.getWorior()) {
                        case Pawn:
                        case Rook:
                        case Knight:
                        case Bishop:
                        case Queen:
                        case King:
                            BlackHealth += (r.nextInt((BlackHeal)) + 1)*2;
                            if(BlackHeal > 1) {
                                BlackHeal--;
                            }
                            dammage = 0;
                            break;
                        default:
                            System.out.println("Error in attack");
                    }
                    break;
            }
        }
        return dammage;
    }

    public static int getWhiteHealth(){
        return WhiteHealth;
    }
    public static void setWhiteHelath(int pain){
        WhiteHealth -= pain;
    }
    public static int getBlackHealth(){
        return BlackHealth;
    }
    public static void setBlackHealth(int pain){
        BlackHealth -= pain;
    }

}
