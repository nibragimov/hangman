package hangman_package;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Random;

public class Dictionary {
    private Hashtable<Integer, String> dict;
    //construct dictionary
    public Dictionary() throws IOException {
        dict = new Hashtable<>();
        FileReader f1 = null;
        BufferedReader b1 = null;
        try {
            f1 = new FileReader("src/words.txt");
            b1 = new BufferedReader(f1);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(1);
        }
        //insert all words from file into dictionary
        String line;
        Integer ind = 1;
        while((line = b1.readLine())!= null){
            dict.put(ind, line);
            ind++;
        }
        b1.close();
        f1.close();
    }

    //pick randomly a word from dictionary
    public String pickWord(){
        Random rand = new Random();
        Integer key = rand.nextInt(dict.size()) + 1;
        return dict.get(key);
    }


}
