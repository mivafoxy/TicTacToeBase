package com.company.mivafox;

import java.util.Scanner;

public class Player {
    Scanner scanner = new Scanner(System.in);
    char chip;
    Player(char chip) {
        this.chip = chip;
    }
    public  int useInput() {
        int x = scanner.nextInt() - 1;
        return x;
    }
}
