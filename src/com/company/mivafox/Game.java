package com.company.mivafox;



import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    public static final int SIZE = 5;
    static char[][] chars = new char[SIZE][SIZE];
    static boolean isFalse;
    static final char EMPTY = '.';
    char[] chip = {'X', 'O', 'V'};
    static int countMove = 0;

    String name;

    public void startGame() {
        Player player1 = new Player(choiceChip(), setName());
        Player player2 = new Player(choiceChip(), setName());
        Player player3 = new Player(choiceChip(), setName());
        PlayerII computer = new PlayerII('I', "Компьютер");
        chars = Game.initChar();
        while (!isFalse) {
         player1.inputPlayer();
         if(isFalse) break;
         if(fullChars(countMove)) break;
            player2.inputPlayer();
            if(isFalse) break;
            if(fullChars(countMove)) break;
            player3.inputPlayer();
            if(isFalse) break;
            if(fullChars(countMove)) break;
         computer.inputPlayer();
         if (isFalse) break;
            if(fullChars(countMove)) break;
        }
    }
    public char choiceChip () {
        int x = 0;
        System.out.println("Выберите фишку незанятую другим игроком: 1 - 'X', 2 - 'O', 3 - 'V' и введите имя через пробел");
            x = scanner.nextInt() - 1;
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

        public boolean fullChars (int fullChars) {
            if (fullChars == SIZE * SIZE) {
                System.out.println("ничья");
                return true;
            }
            else return false;
        }
        public String setName() {
        name = scanner.nextLine();
        return name;
        }

    }

