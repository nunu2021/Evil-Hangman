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
public class Person {

    public Person() {

        allGuesses = new ArrayList<String>();
        wrongGuesses = new ArrayList<String>();
        rightGuesses = new ArrayList<String>();
        points = 0;

    }
    
    public void set_name(String name){
        NAME = name;
    }

    public void addGuess(String guess) {
        allGuesses.add(guess);
    }

    public void addWrongGuess(String guess) {
        wrongGuesses.add(guess);
    }

    public void addRightGuess(String guess) {
        rightGuesses.add(guess);
    }
    
    public ArrayList<String> all_guesses(){
        return allGuesses;
    }
    
    public ArrayList<String> right_guesses(){
        return rightGuesses;
    }
    
    public ArrayList<String> wrong_guesses(){
        return wrongGuesses;
    }
    
    public void calculatePoints(){
        points = 10 - wrongGuesses.size();
    }
    
    public int points(){
        return points;
    }

  private static String NAME;
    private ArrayList<String> allGuesses;
    private ArrayList<String> wrongGuesses;
    private ArrayList<String> rightGuesses;
private int points;
}
