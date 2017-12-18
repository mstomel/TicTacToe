package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new boardState();
        Scanner hello = new Scanner(System.in);

        System.out.println("who will go first? (CPU=0, User=1)");
        int start = hello.nextInt();


        for (int i = 0; i<boardState.board.length; i++) {
            for (int j = 0; j<boardState.board.length; j++) {
                System.out.print(boardState.board[i][j]);
            }
            System.out.println();
        }
        System.out.println("coordinates are based on 0 1 and 2 ie top left is (0,0) and bottom right is (2,2)");
        (start == 0)?:
    }
}