package com.vladimirsimek.checkers;

import java.util.Scanner;

import static com.vladimirsimek.checkers.gui.*;

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
            if (isLeftOrRightValidPlayer(fields, leftOrRight)) {
                move();
            } else {
                notValidLeftOrRight();
                if (isLeftOrRightValidPlayer(fields, leftOrRight)) {
                    move();
                }
            }

                System.out.println("END OF ROUND");
        }
    }
}
