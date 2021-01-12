package com.vladimirsimek.checkers;

public class gui {

    public static void drawFields(String[][] fields) {
        /*
        Draws the playboard.
         */
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                System.out.print(fields[i][j] + " ");
            }
            System.out.println();
        }
    } // Draws the game playground

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    } // Should clear screen
}
