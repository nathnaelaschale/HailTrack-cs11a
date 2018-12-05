/**
* This class allows users to play either classic Tic Tac Toe or
* Three Dimensional Tic Tac Toe. This program will continue running
* until the user decides they would no longer like to play. Both 
* games of Tic Tac Toe have been created using one-dimensional arrays.
*
* @version 1.10 03 Dec 2018
* @author Nathnael Aschale
* @author Alexander Cortez
* @author Anna Machata
* @author Jesse Pejcha
* @author Iria Wang
 */

import java.util.*;

public class TicTacToe {
	public static Scanner console = new Scanner(System.in);
	public static String firstPlayer = "";
	public static String secondPlayer = "";//establishes variables of player names

	public static void main(String[] args) {
		System.out.println("Hello! You are currently playing HailTrack's TicTacToe. Which game "
				+ "would you like to play? Input to number corresponding to your choice.");
		System.out.println("1  Normal TicTacToe");
		System.out.println("2  3D TicTacToe");
		int choice = console.nextInt();//allows players to select Normal TicTacToe or 3D TicTacToe
		while (choice != 1 && choice != 2) {
			System.out.println("Error: Please enter the number corresponding to the game of your choice.");
			choice = console.nextInt(); //makes sure players select a valid game option, and sends them into a loop until they do.
		}
		if (choice == 1) {
			NormalTicTacToe();
		}
		if (choice == 2) {
			ThreeDTicTacToe();
		}
	}

	/**
 	* This method allows players to play NormalTicTacToe, with a 3 by 3 board. It also alerts
	* players if they have tied, and provides the players with the option to play again if 
 	* they would like to.
 	*/
	
	public static void NormalTicTacToe() {
		boolean PlayAgain = true; //Boolean which allows the game to run. Can be changed by user at end of game.
		System.out.println("Normal Tic-Tac-Toe");
		System.out.println("________________________________");
		System.out.println("This is a 2-player game with a 2-dimensional 3 by 3 Tic-Tac-Toe board.");
		System.out.println("First person to get 3 in a row wins!");
		System.out.println("_____________________");
		System.out.println("How to play: the computer will display the board, and there will "
				+ "be a number corresponding to each empty space. When prompted, enter the "
				+ "number corresponding to the space where you want to place your piece. Your "
				+ "piece will show up on the board! Have fun :)");
		while (PlayAgain == true) {
			String[] board = { "1", "2", "3", "4", "5", "6", "7", "8", "9" }; //array representing game board.
			int counter = 1; //counter is established to determine that the players tied if they make enough moves to fill the board.
			System.out.println("Enter name of player one: ");
			String p1 = console.next();
			System.out.println("Enter name of player two: ");
			String p2 = console.next();
			System.out.println("Who wants to go first? ");
			firstPlayer = console.next();
			if (firstPlayer.equals(p1)) {
				secondPlayer = p2;
			} else {
				secondPlayer = p1;
			}
			printBoards(board);
			boolean win = false;
			do {
				firstplay(board);//allows first player to make a move
				win = winThreeByThreeTest(board);
				if (win == true) {//breaks out of gameplay if someone has won
					break;
				}
				if (counter > 8) {//breaks out of gameplay if players have tied
					break;
				}
				counter++;
				secondplay(board);//allows second player to make a move
				win = winThreeByThreeTest(board);
				if (win == true) {//breaks out of gameplay if someone has won
					break;
				}
				counter++;
			} while (win == false);
			if (win == false){
				System.out.println("Nice work, but it's a tie! Great game!");
			}
			System.out.println("Would you like to play again? (Answer 'yes' or 'no')");//Asks if players would like to play again
			String YesNo = console.next();
			while (!YesNo.equalsIgnoreCase("yes") && !YesNo.equalsIgnoreCase("no")) {
				System.out.println("Error: Please enter 'yes' or 'no'.");
				YesNo = console.next();
			}
			if (YesNo.equalsIgnoreCase("no")) {
				PlayAgain = false;
			}
		}
	}
	/**
 	* This method allows players to play ThreeDTicTacToe, with three 3 by 3 boards. This method has no option
	*for tying because it is impossible to tie in Three Dimensional TicTacToe. This method also provides
	*the players with the option to play again if they would like to.
 	*/
	public static void ThreeDTicTacToe() {
		boolean PlayAgain = true; //Boolean which allows the game to run. Can be changed by user at end of game.
		System.out.println("3D Tic-Tac-Toe");
		System.out.println("________________________________");
		System.out.println("This is a 2-player game with a 3-dimensional 3 by 3 by 3 Tic-Tac-Toe board.");
		System.out.println("First person to get 3 in a row wins!");
		System.out.println("_____________________");
		System.out.println("How to play: the computer will display the board, and there will "
				+ "be a number corresponding to each empty space. When prompted, enter the "
				+ "number corresponding to the space where you want to place your piece. Your "
				+ "piece will show up on the board! Have fun :)");
		while (PlayAgain == true) {
			String[] board = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
					"18", "19", "20", "21", "22", "23", "24", "25", "26", "27" };
			System.out.println("Enter name of player one: ");
			String p1 = console.next();
			System.out.println("Enter name of player two: ");
			String p2 = console.next();
			System.out.println("Who wants to go first? ");
			firstPlayer = console.next();
			if (firstPlayer.equals(p1)) {
				secondPlayer = p2;
			} else {
				secondPlayer = p1;
			}
			printBoards(board);
			boolean win = false;
			do {
				firstplay(board);//allows the first player to make a move
				if (winThreeByThreeTest(board) == true || winCombinedBoardTest(board) == true) {//tests to see if anyone has won
					win = true;
				}
				if (win == true) {
					break;//breaks out of gameplay if someone has won
				}
				secondplay(board);//allows the second player to make a move
				if (winThreeByThreeTest(board) == true || winCombinedBoardTest(board) == true) {//tests to see if anyone has won
					win = true;
				}
				if (win == true) {
					break;//breaks out of gameplay if someone has won
				}
			} while (win == false);
			System.out.println("Would you like to play again? (Answer 'yes' or 'no')");//Allows players to choose to play again
			String YesNo = console.next();
			while (!YesNo.equalsIgnoreCase("yes") && !YesNo.equalsIgnoreCase("no")) {
				if (YesNo.equalsIgnoreCase("no")) {
					PlayAgain = false;
				}
			}
		}
	}
	/**
 	* This method allows the first player to make a move in either game. 
	*It sends an error message if a spot is taken or nonexistant, and
	*prints the board(s) after the player has moved.
 	*/
	public static void firstplay(String[] board) {
		System.out.println(firstPlayer + " make your move:");
		Scanner number = new Scanner(System.in);
		int move = number.nextInt();//this is the space selected by the player to place an "X"
		move--;//this translates the name of the space that the user selects to its location on the board array
		if (move < 0 || move > board.length) {
			System.out.println("That spot does not exist, make another move");
			firstplay(board);
		}
		if (board[move] != "O" && board[move] != "X") {
			board[move] = "X";
		} else {
			System.out.println("That spot is already taken, make another move.");
			firstplay(board);
		}
		printBoards(board);//prints the board(s)
	}
	/**
 	* This method allows the second player to make a move in either game. 
	*It sends an error message if a spot is taken or nonexistant, and
	*prints the board(s) after the player has moved.
 	*/
	public static void secondplay(String[] board) {
		System.out.println(secondPlayer + " make your move:");
		Scanner number = new Scanner(System.in);
		int move = number.nextInt();//this is the space selected by the player to place an "O"
		move--;//this translates the name of the space that the user selects to its location on the board array
		if (move < 0 || move > board.length) {
			System.out.println("That spot does not exist, make another move");
			secondplay(board);
		}
		if (board[move] != "O" && board[move] != "X") {
			board[move] = "O";
		} else {
			System.out.println("That spot is already taken, make another move.");
			secondplay(board);
		}
		printBoards(board);//prints the board(s)
	}
	/**
 	* This method prints the board or boards by printing the board array.
 	*/
	public static void printBoards(String[] board) {
		for (int i = 0; i < board.length; i += 3) {
			System.out.println("-------------");
			System.out.println("| " + board[i] + " | " + board[i + 1] + " | " + board[i + 2] + " |");
			if (i == 6 || i == 15 || i == 24) {
				System.out.println("-------------");
				System.out.println();
			}
		}
	}
	/**
 	* This method tests if players won in a line on a singular board rather
	*than by a pattern across multiple boards, and prints a win statement
	*if a player has won. It returns a true boolean if someone has won.
 	*/
	public static boolean winThreeByThreeTest(String[] board) {
		boolean win = false;
		for (int i = 0; i < board.length; i += 3) {
			if (board[i].equals("X") && board[i + 1].equals("X") && board[i + 2].equals("X")) {
				win = true;
				System.out.println("Congratulations," + firstPlayer + " won!!!!!");
			} else if (board[i].equals("O") && board[i + 1].equals("O") && board[i + 2].equals("O")) {
				win = true;
				System.out.println("Congratulations," + secondPlayer + " won!!!!!");
			}
		}
		for (int i = 0; i < board.length - 5; i++) {
			if (board[i].equals("X") && board[i + 3].equals("X") && board[i + 6].equals("X")) {
				win = true;
				System.out.println("Congratulations," + firstPlayer + " won!!!!!");
			} else if (board[i].equals("O") && board[i + 3].equals("O") && board[i + 6].equals("O")) {
				win = true;
				System.out.println("Congratulations," + secondPlayer + " won!!!!!");
			}
			if (i == 2 || i == 11) {
				i += 6;
			}
		}
		if (board[0].equals("X") && board[4].equals("X") && board[8].equals("X")) {
			win = true;
			System.out.println("Congratulations," + firstPlayer + " won!!!!!");
		}
		if (board[2].equals("X") && board[4].equals("X") && board[6].equals("X")) {
			win = true;
			System.out.println("Congratulations," + firstPlayer + " won!!!!!");
		}
		if (board[0].equals("O") && board[4].equals("O") && board[8].equals("O")) {
			win = true;
			System.out.println("Congratulations," + secondPlayer + " won!!!!!");
		}
		if (board[2].equals("O") && board[4].equals("O") && board[6].equals("O")) {
			win = true;
			System.out.println("Congratulations," + secondPlayer + " won!!!!!");
		}
		return win;
	}
	/**
 	* This method tests if players have won in a variety of ways on a 3D
	*TicTacToe board, including cross vertical wins, cross horizontal wins,
	*and cross diagonal wins. It returns a printed win statement and
	*a true boolean if someone has won.
 	*/
	public static boolean winCombinedBoardTest(String[] board) {
		boolean win = false;
		for (int i = 0; i < 9; i++) {//this loop defines a vertical win between the three boards
			if (board[i].equals("X") && board[i + 9].equals("X") && board[i + 18].equals("X")) {
				win = true;
				System.out.println("Congratulations," + firstPlayer + " won!!!!!");
			} else if (board[i].equals("O") && board[i + 9].equals("O") && board[i + 18].equals("O")) {
				win = true;
				System.out.println("Congratulations," + secondPlayer + " won!!!!!");
			}
		}
		for (int i = 0; i < 7; i += 3) {//defines a left to right horizontal diagonal win amongst 3 boards
			if (board[i].equals("X") && board[i + 10].equals("X") && board[i + 20].equals("X")) {
				win = true;
				System.out.println("Congratulations," + firstPlayer + " won!!!!!");
			} else if (board[i].equals("O") && board[i + 10].equals("O") && board[i + 20].equals("O")) {
				win = true;
				System.out.println("Congratulations," + secondPlayer + " won!!!!!");
			}
		}
		for (int i = 2; i < 9; i += 3) {//defines a left to right horizontal diagonal win amongst 3 boards
			if (board[i].equals("X") && board[i + 8].equals("X") && board[i + 16].equals("X")) {
				win = true;
				System.out.println("Congratulations," + firstPlayer + " won!!!!!");
			} else if (board[i].equals("O") && board[i + 8].equals("O") && board[i + 16].equals("O")) {
				win = true;
				System.out.println("Congratulations," + secondPlayer + " won!!!!!");
			}
		}
		for (int i = 0; i < 3; i++) {//defines a top to bottom diagonal win amongst 3 boards
			if (board[i].equals("X") && board[i + 12].equals("X") && board[i + 24].equals("X")) {
				win = true;
				System.out.println("Congratulations," + firstPlayer + " won!!!!!");
			} else if (board[i].equals("O") && board[i + 12].equals("O") && board[i + 24].equals("O")) {
				win = true;
				System.out.println("Congratulations," + secondPlayer + " won!!!!!");
			}
		}
		for (int i = 6; i < 9; i++) {//defines a bottom to top diagonal win amongst 3 boards
			if (board[i].equals("X") && board[i + 6].equals("X") && board[i + 12].equals("X")) {
				win = true;
				System.out.println("Congratulations," + firstPlayer + " won!!!!!");
			} else if (board[i].equals("O") && board[i + 6].equals("O") && board[i + 12].equals("O")) {
				win = true;
				System.out.println("Congratulations," + secondPlayer + " won!!!!!");
			}
		}//the following loops describe diagonal diagonal wins amongst the three boards
		if (board[0].equals("X") && board[13].equals("X") && board[26].equals("X")) {
			win = true;
			System.out.println("Congratulations," + firstPlayer + " won!!!!!");
		}
		if (board[2].equals("X") && board[13].equals("X") && board[24].equals("X")) {
			win = true;
			System.out.println("Congratulations," + firstPlayer + " won!!!!!");
		}
		if (board[0].equals("O") && board[13].equals("O") && board[26].equals("O")) {
			win = true;
			System.out.println("Congratulations," + secondPlayer + " won!!!!!");
		}
		if (board[2].equals("O") && board[13].equals("O") && board[24].equals("O")) {
			win = true;
			System.out.println("Congratulations," + secondPlayer + " won!!!!!");
		}
		return win;
	}
}
