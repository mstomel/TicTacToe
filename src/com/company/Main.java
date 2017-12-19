package com.company;

import java.util.Scanner;

public class Main {

    Scanner hello = new Scanner(System.in);
    public static void main(String[] args) {
        new boardState();
        Main a = new Main();
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
            for (int i = 0; i<boardState.board.length; i++) {
                for (int j = 0; j<boardState.board.length; j++) {
                    System.out.print(boardState.board[i][j]);
                }
                System.out.println();
            }
            System.out.println("where would you like to play ex: 1,2 for (1,2)");

        }
        else if (start == 1) {

        }
        else {
            System.out.println("invalid input");
        }
    }
    public String[] UserPlace(String coordinates) {

        String[] temp = coordinates.split(",");
        return temp;

    }
    public boolean winCheck() {

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
    /*public void CPUFirst() {



    }
    public void UserFirst() {



    }*/
}