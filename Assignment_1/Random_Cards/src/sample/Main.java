package sample;

//This program displays 3 random card images out of a possible 54. The cards are loaded from an external folder.

//important the necessary javafx classes
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

//for reading file names
import java.io.FileInputStream;

//main function
public class Main extends Application {

    //create viewing image variables
    ImageView cards1 = new ImageView();
    ImageView cards2 = new ImageView();
    ImageView cards3 = new ImageView();

    //image variables for file io
    Image card1;
    Image card2;
    Image card3;

    @Override
    public void start(Stage primaryStage) throws Exception{

        //generate random intergers between 1-54 (because there are 54 card images
        int random1 = (int)(Math.random() * 54 + 1);
        int random2 = (int)(Math.random() * 54 + 1);
        int random3 = (int)(Math.random() * 54 + 1);

        //retrieve the 3 random cards from file location
        card1 = new Image(new FileInputStream("C:/Users/Hubert/Downloads/Cards/" + Integer.toString(random1) + ".png"));
        card2 = new Image(new FileInputStream("C:/Users/Hubert/Downloads/Cards/" + Integer.toString(random2) + ".png"));
        card3 = new Image(new FileInputStream("C:/Users/Hubert/Downloads/Cards/" + Integer.toString(random3) + ".png"));

        //set cards and dimensions
        cards1.setImage(card1);
        cards1.setFitWidth(100);
        cards1.setPreserveRatio(true);

        cards2.setImage(card2);
        cards2.setFitWidth(100);
        cards2.setPreserveRatio(true);

        cards3.setImage(card3);
        cards3.setFitWidth(100);
        cards3.setPreserveRatio(true);

        Group root = new Group();

        HBox box = new HBox();
        //add cards to box
        box.getChildren().addAll(cards1, cards2, cards3);

        root.getChildren().add(box);

        //Scene name
        primaryStage.setTitle("Random_Cards");
        //Set stage
        primaryStage.setScene(new Scene(root, 300, 275));
        //show stage
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}