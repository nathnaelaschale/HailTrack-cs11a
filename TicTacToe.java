import java.util.*;

public class TicTacToe {
	public static Scanner console = new Scanner(System.in);
	public static String firstPlayer = "";
	public static String secondPlayer = "";

	public static void main(String[] args) {
		System.out.println("Hello! You are currently playing HailTrack's TicTacToe. Which game "
				+ "would you like to play? Input to number corresponding to your choice.");
		System.out.println("1  Normal TicTacToe");
		System.out.println("2  3D TicTacToe");
		int choice = console.nextInt();
		while (choice != 1 && choice != 2) {
			System.out.println("Error: Please enter the number corresponding to the game of your choice.");
			choice = console.nextInt();
		}
		if (choice == 1) {
			NormalTicTacToe();
		}
		if (choice == 2) {
			ThreeDTicTacToe();
		}
	}

	public static void NormalTicTacToe() {

	}

	public static void ThreeDTicTacToe() {
		String[] board = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
				"18", "19", "20", "21", "22", "23", "24", "25", "26", "27" };
		boolean PlayAgain = true;
		System.out.println("Normal Tic-Tac-Toe");
		System.out.println("________________________________");
		System.out.println("This is a 2-player game with a 2-dimentional 3 by 3 Tic-Tac-Toe board.");
		System.out.println("First person to get 3 in a row wins!");
		System.out.println("_____________________");
		System.out.println("How to play: the computer will display the board, and there will "
				+ "be a number corresponding to each empty space. When prompted, enter the "
				+ "number corresponding to the space where you want to place your piece. Your "
				+ "piece will show up on the board! Have fun :)");
		while (PlayAgain == true) {
			System.out.println("Enter name of player one:");
			String p1 = console.nextLine();
			System.out.println("Enter name of player two:");
			String p2 = console.nextLine();
			System.out.println("Who wants to go first? ");
			firstPlayer = console.nextLine();
			if (firstPlayer == p1) {
				secondPlayer = p2;
			} else {
				secondPlayer = p1;
			}
			printBoards(board);
			boolean win = false;
			do {
				firstplay(board, firstPlayer);
				if (winThreeByThreeTest(board, win) == true || winCombinedBoardTest(board, win) == true) {
					break;
				}
				secondplay(board, secondPlayer);
				if (winThreeByThreeTest(board, win) == true || winCombinedBoardTest(board, win) == true) {
					break;
				}
			} while (win == false);
		}
		System.out.println("Would you like to play again? (Answer 'yes' or 'no')");
		String YesNo = console.nextLine();
		while (!YesNo.equalsIgnoreCase("yes") && !YesNo.equalsIgnoreCase("no"))
			if (YesNo.equalsIgnoreCase("no")) {
				PlayAgain = false;
			}
	}

	public static void firstplay(String[] board, String currentPlayer) {
		System.out.println(currentPlayer + " make your move:");
		Scanner number = new Scanner(System.in);
		int move = number.nextInt();
		move--;
		if (move < 0 || move > board.length) {
			System.out.println("That spot does not exist, make another move");
			firstplay(board, currentPlayer);
		}
		if (board[move] != "O" && board[move] != "X") {
			board[move] = "X";
		} else {
			System.out.println("That spot is already taken, make another move.");
			firstplay(board, currentPlayer);
		}
		printBoards(board);
	}

	public static void secondplay(String[] board, String currentPlayer) {
		System.out.println(currentPlayer + " make your move:");
		Scanner number = new Scanner(System.in);
		int move = number.nextInt();
		move--;
		if (move < 0 || move > board.length) {
			System.out.println("That spot does not exist, make another move");
			firstplay(board, currentPlayer);
		}
		if (board[move] != "O" && board[move] != "X") {
			board[move] = "O";
		} else {
			System.out.println("That spot is already taken, make another move.");
			secondplay(board, currentPlayer);
		}
		printBoards(board);
	}

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

	public static boolean winThreeByThreeTest(String[] board, Boolean win) {
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
		return win;
	}

	public static boolean winCombinedBoardTest(String[] board, Boolean win) {
		for (int i = 0; i < 9; i++) {
			if (board[i].equals("X") && board[i + 9].equals("X") && board[i + 18].equals("X")) {
				win = true;
				System.out.println("Congratulations," + firstPlayer + " won!!!!!");
			} else if (board[i].equals("O") && board[i + 9].equals("O") && board[i + 18].equals("O")) {
				win = true;
				System.out.println("Congratulations," + secondPlayer + " won!!!!!");
			}
		}
		for (int i = 0; i < 7; i += 3) {
			if (board[i].equals("X") && board[i + 10].equals("X") && board[i + 20].equals("X")) {
				win = true;
				System.out.println("Congratulations," + firstPlayer + " won!!!!!");
			} else if (board[i].equals("O") && board[i + 10].equals("O") && board[i + 20].equals("O")) {
				win = true;
				System.out.println("Congratulations," + secondPlayer + " won!!!!!");
			}
		}
		for (int i = 2; i < 9; i += 3) {
			if (board[i].equals("X") && board[i + 8].equals("X") && board[i + 16].equals("X")) {
				win = true;
				System.out.println("Congratulations," + firstPlayer + " won!!!!!");
			} else if (board[i].equals("O") && board[i + 8].equals("O") && board[i + 16].equals("O")) {
				win = true;
				System.out.println("Congratulations," + secondPlayer + " won!!!!!");
			}
		}
		for (int i = 0; i < 3; i++) {
			if (board[i].equals("X") && board[i + 12].equals("X") && board[i + 24].equals("X")) {
				win = true;
				System.out.println("Congratulations," + firstPlayer + " won!!!!!");
			} else if (board[i].equals("O") && board[i + 12].equals("O") && board[i + 24].equals("O")) {
				win = true;
				System.out.println("Congratulations," + secondPlayer + " won!!!!!");
			}
		}
		for (int i = 6; i < 9; i++) {
			if (board[i].equals("X") && board[i + 6].equals("X") && board[i + 12].equals("X")) {
				win = true;
				System.out.println("Congratulations," + firstPlayer + " won!!!!!");
			} else if (board[i].equals("O") && board[i + 6].equals("O") && board[i + 12].equals("O")) {
				win = true;
				System.out.println("Congratulations," + secondPlayer + " won!!!!!");
			}
		}
		if (board[0].equals("X") && board[13].equals("X") && board[26].equals("X")) {
			win = true;
			System.out.println(firstPlayer + " won!!!!!");
		}
		if (board[2].equals("X") && board[13].equals("X") && board[24].equals("X")) {
			win = true;
			System.out.println(firstPlayer + " won!!!!!");
		}
		return win;
	}
}
