package com.company.mivafox;


import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);
    public static final int SIZE = 3;
    static char[][] chars = new char[SIZE][SIZE];
    static boolean isFalse;
    static final char EMPTY = '.';
    char[] chip = {'X', 'O', 'V'};
    static int countMove = 0;

    public void startGame() {
        Player player1 = new Player(choiceChip(), );
        PlayerII computer = new PlayerII('I', "Компьютер");
        chars = Game.initChar();
        while (!isFalse) {

        }
    }
    public char choiceChip () {
        System.out.println("Выберите фишку: 1 - 'X', 2 - 'O', 3 - 'V' ");
        int x = scanner.nextInt() - 1;
        char c = chip[x];
        return c;
    }
    public static char[][] initChar() {
        for (int x = 0; x < chars.length; x++) {
            for (int y = 0; y < chars[x].length; y++) {
                chars[x][y] = EMPTY;
            }
        }
        return Game.chars;
    }

         public static void printMap() {
            for (int i = 0; i <= chars.length; i++) {
                System.out.print(i + " ");
            }
            System.out.println();

            for (int i = 0; i < chars.length; i++) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < chars[i].length; j++) {
                    System.out.print(chars[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        public void fullChars ( int fullChars){
            if (fullChars == SIZE * SIZE) {
                System.out.println("ничья");
                isFalse = true;
            }
        }
    }

