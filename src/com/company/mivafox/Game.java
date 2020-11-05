package com.company.mivafox;



import java.util.Scanner;

public class Game {
    public static final int SIZE = 5;
    static char[][] chars = new char[SIZE][SIZE];
    static boolean isFalse;
    static final char EMPTY = '.';
    static int countMove = 0;


    public void startGame() {
        Player player1 = new Player(choiceCHip(),setName());
        PlayerII computer = new PlayerII( 'O',"Компьютер");
        chars = Game.initChar();
        while (!isFalse) {
         player1.inputPlayer();
         if(isFalse) break;
         if(fullChars(countMove)) break;
         computer.inputPlayer();
         if (isFalse) break;
            if(fullChars(countMove)) break;
        }
    }
    public char choiceCHip() {
        return 'X';
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

        public boolean fullChars(int fullChars) {
            if (fullChars == SIZE * SIZE) {
                System.out.println("ничья");
                return true;
            }
            else return false;
        }
        String setName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя!");
        String name = scanner.nextLine();
        return name;
        }
    }

