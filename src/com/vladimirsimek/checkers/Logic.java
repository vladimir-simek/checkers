package com.vladimirsimek.checkers;

import java.util.Locale;

import static com.vladimirsimek.checkers.Gui.*;
import static com.vladimirsimek.checkers.Main.*;

public class Logic {

    public static int[] intCoordinates = new int[2];
    public static int[] intCoordinatesMoveTo = new int[2];
    public static int[] intCoordinatesMoveToHigher = new int[2];

    public static void areHerePlayers() {
        player2amount = 0;
        player1amount = 0;
        playersLeft = false;
        int index = 0;
        for (String[] field : fields) {
            for (String s : field) {
                if (s.equals(PLAYER_2)) {
                    player2amount++;
                } else if (s.equals(PLAYER_1)) {
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
        } else if (index == 3) {
            playersLeft = true;
        }
    } // Checks if are any players remaining, if yes game continues, if not gameOver() will be called

    public static boolean isCoordinateValid(String[][] fields, String rawCoordinates) {
        boolean isValid = true;
        String[] stringCoordinates = rawCoordinates.split(",");
        try {
            char a = rawCoordinates.charAt(0);
            char b = rawCoordinates.charAt(1);
            char c = rawCoordinates.charAt(2);
        } catch (Exception e) {
            isValid = false;
        }
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
                if (fields[a][b].equals(PLAYER_2)) {
                    isValidData = true;
                }
            } else if (fields[a][b].equals(PLAYER_1)) {
                isValidData = true;
            }
        }
        return isValidData;
    } // Checks if input of coordination is valid

    public static void move(String[][] fields, String leftOrRight) {

    }
}
