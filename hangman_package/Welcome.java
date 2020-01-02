package hangman_package;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;


import java.io.IOException;

public class Welcome {
    
    private Stage stage;
    @FXML
    private Label welcome_title, instruct_1, instruct_2;
    @FXML
    private Button start_game;
    @FXML
    private VBox welcome_pane;

    public VBox getWelcome_pane() {
        return welcome_pane;
    }

    public void setWelcome_pane(VBox welcome_pane) {
        this.welcome_pane = welcome_pane;
    }

    //getters and setters of all Welcome fields
    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Label getWelcome_title() {
        return welcome_title;
    }

    public void setWelcome_title(Label welcome_title) {
        this.welcome_title = welcome_title;
    }

    public Label getInstruct_1() {
        return instruct_1;
    }

    public void setInstruct_1(Label instruct_1) {
        this.instruct_1 = instruct_1;
    }

    public Label getInstruct_2() {
        return instruct_2;
    }

    public void setInstruct_2(Label instruct_2) {
        this.instruct_2 = instruct_2;
    }

    public Button getStart_game() {
        return start_game;
    }

    public void setStart_game(Button start_game) {
        this.start_game = start_game;
    }

    public void startGame() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("game.fxml"));
        Parent root = fxmlLoader.load();
        stage.setTitle("Hangman");

        Scene scene = new Scene(root);
        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Chewy&display=swap");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        Controller controller = fxmlLoader.getController();
        controller.setStage(stage);
        controller.setWords();
        controller.getUnknown().setStyle("-fx-font-family: 'Chewy', cursive;");
        controller.getCounter().setStyle("-fx-font-family: 'Chewy', cursive;");
        controller.getGive_up().setStyle("-fx-font-family: 'Chewy', cursive;");
        controller.getInput_word().setStyle("-fx-font-family: 'Chewy', cursive;");
        controller.getStop_game().setStyle("-fx-font-family: 'Chewy', cursive;");
        controller.getTxt_field().setStyle("-fx-font-family: 'Chewy', cursive;");

        BackgroundImage myBI = new BackgroundImage(new Image("resource/paper.jpg",600,400,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        controller.getRootpane().setBackground(new Background(myBI));



    }
}
