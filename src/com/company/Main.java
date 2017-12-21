package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        new boardState();
        Scanner hello = new Scanner(System.in);

        for (int i = 0; i<boardState.board.length; i++) {
            for (int j = 0; j<boardState.board.length; j++) {
                System.out.print(boardState.board[i][j]);
            }
            System.out.println();
        }

        System.out.println("who will go first? (CPU=0, User=1)");
        int start = hello.nextInt();
        System.out.println("coordinates are based on 0 1 and 2 ie top left is (0,0) and bottom right is (2,2)");
        System.out.println("CPU is X User is O");

        if (start == 0) {
            boardState.board[0][0] = "X ";
            printBoard();
            System.out.println("where would you like to play ex: 12 for (1,2)");
            userTurn(hello.next());
            if (!boardState.board[1][1].equals("O ")) {
                boardState.board[1][1] = "X ";
            }
            else {
                boardState.board[2][0] = "X ";
            }
            printBoard();

            System.out.println("where would you like to play?");
            userTurn(hello.next());
            if (boardState.board[2][0].equals("N ")) {
                boardState.board[2][0] = "X ";
            }
            else if (boardState.board[1][1].equals("X ")) {
                boardState.board[2][2] = "X ";
            }
            printBoard();
            if (winCheck()) {
                System.exit(1);
            }


        }
        else if (start == 1) {

        }
        else {
            System.out.println("invalid input");
        }
    }
    private static void blockCheck() {
        Integer count, tempI, tempJ;
        for (int i = 0; i<boardState.board.length; i++) {
            count = 0; tempI = 0; tempJ = 0;
            for (int j = 0; j<boardState.board.length; j++) {
                if (boardState.board[i][j].equals("O ")) {
                    count++;tempI+=i;tempJ+=j;
                }
                if (count == 2) {

                }
            }
        }
    }
    private static void printBoard() {
        for (int i = 0; i<boardState.board.length; i++) {
            for (int j = 0; j<boardState.board.length; j++) {
                System.out.print(boardState.board[i][j]);
            }
            System.out.println();
        }
    }
    private static void userTurn(String coordinates) {
        boardState.board[Integer.valueOf(coordinates.substring(0, 1))][Integer.valueOf(coordinates.substring(1, 2))] = "O ";
    }
    private static boolean winCheck() {

        for (int i = 0; i <= 2; i++) {
            int Comp = 0, Use = 0;
            for (int j = 0; j <= 2; j++) {
                String temp = boardState.board[i][j];
                if (temp.equals("X")) {
                    Comp++;
                }
                else if (temp.equals("O")) {
                    Use++;
                }
            }
            if (Comp==3) {
                System.out.println("CPU wins");
                return true;
            }
            else if (Use==3) {
                System.out.println("User wins");
                return true;
            }
        }

        for (int i = 0; i <= 2; i++) {
            int Comp = 0, Use = 0;
            for (int j = 0; j <= 2; j++) {
                String temp = boardState.board[j][i];
                if (temp.equals("X")) {
                    Comp++;
                }
                else if (temp.equals("O")) {
                    Use++;
                }
            }
            if (Comp==3) {
                System.out.println("CPU wins");
                return true;
            }
            else if (Use==3) {
                System.out.println("User wins");
                return true;
            }
        }

        if (boardState.board[0][0].equals("X") && boardState.board[1][1].equals("X") && boardState.board[2][2].equals("X")) {
            System.out.println("CPU wins");
            return true;
        }
        else if (boardState.board[0][0].equals("O") && boardState.board[1][1].equals("O") && boardState.board[2][2].equals("O")) {
            System.out.println("User wins");
            return true;
        }

        if (boardState.board[2][0].equals("X") && boardState.board[1][1].equals("X") && boardState.board[0][2].equals("X")) {
            System.out.println("CPU wins");
            return true;
        }
        else if (boardState.board[2][0].equals("O") && boardState.board[1][1].equals("O") && boardState.board[0][2].equals("O")) {
            System.out.println("User wins");
            return true;
        }
        return false;
    }
}