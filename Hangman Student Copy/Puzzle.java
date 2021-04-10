import java.util.ArrayList;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Puzzle
{
    private ArrayList<String> words;
    private String Guess=""; 
    private String word;
    private String alphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String error="";
    public Puzzle() {
        words= new ArrayList<String>();
        
        try {
            File file = new File("words.txt");
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNext()) {

                String tempWord = scanner.next().toUpperCase();
            
                    words.add(tempWord);
                   
                
            }
            scanner.close();

            //ONCE THIS LINE OF CODE IS REACHED, YOUR words ArrayList
            //CONTAINS ALL THE WORDS IN words.txt
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    
        for(int i=0;i<words.size();i++){
            if(words.get(i).contains(alphabet))
            words.remove(i);
        }
        int hi=words.size();
        word=words.get((int)(Math.random()*hi));

    }

    public boolean makeGuess(String guess){
        guess = guess.toUpperCase();
        if(Guess.contains(guess)){
        error="Already Guessed: "+ guess;
        
    }
    else
        Guess+=guess;
        
        
        
        return word.contains(guess);

    }

    public String getWord(){
        return word;

    }

    public void show(){
        System.out.print("Puzzle: ");
        String wordBlank="";
        for(int i=0;i<word.length();i++){

            if (Guess.contains(word.substring(i,i+1))) {
                System.out.print(word.substring(i,i+1));
                
            } else {
                
                System.out.print("_");
            }
            
        }

        System.out.println(" ");
        System.out.print("Guesses: ");

        for(int j=0;j<Guess.length();j++){
            System.out.print(Guess.charAt(j)+", ");   
        }
        System.out.println(" ");
        System.out.print(error);

    }

    public boolean isUnsolved() {
        int right=0;
      for(int i=0;i<word.length();i++){
          if(Guess.contains(word.substring(i,i+1))) 
          right++;
          
        }
        return !(right==word.length());
    }
}

