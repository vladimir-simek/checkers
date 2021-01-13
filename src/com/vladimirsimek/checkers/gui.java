package com.vladimirsimek.checkers;

import static com.vladimirsimek.checkers.Main.*;

public class gui {

    public static int[] intCoordinates = new int[2];

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
        System.out.flush();
    } // Should clear screen

    public static boolean isCharacterValidPlayer(String[][] fields, int a, int b) {
        boolean isValid = false;

        return isValid;
    }

    public static boolean isCoordinateValid(String[][] fields, String rawCoordinates) {
        boolean isValid = true;
        String[] stringCoordinates = rawCoordinates.split(",");
        try {
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
        } catch (Exception e) {
            isValid = false;
        }
        if (isValid) {
            int a = intCoordinates[0];
            int b = intCoordinates[1];
            int c = 0;
            if (runTimeCycles % 2 == 0) {
                if (fields[a][b].equals(player1)) {
                    isValid = true;
                    c++;
                }
            } else {
                if (fields[a][b].equals(player1)) {
                    isValid = true;
                    c++;
                }
            }
            if (c == 0) {
                isValid = false;
            } else if (c == 2) {
                isValid = false;
            } else if (c == 1) {
                isValid = true;
            }

        }

        return isValid;
    }

    public static void notValidCoordinate() {
        System.out.println(row);
        System.out.println("Coordinates that you entered are not valid! Please enter valid coordinates \"x,y\"");
        rawCoordinates = sc.next();
    }
}
