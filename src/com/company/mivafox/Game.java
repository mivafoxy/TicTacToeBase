package com.company.mivafox;

import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    char[][] chars = new char[3][3];
    boolean isFalse = false;
    char empty = ' ';
    char[] chip = {'X', 'O', 'V'};

    public void startGame() {
        Player player1 = new Player(choiceChip());
        Player player2 = new Player(choiceChip());
        Player player3 = new Player(choiceChip());
        chars = initChar();
        while (isFalse) {

        }

    }
    public char choiceChip() {
        System.out.println("Выберите фишку: 1 - 'X', 2 - 'O', 3 - 'V' ");
        int x = scanner.nextInt();
        char c = chip[x];
        return c;
    }
    public  char[][] initChar() {
        for(int x = 0; x<chars.length; x++) {
            for(int y = 0; y < chars[y].length;y++) {
                chars[x][y] = empty;
            }
        }
        return chars;
    }
    public void printMap()
    {
        for (int i = 0; i <= chars.length; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < chars.length; i++)
        {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < chars[i].length; j++)
            {
                System.out.print(chars[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

}
