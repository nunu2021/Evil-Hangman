/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evilhangman;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 *
 * @author labdhijain
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label wrongGuesses, showWord;
    
    @FXML
    private Button play, go;
    
    @FXML
    private TextField enterChar;
    
    @FXML
    private ImageView hangman = new ImageView();
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        bigPoints = 0;
        play.setVisible(false);
        theGame = new GamePlay();
        player = new Person();
        enterChar.setPromptText("Your Name");
        showWord.setText(theGame.show_word());
        
        
    }
    
    @FXML
    private void enterGuess(ActionEvent event) {
        if(!putName){
            player.set_name(enterChar.getText());
        }else{
            enterChar.setPromptText("Guess A Letter");
        
        wrongGuesses.setText(" ");
        if (!setWord){
            
            
       
            
            theGame.set_underlines((Integer.parseInt(enterChar.getText())));
            showWord.setText(theGame.show_word());
            setWord = true;
            enterChar.setText("");
            enterChar.setPromptText("Guess A Letter");
           
            
        }else{
            setWord = true;
       
        //player.addGuess(guess);
        enterChar.setPromptText("Guess A Letter");
        String guess = enterChar.getText();
        player.addGuess(guess);
        
        if(!theGame.word_found()){
            theGame.if_word_found(player.all_guesses());
        }
        
            
        theGame.compareGuess(guess);
        showWord.setText(theGame.show_word());
        
        if(theGame.matched()){
            player.addRightGuess(guess);
            
            if(player.right_guesses().size() == theGame.length()){
                wrongGuesses.setText("You Won");
                bigPoints+=theGame.length()*10;
                
                setWord = false;
                resetGame();
            }
        }else{
            
            player.addWrongGuess(guess);
            
            
            for(int i = 0; i< player.wrong_guesses().size();i++){
                hangman.setImage(all_images.get(i+1));
            }
            
            if(player.wrong_guesses().size() == 10){
                
                wrongGuesses.setText("GAME OVER");
                setWord = false;
                bigPoints-=10/theGame.length();
                resetGame();
            }
            
            
            
        }
            System.out.println(player.wrong_guesses());
        enterChar.setText("");
        
        for(String theLetter : player.wrong_guesses()){
            
            wrongGuesses.setText(wrongGuesses.getText() + theLetter + " ");
            
        }
        
        
        }
        
        
        
        
        
        
        }
        
        
        
    }
    
    @FXML
    public void set_Scores()
    {
        
        String outFile = "src/resources/Scores.txt";
        ArrayList<String> players = new ArrayList<String>();
       ArrayList<Person> insertionList = new ArrayList<Person>();
//        for(int i = 0; i< 10; i++){
           
//            players.add(new Person());
//            
//            if(players.size()== 1){
//                insertionList.add(players.get(0));
//            }
//         
//                for(int j = 1; j< players.size(); j++){
//                    
//                    int sam = 0;
//                    
//                for(int l = insertionList.size()-1; l>-1 ;l--){
//                    
//                    if(players.get(j).score()>insertionList.get(l).score()){
//                        
//                        sam = insertionList.indexOf(insertionList.get(l));
//                        break;
//                    }
//                }
//                insertionList.add(sam, players.get(j));
//            }
//     
//    for(int k = 0; k<insertionList.size(); k++){
//            if(k<5){
//                System.out.println(insertionList.get(k).name() + " : " + insertionList.get(k).score());
//            }
//        }
//    System.out.println("");}
    }    
    @FXML
    public void resetGame(){
        
        setWord = false;
      hangman.setImage(zero);
        theGame = new GamePlay();
        player = new Person();
        enterChar.setPromptText("Length Of Word");
        showWord.setText(theGame.show_word());
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        zero = new Image("resources/zero.png");
        one = new Image("resources/one.png");
        two= new Image("resources/two.png");
        three= new Image("resources/three.png");
        four= new Image("resources/four.png");
        five= new Image("resources/five.png");
        six= new Image("resources/six.png");
        seven= new Image("resources/seven.png");
        eight= new Image("resources/eight.png");
        nine= new Image("resources/nine.png");
        ten= new Image("resources/ten.png");
        
        all_images = new ArrayList<Image>();
        all_images.add(zero);
        all_images.add(one);
        all_images.add(two);
        all_images.add(three);
        all_images.add(four);
        all_images.add(five);
        all_images.add(six);
        all_images.add(seven);
        all_images.add(eight);
        all_images.add(nine);
        all_images.add(ten);
       
        
        
        
        
            setWord = false;
//   
        
    } 
    
    private ObservableList displayList = FXCollections.observableArrayList();
    private int bigPoints;
    private boolean putName;
    private int points;
 private Person new_player;
 private GamePlay new_game;
    private ArrayList<Image> all_images;
     private Image zero; 
    private Image one;
    private Image two;
     private Image three;
  private Image four;
   private Image  five;
     private Image six;
   private Image seven;
     private Image eight;
     private Image nine;
    private Image ten;
    private  GamePlay theGame;
    private Person player;
    private boolean setWord;
   
    
    
    
}
