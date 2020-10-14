package com.company.mivafox;

import java.util.Scanner;

public class Player {
    Scanner scanner = new Scanner(System.in);
    int x;
    int y;
    char chip;
    Player(char chip) {
        this.chip = chip;
    }
    public void userInput() {
      x = scanner.nextInt() - 1;
      y = scanner.nextInt() - 1;
    }
}
