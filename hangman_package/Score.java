package hangman_package;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Score {
    private int int_wins = 0, int_losses = 0;
    private Stage stage;



    @FXML
    private VBox score_pane;
    @FXML
    private Button play_again, clear_score;
    @FXML
    private Label wins, losses, your_score;

    public VBox getScore_pane() {
        return score_pane;
    }

    public void setScore_pane(VBox score_pane) {
        this.score_pane = score_pane;
    }
    public void setWins(Label w){ wins = w; }
    public void setLosses(Label l){ losses = l; }
    public void setStage(Stage s){ stage = s; }

    public Label getYour_score() {
        return your_score;
    }

    public void setYour_score(Label your_score) {
        this.your_score = your_score;
    }

    public Label getWins(){ return wins; }
    public void setIntWins(int w){ int_wins = w; }
    public void setIntLosses(int l){ int_losses = l; }

    public Label getLosses(){ return losses; }
    public Stage getStage(){ return stage; }
    public int getIntWins(){ return int_wins; }
    public int getIntLosses(){ return int_losses; }


    public Button getPlay_again() {
        return play_again;
    }

    public void setPlay_again(Button play_again) {
        this.play_again = play_again;
    }

    public Button getClear_score() {
        return clear_score;
    }

    public void setClear_score(Button clear_score) {
        this.clear_score = clear_score;
    }
    //display game page and init game
    public void playAgain() throws IOException {
        System.out.println("playAgain() called");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("game.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Chewy&display=swap");
        Stage window = stage;
        window.setScene(scene);
        window.show();

        Controller controller = fxmlLoader.getController();
        controller.setWords();
        controller.setStage(stage);
        controller.getUnknown().setStyle("-fx-font-family: 'Chewy', cursive;");
        controller.getCounter().setStyle("-fx-font-family: 'Chewy', cursive;");
        controller.getGive_up().setStyle("-fx-font-family: 'Chewy', cursive;");
        controller.getInput_word().setStyle("-fx-font-family: 'Chewy', cursive;");
        controller.getStop_game().setStyle("-fx-font-family: 'Chewy', cursive;");
        controller.getTxt_field().setStyle("-fx-font-family: 'Chewy', cursive;");
        BackgroundImage myBI= new BackgroundImage(new Image("paper.jpg",600,400,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        controller.getRootpane().setBackground(new Background(myBI));


    }
    //set all your wins and losses to 0
    public void clearScore(){
        Controller.setLosses(0);
        Controller.setWins(0);
        wins.setText("Wins: 0");
        losses.setText("Losses: 0");
    }

}
