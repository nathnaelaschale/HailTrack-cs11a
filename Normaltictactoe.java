import java.util.Scanner;
public class NormalTicTacToeTest{
  public static void main(String[] args){
    Scanner console = new Scanner(System.in);


    String[]  r = {"1", "2", "3", "4", "5", "6", "7", "8", "9","10", "11", "12",
    "13", "14", "15", "16", "17","18","19","20","21","22","23","24",
    "25","26","27"};
    boolean PlayAgain = true;

    System.out.println("Normal Tic-Tac-Toe");

    System.out.println("__________________________");

    System.out.print("This is a 2-player game with a 2-dimentional 3 by");
    System.out.println("3 tic-tac-toe board.");

    System.out.println("First person to get 3 in a row wins!");

    System.out.println("How to play: the computer will display the board, and");
    System.out.println("there will be a number corresponding to each empty space.");
    System.out.println("When prompted, enter the number corresponding to the space where you want to");
    System.out.println("place your piece. Your piece will show up on the board! Have fun :)");
    while (PlayAgain == true) {
      System.out.println("Enter the names of the players:");//gets names of the players
      System.out.println("Enter name of player one.");
      String p1= console.nextLine();
      System.out.println("Enter name of player two.");
      String p2= console.nextLine();

      System.out.println("Who wants to go first:");//gets whos wants to go first
      String player= console.nextLine();

      boards(r);

      Boolean win = false;//a statement that check if someone wins.
      if (p1.equals(player)){//checks which one is the players wants to go.
            do {
              firstplay(r,p1,win,p2);
              if (winboard(r,win,p1,p2)== true|| wincombinedboard(r,win,p1,p2)==true){
                break;
              }
              secondplay(r,p2,win,p1);
              if (winboard(r,win,p1,p2)== true|| wincombinedboard(r,win,p1,p2)==true){
                break;
              }
            }while(win == false);
    //This while loop will let the plays make their moves until someone wins.
        }else {
          do {
            secondplay(r,p2,win,p1);
            if (winboard(r,win,p1,p2)== true|| wincombinedboard(r,win,p1,p2)==true){
              break;
            }
            firstplay(r,p1,win,p2);
            if (winboard(r, win,p1,p2)== true|| wincombinedboard(r,win,p1,p2)== true ){
              break;
            }
          }while(win == false);
        }
        System.out.println("Would you like to play again? (Answer 'yes' or 'no')");
        String YesNo = console.nextLine();
        if (YesNo.equals("no")){
          PlayAgain = false;
        }
      }
    }
public static void firstplay(String[] r, String p1,Boolean win,String p2){//this lets the first player make their move.
      System.out.println(p1+" make your move:");
      Scanner number = new Scanner(System.in);
      int p1Move = number.nextInt();
      p1Move--;
      if(r[p1Move] != "O" && r[p1Move] != "X"){//checks if the place is already taken
        r[p1Move] = "X";//places O when there is no Xs or Os on the board
      }else{
        System.out.println(p1+", it is already taken make another move.");
        firstplay(r,p1,win,p1);
      }
      boards(r);
    }
public static void secondplay(String[] r,String  p2, Boolean win, String p1){
      System.out.println(p2+" make your move:");
      Scanner number = new Scanner(System.in);
      int p2Move = number.nextInt();
      p2Move--;
      if(r[p2Move] != "O" && r[p2Move] != "X"){
        r[p2Move] = "O";
      }else{
        System.out.println(p2+", it is already taken make another move.");
        secondplay(r,p2,win,p1);
      }
      boards(r);
    }

public static void boards(String[] r){//this is boards
      for(int i=0; i<r.length; i++){
        System.out.println("-------------");
        System.out.println("| " + r[i] + " | " + r[i+1] + " | " + r[i+2] + " |");
        i= i+2;
      }
    System.out.println("-------------");
  }

  /* the looop and the this print method are the same but one is more effective than the other
    public static void firstboard(String[][] r){//this is the first board
      System.out.println("---------------");
      System.out.println("| " + r[0] + " | " + r[1] + " | " + r[2] + " |");
      System.out.println("---------------");
      System.out.println("| " + r[3] + " | " + r[4] + " | " + r[5] + " |");
      System.out.println("---------------");
      System.out.println("| " + r[6] + " | " + r[7] + " | " + r[8] + " |");
      System.out.println("---------------");
    }
    public static void secoundboard(String[] r){//this is the secound board
      System.out.println("----------------");
      System.out.println("| " + r[10] + " | " + r[11] + " | " + r[12] + " |");
      System.out.println("----------------");
      System.out.println("| " + r[13] + " | " + r[14] + " | " + r[15] + " |");
      System.out.println("----------------");
      System.out.println("| " + r[16] + " | " + r[17] + " | " + r[18] + " |");
      System.out.println("----------------");
    }
    public static void thirdboard(String[] r){//this is the thrid board
      System.out.println("----------------");
      System.out.println("| " + r[20] + " | " + r[21] + " | " + r[22] + " |");
      System.out.println("----------------");
      System.out.println("| " + r[23] + " | " + r[24] + " | " + r[25] + " |");
      System.out.println("----------------");
      System.out.println("| " + r[26] + " | " + r[27] + " | " + r[28] + " |");
      System.out.println("----------------");
    }
    */

    public static boolean winboard(String[] r, Boolean win, String p1, String p2){
      for(int i=0; i<r.length; i+=3){//this does the row passibility of wining
        if (r[i].equals("X") && r[i+1].equals("X") && r[i+2].equals("X")){
          win = true;
          System.out.println(p1 + " won!!!!!");
          return win;
        }else if (r[i].equals("O") && r[i+1].equals("O") && r[i+2].equals("O")){
          win = true;
          System.out.println(p2 + " won!!!!!");
          return win;
        }
      }

      for(int i=0; i<3; i++){//this does the row passibility of wining
        if (r[i].equals("X") && r[i+3].equals("X") && r[i+6].equals("X")){
          win = true;
          System.out.println(p1 + " won!!!!!");
          return win;
        }else if (r[i].equals("O") && r[i+3].equals("O") && r[i+6].equals("O")){
          win = true;
          System.out.println(p2 + " won!!!!!");
          return win;
        }
      }

      for(int i=10; i<13; i++){//this does the row passibility of wining
        if (r[i].equals("X") && r[i+3].equals("X") && r[i+6].equals("X")){
          win = true;
          System.out.println(p1 + " won!!!!!");
          return win;
        }else if (r[i].equals("O") && r[i+3].equals("O") && r[i+6].equals("O")){
          win = true;
          System.out.println(p2 + " won!!!!!");
          return win;
        }
      }

      for(int i=20; i<23; i++){//this does the row passibility of wining
        if (r[i].equals("X") && r[i+3].equals("X") && r[i+6].equals("X")){
          win = true;
          System.out.println(p1 + " won!!!!!");
          return win;
        }else if (r[i].equals("O") && r[i+3].equals("O") && r[i+6].equals("O")){
          win = true;
          System.out.println(p2 + " won!!!!!");
          return win;
        }
      }

      for(int i=0; i<r.length; i+=10){//this does the colum passibility of wining
        if (r[i+2].equals("X") && r[i+4].equals("X") && r[i+6].equals("X")){
          win = true;
          System.out.println(p1 + " won!!!!!");
          return win;
        }else if (r[i].equals("X") && r[i+4].equals("X") && r[i+8].equals("X")){
          win = true;
          System.out.println(p1 + " won!!!!!");
        }else if (r[i+2].equals("O") && r[i+4].equals("O") && r[i+6].equals("O")){
          win = true;
          System.out.println(p2 + " won!!!!!");
          return win;
        }else if (r[i].equals("O") && r[i+4].equals("O") && r[i+8].equals("O")){
          win = true;
          System.out.println(p2 + " won!!!!!");
          return win;
        }
      }
      return win;
    }
    public static boolean wincombinedboard(String[] r, Boolean win, String p1, String p2){
      if (r[0].equals("X") && r[13].equals("X") && r[26].equals("X")){
        win = true;
        System.out.println(p1 + " won!!!!!");
        return win;
      }else if (r[2].equals("X") && r[13].equals("X") && r[24].equals("X")){
        win = true;
        System.out.println(p1 + " won!!!!!");
        return win;
      }else if (r[1].equals("X") && r[13].equals("X") && r[25].equals("X")){
        win = true;
        System.out.println(p1 + " won!!!!!");
        return win;
      }else if (r[0].equals("X") && r[12].equals("X") && r[24].equals("X")){
        win = true;
        System.out.println(p1 + " won!!!!!");
        return win;
      }else if (r[2].equals("X") && r[14].equals("X") && r[26].equals("X")){
        win = true;
        System.out.println(p1 + " won!!!!!");
        return win;
      }if (r[0].equals("O") && r[13].equals("O") && r[26].equals("O")){
        win = true;
        System.out.println(p2 + " won!!!!!");
        return win;
      }else if (r[2].equals("O") && r[13].equals("O") && r[24].equals("O")){
        win = true;
        System.out.println(p2 + " won!!!!!");
        return win;
      }else if (r[1].equals("O") && r[13].equals("O") && r[25].equals("O")){
        win = true;
        System.out.println(p2 + " won!!!!!");
        return win;
      }else if (r[0].equals("O") && r[12].equals("O") && r[24].equals("O")){
        win = true;
        System.out.println(p2 + " won!!!!!");
        return win;
      }else if (r[2].equals("O") && r[14].equals("O") && r[26].equals("O")){
        win = true;
        System.out.println(p2 + " won!!!!!");
        return win;
      }else{
        win = false;
        return win;
      }
    }


}
