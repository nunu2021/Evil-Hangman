/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evilhangman;

import java.util.ArrayList;

/**
 *
 * @author labdhijain
 */
public class GamePlay {

    // this class basically checks the word and the guesses, and chooses the word accordingly, from the dictionary
    // this class also checks of the user inout matches the word, if there is a word.
    public GamePlay() {

        word_bank = new Dictionary();
matches = false;
    }

    public void set_word(int num, String theChosenWord) {

        length_of_word = num;
        theWord = theChosenWord;
        the_word = new ArrayList<String>();
        for (int i = 0; i < length_of_word; i++) {
            
                the_word.add(theWord.substring(i, i + 1));
            

        }
    }

    public void set_underlines(int num) {

        length_of_word = num;
        show_word = new ArrayList<String>();
        for (int i = 0; i < length_of_word; i++) {

            show_word.add("_");
        }

        showWord = "";

        for (int i = 0; i < show_word.size(); i++) {

            showWord += show_word.get(i) + " ";

        }

    }
    
    
   

    public String show_word() {
        return showWord;
    }

    public boolean matched() {
        return matches;
    }

    public int length() {
        return length_of_word;
    }

    public void compareGuess(String guess) {

        if (wordFound) {

            matches = false;
            for (int i = 0; i < the_word.size(); i++) {
                System.out.println(the_word.get(i));

                if (the_word.get(i).equals(guess.toUpperCase())) {
                    // wierd

                    matches = true;
                    show_word.set(i, guess);
                       
                }

            }
            showWord = "";

            for (int i = 0; i < show_word.size(); i++) {

                showWord += show_word.get(i) + " ";

            }

        } else {

            matches = false;

        }

    }
    
    public boolean word_found(){
        return wordFound;
    }

    public void if_word_found(ArrayList allGuesses) {
        ArrayList<String> words = word_bank.getArrayNoMatch(allGuesses, length_of_word);
        
        if(words.size() == 0){
        
            ArrayList<String> temp_guesses = allGuesses;
            
            temp_guesses.remove(temp_guesses.size()-1);
            subOne = true;
           
           words = word_bank.getArrayNoMatch(temp_guesses, length_of_word);
         
           if(subOne = true && words.size() > 1){
            int randNum = (int)(Math.random()*words.size());
            set_word(length_of_word, words.get(randNum));
            wordFound = true;
           
        }
        }else if (words.size()==1){
            set_word(length_of_word, words.get(0));
            wordFound = true;
            
        }else{
         
        }
    }
   
    private boolean subOne;

    private Dictionary word_bank;
    private boolean the_word_determined;
    private int length_of_word;
    private boolean matches;
    private String theWord;
    private String showWord;
    private ArrayList<String> the_word;
    private ArrayList<String> show_word;
    private boolean wordFound;

}
