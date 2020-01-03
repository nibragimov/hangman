package hangman_package;

import java.io.*;
import java.util.Hashtable;
import java.util.Random;

public class Dictionary {
    private Hashtable<Integer, String> dict;
    //construct dictionary
    public Dictionary() throws IOException {
        dict = new Hashtable<>();
        InputStream is = null;
        BufferedReader b1 = null;
       
        is = Main.class.getResourceAsStream("words.txt");
        b1 = new BufferedReader(new InputStreamReader(is));
        //insert all words from file into dictionary
        String line;
        Integer ind = 1;
        while((line = b1.readLine())!= null){
            dict.put(ind, line);
            ind++;
        }
        b1.close();
        is.close();
    }

    //pick randomly a word from dictionary
    public String pickWord(){
        Random rand = new Random();
        Integer key = rand.nextInt(dict.size()) + 1;
        return dict.get(key);
    }

}
