package hangman_package;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller {

    private String unknown_word = "";
    private String word;
    private int turns = 10;
    private static int wins = 0, losses = 0;
    private boolean win = false;
    private boolean input_word_mode = false;
    private Stage stage;


    @FXML
    private BorderPane rootpane;
    @FXML
    private Canvas canvas;
    @FXML
    private Button stop_game, give_up, input_word;
    @FXML
    private TextField txt_field;
    @FXML
    private Label counter, unknown;

    //getters and setters
    public BorderPane getRootpane() {
        return rootpane;
    }

    public void setRootpane(BorderPane rootpane) {
        this.rootpane = rootpane;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public Button getStop_game() {
        return stop_game;
    }

    public void setStop_game(Button stop_game) {
        this.stop_game = stop_game;
    }

    public Button getGive_up() {
        return give_up;
    }

    public void setGive_up(Button give_up) {
        this.give_up = give_up;
    }

    public Button getInput_word() {
        return input_word;
    }

    public void setInput_word(Button input_word) {
        this.input_word = input_word;
    }

    public TextField getTxt_field() {
        return txt_field;
    }

    public void setTxt_field(TextField txt_field) {
        this.txt_field = txt_field;
    }

    public Label getCounter() {
        return counter;
    }

    public void setCounter(Label counter) {
        this.counter = counter;
    }

    public Label getUnknown() {
        return unknown;
    }

    public void setUnknown(Label unknown) {
        this.unknown = unknown;
    }
    //getters for word and unknown word
    public String getUnknownWord() {
        return unknown_word;
    }
    public String getWord() {
        return word;
    }
    public static int getWins(){ return wins; }
    public static int getLosses(){ return losses; }
    public static void setWins(int v){ wins = v; }
    public static void setLosses(int l){ losses = l; }

    //setter and getter for turns var
    public int getTurns(){ return turns; }
    public void setTurns(int turns){
        this.turns = turns;
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }
    public Stage getStage(){
        return stage;
    }


    /*public void loadDictionary() throws IOException { }*/
    public void setWords() throws IOException{
        Dictionary dict = new Dictionary();
        word = dict.pickWord();
        //for testing
        System.out.println(word);

        for (int i = 0; i < word.length() ; i++) {
            unknown_word += "?";
        }
        unknown.setText(unknown_word);
    }

    public void inputWord(){
        input_word_mode = true;
    }

    //get char or word from text field
    public void getChar() throws IOException{
        System.out.println("getChar() called");
        String info = txt_field.getText();
        if(input_word_mode){
            if(info.equals(word)){
                win = true;
                finishGame();
            }
            else{
                System.out.println("Incorrect word");
            }
            input_word_mode = false;
        }
        else{
            if(info.length() > 1){
                System.out.println("Please enter only one character");
            }
            updateUnknownWord(info.charAt(0));
        }

    }
    //update unknown label and unknown var
    public void updateUnknownWord(char ch) {
        boolean guessed = false;
        StringBuilder sb_unknown = new StringBuilder(unknown_word);
        for (int i = 0; i < word.length(); i++) {
            if(ch == word.charAt(i)){
                guessed = true;
                sb_unknown.setCharAt(i, ch);
            }
        }
        if(guessed){
            System.out.println("Match!");
            unknown_word = sb_unknown.toString();
            unknown.setText(unknown_word);
            if(unknown_word.equals(word)){
                win = true;
                try{
                    finishGame();
                }catch (IOException e){
                    System.out.println("Error in I/O");
                    System.exit(3);
                }

            }
        }
        else{
            System.out.println("No match!");
            turns--;
            if(turns == 1){
                counter.setText(turns + " " +
                        "turn left");
            }else{
                counter.setText(turns + " " +
                        "turns left");
            }
            createPict();
        }

    }

    //draw hangman picture
    public void createPict(){

        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setLineWidth(3);

        switch(turns){
            case 9: g.strokeLine(145, 185, 110, 185);break;
            case 8: g.strokeLine(135,75, 135, 185);break;
            case 7: g.strokeLine(110, 75, 135,75);break;
            case 6: g.strokeLine(110, 100, 110, 75);break;
            case 5: g.strokeOval(100, 100, 20, 20);break;
            case 4:  g.strokeLine(110, 120, 110,130);break;
            case 3:
                g.strokeLine(110, 130, 105, 145);
                g.strokeLine(110, 130, 115, 145);
                break;
            case 2: g.strokeLine(110, 130, 110 ,150);break;
            case 1: g.strokeLine(110, 150,105, 175); break;
            case 0:
                g.strokeLine(110, 150,115, 175);

                try{
                    finishGame();
                }catch (IOException e){
                    System.out.println("Error in I/O");
                    System.exit(3);
                }
                break;
        }
    }
    //display score page
    public void stopGame() throws IOException {
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
    //display win/lose page
    public void finishGame() throws IOException{
        System.out.println("finishGame() called");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("finish_game.fxml"));
        Scene f_scene = new Scene(fxmlLoader.load());
        f_scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Chewy&display=swap");
        Stage window = stage;
        window.setScene(f_scene);
        window.show();

        Finisher finisher = fxmlLoader.getController();
        finisher.setStage(stage);

        finisher.getTitle().setStyle("-fx-font-family: 'Chewy', cursive;");
        finisher.getRev_word().setStyle("-fx-font-family: 'Chewy', cursive;");
        finisher.getPlay_again().setStyle("-fx-font-family: 'Chewy', cursive;");
        finisher.getStop_game().setStyle("-fx-font-family: 'Chewy', cursive;");

        BackgroundImage myBI= new BackgroundImage(new Image("paper.jpg",600,400,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        finisher.getFinisher_pane().setBackground(new Background(myBI));

        //show unknown word
        finisher.getRev_word().setText("Word: " + word);
        if(win){
            wins++;
            finisher.getTitle().setText("You win!!\uD83C\uDF89");
        }
        else{
            losses++;
        }
        finisher.setWins(wins);
        finisher.setLosses(losses);

    }



}
