public class NormalTicTacToe{
  public static void main(String[] args){

    String[]  r = {"1", "2", "3", "4", "5", "6", "7", "8", "9","10", "11", "12",
    "13", "14", "15", "16", "17","18","19","20","21","22","23","24",
    "25","26","27"};

    firstboard(r);//prints the first board
    secoundboard(r);//prints the secound board
    thirdboard(r);//prints the third board

    System.out.println("Normal Tic-Tac-Toe");

    System.out.println("__________________________");

    System.out.println("This is a 2-player game with a 2-dimentional 3 by
    3 tic-tac-toe board.");

    System.out.println("First person to get 3 in a row wins!");

    System.out.println("How to play: the computer will display the board, and
    there will be a number corresponding to each empty space. When prompted,
    enter the number corresponding to the space where you want to place your
    piece. Your piece will show up on the board! Have fun :)");

    System.out.println("Enter a numes of the players:");//gets names of the players
    String p1= TextIO.getlnWord();
    String p2= TextIO.getlnWord();

    System.out.println("Who wants to go first:");//gets whos wants to go first
    String player= TextIO.getlnWord();

    Boolean win = false;//a statement that check if someone wins.
    if (p1.equals(player)){//checks which one is the players wants to go.
      while(win == false){
    //This while loop will let the plays make their moves until someone wins.
        firstplay(r,p1);
        secondplay(r,p2);
      }
    }else{
      while(win == false){
        secondplay(r,p2);
        firstplay(r,p1);
      }
    }

    NormalTicTacToeBoard(data);
    System.out.println(player1+ " make your move:");
    int p1Move = TextIO.getlnInt();
    p1Move--;
    data[p1Move] = "x";
    NormalTicTacToeBoard(data);
  }
  public static void firstplay(String[] r, String p1){//this lets the first player make their move.
  System.out.println(p1+" make your move:");
  int p1Move = TextIO.getlnInt();
  if(r[p1move] != "O" & r[p1move] = "X"){//checks if the place is already taken
    int p1move= p1Move-1;
    r[p1move] = "O";//places O when there is no Xs or Os on the board
  }else{
    System.out.println(p1+", it is already taken make another move.");
    firstplay(r,p2);
  }
  firstboard(r);
  secoundboard(r);
  thirdboard(r);
}
  public static void secondplay(String[] r,String  p2){
    System.out.println(p2+" make your move:");
    int p2Move = TextIO.getlnInt();
    if(r[p2move] != "O" & r[p2move] = "X"){
      int p2move= p2Move-1;
      r[p2move] = "O";
    }else{
      System.out.println(p2+" it is already taken make another move.");
      secondplay(r,p2);
    }
    firstboard(r);
    secoundboard(r);
    thirdboard(r);
  }
  
  public static void NormalTicTacToeBoard(String[] r){
    System.out.println("-------------");
    System.out.println("| " + r[0] + " | " + r[1] + " | " + r[2] + " |");
    System.out.println("-------------");
    System.out.println("| " + r[3] + " | " + r[4] + " | " + r[5] + " |");
    System.out.println("-------------");
    System.out.println("| " + r[6] + " | " + r[7] + " | " + r[8] + " |");
    System.out.println("-------------");
  }

  public static boolean winfirstboard(String[] r){

  }

  public static boolean winsecoundboard(String[] r){

  }

  public static boolean winthirdboard(String[] r){

  }
  public static boolean wincominedboard(String[] r){

  }






}
