package csc223.aa;

import java.util.Arrays;
import java.util.Scanner;

public class WordGuess implements Game{
    // Word to be guessed and the initial guess (hidden letters represented by underscores)
    char[] word = {'c','h','a','n','g','e'};
    char[] guess = {'_','_','_','_','_','_'};
    int lives = word.length;
    
    public static void main(String[] args) {
        WordGuess game = new WordGuess(); 
        game.startGame();
    }
    
    @Override
    public void startGame(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Do You Wanna Play(y/n): ");
        String input = scn.nextLine();

        if (input.equals("y")){
                playGame();
        }
        endGame();

    }

    @Override
    public void playGame(){
        while (lives > 0){
            takeTurn();
            printBoard();
        }
    }
    
    @Override
    public void takeTurn(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Guess the letter or the entire word:");
        String input = scn.nextLine();

        if (input.length() > 1){
            if (input.equals(new String(word))){  
                guess = word; 
                endGame();
            } 
            else{
                System.out.println("You have " + lives + " lives chances remaining");
                lives--;
            }
        } 

        else {
            boolean correctGuess = false;
            for (int i = 0; i < word.length; i++){
                if (word[i] == input.charAt(0)){ 
                    guess[i] = word[i];
                    correctGuess = true;
                }
            }
            if (!(correctGuess)){
                System.out.println("You have " + lives + " lives chances remaining");
                lives--;
            }
        }  
    }

    @Override
    public void printBoard(){
        for (int i = 0; i < guess.length; i++){
            System.out.print(guess[i] + " ");  
        }
        System.out.println();
    }

    @Override
    public void endGame(){
        if (isGameOver()){
            System.out.println("Game over.");

        }
        
    }

    @Override
    public boolean isGameOver(){
        if (Arrays.equals(guess, word)){
            System.out.println("Congrats! Your guess was correct. The word was '" + new String(word) + "'.");
            return true;
        } 
        else if (lives == 0){
            System.out.println("Game over! The word was: " + new String(word));
            return true;
        }
        return false;
    }
}
    
