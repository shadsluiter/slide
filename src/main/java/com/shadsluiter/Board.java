package com.shadsluiter;

public class Board {

    // properties of the class
    // length of one side of the board
    private int size;
    // 2d array of integers to represent the squares of the board
    private int[][] board;

    // methods

    // constructor
    public Board(int size) {
        this.size = size;
        this.board = new int[size][size];
        int n = 0;
        // fill the board with numbers from 1 to size * size - 1
        // and leave the last cell empty
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                n++;
                if (n == size * size) {
                    board[i][j] = 0;
                } else {
                    board[i][j] = n;
                }
            }
        }
        shuffle();
    }

    // scramble the board
    public void shuffle() {
        // shuffle the board by making 10000 random moves
       for(int i=0; i < 10000; i++) {
           int n = (int) (Math.random() * size * size);
           move(n);
       }
    }

    // return True if the pieces are in order
    public boolean isSolved() {
        // check if the board is solved. The board is solved if the numbers are in order
        int n = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                n++;
                if (n == size * size) {
                    return true;
                }
                if (board[i][j] != n) {
                    return false;
                }
            }
        }
        return true;
    }

    // get a number n and move the number n to the empty cell.
    // if n is not next to the empty cell, do nothing
    public void move(int n) {
        // row and col are the coordinates of the cell with the number n
        int row = -1;
        int col = -1; 
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j < size ; j++) {
                if (board[i][j] == n) {
                    row = i;
                    col = j; 
                }
            }
        }
        // row and col are the coordinates of the cell with the number n

        // find the empty cell next to the cell with the number n
        // and swap the two cells
 
        if (isOnBoard(row - 1, col) && board[row - 1][col] == 0) {
            // n is north of the empty cell
            board[row - 1][col] = n;
            board[row][col] = 0;
        } else if (isOnBoard(row + 1, col) && board[row + 1][col] == 0) {
            // n is south of the empty cell
            board[row + 1][col] = n;
            board[row][col] = 0;
        } else if (isOnBoard(row, col - 1) && board[row][col - 1] == 0) {
            // n is west of the empty cell
            board[row][col - 1] = n;
            board[row][col] = 0;
        } else if (isOnBoard(row, col + 1) && board[row][col + 1] == 0) {
            // n is east of the empty cell
            board[row][col + 1] = n;
            board[row][col] = 0;
        }
        
    }

    // helper method to check if the cell with coordinates i, col is on the board.
    // return True if the cell is on the board
    private boolean isOnBoard(int i, int col) {
        return i >= 0 && i < size && col >= 0 && col < size;
    }

    // getters and setters
    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}
