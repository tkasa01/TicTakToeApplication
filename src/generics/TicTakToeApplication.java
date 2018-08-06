package generics;

import java.util.Scanner;

public class TicTakToeApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean doYouWantToPlay = true;
        while (doYouWantToPlay){
            System.out.println("Welcome to Tic Tak Toe!\n");
            System.out.println();

            System.out.println("Enter a single character that will represent you on the board.");
            char playerToken = sc.next().charAt(0);

            System.out.println("Enter a single character that will represent your opponent on the board");
            char opponentToken = sc.next().charAt(0);

            TicTakToe game = new TicTakToe(playerToken, opponentToken);
            AI ai = new AI();

            //Set up the game
            System.out.println();
            System.out.println("Start the game.\n ");
            TicTakToe.printIndexBoard();
            System.out.println();

            while (game.gameOver().equals("notOver")) {
                if(game.currentMarker == game.userMarker){
                    System.out.println("It is your turn");
                    int spot = sc.nextInt();
                    while (!game.playTurn(spot)){
                        System.out.println("Try again " + spot + " is invalid this sport is already taken");
                        spot = sc.nextInt();
                    }
                    System.out.println("You picked " + spot +  "!");
                }else{
                    System.out.println("It's my turn!");
                    int aiSpot = ai.pickSpot(game);
                    game.playTurn(aiSpot);
                    System.out.println("I picked "+ aiSpot + "!");
                }
                //Print out new board
                System.out.println();
                game.printBoard();
            }
            System.out.println(game.gameOver());
            System.out.println();

            //set up a new game
            System.out.println(" Do you want to play again? Enter Y");
            char response = sc.next().charAt(0);
            doYouWantToPlay = (response == 'Y');
            System.out.println();
            System.out.println();
        }
    }
}
