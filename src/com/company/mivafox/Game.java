package com.company.mivafox;

import java.util.Random;
import java.util.Scanner;

public class Game {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    public static final int SIZE = 3;
    char[][] chars = new char[SIZE][SIZE];
    boolean isFalse;
   static final char EMPTY = '.';
    char[] chip = {'X', 'O', 'V'};
    int countMove = 0;

    public void startGame() {
        Player player1 = new Player(choiceChip());
        Player computer = new Player('I');
        chars = initChar();
        while (!isFalse) {
            printMap();
            if(fullChars(countMove)) {
                System.out.println("Ничья");
                break;
            }
            do {
                System.out.println("Введите координаты ячейки x, y.");
                player1.x = scanner.nextInt() - 1;
                player1.y = scanner.nextInt() - 1;
            } while (!playerMove(player1.x, player1.y));
            chars[player1.x][player1.y] = player1.chip;
            countMove++;
            if (win(chars, player1.chip)) {
                System.out.println("Игрок победил!");
                break;
            }
            printMap();
            do {
                computer.x = random.nextInt(SIZE);
                computer.y = random.nextInt(SIZE);
            }
            while (!playerMove(computer.x, computer.y));
            chars[computer.x][computer.y] = computer.chip;
            countMove++;
            if (win(chars, computer.chip)) {
                System.out.println("Компьютер победил");
                break;
            }
            printMap();
        }
    }


    public char choiceChip() {
        System.out.println("Выберите фишку: 1 - 'X', 2 - 'O', 3 - 'V' ");
        int x = scanner.nextInt() - 1;
        char c = chip[x];
        return c;
    }

    public char[][] initChar() {
        for (int x = 0; x < chars.length; x++) {
            for (int y = 0; y < chars[x].length; y++) {
                chars[x][y] = EMPTY;
            }
        }
        return chars;
    }

    public void printMap() {
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

    boolean win(char[][] chars, char chip) {
        int x = 0;
        int count = 0;
        boolean isWin = false;
        if (!isWin) {
            while (chars.length > x) {
                for (int y = 0; y < chars[x].length; y++) {
                    if (chars[x][y] == chip) count++;
                    else
                        count = 0;
                }
                if (count == SIZE) {
                    isWin = true;
                    break;
                } else x++;
            }
        }
        x = 0;
        count = 0;
        if (!isWin) {
            while (chars.length > x) {
                for (int y = 0; y < chars.length; y++) {
                    if (chars[y][x] == chip) count++;
                    else
                        count = 0;
                }
                if (count == SIZE) {
                    isWin = true;
                    break;
                } else x++;
            }
        }
        count = 0;
        if (!isWin) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i][i] == chip) count++;
            }
                if (count == SIZE) isWin = true;



            count = 0;
            for(int i = 0; i<chars.length;i++) {
                if(chars[i][chars.length -1 -i] == chip) count++;
            }
            if(count == SIZE) isWin = true;
        }
        return isWin;
    }

    public boolean playerMove(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }  if (chars[x][y] == EMPTY) {
            return true;
        } else
            return false;
    }
    public boolean fullChars(int fullChars) {
        if(fullChars == SIZE * SIZE) {
            return true;
        }
        else return false;
    }
}
