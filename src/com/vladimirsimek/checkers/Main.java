package com.vladimirsimek.checkers;

import java.util.Locale;
import java.util.Scanner;

import static com.vladimirsimek.checkers.Gui.*;
import static com.vladimirsimek.checkers.Logic.*;

public class Main {

    public static final String BLACK_SPOT = "■";
    public static final String WHITE_SPOT = "□";
    public static final String PLAYER_2 = "©";
    public static final String PLAYER_1 = "®";
    public static final String row = "-----------------------------------";
    public static String rawCoordinates;
    public static String leftOrRight;
    public static Scanner sc = new Scanner(System.in);
    public static int runTimeCycles = 2;
    public static boolean canMove = true;
    public static String[][] fields = {
            {WHITE_SPOT, PLAYER_2, WHITE_SPOT, PLAYER_2, WHITE_SPOT, PLAYER_2, WHITE_SPOT, PLAYER_2},
            {PLAYER_2, WHITE_SPOT, PLAYER_2, WHITE_SPOT, PLAYER_2, WHITE_SPOT, PLAYER_2, WHITE_SPOT},
            {WHITE_SPOT, PLAYER_2, WHITE_SPOT, PLAYER_2, WHITE_SPOT, PLAYER_2, WHITE_SPOT, PLAYER_2},
            {BLACK_SPOT, WHITE_SPOT, BLACK_SPOT, WHITE_SPOT, BLACK_SPOT, WHITE_SPOT, BLACK_SPOT, WHITE_SPOT},
            {WHITE_SPOT, BLACK_SPOT, WHITE_SPOT, BLACK_SPOT, WHITE_SPOT, BLACK_SPOT, WHITE_SPOT, BLACK_SPOT},
            {PLAYER_1, WHITE_SPOT, PLAYER_1, WHITE_SPOT, PLAYER_1, WHITE_SPOT, PLAYER_1, WHITE_SPOT},
            {WHITE_SPOT, PLAYER_1, WHITE_SPOT, PLAYER_1, WHITE_SPOT, PLAYER_1, WHITE_SPOT, PLAYER_1},
            {PLAYER_1, WHITE_SPOT, PLAYER_1, WHITE_SPOT, PLAYER_1, WHITE_SPOT, PLAYER_1, WHITE_SPOT}
    };
    public static int player2amount = 12;
    public static int player1amount = 12;
    public static boolean playersLeft = true;


    public static void main(String[] args) {
        drawGameName();
        while (playersLeft) {
            canMove = true;
            System.out.println(row);
            drawProgressBars();
            System.out.println(row);
            drawFields(fields);
            runTimeCycles++;
            areHerePlayers();
            System.out.println(row);
            if (runTimeCycles % 2 == 0) {
                System.out.println("Write down coordinates for player number 2 \"x,y\".");
            } else System.out.println("Write down coordinates for player number 1 \"x,y\".");
            rawCoordinates = sc.next();
            if (isCoordinateValid(fields, rawCoordinates)) {
                System.out.println(row);
                System.out.println("You selected checker on [" + rawCoordinates + "].");
            } else {
                notValidCoordinate();
                if (isCoordinateValid(fields, rawCoordinates)) {
                    System.out.println(row);
                    System.out.println("You selected checker on [" + rawCoordinates + "].");
                }
            }
            System.out.println("Now choose where you want to move:");
            System.out.println("A) Left");
            System.out.println("B) Right");
            leftOrRight = sc.next();
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            String lowLeftOrRight = leftOrRight.toLowerCase(Locale.ROOT);
            intCoordinatesMoveTo[0] = intCoordinates[0];
            intCoordinatesMoveTo[1] = intCoordinates[1];
            if (runTimeCycles % 2 == 0) {
                if (lowLeftOrRight.equals("a")) {
                    intCoordinatesMoveTo[0] = intCoordinatesMoveTo[0] + 1;
                    intCoordinatesMoveTo[1] = intCoordinatesMoveTo[1] - 1;
                } else {
                    intCoordinatesMoveTo[0] = intCoordinatesMoveTo[0] + 1;
                    intCoordinatesMoveTo[1] = intCoordinatesMoveTo[1] + 1;
                }
            } else {
                if (lowLeftOrRight.equals("a")) {
                    intCoordinatesMoveTo[0] = intCoordinatesMoveTo[0] - 1;
                    intCoordinatesMoveTo[1] = intCoordinatesMoveTo[1] - 1;
                } else {
                    intCoordinatesMoveTo[0] = intCoordinatesMoveTo[0] - 1;
                    intCoordinatesMoveTo[1] = intCoordinatesMoveTo[1] + 1;
                }

            }

            if (fields[intCoordinatesMoveTo[0]][intCoordinatesMoveTo[1]].equals(BLACK_SPOT)){

                fields[intCoordinates[0]][intCoordinates[1]] = BLACK_SPOT;

                if (runTimeCycles % 2 == 0) {
                    fields[intCoordinatesMoveTo[0]][intCoordinatesMoveTo[1]] = PLAYER_2;
                } else {
                    fields[intCoordinatesMoveTo[0]][intCoordinatesMoveTo[1]] = PLAYER_1;
                }
            } else if (fields[intCoordinatesMoveTo[0]][intCoordinatesMoveTo[1]].equals(PLAYER_1) || fields[intCoordinatesMoveTo[0]][intCoordinatesMoveTo[1]].equals(PLAYER_2)) {
                intCoordinatesMoveToHigher = intCoordinatesMoveTo;
                if (runTimeCycles % 2 == 0) {
                    if (lowLeftOrRight.equals("a")) {
                        intCoordinatesMoveToHigher[0] = intCoordinatesMoveToHigher[0] + 1;
                        intCoordinatesMoveToHigher[1] = intCoordinatesMoveToHigher[1] - 1;
                    } else {
                        intCoordinatesMoveToHigher[0] = intCoordinatesMoveToHigher[0] + 1;
                        intCoordinatesMoveToHigher[1] = intCoordinatesMoveToHigher[1] + 1;
                    }
                } else {
                    if (lowLeftOrRight.equals("a")) {
                        intCoordinatesMoveToHigher[0] = intCoordinatesMoveToHigher[0] - 1;
                        intCoordinatesMoveToHigher[1] = intCoordinatesMoveToHigher[1] - 1;
                    } else {
                        intCoordinatesMoveToHigher[0] = intCoordinatesMoveToHigher[0] - 1;
                        intCoordinatesMoveToHigher[1] = intCoordinatesMoveToHigher[1] + 1;
                    }

                }
                if (fields[intCoordinatesMoveToHigher[0]][intCoordinatesMoveToHigher[1]].equals(BLACK_SPOT)) {
                    fields[intCoordinates[0]][intCoordinates[1]] = BLACK_SPOT;
                    fields[intCoordinatesMoveTo[0] - 1][intCoordinatesMoveTo[1] - 1] = BLACK_SPOT;
                    if (runTimeCycles % 2 == 0) {
                        fields[intCoordinatesMoveToHigher[0]][intCoordinatesMoveToHigher[1]] = PLAYER_2;
                    } else {
                        fields[intCoordinatesMoveToHigher[0]][intCoordinatesMoveToHigher[1]] = PLAYER_1;
                    }
                }
            }
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            System.out.println("END OF ROUND");
        }
    }
}
