package com.shadsluiter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

       

        System.out.println("Welcome to the slider puzzle game!");
        System.out.println("To move a number, enter the number you want to move.");
        System.out.println("The blank space is represented by the number 0.");
        System.out.println("You win when the numbers look like this:");
        System.out.println("+----+----+----+");
        System.out.println("|  1 |  2 |  3 |");
        System.out.println("+----+----+----+");
        System.out.println("|  4 |  5 |  6 |");
        System.out.println("+----+----+----+");
        System.out.println("|  7 |  8 |    |");
        System.out.println("+----+----+----+"); 
        System.out.println("Enter the size of the board: ");
        int size = Integer.parseInt(System.console().readLine());
        Board board = new Board(size);
        System.out.println("===============");  

        printBoard(board);

        while(!board.isSolved()) {
            System.out.println("Enter a number to move: ");
            int n = Integer.parseInt(System.console().readLine());
            board.move(n);
            printBoard(board);
        }
        System.out.println("You win!");
    }

    private static void printBoard(Board board) { 
        int[][] b = board.getBoard();
        for (int i = 0; i < board.getSize(); i++) { 
            for (int j = 0; j < board.getSize(); j++) {
                if (b[i][j] == 0) {
                    System.out.print("    ");
                } else {
                    if(b[i][j] < 10) {
                        System.out.print(" ");
                    }  
                    System.out.print(b[i][j] + "  ");
                     
                } 
            }
            System.out.println();
        }
    } 
}
