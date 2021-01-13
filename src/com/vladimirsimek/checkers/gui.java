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
        for (int i = 0; i < 100; i++) {
            System.out.println(" ");
        }
    } // Should clear screen

    public static boolean isCharacterValidPlayer1(String[][] fields, int a, int b) {
        boolean isValid = false;
        for (String[] field : fields) {
            for (int j = 0; j < field.length; j++) {
                if (fields[a][b].equals(player1)) {
                    isValid = true;
                    break;
                }
            }
        }
        return isValid;
    }

    public static boolean isCoordinateValid(String rawCoordinates) {
        boolean isValid = true;
        int[] intCoordinates = new int[2];
        String[] stringCoordinates = rawCoordinates.split(",");
        for (int i = 0; i < stringCoordinates.length; i++) {
            intCoordinates[i] = Integer.parseInt(stringCoordinates[i]);
        }
        if (intCoordinates[0] > 8 || intCoordinates[0] < 1) {
            isValid = false;
        } else if (intCoordinates[1] > 8 || intCoordinates[1] < 1) {
            isValid = false;
        } else if (rawCoordinates.length() < 1 || rawCoordinates.length() > 3) {
            isValid = false;
        }

        return isValid;
    }
}
