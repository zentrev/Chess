package sample.Limbo;
import javafx.scene.paint.Color;
import sample.Controller;

import static sample.Limbo.Board.rec;

//List of movement options according to piece type
public class MoveList {

    public static boolean WhitePawn(int pawn) {
        boolean north = false;
        boolean south = false;
        boolean east = true;
        boolean first = true;
        if(Controller.WhitePieces[pawn].getCol() == 7){
            Controller.swaping = true;
            return true;
        }
        for (int i = 0; i < 16; i++) {
            if(Controller.WhitePieces[pawn].getFirstMove()){
                if (Controller.BlackPieces[i].getCol() == (Controller.WhitePieces[pawn].getCol() + 2) && Controller.BlackPieces[i].getRow() == Controller.WhitePieces[pawn].getRow()) {
                    first = false;
                }
                if (Controller.WhitePieces[i].getCol() == (Controller.WhitePieces[pawn].getCol() + 2) && Controller.WhitePieces[i].getRow() == Controller.WhitePieces[pawn].getRow()) {
                    first = false;
                }
            }else{
                first = false;
            }
            if (Controller.BlackPieces[i].getCol() == (Controller.WhitePieces[pawn].getCol() + 1) && Controller.BlackPieces[i].getRow() == (Controller.WhitePieces[pawn].getRow() + 1)) {
                south = true;
            }
            if (Controller.BlackPieces[i].getCol() == (Controller.WhitePieces[pawn].getCol() + 1) && Controller.BlackPieces[i].getRow() == (Controller.WhitePieces[pawn].getRow() - 1)) {
                north = true;
            }
            if (Controller.BlackPieces[i].getCol() == (Controller.WhitePieces[pawn].getCol() + 1) && Controller.BlackPieces[i].getRow() == Controller.WhitePieces[pawn].getRow()) {
                east = false;
            }
            if (Controller.WhitePieces[i].getCol() == (Controller.WhitePieces[pawn].getCol() + 1) && Controller.WhitePieces[i].getRow() == Controller.WhitePieces[pawn].getRow()) {
                east = false;
            }
        }
        if (south) {
            rec[Controller.WhitePieces[pawn].getCol() + 1][Controller.WhitePieces[pawn].getRow() + 1].setFill(Color.BLUE);
        }
        if (north) {
            rec[Controller.WhitePieces[pawn].getCol() + 1][Controller.WhitePieces[pawn].getRow() - 1].setFill(Color.BLUE);
        }
        if (east) {
            if ((Controller.WhitePieces[pawn].getCol() + 1) < 8) {
                rec[Controller.WhitePieces[pawn].getCol() + 1][Controller.WhitePieces[pawn].getRow()].setFill(Color.BLUE);
            }
        }
        if (first && east){
            if ((Controller.WhitePieces[pawn].getCol() + 2) < 8) {
                rec[Controller.WhitePieces[pawn].getCol() + 2][Controller.WhitePieces[pawn].getRow()].setFill(Color.BLUE);
                Controller.WhitePieces[pawn].setFirstMove(false);

            }
        }
        if (east == false && north == false && south == false) {
            return false;
        } else {
            return true;
        }
    }
    public static boolean BlackPawn(int pawn) {
        boolean north = false;
        boolean south = false;
        boolean east = true;
        boolean first = true;
        if (Controller.BlackPieces[pawn].getCol() == 0){
            Controller.swaping = true;
            return true;
        }

        for (int i = 0; i < 16; i++) {

            if(Controller.BlackPieces[pawn].getFirstMove()){
                if (Controller.WhitePieces[i].getCol() == (Controller.BlackPieces[pawn].getCol() - 2) && Controller.WhitePieces[i].getRow() == Controller.BlackPieces[pawn].getRow()) {
                    first = false;
                }
                if (Controller.BlackPieces[i].getCol() == (Controller.BlackPieces[pawn].getCol() - 2) && Controller.BlackPieces[i].getRow() == Controller.BlackPieces[pawn].getRow()) {
                    first = false;
                }
            }else{
                first = false;
            }

            if ((Controller.BlackPieces[pawn].getCol() - 1) == (Controller.WhitePieces[i].getCol()) && (Controller.BlackPieces[pawn].getRow() + 1) == (Controller.WhitePieces[i].getRow())) {
                south = true;
            }
            if ((Controller.BlackPieces[pawn].getCol() - 1) == (Controller.WhitePieces[i].getCol()) && (Controller.BlackPieces[pawn].getRow() - 1) == (Controller.WhitePieces[i].getRow())) {
                north = true;
            }
            if ((Controller.BlackPieces[pawn].getCol() - 1) == (Controller.WhitePieces[i].getCol()) && Controller.BlackPieces[pawn].getRow() == Controller.WhitePieces[i].getRow()) {
                east = false;
            }
            if ((Controller.BlackPieces[pawn].getCol() - 1) == (Controller.BlackPieces[i].getCol()) && Controller.BlackPieces[pawn].getRow() == Controller.BlackPieces[i].getRow()) {
                east = false;
            }
        }

        if (south) {
            rec[Controller.BlackPieces[pawn].getCol() - 1][Controller.BlackPieces[pawn].getRow() + 1].setFill(Color.BLUE);
        }
        if (north) {
            rec[Controller.BlackPieces[pawn].getCol() - 1][Controller.BlackPieces[pawn].getRow() - 1].setFill(Color.BLUE);
        }
        if (east) {
            if ((Controller.BlackPieces[pawn].getCol() - 1) >= 0) {
                rec[Controller.BlackPieces[pawn].getCol() - 1][Controller.BlackPieces[pawn].getRow()].setFill(Color.BLUE);
            }
        }
        if (first && east){
            if ((Controller.BlackPieces[pawn].getCol() - 2) >= 0) {
                rec[Controller.BlackPieces[pawn].getCol() - 2][Controller.BlackPieces[pawn].getRow()].setFill(Color.BLUE);
                Controller.BlackPieces[pawn].setFirstMove(false);

            }
        }

        if (east == false && north == false && south == false) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean WhiteRook(int rook) {
        boolean north = false;
        boolean south = false;
        boolean east = false;
        boolean west = false;
        boolean northContact = false;
        boolean southContact = false;
        boolean eastContact = false;
        boolean westContact = false;

        for (int i = 1; i < 8; i++) {
            for (int j = 0; j < 16; j++) {
                if (((Controller.WhitePieces[j].getCol()) == (Controller.WhitePieces[rook].getCol() + i)) && (Controller.WhitePieces[j].getRow()) == Controller.WhitePieces[rook].getRow()) {
                    eastContact = true;
                }
                if ((Controller.BlackPieces[j].getCol() == (Controller.WhitePieces[rook].getCol() + i - 1)) && Controller.BlackPieces[j].getRow() == Controller.WhitePieces[rook].getRow()) {
                    eastContact = true;
                }

                if (((Controller.WhitePieces[j].getCol()) == (Controller.WhitePieces[rook].getCol() - i)) && (Controller.WhitePieces[j].getRow()) == Controller.WhitePieces[rook].getRow()) {
                    westContact = true;
                }
                if ((Controller.BlackPieces[j].getCol() == (Controller.WhitePieces[rook].getCol() - i + 1)) && Controller.BlackPieces[j].getRow() == Controller.WhitePieces[rook].getRow()) {
                    westContact = true;
                }

                if (((Controller.WhitePieces[j].getCol()) == (Controller.WhitePieces[rook].getCol())) && (Controller.WhitePieces[j].getRow()) == Controller.WhitePieces[rook].getRow() + i) {
                    southContact = true;
                }
                if ((Controller.BlackPieces[j].getCol() == (Controller.WhitePieces[rook].getCol())) && Controller.BlackPieces[j].getRow() == Controller.WhitePieces[rook].getRow() + i - 1) {
                    southContact = true;
                }

                if (((Controller.WhitePieces[j].getCol()) == (Controller.WhitePieces[rook].getCol())) && (Controller.WhitePieces[j].getRow()) == Controller.WhitePieces[rook].getRow() - i) {
                    northContact = true;
                }
                if ((Controller.BlackPieces[j].getCol() == (Controller.WhitePieces[rook].getCol())) && Controller.BlackPieces[j].getRow() == Controller.WhitePieces[rook].getRow() - i + 1) {
                    northContact = true;
                }
            }
            if (!eastContact && Controller.WhitePieces[rook].getCol() + i < 8) {
                east = true;
                rec[Controller.WhitePieces[rook].getCol() + i][Controller.WhitePieces[rook].getRow()].setFill(Color.BLUE);
            }
            if (!westContact && Controller.WhitePieces[rook].getCol() - i >= 0) {
                west = true;
                rec[Controller.WhitePieces[rook].getCol() - i][Controller.WhitePieces[rook].getRow()].setFill(Color.BLUE);
            }
            if (!southContact && Controller.WhitePieces[rook].getRow() + i < 8) {
                south = true;
                rec[Controller.WhitePieces[rook].getCol()][Controller.WhitePieces[rook].getRow() + i].setFill(Color.BLUE);
            }
            if (!northContact && Controller.WhitePieces[rook].getRow() - i >= 0) {
                north = true;
                rec[Controller.WhitePieces[rook].getCol()][Controller.WhitePieces[rook].getRow() - i].setFill(Color.BLUE);
            }
        }
        if (east == false && north == false && south == false && west == false) {
            return false;
        } else {
            return true;
        }
    }
    public static boolean BlackRook(int rook) {
        boolean north = false;
        boolean south = false;
        boolean east = false;
        boolean west = false;
        boolean northContact = false;
        boolean southContact = false;
        boolean eastContact = false;
        boolean westContact = false;

        for (int i = 1; i < 8; i++) {
            for (int j = 0; j < 16; j++) {
                if (((Controller.BlackPieces[j].getCol()) == (Controller.BlackPieces[rook].getCol() + i)) && (Controller.BlackPieces[j].getRow()) == Controller.BlackPieces[rook].getRow()) {
                    eastContact = true;
                }
                if ((Controller.WhitePieces[j].getCol() == (Controller.BlackPieces[rook].getCol() + i - 1)) && Controller.WhitePieces[j].getRow() == Controller.BlackPieces[rook].getRow()) {
                    eastContact = true;
                }

                if (((Controller.BlackPieces[j].getCol()) == (Controller.BlackPieces[rook].getCol() - i)) && (Controller.BlackPieces[j].getRow()) == Controller.BlackPieces[rook].getRow()) {
                    westContact = true;
                }
                if ((Controller.WhitePieces[j].getCol() == (Controller.BlackPieces[rook].getCol() - i + 1)) && Controller.WhitePieces[j].getRow() == Controller.BlackPieces[rook].getRow()) {
                    westContact = true;
                }

                if (((Controller.BlackPieces[j].getCol()) == (Controller.BlackPieces[rook].getCol())) && (Controller.BlackPieces[j].getRow()) == Controller.BlackPieces[rook].getRow() + i) {
                    southContact = true;
                }
                if ((Controller.WhitePieces[j].getCol() == (Controller.BlackPieces[rook].getCol())) && Controller.WhitePieces[j].getRow() == Controller.BlackPieces[rook].getRow() + i - 1) {
                    southContact = true;
                }

                if (((Controller.BlackPieces[j].getCol()) == (Controller.BlackPieces[rook].getCol())) && (Controller.BlackPieces[j].getRow()) == Controller.BlackPieces[rook].getRow() - i) {
                    northContact = true;
                }
                if ((Controller.WhitePieces[j].getCol() == (Controller.BlackPieces[rook].getCol())) && Controller.WhitePieces[j].getRow() == Controller.BlackPieces[rook].getRow() - i + 1) {
                    northContact = true;
                }
            }
            if (!eastContact && Controller.BlackPieces[rook].getCol() + i < 8) {
                east = true;
                rec[Controller.BlackPieces[rook].getCol() + i][Controller.BlackPieces[rook].getRow()].setFill(Color.BLUE);
            }
            if (!westContact && Controller.BlackPieces[rook].getCol() - i >= 0) {
                west = true;
                rec[Controller.BlackPieces[rook].getCol() - i][Controller.BlackPieces[rook].getRow()].setFill(Color.BLUE);
            }
            if (!southContact && Controller.BlackPieces[rook].getRow() + i < 8) {
                south = true;
                rec[Controller.BlackPieces[rook].getCol()][Controller.BlackPieces[rook].getRow() + i].setFill(Color.BLUE);
            }
            if (!northContact && Controller.BlackPieces[rook].getRow() - i >= 0) {
                north = true;
                rec[Controller.BlackPieces[rook].getCol()][Controller.BlackPieces[rook].getRow() - i].setFill(Color.BLUE);
            }
        }
        if (east == false && north == false && south == false && west == false) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean WhiteKnight(int knight) {
        boolean one = false;
        boolean two = false;
        boolean three = false;
        boolean four = false;
        boolean five = false;
        boolean six = false;
        boolean seven = false;
        boolean eight = false;
        boolean onem = false;
        boolean twom = false;
        boolean threem = false;
        boolean fourm = false;
        boolean fivem = false;
        boolean sixm = false;
        boolean sevenm = false;
        boolean eightm = false;

        for (int i = 0; i < 16; i++) {
            if (Controller.WhitePieces[i].getCol() == (Controller.WhitePieces[knight].getCol() + 1) && Controller.WhitePieces[i].getRow() == (Controller.WhitePieces[knight].getRow() + 2)) {
                one = true;
            }
            if (Controller.WhitePieces[i].getCol() == (Controller.WhitePieces[knight].getCol() + 1) && Controller.WhitePieces[i].getRow() == (Controller.WhitePieces[knight].getRow() - 2)) {
                two = true;
            }
            if (Controller.WhitePieces[i].getCol() == (Controller.WhitePieces[knight].getCol() + 2) && Controller.WhitePieces[i].getRow() == (Controller.WhitePieces[knight].getRow() + 1)) {
                three = true;
            }
            if (Controller.WhitePieces[i].getCol() == (Controller.WhitePieces[knight].getCol() + 2) && Controller.WhitePieces[i].getRow() == (Controller.WhitePieces[knight].getRow() - 1)) {
                four = true;
            }
            if (Controller.WhitePieces[i].getCol() == (Controller.WhitePieces[knight].getCol() - 1) && Controller.WhitePieces[i].getRow() == (Controller.WhitePieces[knight].getRow() + 2)) {
                five = true;
            }
            if (Controller.WhitePieces[i].getCol() == (Controller.WhitePieces[knight].getCol() - 1) && Controller.WhitePieces[i].getRow() == (Controller.WhitePieces[knight].getRow() - 2)) {
                six = true;
            }
            if (Controller.WhitePieces[i].getCol() == (Controller.WhitePieces[knight].getCol() - 2) && Controller.WhitePieces[i].getRow() == (Controller.WhitePieces[knight].getRow() + 1)) {
                seven = true;
            }
            if (Controller.WhitePieces[i].getCol() == (Controller.WhitePieces[knight].getCol() - 2) && Controller.WhitePieces[i].getRow() == (Controller.WhitePieces[knight].getRow() - 1)) {
                eight = true;
            }

        }

        if (!one && (Controller.WhitePieces[knight].getCol()+1 < 8) && (Controller.WhitePieces[knight].getRow()+2 < 8)) {
            onem = true;
            rec[Controller.WhitePieces[knight].getCol() + 1][Controller.WhitePieces[knight].getRow() + 2].setFill(Color.BLUE);
        }
        if (!two && (Controller.WhitePieces[knight].getCol()+1 < 8) && (Controller.WhitePieces[knight].getRow()-2 >= 0)) {
            twom = true;
            rec[Controller.WhitePieces[knight].getCol() + 1][Controller.WhitePieces[knight].getRow() - 2].setFill(Color.BLUE);
        }
        if (!three && (Controller.WhitePieces[knight].getCol()+2 < 8) && (Controller.WhitePieces[knight].getRow()+1 < 8)) {
            threem = true;
            rec[Controller.WhitePieces[knight].getCol() + 2][Controller.WhitePieces[knight].getRow() + 1].setFill(Color.BLUE);
        }
        if (!four && (Controller.WhitePieces[knight].getCol()+2 < 8) && (Controller.WhitePieces[knight].getRow()-1 >= 0)) {
            fourm = true;
            rec[Controller.WhitePieces[knight].getCol() + 2][Controller.WhitePieces[knight].getRow() - 1].setFill(Color.BLUE);
        }
        if (!five && (Controller.WhitePieces[knight].getCol()-1 >= 0) && (Controller.WhitePieces[knight].getRow()+2 < 8)) {
            fivem = true;
            rec[Controller.WhitePieces[knight].getCol() -1][Controller.WhitePieces[knight].getRow() +2].setFill(Color.BLUE);
        }
        if (!six && (Controller.WhitePieces[knight].getCol()-1 >= 0) && (Controller.WhitePieces[knight].getRow()-2 >=0)) {
            sixm = true;
            rec[Controller.WhitePieces[knight].getCol() -1][Controller.WhitePieces[knight].getRow() -2].setFill(Color.BLUE);
        }
        if (!seven && (Controller.WhitePieces[knight].getCol()-2 >= 0) && (Controller.WhitePieces[knight].getRow()+1 < 8 )) {
            sevenm = true;
            rec[Controller.WhitePieces[knight].getCol() -2][Controller.WhitePieces[knight].getRow() +1].setFill(Color.BLUE);
        }
        if (!eight && (Controller.WhitePieces[knight].getCol()-2 >= 0) && (Controller.WhitePieces[knight].getRow()-1 >=0)) {
            eightm = true;
            rec[Controller.WhitePieces[knight].getCol() -2][Controller.WhitePieces[knight].getRow() -1].setFill(Color.BLUE);
        }

        if (onem == false && twom == false && threem == false && fourm == false && fivem == false && sixm == false && sevenm == false && eightm == false) {
            return false;
        } else {
            return true;
        }
    }
    public static boolean BlackKnight(int knight) {
        boolean one = false;
        boolean two = false;
        boolean three = false;
        boolean four = false;
        boolean five = false;
        boolean six = false;
        boolean seven = false;
        boolean eight = false;
        boolean onem = false;
        boolean twom = false;
        boolean threem = false;
        boolean fourm = false;
        boolean fivem = false;
        boolean sixm = false;
        boolean sevenm = false;
        boolean eightm = false;

        for (int i = 0; i < 16; i++) {
            if (Controller.BlackPieces[i].getCol() == (Controller.BlackPieces[knight].getCol() + 1) && Controller.BlackPieces[i].getRow() == (Controller.BlackPieces[knight].getRow() + 2)) {
                one = true;
            }
            if (Controller.BlackPieces[i].getCol() == (Controller.BlackPieces[knight].getCol() + 1) && Controller.BlackPieces[i].getRow() == (Controller.BlackPieces[knight].getRow() - 2)) {
                two = true;
            }
            if (Controller.BlackPieces[i].getCol() == (Controller.BlackPieces[knight].getCol() + 2) && Controller.BlackPieces[i].getRow() == (Controller.BlackPieces[knight].getRow() + 1)) {
                three = true;
            }
            if (Controller.BlackPieces[i].getCol() == (Controller.BlackPieces[knight].getCol() + 2) && Controller.BlackPieces[i].getRow() == (Controller.BlackPieces[knight].getRow() - 1)) {
                four = true;
            }
            if (Controller.BlackPieces[i].getCol() == (Controller.BlackPieces[knight].getCol() - 1) && Controller.BlackPieces[i].getRow() == (Controller.BlackPieces[knight].getRow() + 2)) {
                five = true;
            }
            if (Controller.BlackPieces[i].getCol() == (Controller.BlackPieces[knight].getCol() - 1) && Controller.BlackPieces[i].getRow() == (Controller.BlackPieces[knight].getRow() - 2)) {
                six = true;
            }
            if (Controller.BlackPieces[i].getCol() == (Controller.BlackPieces[knight].getCol() - 2) && Controller.BlackPieces[i].getRow() == (Controller.BlackPieces[knight].getRow() + 1)) {
                seven = true;
            }
            if (Controller.BlackPieces[i].getCol() == (Controller.BlackPieces[knight].getCol() - 2) && Controller.BlackPieces[i].getRow() == (Controller.BlackPieces[knight].getRow() - 1)) {
                eight = true;
            }

        }

        if (!one && (Controller.BlackPieces[knight].getCol()+1 < 8) && (Controller.BlackPieces[knight].getRow()+2 < 8)) {
            onem = true;
            rec[Controller.BlackPieces[knight].getCol() + 1][Controller.BlackPieces[knight].getRow() + 2].setFill(Color.BLUE);
        }
        if (!two && (Controller.BlackPieces[knight].getCol()+1 < 8) && (Controller.BlackPieces[knight].getRow()-2 >= 0)) {
            twom = true;
            rec[Controller.BlackPieces[knight].getCol() + 1][Controller.BlackPieces[knight].getRow() - 2].setFill(Color.BLUE);
        }
        if (!three && (Controller.BlackPieces[knight].getCol()+2 < 8) && (Controller.BlackPieces[knight].getRow()+1 < 8)) {
            threem = true;
            rec[Controller.BlackPieces[knight].getCol() + 2][Controller.BlackPieces[knight].getRow() + 1].setFill(Color.BLUE);
        }
        if (!four && (Controller.BlackPieces[knight].getCol()+2 < 8) && (Controller.BlackPieces[knight].getRow()-1 >= 0)) {
            fourm = true;
            rec[Controller.BlackPieces[knight].getCol() + 2][Controller.BlackPieces[knight].getRow() - 1].setFill(Color.BLUE);
        }
        if (!five && (Controller.BlackPieces[knight].getCol()-1 >= 0) && (Controller.BlackPieces[knight].getRow()+2 < 8)) {
            fivem = true;
            rec[Controller.BlackPieces[knight].getCol() -1][Controller.BlackPieces[knight].getRow() +2].setFill(Color.BLUE);
        }
        if (!six && (Controller.BlackPieces[knight].getCol()-1 >= 0) && (Controller.BlackPieces[knight].getRow()-2 >=0)) {
            sixm = true;
            rec[Controller.BlackPieces[knight].getCol() -1][Controller.BlackPieces[knight].getRow() -2].setFill(Color.BLUE);
        }
        if (!seven && (Controller.BlackPieces[knight].getCol()-2 >= 0) && (Controller.BlackPieces[knight].getRow()+1 < 8 )) {
            sevenm = true;
            rec[Controller.BlackPieces[knight].getCol() -2][Controller.BlackPieces[knight].getRow() +1].setFill(Color.BLUE);
        }
        if (!eight && (Controller.BlackPieces[knight].getCol()-2 >= 0) && (Controller.BlackPieces[knight].getRow()-1 >=0)) {
            eightm = true;
            rec[Controller.BlackPieces[knight].getCol() -2][Controller.BlackPieces[knight].getRow() -1].setFill(Color.BLUE);
        }

        if (onem == false && twom == false && threem == false && fourm == false && fivem == false && sixm == false && sevenm == false && eightm == false) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean WhiteBishop(int bishop) {
        boolean north = false;
        boolean south = false;
        boolean east = false;
        boolean west = false;
        boolean northContact = false;
        boolean southContact = false;
        boolean eastContact = false;
        boolean westContact = false;

        for(int i = 1; i < 8; i++){
            for(int j = 0; j < 16; j++) {
                if (((Controller.WhitePieces[j].getCol()) == (Controller.WhitePieces[bishop].getCol() + i)) && (Controller.WhitePieces[j].getRow()) == Controller.WhitePieces[bishop].getRow() + i) {
                    eastContact = true;
                }
                if ((Controller.BlackPieces[j].getCol() == (Controller.WhitePieces[bishop].getCol() + i - 1)) && Controller.BlackPieces[j].getRow() == Controller.WhitePieces[bishop].getRow() +i -1) {
                    eastContact = true;
                }

                if (((Controller.WhitePieces[j].getCol()) == (Controller.WhitePieces[bishop].getCol() - i)) && (Controller.WhitePieces[j].getRow()) == Controller.WhitePieces[bishop].getRow() - i) {
                    westContact = true;
                }
                if ((Controller.BlackPieces[j].getCol() == (Controller.WhitePieces[bishop].getCol() - i + 1)) && Controller.BlackPieces[j].getRow() == Controller.WhitePieces[bishop].getRow() - i + 1) {
                    westContact = true;
                }

                if (((Controller.WhitePieces[j].getCol()) == (Controller.WhitePieces[bishop].getCol()) - i) && (Controller.WhitePieces[j].getRow()) == Controller.WhitePieces[bishop].getRow() + i) {
                    southContact = true;
                }
                if ((Controller.BlackPieces[j].getCol() == (Controller.WhitePieces[bishop].getCol() - i + 1)) && Controller.BlackPieces[j].getRow() == Controller.WhitePieces[bishop].getRow() + i - 1) {
                    southContact = true;
                }

                if (((Controller.WhitePieces[j].getCol()) == (Controller.WhitePieces[bishop].getCol()) + i) && (Controller.WhitePieces[j].getRow()) == Controller.WhitePieces[bishop].getRow() - i) {
                    northContact = true;
                }
                if ((Controller.BlackPieces[j].getCol() == (Controller.WhitePieces[bishop].getCol()) + i - 1) && Controller.BlackPieces[j].getRow() == Controller.WhitePieces[bishop].getRow() - i + 1) {
                    northContact = true;
                }
            }
            if (!eastContact && Controller.WhitePieces[bishop].getCol() + i < 8 && Controller.WhitePieces[bishop].getRow() + i < 8 ) {
                east = true;
                rec[Controller.WhitePieces[bishop].getCol() + i][Controller.WhitePieces[bishop].getRow() + i].setFill(Color.BLUE);
            }
            if (!westContact && Controller.WhitePieces[bishop].getCol() - i >= 0 && Controller.WhitePieces[bishop].getRow() - i >= 0 ) {
                west = true;
                rec[Controller.WhitePieces[bishop].getCol() - i][Controller.WhitePieces[bishop].getRow() - i].setFill(Color.BLUE);
            }
            if (!southContact && Controller.WhitePieces[bishop].getCol() - i >= 0 && Controller.WhitePieces[bishop].getRow() + i < 8 ) {
                south = true;
                rec[Controller.WhitePieces[bishop].getCol() - i][Controller.WhitePieces[bishop].getRow() + i].setFill(Color.BLUE);
            }
            if (!northContact && Controller.WhitePieces[bishop].getCol() + i < 8 && Controller.WhitePieces[bishop].getRow() - i >= 0 ) {
                north = true;
                rec[Controller.WhitePieces[bishop].getCol() + i][Controller.WhitePieces[bishop].getRow()-i].setFill(Color.BLUE);
            }
        }
        if(east == false && north == false && south == false && west == false){
            return false;
        } else {
            return true;
        }
    }
    public static boolean BlackBishop(int bishop) {
        boolean north = false;
        boolean south = false;
        boolean east = false;
        boolean west = false;
        boolean northContact = false;
        boolean southContact = false;
        boolean eastContact = false;
        boolean westContact = false;

        for(int i = 1; i < 8; i++){
            for(int j = 0; j < 16; j++) {
                if (((Controller.BlackPieces[j].getCol()) == (Controller.BlackPieces[bishop].getCol() + i)) && (Controller.BlackPieces[j].getRow()) == Controller.BlackPieces[bishop].getRow() + i) {
                    eastContact = true;
                }
                if ((Controller.WhitePieces[j].getCol() == (Controller.BlackPieces[bishop].getCol() + i - 1)) && Controller.WhitePieces[j].getRow() == Controller.BlackPieces[bishop].getRow() +i -1) {
                    eastContact = true;
                }

                if (((Controller.BlackPieces[j].getCol()) == (Controller.BlackPieces[bishop].getCol() - i)) && (Controller.BlackPieces[j].getRow()) == Controller.BlackPieces[bishop].getRow() - i) {
                    westContact = true;
                }
                if ((Controller.WhitePieces[j].getCol() == (Controller.BlackPieces[bishop].getCol() - i + 1)) && Controller.WhitePieces[j].getRow() == Controller.BlackPieces[bishop].getRow() - i + 1) {
                    westContact = true;
                }

                if (((Controller.BlackPieces[j].getCol()) == (Controller.BlackPieces[bishop].getCol()) - i) && (Controller.BlackPieces[j].getRow()) == Controller.BlackPieces[bishop].getRow() + i) {
                    southContact = true;
                }
                if ((Controller.WhitePieces[j].getCol() == (Controller.BlackPieces[bishop].getCol() - i + 1)) && Controller.WhitePieces[j].getRow() == Controller.BlackPieces[bishop].getRow() + i - 1) {
                    southContact = true;
                }

                if (((Controller.BlackPieces[j].getCol()) == (Controller.BlackPieces[bishop].getCol()) + i) && (Controller.BlackPieces[j].getRow()) == Controller.BlackPieces[bishop].getRow() - i) {
                    northContact = true;
                }
                if ((Controller.WhitePieces[j].getCol() == (Controller.BlackPieces[bishop].getCol()) + i - 1) && Controller.WhitePieces[j].getRow() == Controller.BlackPieces[bishop].getRow() - i + 1) {
                    northContact = true;
                }
            }
            if (!eastContact && Controller.BlackPieces[bishop].getCol() + i < 8 && Controller.BlackPieces[bishop].getRow() + i < 8 ) {
                east = true;
                rec[Controller.BlackPieces[bishop].getCol() + i][Controller.BlackPieces[bishop].getRow() + i].setFill(Color.BLUE);
            }
            if (!westContact && Controller.BlackPieces[bishop].getCol() - i >= 0 && Controller.BlackPieces[bishop].getRow() - i >= 0 ) {
                west = true;
                rec[Controller.BlackPieces[bishop].getCol() - i][Controller.BlackPieces[bishop].getRow() - i].setFill(Color.BLUE);
            }
            if (!southContact && Controller.BlackPieces[bishop].getCol() - i >= 0 && Controller.BlackPieces[bishop].getRow() + i < 8 ) {
                south = true;
                rec[Controller.BlackPieces[bishop].getCol() - i][Controller.BlackPieces[bishop].getRow() + i].setFill(Color.BLUE);
            }
            if (!northContact && Controller.BlackPieces[bishop].getCol() + i < 8 && Controller.BlackPieces[bishop].getRow() - i >= 0 ) {
                north = true;
                rec[Controller.BlackPieces[bishop].getCol() + i][Controller.BlackPieces[bishop].getRow()-i].setFill(Color.BLUE);
            }
        }
        if(east == false && north == false && south == false && west == false){
            return false;
        } else {
            return true;
        }
    }

    public static boolean WhiteKing(int king){
        boolean one = false;
        boolean two = false;
        boolean three = false;
        boolean four = false;
        boolean five = false;
        boolean six = false;
        boolean seven = false;
        boolean eight = false;
        boolean onem = false;
        boolean twom = false;
        boolean threem = false;
        boolean fourm = false;
        boolean fivem = false;
        boolean sixm = false;
        boolean sevenm = false;
        boolean eightm = false;

        for (int i = 0; i < 16; i++) {
            if (Controller.WhitePieces[i].getCol() == (Controller.WhitePieces[king].getCol() + 1) && Controller.WhitePieces[i].getRow() == (Controller.WhitePieces[king].getRow())) {
                one = true;
                
            }
            if (Controller.WhitePieces[i].getCol() == (Controller.WhitePieces[king].getCol() + 1) && Controller.WhitePieces[i].getRow() == (Controller.WhitePieces[king].getRow() - 1)) {
                two = true;
                
            }
            if (Controller.WhitePieces[i].getCol() == (Controller.WhitePieces[king].getCol() + 1) && Controller.WhitePieces[i].getRow() == (Controller.WhitePieces[king].getRow() + 1)) {
                three = true;
                
            }
            if (Controller.WhitePieces[i].getCol() == (Controller.WhitePieces[king].getCol()) && Controller.WhitePieces[i].getRow() == (Controller.WhitePieces[king].getRow() - 1)) {
                four = true;
                
            }
            if (Controller.WhitePieces[i].getCol() == (Controller.WhitePieces[king].getCol()) && Controller.WhitePieces[i].getRow() == (Controller.WhitePieces[king].getRow() + 1)) {
                five = true;
                
            }
            if (Controller.WhitePieces[i].getCol() == (Controller.WhitePieces[king].getCol() - 1) && Controller.WhitePieces[i].getRow() == (Controller.WhitePieces[king].getRow() - 1)) {
                six = true;
                
            }
            if (Controller.WhitePieces[i].getCol() == (Controller.WhitePieces[king].getCol() - 1) && Controller.WhitePieces[i].getRow() == (Controller.WhitePieces[king].getRow() + 1)) {
                seven = true;
                
            }
            if (Controller.WhitePieces[i].getCol() == (Controller.WhitePieces[king].getCol() - 1) && Controller.WhitePieces[i].getRow() == (Controller.WhitePieces[king].getRow())) {
                eight = true;
                
            }

        }

        if (!one && (Controller.WhitePieces[king].getCol()+1 < 8)) {
            onem = true;
            rec[Controller.WhitePieces[king].getCol() + 1][Controller.WhitePieces[king].getRow() ].setFill(Color.BLUE);
        }
        if (!two && (Controller.WhitePieces[king].getCol()+1 < 8) && (Controller.WhitePieces[king].getRow()-1 >= 0)) {
            twom = true;
            rec[Controller.WhitePieces[king].getCol() + 1][Controller.WhitePieces[king].getRow() - 1].setFill(Color.BLUE);
        }
        if (!three && (Controller.WhitePieces[king].getCol()+1 < 8) && (Controller.WhitePieces[king].getRow()+1 < 8)) {
            threem = true;
            rec[Controller.WhitePieces[king].getCol() + 1][Controller.WhitePieces[king].getRow() + 1].setFill(Color.BLUE);
        }
        if (!four && (Controller.WhitePieces[king].getRow()-1 >= 0)) {
            fourm = true;
            rec[Controller.WhitePieces[king].getCol()][Controller.WhitePieces[king].getRow() - 1].setFill(Color.BLUE);
        }
        if (!five && (Controller.WhitePieces[king].getRow()+1 < 8)) {
            fivem = true;
            rec[Controller.WhitePieces[king].getCol() ][Controller.WhitePieces[king].getRow() +1].setFill(Color.BLUE);
        }
        if (!six && (Controller.WhitePieces[king].getCol()-1 >= 0) && (Controller.WhitePieces[king].getRow()-1 >=0)) {
            sixm = true;
            rec[Controller.WhitePieces[king].getCol() -1][Controller.WhitePieces[king].getRow() -1].setFill(Color.BLUE);
        }
        if (!seven && (Controller.WhitePieces[king].getCol()-1 >= 0) && (Controller.WhitePieces[king].getRow()+1 < 8 )) {
            sevenm = true;
            rec[Controller.WhitePieces[king].getCol() -1][Controller.WhitePieces[king].getRow() +1].setFill(Color.BLUE);
        }
        if (!eight && (Controller.WhitePieces[king].getCol()-1 >= 0) ) {
            eightm = true;
            rec[Controller.WhitePieces[king].getCol() -1][Controller.WhitePieces[king].getRow()].setFill(Color.BLUE);
        }

        if (onem == false && twom == false && threem == false && fourm == false && fivem == false && sixm == false && sevenm == false && eightm == false) {
            return false;
        } else {
            return true;
        }

    }
    public static boolean BlackKing(int king){
        boolean one = false;
        boolean two = false;
        boolean three = false;
        boolean four = false;
        boolean five = false;
        boolean six = false;
        boolean seven = false;
        boolean eight = false;
        boolean onem = false;
        boolean twom = false;
        boolean threem = false;
        boolean fourm = false;
        boolean fivem = false;
        boolean sixm = false;
        boolean sevenm = false;
        boolean eightm = false;

        for (int i = 0; i < 16; i++) {
            if (Controller.BlackPieces[i].getCol() == (Controller.BlackPieces[king].getCol() + 1) && Controller.BlackPieces[i].getRow() == (Controller.BlackPieces[king].getRow())) {
                one = true;
                
            }
            if (Controller.BlackPieces[i].getCol() == (Controller.BlackPieces[king].getCol() + 1) && Controller.BlackPieces[i].getRow() == (Controller.BlackPieces[king].getRow() - 1)) {
                two = true;
                
            }
            if (Controller.BlackPieces[i].getCol() == (Controller.BlackPieces[king].getCol() + 1) && Controller.BlackPieces[i].getRow() == (Controller.BlackPieces[king].getRow() + 1)) {
                three = true;
                
            }
            if (Controller.BlackPieces[i].getCol() == (Controller.BlackPieces[king].getCol()) && Controller.BlackPieces[i].getRow() == (Controller.BlackPieces[king].getRow() - 1)) {
                four = true;
                
            }
            if (Controller.BlackPieces[i].getCol() == (Controller.BlackPieces[king].getCol()) && Controller.BlackPieces[i].getRow() == (Controller.BlackPieces[king].getRow() + 1)) {
                five = true;
                
            }
            if (Controller.BlackPieces[i].getCol() == (Controller.BlackPieces[king].getCol() - 1) && Controller.BlackPieces[i].getRow() == (Controller.BlackPieces[king].getRow() - 1)) {
                six = true;
                
            }
            if (Controller.BlackPieces[i].getCol() == (Controller.BlackPieces[king].getCol() - 1) && Controller.BlackPieces[i].getRow() == (Controller.BlackPieces[king].getRow() + 1)) {
                seven = true;
                
            }
            if (Controller.BlackPieces[i].getCol() == (Controller.BlackPieces[king].getCol() - 1) && Controller.BlackPieces[i].getRow() == (Controller.BlackPieces[king].getRow())) {
                eight = true;
                
            }

        }

        if (!one && (Controller.BlackPieces[king].getCol()+1 < 8)) {
            onem = true;
            rec[Controller.BlackPieces[king].getCol() + 1][Controller.BlackPieces[king].getRow() ].setFill(Color.BLUE);
        }
        if (!two && (Controller.BlackPieces[king].getCol()+1 < 8) && (Controller.BlackPieces[king].getRow()-1 >= 0)) {
            twom = true;
            rec[Controller.BlackPieces[king].getCol() + 1][Controller.BlackPieces[king].getRow() - 1].setFill(Color.BLUE);
        }
        if (!three && (Controller.BlackPieces[king].getCol()+1 < 8) && (Controller.BlackPieces[king].getRow()+1 < 8)) {
            threem = true;
            rec[Controller.BlackPieces[king].getCol() + 1][Controller.BlackPieces[king].getRow() + 1].setFill(Color.BLUE);
        }
        if (!four && (Controller.BlackPieces[king].getRow()-1 >= 0)) {
            fourm = true;
            rec[Controller.BlackPieces[king].getCol()][Controller.BlackPieces[king].getRow() - 1].setFill(Color.BLUE);
        }
        if (!five && (Controller.BlackPieces[king].getRow()+1 < 8)) {
            fivem = true;
            rec[Controller.BlackPieces[king].getCol() ][Controller.BlackPieces[king].getRow() +1].setFill(Color.BLUE);
        }
        if (!six && (Controller.BlackPieces[king].getCol()-1 >= 0) && (Controller.BlackPieces[king].getRow()-1 >=0)) {
            sixm = true;
            rec[Controller.BlackPieces[king].getCol() -1][Controller.BlackPieces[king].getRow() -1].setFill(Color.BLUE);
        }
        if (!seven && (Controller.BlackPieces[king].getCol()-1 >= 0) && (Controller.BlackPieces[king].getRow()+1 < 8 )) {
            sevenm = true;
            rec[Controller.BlackPieces[king].getCol() -1][Controller.BlackPieces[king].getRow() +1].setFill(Color.BLUE);
        }
        if (!eight && (Controller.BlackPieces[king].getCol()-1 >= 0) ) {
            eightm = true;
            rec[Controller.BlackPieces[king].getCol() -1][Controller.BlackPieces[king].getRow()].setFill(Color.BLUE);
        }

        if (onem == false && twom == false && threem == false && fourm == false && fivem == false && sixm == false && sevenm == false && eightm == false) {
            return false;
        } else {
            return true;
        }

    }
    
    public static boolean WhiteQueen(int queen) {
        boolean good = false;
        if(WhiteBishop(queen)){
            good = true;
        }
        if(WhiteRook(queen)) {
            good = true;
        }
        if(good){
            return true;
        } else {
            return false;
        }
    }
    public static boolean BlackQueen(int queen) {
        boolean good = false;
        if(BlackBishop(queen)){
            good = true;
        }
        if(BlackRook(queen)) {
            good = true;
        }
        if(good){
            return true;
        } else {
            return false;
        }
    }

}
