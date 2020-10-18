package com.company.mivafox;

import java.util.Random;

public class PlayerII extends Player {
    Random random = new Random();
    PlayerII(char chip, String name) {
        super(chip, name);
    }
    public  void inputPlayer() {
        do {
            x = random.nextInt(Game.SIZE);
            y = random.nextInt(Game.SIZE);
        } while (!playerMove(x, y));
        Game.chars[x][y] = this.chip;
       Game.countMove++;

        if (win(Game.chars, chip)) {
            System.out.println("Компьютер победил");
            Game.isFalse = true;
        }
        Game.printMap();
    }
}
