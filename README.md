# Hangman
a fun game that I wrote on Java using JavaFX

## About The Project

![Hangman-screenshot](/resource/hangman-screenshot.png)

I have created the minimalistic design of [Hangman](https://en.wikipedia.org/wiki/Hangman_(game)) word game. In this game
the word to guess is represented by a row of question marks, representing each letter of the word. You win the game if you guess the word
in 10 turns. You lose otherwise. When you stop the game the game calculates your score: the number of wins and losses. In this window, you can clear the scores and start the game again. 

You guess the word by entering letters into text field - one at a time. If you guessed the word in your head, you can click **I know the word!** button and enter the whole word into text field.  

Words are randomly extracted from file words.txt. The file words.txt contains 120 words. When compiling words.txt, I used 4th grade English vocabulary: no informal words, literary words and names.    
### Built With
The game is written on Java using [JavaFX](https://openjfx.io/) platform.
### What did I learn?
This project refreshed my knowledge of Java, OOP in Java, creating 2D objects and using dictionaries. Also, I learned how to handle large projects.

### Installation
1. In resources directory download the .jar file. 
2. Download an appropriate [JavaFX runtime](https://gluonhq.com/products/javafx/) for your operating system and unzip it to a desired location. Also, make sure you have JDK installed.
3. Add an environment variable pointing to the lib directory of the runtime:

Windows
```sh
set PATH_TO_FX="path\to\javafx-sdk-13\lib"
```
Linux/Mac
```sh
export PATH_TO_FX=path\to\javafx-sdk-13\lib
```
4. Next, run the .jar file:

Windows
```sh
java --module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml -jar Hangman.jar
```
Linux/Mac
```sh
java --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml -jar Hangman.jar
```
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Acknowledgements
1. paper.jpg (used as background image) - <a href="https://www.freepik.com">designed by Efe_Madrid - Freepik.com</a>

