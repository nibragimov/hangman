package hangman_package;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("welcome.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Hangman");

        Scene scene = new Scene(root);
        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Chewy&display=swap");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        Welcome welcome = fxmlLoader.getController();
        welcome.setStage(primaryStage);

        welcome.getWelcome_title().setStyle("-fx-font-family: 'Chewy', cursive;");
        welcome.getInstruct_1().setStyle("-fx-font-family: 'Chewy', cursive;");
        welcome.getInstruct_2().setStyle("-fx-font-family: 'Chewy', cursive;");
        welcome.getStart_game().setStyle("-fx-font-family: 'Chewy', cursive;");
        //set background
        BackgroundImage myBI= new BackgroundImage(new Image("paper.jpg",600,400,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        welcome.getWelcome_pane().setBackground(new Background(myBI));

    }



    public static void main(String[] args) {
        launch(args);
    }
}
