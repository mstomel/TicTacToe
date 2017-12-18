package com.company;

class boardState {

    static String [][] board;
    boardState(){

        board = new String[3][3];
        for (int i = 0; i<board.length; i++) {
            for (int j = 0; j<board[0].length; j++) {
                board[i][j]= "N ";
            }
        }
    }
}