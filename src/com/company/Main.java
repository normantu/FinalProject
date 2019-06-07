package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[][] grid = new char[6][8];
        for (int row = 0; row < grid.length; row++) {
            for (int coloumn = 0; coloumn < grid[0].length; coloumn++) {
                grid[row][coloumn] = ' ';
            }
        }
        int turn = 0;
        char player = 'X';
        boolean winner = false;

        while (winner == false && turn <= 30) {
            boolean validPlay;
            int play;
            do {
                display(grid);

                System.out.print("Player " + player + ", enter a column to put your piece in: ");
                play = in.nextInt();

                validPlay = validate(play, grid);

            } while (validPlay == false);

            for (int row = grid.length - 1; row >= 0; row--) {
                if (grid[row][play] == ' ') {
                    grid[row][play] = player;
                    break;
                }
            }
            if (player == 'X') {
                player = 'Y';
            } else {
                player = 'X';
            }
            turn = turn + 1;
        }
        display(grid);
        winner = isWinner(player, grid);
        if (winner) {
            if (player == 'X') {
                System.out.println("Player Y won");
            } else {
                System.out.println("Player X won");
            }
        }else {
            System.out.println("It's a tie game");
        }

    }
    public static void display(char[][] grid) {
        System.out.println(" 0 1 2 3 4 5 6 ");
        System.out.println("---------------");
        for (int row = 0; row < grid.length; row++) {
            System.out.print("|");
            for (int coloumn = 0; coloumn < grid[0].length; coloumn++) {
                System.out.print(grid[row][coloumn]);
                System.out.print("|");
            }
            System.out.println();
            System.out.println("---------------");
        }
        System.out.println(" 0 1 2 3 4 5 6 ");
        System.out.println();
    }
    public static boolean validate(int column, char[][] grid) {
        if (column < 0 || column > grid[0].length) {
            return false;
        }
        if (grid[0][column] != ' ') {
            return false;
        }
        return true;
    }
    public static boolean isWinner(char player, char[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int coloumn = 0; coloumn < grid[0].length - 3; coloumn++) {
                if (grid[row][coloumn] == player &&
                        grid[row][coloumn + 1] == player &&
                        grid[row][coloumn + 2] == player &&
                        grid[row][coloumn + 3] == player) {
                    return true;
                }
            }
        }
        for (int row = 0; row < grid.length - 3; row++) {
            for (int coloumn = 0; coloumn < grid[0].length; coloumn++) {
                if (grid[row][coloumn] == player &&
                        grid[row + 2][coloumn] == player &&
                        grid[row + 1][coloumn] == player &&
                        grid[row + 3][coloumn] == player) {
                    return true;
                }
            }
        }
        return false;

    }
}


