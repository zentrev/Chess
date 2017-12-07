package sample.Limbo;

import javafx.beans.value.ObservableDoubleValue;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import sample.Controller;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

import static sample.Limbo.Atacks.BlackHealth;
import static sample.Limbo.Atacks.WhiteHealth;

public class SecondaryController implements Initializable {

    public HBox BattleBox;
    public Button Battle11;
    public Button Battle12;
    public Button Battle13;
    public Button Battle14;
    public Button Battle21;
    public Button Battle22;
    public Button Battle23;
    public Button Battle24;
    public Button Fight;
    public Label WhiteMelee;
    public Label WhiteRanged;
    public Label WhiteDeffend;
    public Label WhiteHeal;
    public Label BlackMelee;
    public Label BlackRanged;
    public Label BlackDeffend;
    public Label BlackHeal;
    public BorderPane WhiteRed;
    public BorderPane BlackRed;
    public Pane WhiteGreen;
    public Pane BlackGreen;
    private static Piece White;
    private static Piece Black;
    private static boolean run = true;
    private static int damage = 0;
    private static int WHeal;
    private static int BHeal;
    private static int whiteint;
    private static int blackcint;






    @Override
    public void initialize(URL location, ResourceBundle resources) {


        System.out.println("Secondary Scene Running...");
        Fight.setOnAction(event -> {
            BattleBox.getChildren().remove(Fight);
            if (run){
                BattleBox.getChildren().removeAll(White.getImg(), Black.getImg());
            }
            BattleBox.getChildren().addAll(White.getImg(), Black.getImg());
            Atacks.setStats(White,Black);
            run = true;
            if (Controller.turn){
                Battle11.setDisable(true);
                Battle12.setDisable(true);
                Battle13.setDisable(true);
                Battle14.setDisable(true);
                Battle21.setDisable(false);
                Battle22.setDisable(false);
                Battle23.setDisable(false);
                Battle24.setDisable(false);
                Controller.turn = false;
            } else {
                Battle21.setDisable(true);
                Battle22.setDisable(true);
                Battle23.setDisable(true);
                Battle24.setDisable(true);
                Battle11.setDisable(false);
                Battle12.setDisable(false);
                Battle13.setDisable(false);
                Battle14.setDisable(false);
                Controller.turn = true;
            }
            WHeal = WhiteHealth;
            BHeal = BlackHealth;
            WhiteGreen = new Pane();
            WhiteGreen.setStyle("-fx-background-color: greenyellow;");
            WhiteGreen.setPrefSize(10,400);
            WhiteRed.setBottom(WhiteGreen);
            BlackGreen = new Pane();
            BlackGreen.setStyle("-fx-background-color: greenyellow;");
            BlackGreen.setPrefSize(10,400);
            BlackRed.setBottom(BlackGreen);
            updatestat();
        });

        Battle11.setOnAction(e -> {
            damage = Atacks.Atack(Battle11,White);
            Atacks.setBlackHealth(damage);
            setnext();
            updatestat();
        });
        Battle12.setOnAction(e -> {
            damage = Atacks.Atack(Battle12,White);
            Atacks.setBlackHealth(damage);
            setnext();
            updatestat();
        });
        Battle13.setOnAction(e -> {
            damage = Atacks.Atack(Battle13,White);
            Atacks.setBlackHealth(damage);
            setnext();
            updatestat();
        });Battle14.setOnAction(e -> {
            damage = Atacks.Atack(Battle14,White);
            Atacks.setBlackHealth(damage);
            setnext();
            updatestat();
        });

        Battle21.setOnAction(e -> {
            damage = Atacks.Atack(Battle21,Black);
            Atacks.setWhiteHelath(damage);
            setnext();
            updatestat();
        });
        Battle22.setOnAction(e -> {
            damage = Atacks.Atack(Battle22,Black);
            Atacks.setWhiteHelath(damage);
            setnext();
            updatestat();
        });
        Battle23.setOnAction(e -> {
            damage = Atacks.Atack(Battle23,Black);
            Atacks.setWhiteHelath(damage);
            setnext();
            updatestat();
        });
        Battle24.setOnAction(e -> {
            damage = Atacks.Atack(Battle24,Black);
            Atacks.setWhiteHelath(damage);
            setnext();
            updatestat();
        });



    }

    public void setnext(){
        if (Controller.turn){
            if(Atacks.getBlackHealth() <= 0){
                Controller.take(whiteint,blackcint);
                Main.Switch();
                BattleBox.getChildren().removeAll(White.getImg(), Black.getImg());
                BattleBox.getChildren().addAll(Fight);
            }
            Battle21.setDisable(false);
            Battle22.setDisable(false);
            Battle23.setDisable(false);
            Battle24.setDisable(false);
            Battle11.setDisable(true);
            Battle12.setDisable(true);
            Battle13.setDisable(true);
            Battle14.setDisable(true);
            Controller.turn = false;

        } else {
            if(Atacks.getWhiteHealth() <= 0){
            Controller.take(whiteint,blackcint);
            Main.Switch();
                BattleBox.getChildren().removeAll(White.getImg(), Black.getImg());
                BattleBox.getChildren().addAll(Fight);
            }
            Battle21.setDisable(true);
            Battle22.setDisable(true);
            Battle23.setDisable(true);
            Battle24.setDisable(true);
            Battle11.setDisable(false);
            Battle12.setDisable(false);
            Battle13.setDisable(false);
            Battle14.setDisable(false);
            Controller.turn = true;
        }
    }


    public void updatestat(){
        WhiteMelee.setText(String.valueOf(Atacks.WhiteStr));
        WhiteRanged.setText(String.valueOf(Atacks.WhiteAgl));
        WhiteDeffend.setText(String.valueOf(Atacks.WhiteDef));
        WhiteHeal.setText(String.valueOf(Atacks.WhiteHeal));
        BlackMelee.setText(String.valueOf(Atacks.BlackStr));
        BlackRanged.setText(String.valueOf(Atacks.BlackAgl));
        BlackDeffend.setText(String.valueOf(Atacks.BlackDef));
        BlackHeal.setText(String.valueOf(Atacks.BlackHeal));
        WhiteGreen.setPrefHeight((400*((double)WhiteHealth/WHeal)));
        BlackGreen.setPrefHeight((400*((double)BlackHealth/BHeal)));
    }

    public static void setPieces(Piece whitePiece, Piece blackPiece, int whiteInt, int blackInt){
        White = whitePiece;
        Black = blackPiece;
        whiteint = whiteInt;
        blackcint = blackInt;
    }




}
