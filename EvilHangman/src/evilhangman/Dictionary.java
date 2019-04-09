
package evilhangman;



import java.util.ArrayList;     // Used to create ArrayLists dictionary use
import java.util.Scanner;
import java.io.*;               // Used for IOException, File
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dictionary {

    // Declare a dynamically allocated ArrayList of Strings for the dictionary.
    // The dictionary can hold any number of words.
    ArrayList<String> dictionary;
    private File dictionaryFile;

	// Constructor
	Dictionary()
	{
        // Define the instance of the dictionary ArrayList
        dictionary = new ArrayList<String>();
        // Now fill the dictionary array list with words from the dictionary file
        readInDictionaryWords();
	}//end Constructor
	

	//---------------------------------------------------------------------------------
    // Read in the words to create the dictionary.
    public void readInDictionaryWords() 
    {
        
//          
        FileReader r = null;
        try 
        {
            r = new FileReader("src/resources/Dictionary.txt");
            
        } 
        catch (FileNotFoundException ex) 
        {

                System.out.println("*** Error *** \n" +
                                   "Your dictionary file has the wrong name or is " +
                                   "in the wrong directory.  \n" +
                                   "Aborting program...\n\n");
                System.exit( -1);    // Terminate the program

        }
     Scanner f = new Scanner(r);

     while(f.hasNextLine())
     {
        dictionary.add(f.nextLine());
     }

    }//end createDictionary()
    
    
    //---------------------------------------------------------------------------------
    // Allow looking up a word in dictionary, returning a value of true or false
    public boolean wordExists( String wordToLookup)
    {
        if( dictionary.contains( wordToLookup.toUpperCase())) {
            return true;    // words was found in dictionary
        }
        else {
            return false;   // word was not found in dictionary    
        }
    }//end wordExists
    
    
    //---------------------------------------------------------------------------------
    // return number of words in dictionary
    public int numberOfWordsInDictionary()
    {
    	return dictionary.size();
    }

    //---------------------------------------------------------------------------------
    // return word at a particular position in dictionary
    public String wordAtIndex( int index)
    {
    	return dictionary.get( index);
    }
     
    public int indexOfWord(String wordToLookup)
    {
        for(int i = 0;i<dictionary.size();i++)
        {
            if (dictionary.get(i).equalsIgnoreCase(wordToLookup))
                return i;
        }
        return -1;
    }
    public ArrayList getDictionary()
    {
        return dictionary;
    }
    //returns an array of words that do not contain the letters
    //the words will be of a certain length only
    
    // pre condition = arraylist of guesses, dictionary, and the length of the word as a positive integer
    // the list must contain a letter
    // don't call this function until you have a letter
    // post condition = returns an arraylist of all possible words that does not contain .
    public ArrayList getArrayNoMatch(ArrayList<String> guesses,int len)
    {
        boolean matches_letter = false; // intially sets that the word has no letter matching to any guesses from guesses array
        ArrayList<String> tempArray = new ArrayList<String>(); // creates the arraylist we will then return with all words possible with
        // suitable to the length pf the word, and containing nor letters from the arraylist of guesses passed.
        for(int i = 0; i< dictionary.size(); i++){ // goes thorugh alll the word from the dictionary
            if(dictionary.get(i).length() == len){ // checks if the length of the word matches the precondition
                  for(int k = 0; k< dictionary.get(i).length();k++){ // for each letter in the word from the previous for loop:
               
                    for(int j = 0; j< guesses.size();j++){ //for each letter in the arraylist of guesses, 
                        
                       
                        if((dictionary.get(i).substring(k,k+1).toUpperCase()).equals(guesses.get(j).toUpperCase())){ // the code checks if the letters match
                            //if the letters match, then the boolean is set to true.
                            matches_letter = true; // the word then cannot be added to the tempArray
                         
                         }
                      
                    }
              }
                  if(!matches_letter){ /// this checks whether there are any matched letter between both the ord from the 
                      // dictionary, and the arraylist of guesses.
                        
                        tempArray.add(dictionary.get(i));  // the word is added if the former conditional is true  
                    }
                  matches_letter = false; // the bolean is set to false again for the next ford in the dictionary that the 
                  // for loops call
            } // crwth 
        }
        return tempArray; // returns the arraylist made for all possible word for the post conditions
    }

    //returns an array of words that do not contain the letters
    //the words will be of a certain length only
    
    // pre condition = arraylist of guesses, dictionary, and the length of the word as a positive integer
    // the list must contain a letter
    // don't call this function until you have a letter
    // post condition = returns an arraylist of all possible words that does not contain .
    // uses while loops instead of for loop for efficiency
   
    public ArrayList getArrayNoMatch_while_loop(ArrayList<String> guesses,int len)
    {
         
        boolean matches_letter = false; // intially sets that the word has no letter matching to any guesses from guesses array
        ArrayList<String> tempArray = new ArrayList<String>();// creates the arraylist we will then return with all words possible with
        // suitable to the length pf the word, and containing nor letters from the arraylist of guesses passed.
        for(int i = 0; i< dictionary.size(); i++){// goes thorugh alll the word from the dictionary
            if(dictionary.get(i).length() == len){// checks if the length of the word matches the precondition
                 int length_guesses = 0;// this sets the dynamic idex for the while loop below, for checking each letter from the word and the guesses.
                 while(!matches_letter && length_guesses<guesses.size()){
                    if(dictionary.get(i).contains(guesses.get(length_guesses))){
                        matches_letter = true;
                    }
                    length_guesses++;
                }
                 if(!matches_letter){
                         tempArray.add(dictionary.get(i));
                      }
                matches_letter = false;
                  // crwth 
             }
        }
        return tempArray;
    }
}//end class Dictionary

 // precondition is a generic condition that has to be true to work

//polymorphism
        // encapsulation
        //cuplin