package com.company.mivafox;

import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    public static final int SIZE = 3;
    char[][] chars = new char[SIZE][SIZE];
    boolean isFalse = false;
    char empty = ' ';
    char[] chip = {'X', 'O', 'V', 'I'};

    public void startGame() {
        Player player1 = new Player(choiceChip());
        PlayerII computer = new PlayerII('I');
        chars = initChar();
        while (!isFalse) {
            printMap();
            System.out.println("Введите координаты ячейки x, y.");
            player1.x = scanner.nextInt() - 1;
            player1.y = scanner.nextInt() - 1;
            if(fullChars(player1.x, player1.y)) {
                chars[player1.x][player1.y] = player1.chip;
            }
              if (win(chars, player1.chip)) System.out.println("Игрок победил!");
                printMap();
            }
        computer.computerInput();
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
                chars[x][y] = empty;
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
        if (!isWin) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i][i] == chip || chars[i][chars.length - 1 - i] == chip) isWin = true;
            }
        }
        return isWin;
    }
    public boolean fullChars(int x, int y) {
        if(x > 0 && x <= SIZE && y > 0 && y <= SIZE && chars[x][y] == empty ) {
            return true;
        }
        else return false;

    }
}
