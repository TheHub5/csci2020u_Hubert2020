package sample;

//This program creates an investment calculator based off of Investment Amount, Years, and Annual Interest Rate
//in order to yield a future value.

//important the necessary javafx classes
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

//Main function
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //create the GridPane
        GridPane pane = new GridPane();

        pane.setHgap(5);
        pane.setVgap(5);
        //4 Textfield Objects
        TextField Investment = new TextField();
        TextField Years = new TextField();
        TextField Interest = new TextField();
        TextField Future_Value_Result = new TextField();

        //Labels for textfield
        pane.add(new Label("  Investment Amount  "), 0, 0);
        pane.add(Investment, 1, 0);
        pane.add(new Label("  Years "), 0, 1);
        pane.add(Years, 1, 1);
        pane.add(new Label("  Annual Interest Rate "), 0, 2);
        pane.add(Interest, 1, 2);
        pane.add(new Label("  Future Value "), 0, 3);
        pane.add(Future_Value_Result, 1, 3);

        Investment.setPrefColumnCount(1);
        Years.setPrefColumnCount(2);
        Future_Value_Result.setPrefColumnCount(3);

        //Make the result field non-editable
        Future_Value_Result.setEditable(false);

        //Create the hbox and add the calculate buton
        HBox hBox = new HBox(5);
        Button btAdd = new Button("  Calculate  ");
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btAdd);

        //Borderpane creation
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.TOP_CENTER);

        //Scene Creation
        Scene scene = new Scene(borderPane, 300, 200);
        primaryStage.setTitle("Investment_Calculator");
        primaryStage.setScene(scene); //
        primaryStage.show(); // Show the stage

        //Button Action
        btAdd.setOnAction(e -> {
            //The Button calculates the future amount based on the formula:
            //futureValue = investmentAmount * (1 + monthlyInterestRate)years*12
            Future_Value_Result.setText(Math.floor(
                    Double.parseDouble(Investment.getText()) *
                            (Math.pow(1 + Double.parseDouble(Interest.getText()) / (100 * 12),
                                    Double.parseDouble(Years.getText()) * 12))
                            * 100) / 100 + "");
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}