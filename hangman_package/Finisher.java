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

public class Finisher {
    private int wins = 0, losses = 0;
    private String word;
    private Stage stage;

    @FXML
    private VBox finisher_pane;
    @FXML
    private Button play_again, stop_game;
    @FXML
    private Label title;
    @FXML
    private Label rev_word;

    public VBox getFinisher_pane() {
        return finisher_pane;
    }

    public void setFinisher_pane(VBox finisher_pane) {
        this.finisher_pane = finisher_pane;
    }

    public void setWord(String word){
        this.word = word;
    }
    public String getWord(){
        return word;
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }
    public Stage getStage(Stage stage){
        return stage;
    }
    public Label getTitle(){ return title; }
    public void setTitle(Label t){ title = t; }
    public Label getRev_word(){ return rev_word; }
    public void setRev_word(Label t){ rev_word = t; }
    public int getWins(){ return wins; }
    public void setWins(int w){ wins = w; }
    public int getLosses(){ return losses; }
    public void setLosses(int l){ losses = l; }
    public Button getPlay_again() {
        return play_again;
    }

    public void setPlay_again(Button play_again) {
        this.play_again = play_again;
    }

    public Button getStop_game() {
        return stop_game;
    }

    public void setStop_game(Button stop_game) {
        this.stop_game = stop_game;
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
    //display score page
    public void stopGame() throws IOException{
        System.out.println("stopGame() called");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("score.fxml"));
        Scene s_scene = new Scene(fxmlLoader.load());
        s_scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Chewy&display=swap");
        Stage window = stage;
        window.setScene(s_scene);
        window.show();

        Score score = fxmlLoader.getController();
        score.setStage(stage);
        score.getWins().setText("Wins: " + wins);
        score.getLosses().setText("Losses: " + losses);
        int temp_w = wins;
        int temp_l = losses;
        score.setIntLosses(temp_w);
        score.setIntWins(temp_l);
        score.getPlay_again().setStyle("-fx-font-family: 'Chewy', cursive;");
        score.getClear_score().setStyle("-fx-font-family: 'Chewy', cursive;");
        score.getWins().setStyle("-fx-font-family: 'Chewy', cursive;");
        score.getLosses().setStyle("-fx-font-family: 'Chewy', cursive;");
        score.getYour_score().setStyle("-fx-font-family: 'Chewy', cursive;");

        BackgroundImage myBI= new BackgroundImage(new Image("paper.jpg",600,400,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        score.getScore_pane().setBackground(new Background(myBI));
    }


}
