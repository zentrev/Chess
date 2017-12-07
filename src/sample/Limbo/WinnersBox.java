package sample.Limbo;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Controller;
import sample.Main;
public class WinnersBox {

//Displays Winner and ask to play again
    public static void winner(Text winn) {
        Stage window = new Stage();


        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("We Have a Winner");
        window.setMinWidth(250);

        Label winner = new Label(winn.getText() + " won!" + "\n" + "Would you like to play again?");
        winner.setTextAlignment(TextAlignment.CENTER);



        Button yes = new Button("Yes");
        Button no = new Button("no");
        no.setOnAction(e -> {
            Main.mainWindow.close();
            window.close();
        });
        yes.setOnAction(e -> {
            Main.mainWindow.close();
            Controller.turn = true;
            window.close();
            Stage stage = new Stage();
            Main str = new Main();
            try {
                str.start(stage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        VBox layout = new VBox(10);
        layout.setStyle("-fx-background-color: a5a5a5");
        layout.getChildren().addAll(winner,yes,no);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);

        window.showAndWait();


    }
}
