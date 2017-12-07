package sample.Limbo;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static sample.Controller.turn;

//Alert box to change player names
public class NameChangeAlert {
    public static void ChangeName(Text play1, Text play2, Text dispaly){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Change Name");
        window.setMinWidth(250);

        Label White = new Label();
        White.setText(play1.getText());
        Label Black = new Label();
        Black.setText(play2.getText());

        TextField newWhite = new TextField(play1.getText());
        TextField newBlack = new TextField(play2.getText());

        Button enter = new Button("Confirm");


        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10));
        layout.setVgap(8);
        layout.setHgap(10);

        GridPane.setConstraints(White,0,0);
        GridPane.setConstraints(Black,0,1);
        GridPane.setConstraints(newWhite,1,0);
        GridPane.setConstraints(newBlack,1,1);
        GridPane.setConstraints(enter,1,2);

        layout.getChildren().addAll(White,Black,newWhite,newBlack,enter);
        layout.setStyle("-fx-background-color: a5a5a5");

        Scene scene = new Scene(layout,300,200);
        window.setScene(scene);

        window.show();



        enter.setOnAction(e -> {
            play1.setText(newWhite.getText());
            play2.setText(newBlack.getText());


            if (turn) {
                dispaly.setText(play1.getText() + "'s turn");
            } else {
                dispaly.setText(play2.getText() + "'s turn");
            }
            window.close();

        });

    }

}
