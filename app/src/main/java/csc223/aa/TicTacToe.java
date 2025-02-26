package csc223.aa;

import java.util.Scanner;

public class TicTacToe implements Game{
    
    char[][] grid = {
        {'_','_','_'},
        {'_','_','_'},
        {'_','_','_'}
    };
    
    //false player is player 1 and true is player 2
    boolean player = false;
    int maxturnsleft = 9;

    public static void main(String[] args){
        TicTacToe game = new TicTacToe(); 
        game.startGame();
    }

    @Override
    public void startGame(){
        //asks user to play, if yes start game
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
        //keep playing game while max turns is not exceeded and while no one wins
        while (maxturnsleft > 0 & !(isGameOver())){
            takeTurn();
            printBoard();

        }
    }
    
    @Override
    public void takeTurn(){
        //tells players whos turn it is 
        Scanner scn = new Scanner(System.in);
        char symbol;

        if (player){
            System.out.println("Player two's (O's) turn.");
            player = false;
            symbol = 'O';
        }
        else{
            System.out.println("Player one's (X's) turn.");
            player = true;
            symbol = 'X';
        }
        //asks players to pick a square
        System.out.println("Enter square: (e.g.  A0): ");
        printBoard();
        String input = scn.nextLine();

        //fills in grid based on players decision
        char[] coordinate = input.toCharArray();
        int column = Character.getNumericValue(coordinate[1]);
        if (coordinate[0] == 'A'){
            grid[column][0] = symbol;
        }
        if (coordinate[0] == 'B'){
            grid[column][1] = symbol;
        }
        if (coordinate[0] == 'C'){
            grid[column][2] = symbol;
        }
        maxturnsleft--;
    }

    @Override
    public void printBoard(){
            //prints boardview
            System.out.println("  A B C");
            for (int i = 0; i < 3; i++) {
                System.out.print(i);
                for (int j = 0; j < 3; j++) {
                    System.out.print(" " + grid[i][j]);
                }
                System.out.println();
            }
    }

    @Override
    public void endGame(){
        //determines who wins by calling isGameOver and outputs accordingly
        if (isGameOver()){
            if (player){
                System.out.println("Player 1 (X) wins!");
            } 

            else{
                System.out.println("Player 2 (O) wins!");
            }
        } 
        else{
            System.out.println("It's a draw!");
        }
    }

    @Override
    public boolean isGameOver(){
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++){
            // Row win
            if (grid[i][0] != '_' && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]){
                return true; 
            }
            // Column win
            if (grid[0][i] != '_' && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]){
                return true; 
            }
        }

        // Diagonal wins
        if (grid[0][0] != '_' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]){
            return true; 
        }
        
        if (grid[0][2] != '_' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]){
            return true;
        }

        // Checks if spaces are filled
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == '_') {
                    return false;
                }
            }
        }

        return false; 
    }
}
    

