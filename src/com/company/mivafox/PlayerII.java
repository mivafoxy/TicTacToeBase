package com.company.mivafox;

import java.util.Random;

public class PlayerII {
    Random random = new Random();
    Game game = new Game();
    int x = 0;
    int y = 0;
    char chip;
    PlayerII(char chip) {
        this.chip = chip;
    }
    public void computerInput() {
        x = random.nextInt(game.SIZE) - 1;
        y = random.nextInt(game.SIZE) - 1;
        if(game.fullChars(x, y)) {
            game.chars[x][y] = chip;
            if(game.win(game.chars, chip)) System.out.println("Компьютер победил");
            game.printMap();
        }
    }
    }

