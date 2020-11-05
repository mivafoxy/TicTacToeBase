package com.company.mivafox;

import java.util.Scanner;

public class Player {
    Scanner scanner = new Scanner(System.in);
    int x = 0;
    int y = 0;

    char chip;
    String name;

    Player(char chip, String name) {
        this.chip = chip;
        this.name = name;


    }

    public String getName() {
        return name;
    }

    public void inputPlayer() {
        System.out.println("Ход игрока " + this.getName());
           do {
                System.out.println("Введите координаты ячейки x, y.");
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
            } while (!isPlayerMove(x, y));
            Game.chars[x][y] = this.chip;
           Game.countMove++;

            if (isWin(Game.chars, chip)) {
                System.out.println(getName() + " победил!");
                Game.isFalse = true;
            }
            Game.printMap();
        }

    boolean isWin(char[][] chars, char chip) {
        int x = 0;
        int count = 0;
        boolean isWin = false;
        if (!isWin) {
            while (chars.length > x) {
                for (int y = 0; y < chars[x].length; y++) {
                    if (chars[x][y] == chip) count++;
                }
                if (count == (Game.SIZE - 1)) {
                    isWin = true;
                    break;
                } else {
                    x++;
                    count = 0;
                }
            }
            x = 0;
            count = 0;
            if (!isWin) {
                while (chars.length > x) {
                    for (int y = 0; y < chars.length; y++) {
                        if (chars[y][x] == chip) count++;
                    }
                    if (count == (Game.SIZE - 1)) {
                        isWin = true;
                        break;
                    } else {
                        x++;
                        count = 0;
                    }
                }
            }
            count = 0;
            if (!isWin) {
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i][i] == chip) count++;
                }
                if (count == (Game.SIZE - 1)) isWin = true;


                count = 0;
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i][chars.length - 1 - i] == chip) count++;
                }
                if (count == (Game.SIZE - 1)) isWin = true;
            }
        }
            return isWin;
    }

        public boolean isPlayerMove ( int x, int y) {
            if (x < 0 || x >= Game.SIZE || y < 0 || y >= Game.SIZE) {
                return false;
            }
            if (Game.chars[x][y] == Game.EMPTY) {
                return true;
            } else
                return false;
        }
    }

