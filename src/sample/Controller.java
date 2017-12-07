package sample;


import com.sun.org.apache.bcel.internal.generic.BALOAD;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Limbo.*;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static sample.Limbo.Board.rec;
import static sample.Limbo.Board.reset;


public class Controller implements Initializable {


    public GridPane Board;
    public FlowPane BlackBank;
    public FlowPane WhiteBank;
    public CheckMenuItem ClickDed;
    public Text PlayerDisplay;
    public Text TextPlay1;
    public Text TextPlay2;
    public MenuItem ChangeName;
    public Button ConButton;
    public static Piece[] WhitePieces = new Piece[16];
    public static Piece[] BlackPieces = new Piece[16];
    boolean moving = false;
    public static boolean swaping = false;
    int SelectedPeice = 0;
    public static boolean turn = true;//true white turn false black turn
    public static int blackReturn;
    public static int whiteReturn;
    private boolean setup = false;




    @Override
    public void initialize(URL location, ResourceBundle resources) {


        ConButton.setVisible(false);


        //Build Board
        Board ourBoard = new Board();
        ourBoard.CreatBoard(Board);


        Piece.Type typeholder = null;
        Piece.Color colorholder = Piece.Color.White;
        int colholder = 0;
        int stack = 0;
        //Build Game Pieces
        for (int x = 0; x < 2; x++) {
            if (x == 1) {
                colorholder = Piece.Color.Black;
                colholder = 7;
            }
            for (int i = 0; i < 16; i++) {

                typeholder = Piece.creatType(i, colorholder);
                if (i == 8) {
                    if (colholder == 0) {
                        colholder = 1;
                    } else {
                        colholder = 6;
                    }
                }
                if (colorholder == Piece.Color.White) {
                    WhitePieces[i] = new Piece(typeholder, colholder, stack, colorholder);
                } else if (colorholder == Piece.Color.Black) {
                    BlackPieces[i] = new Piece(typeholder, colholder, stack, colorholder);
                }

                stack++;
                if (stack == 8) {
                    stack = 0;
                }
            }
        }
        System.out.println("Chess Sprites taken from: https://en.wikipedia.org/wiki/Chess");

        System.out.println("Primary Scene Running....");

        ImageView img;
        stack = 0;
        for (int i = 0; i < 32; i++) {
            if (i < 16) {
                WhitePieces[stack].setImg();
                Board.add(WhitePieces[stack].getImg(), WhitePieces[stack].getCol(), WhitePieces[stack].getRow());
            } else {
                BlackPieces[stack].setImg();
                Board.add(BlackPieces[stack].getImg(), BlackPieces[stack].getCol(), BlackPieces[stack].getRow());
            }
            stack++;
            if (stack == 16) {
                stack = 0;
            }
        }




//----------------------------------------------------------------------------------------------------------------------//

        //move handler
        for (int i = 0; i < 16; i++) {
            int finalI = i;

            //WhitePieces
            WhitePieces[i].getImg().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                if (!moving && turn && !setup) {
                    if (WhitePieces[finalI].getWorior() == Piece.Type.Pawn) {
                        SelectedPeice = finalI;
                        moving = MoveList.WhitePawn(finalI);
                    }
                    if (WhitePieces[finalI].getWorior() == Piece.Type.Rook) {
                        SelectedPeice = finalI;
                        moving = MoveList.WhiteRook(finalI);
                    }
                    if (WhitePieces[finalI].getWorior() == Piece.Type.Knight) {
                        SelectedPeice = finalI;
                        moving = MoveList.WhiteKnight(finalI);
                    }
                    if (WhitePieces[finalI].getWorior() == Piece.Type.Bishop) {
                        SelectedPeice = finalI;
                        moving = MoveList.WhiteBishop(finalI);
                    }
                    if (WhitePieces[finalI].getWorior() == Piece.Type.King) {
                        SelectedPeice = finalI;
                        moving = MoveList.WhiteKing(finalI);
                    }
                    if (WhitePieces[finalI].getWorior() == Piece.Type.Queen) {
                        SelectedPeice = finalI;
                        moving = MoveList.WhiteQueen(finalI);
                    }
                } else if (moving) {
                    if (!ClickDed.isSelected()) {
                        if (finalI == SelectedPeice) {
                            moving = false;
                            sample.Limbo.Board.reset();
                        }
                    }
                    moveB(finalI);
                }
                event.consume();
            });


            //BlackPieces
            BlackPieces[i].getImg().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                if (!moving && !turn & !setup) {
                    if (BlackPieces[finalI].getWorior() == Piece.Type.Pawn) {
                        SelectedPeice = finalI;
                        moving = MoveList.BlackPawn(finalI);
                    }
                    if (BlackPieces[finalI].getWorior() == Piece.Type.Rook) {
                        SelectedPeice = finalI;
                        moving = MoveList.BlackRook(finalI);
                    }
                    if (BlackPieces[finalI].getWorior() == Piece.Type.Knight) {
                        SelectedPeice = finalI;
                        moving = MoveList.BlackKnight(finalI);
                    }
                    if (BlackPieces[finalI].getWorior() == Piece.Type.Bishop) {
                        SelectedPeice = finalI;
                        moving = MoveList.BlackBishop(finalI);
                    }
                    if (BlackPieces[finalI].getWorior() == Piece.Type.King) {
                        SelectedPeice = finalI;
                        moving = MoveList.BlackKing(finalI);
                    }
                    if (BlackPieces[finalI].getWorior() == Piece.Type.Queen) {
                        SelectedPeice = finalI;
                        moving = MoveList.BlackQueen(finalI);
                    }
                } else if (moving) {
                    if (!ClickDed.isSelected()) {
                        if (finalI == SelectedPeice) {
                            moving = false;
                            sample.Limbo.Board.reset();
                        }
                    }
                    moveW(finalI);
                }
                event.consume();
            });


            //Blue Squares
            for (int e = 0; e < 8; e++) {
                for (int j = 0; j < 8; j++) {
                    int finalJ = j;
                    int finalE = e;
                    rec[e][j].addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                        if (rec[finalE][finalJ].getFill().equals(Color.BLUE) && moving && !setup) {
                            if (turn) {
                                WhitePieces[SelectedPeice].setCol(finalE);
                                WhitePieces[SelectedPeice].setRow(finalJ);
                                Board.getChildren().remove(WhitePieces[SelectedPeice].getImg());
                                Board.add(WhitePieces[SelectedPeice].getImg(), WhitePieces[SelectedPeice].getCol(), WhitePieces[SelectedPeice].getRow());
                                checkWSpot();
                            } else {
                                BlackPieces[SelectedPeice].setCol(finalE);
                                BlackPieces[SelectedPeice].setRow(finalJ);
                                Board.getChildren().remove(BlackPieces[SelectedPeice].getImg());
                                Board.add(BlackPieces[SelectedPeice].getImg(), BlackPieces[SelectedPeice].getCol(), BlackPieces[SelectedPeice].getRow());
                                checkBSpot();
                            }
                            reset();
                            moving = false;
                            nextTurn();
                        }
                        event.consume();
                    });
                }
            }
        }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Name Change
        ChangeName.setOnAction(e -> {
            NameChangeAlert.ChangeName(TextPlay1, TextPlay2, PlayerDisplay);

        });
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Continue

        ConButton.setOnAction(e ->{
            setup = false;
            if(turn) {
                Board.getChildren().removeAll(WhitePieces[whiteReturn].getImg(), BlackPieces[blackReturn].getImg());
                Board.add(BlackPieces[blackReturn].getImg(), BlackPieces[blackReturn].getCol(), BlackPieces[blackReturn].getRow());
                Board.getChildren().remove(WhitePieces[whiteReturn].getImg());
                WhitePieces[whiteReturn].setRow(8);
                WhitePieces[whiteReturn].setCol(8);
                WhiteBank.getChildren().addAll(WhitePieces[whiteReturn].getImg());
                nextTurn();
                nextTurn();
                if (WhitePieces[whiteReturn].getWorior() == Piece.Type.King) {
                    WinnersBox.winner(TextPlay2);
                }
            } else {
                Board.getChildren().removeAll(WhitePieces[whiteReturn].getImg(), BlackPieces[blackReturn].getImg());
                Board.add(WhitePieces[whiteReturn].getImg(), WhitePieces[whiteReturn].getCol(), WhitePieces[whiteReturn].getRow());
                Board.getChildren().remove(BlackPieces[blackReturn].getImg());
                BlackPieces[blackReturn].setRow(8);
                BlackPieces[blackReturn].setCol(8);
                BlackBank.getChildren().addAll(BlackPieces[blackReturn].getImg());
                nextTurn();
                nextTurn();
                if (BlackPieces[blackReturn].getWorior() == Piece.Type.King) {
                    WinnersBox.winner(TextPlay1);
                }
            }
            ConButton.setVisible(false);
        });
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Move methods and Contact checks

    public void moveW(int mover) {

        if (swaping) {
            if (BlackPieces[mover].getCol() == 8 && BlackPieces[mover].getRow() == 8)
                BlackPieces[mover].setCol(BlackPieces[SelectedPeice].getCol());
            BlackPieces[mover].setRow(BlackPieces[SelectedPeice].getRow());
            BlackBank.getChildren().remove(BlackPieces[mover].getImg());
            Board.getChildren().remove(BlackPieces[SelectedPeice].getImg());
            Board.add(BlackPieces[mover].getImg(), BlackPieces[mover].getCol(), BlackPieces[mover].getRow());
            BlackPieces[SelectedPeice].setCol(8);
            BlackPieces[SelectedPeice].setRow(8);
            BlackBank.getChildren().add(BlackPieces[SelectedPeice].getImg());
            swaping = false;
            moving = false;
            nextTurn();
        }

        if (BlackPieces[mover].getCol() < 8 && BlackPieces[mover].getRow() < 8) {
            if (rec[BlackPieces[mover].getCol()][BlackPieces[mover].getRow()].getFill().equals(Color.BLUE) && moving) {
                if (turn) {
                    WhitePieces[SelectedPeice].setCol(BlackPieces[mover].getCol());
                    WhitePieces[SelectedPeice].setRow(BlackPieces[mover].getRow());
                    Board.getChildren().remove(WhitePieces[SelectedPeice].getImg());
                    Board.add(WhitePieces[SelectedPeice].getImg(), WhitePieces[SelectedPeice].getCol(), WhitePieces[SelectedPeice].getRow());
                    checkWSpot();
                }
                reset();
                moving = false;
                nextTurn();
            }
        }

    }

    public void moveB(int mover) {
        if (swaping) {
            if (WhitePieces[mover].getCol() == 8 && WhitePieces[mover].getRow() == 8)
                WhitePieces[mover].setCol(WhitePieces[SelectedPeice].getCol());
            WhitePieces[mover].setRow(WhitePieces[SelectedPeice].getRow());
            WhiteBank.getChildren().remove(WhitePieces[mover].getImg());
            Board.getChildren().remove(WhitePieces[SelectedPeice].getImg());
            Board.add(WhitePieces[mover].getImg(), WhitePieces[mover].getCol(), WhitePieces[mover].getRow());
            WhitePieces[SelectedPeice].setCol(8);
            WhitePieces[SelectedPeice].setRow(8);
            WhiteBank.getChildren().add(WhitePieces[SelectedPeice].getImg());
            swaping = false;
            moving = false;
            nextTurn();
        }

        if (WhitePieces[mover].getCol() < 8 && WhitePieces[mover].getRow() < 8) {
            if (rec[WhitePieces[mover].getCol()][WhitePieces[mover].getRow()].getFill().equals(Color.BLUE) && moving) {
                if (!turn) {
                    BlackPieces[SelectedPeice].setCol(WhitePieces[mover].getCol());
                    BlackPieces[SelectedPeice].setRow(WhitePieces[mover].getRow());
                    Board.getChildren().remove(BlackPieces[SelectedPeice].getImg());
                    Board.add(BlackPieces[SelectedPeice].getImg(), BlackPieces[SelectedPeice].getCol(), BlackPieces[SelectedPeice].getRow());
                    checkBSpot();
                }
                reset();
                moving = false;
                nextTurn();
            }
        }
    }

    public void checkWSpot() {

        for (int p = 0; p < 16; p++) {
            if ((WhitePieces[SelectedPeice].getCol()) == (BlackPieces[p].getCol()) && (WhitePieces[SelectedPeice].getRow()) == (BlackPieces[p].getRow())) {

                Main.Switch();
                SecondaryController.setPieces(WhitePieces[SelectedPeice],BlackPieces[p],SelectedPeice,p);
                ConButton.setVisible(true);
                setup = true;

            }
        }
    }

    public void checkBSpot() {
        for (int p = 0; p < 16; p++) {
            if ((BlackPieces[SelectedPeice].getCol()) == (WhitePieces[p].getCol()) && (BlackPieces[SelectedPeice].getRow()) == (WhitePieces[p].getRow())) {
                Main.Switch();
                SecondaryController.setPieces(WhitePieces[p],BlackPieces[SelectedPeice],p,SelectedPeice);
                ConButton.setVisible(true);
                setup = true;
            }
        }
    }

    public void nextTurn(){
        if (turn) {
            turn = false;
            PlayerDisplay.setText(TextPlay2.getText() + "'s turn");
        } else {
            turn = true;
            PlayerDisplay.setText(TextPlay1.getText() + "'s turn");
        }
    }
    public static void take(int white, int black){
        whiteReturn = white;
        blackReturn = black;
    }
}




