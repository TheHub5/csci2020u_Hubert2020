package sample;

//This program counts the number of alphabetical characters (a-z) in a text file and displays a histogram.
// Note that it will NOT work on files with
//characters outside of the alphabet range and will yield an error.

//Example file address: C:/Users/Hubert/Downloads/test.txt
//important the necessary javafx classes
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;

//for reading files
import java.io.File;
import java.util.Scanner;

//main class
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        double paneHeight = 250;

        //Pane Object
        Pane pane = new Pane();
        //Text Object
        Text label = new Text(15, paneHeight - 15, "Filename:");
        //Button
        Button graph = new Button("View");
        //set values for our variables
        graph.setTranslateX(450);
        graph.setTranslateY(paneHeight - 30);
        //Textfield for File
        TextField file = new TextField();
        //Set Textfield size and position
        file.setTranslateX(175);
        file.setTranslateY(paneHeight - 30);
        file.setScaleX(1);
        file.setAlignment(Pos.BOTTOM_LEFT);

        //array corresponding to the letter count
        int count[] = new int[26];

        //an array for the bars in our bar graph
        Rectangle[] rectangle_bars = new Rectangle[26];
        //letter array
        Text[] letters = new Text[26];

        //loop through and count letters
        for (int i = 0; i < 26; i++)
        {

            rectangle_bars[i] = new Rectangle(15 * i + 60, paneHeight - 80, 10, 10);
            rectangle_bars[i].setStroke(Color.BLACK);
            rectangle_bars[i].setFill(Color.WHITE);


            letters[i] = new Text(15 * i + 60, paneHeight - 50, Character.toString((char)(i+65)));
        }

        pane.getChildren().addAll(rectangle_bars);

        pane.getChildren().addAll(letters);
        //add components to the graph
        pane.getChildren().addAll(label, file, graph);

        //Create Scene and show it
        Scene scene = new Scene(pane, 500, paneHeight);
        primaryStage.setTitle("Histogram");
        primaryStage.setScene(scene);
        primaryStage.show();


        //Button event
        graph.setOnAction(e -> {
            //highest count value to base graph around
            int highest = 1;


            File f = new File(file.getText());
            //read the file
            try (Scanner scanner = new Scanner(f)) {


                while (scanner.hasNextLine())
                {

                    String string = scanner.nextLine();

                    for(int i = 0; i < string.length(); i++)
                    {

                        char current_char = string.charAt(i);

                        if (current_char != ' ')
                        {
                            current_char = Character.toUpperCase(current_char);
                            
                            count[((int)(current_char))-65]++;


                            if (count[(int)(current_char)-65] > highest)
                            {
                                highest = count[(int)(current_char)-65];
                            }
                        }
                    }
                }
                //go through each bar and set height based on the letter count. Uses Letter count/highest count *100 to
                //get the height of the bar in pixels.
                for (int i = 0; i < 26; i++)
                {

                    rectangle_bars[i].setHeight(((double)count[i] / (double)highest) * 100);

                    rectangle_bars[i].setY(paneHeight - 80 - (rectangle_bars[i].getHeight()));
                }
                //catch exception
            } catch (Exception e2) {

                System.out.println(e2.toString());
            }

        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}