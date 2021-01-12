package com.vladimirsimek.checkers;

import static com.vladimirsimek.checkers.Main.*;

public class gui {

    public static void drawFields(String[][] fields) {
        /*
        Draws the play board.
         */
        for (String[] field : fields) {
            for (String s : field) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    } // Draws the game play board

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    } // Should clear screen

    public static void isCharacterValidPlayer1(String[][] fields, int a, int b) {
        for (String[] field : fields) {
            for (String s : field) {
                if (s.equals(player1)) {
                    if ()
                }
            }
        }
    }
}
