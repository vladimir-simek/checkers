package com.vladimirsimek.checkers;

import static com.vladimirsimek.checkers.Main.*;

public class gui {

    public static int[] intCoordinates = new int[2];

    public static void drawFields(String[][] fields) {
        /*
        Draws the play board.
         */
        for (int i = 0; i < fields.length; i++) {
            String[] field = fields[i];
            if (i==i) {
                System.out.print(i + " ");
            }
            for (int j = 0; j < field.length; j++) {
                String s = field[j];
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

            if (intCoordinates[0] > 7 || intCoordinates[0] < 0) {
                isValid = false;
            } else if (intCoordinates[1] > 7 || intCoordinates[1] < 0) {
                isValid = false;
            } else if (rawCoordinates.length() < 1 || rawCoordinates.length() > 3) {
                isValid = false;
            }
        } catch (Exception e) {
            isValid = false;
        }
        boolean isValidData = false;
        if (isValid) {
            int a = intCoordinates[0];
            int b = intCoordinates[1];
            if (runTimeCycles % 2 == 0) {
                if (fields[a][b].equals(player2)) {
                    isValidData = true;
                }
            } else if(fields[a][b].equals(player1)) {
                isValidData = true;
            }


        }
        return isValidData;
    }

    public static void notValidCoordinate() {
        while (!isCoordinateValid(fields, rawCoordinates)) {
            System.out.println(row);
            System.out.println("Coordinates that you entered are not valid! Please enter valid coordinates \"x,y\"");
            System.out.println(row);
            rawCoordinates = sc.next();
        }
    }

    public static void gameOver1Won() {
        System.out.println("Game over!");
        System.out.println("Player 1 won the game! Congratulations!");
        System.out.println(row);
        System.out.println("It took you total of " + (runTimeCycles - 2) + " rounds to beat player 2.");
        System.exit(0);
    }

    public static void  gameOver2Won() {
        System.out.println("Game over!");
        System.out.println("Player 2 won the game! Congratulations!");
        System.out.println(row);
        System.out.println("It took you total of " + (runTimeCycles - 2) + " rounds to beat player 1.");
        System.exit(0);
    }

    public static void areHerePlayers() {
        player2amount = 0;
        player1amount = 0;
        playersLeft = false;
        int index = 0;
        for (String[] field : fields) { // Checks if there are still some players left
            for (String s : field) {
                if (s.equals(player2)) {
                    player2amount++;
                } else if (s.equals(player1)) {
                    player1amount++;
                }
            }
        }
        if (player2amount == 0 && player1amount > 0) {
            index = 1;
        } else if (player1amount == 0 && player2amount > 0) {
            index = 2;
        } else if (player2amount > 0 && player1amount > 0) {
            index = 3;
        }

        if (index == 1) {
            gameOver1Won();
        } else if (index == 2) {
            gameOver2Won();
        }  else if (index == 3) {
            playersLeft = true;
        }
    }
}
