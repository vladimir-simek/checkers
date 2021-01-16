package com.vladimirsimek.checkers;

import java.util.Scanner;

import static com.vladimirsimek.checkers.gui.*;

public class Main {

    public static final String blackSpot = "■";
    public static final String whiteSpot = "□";
    public static final String player2 = "©";
    public static final String player1 = "®";
    public static final String row = "-----------------------------------";
    public static String rawCoordinates;
    public static Scanner sc = new Scanner(System.in);
    public static int runTimeCycles = 2;
    public static String[][] fields = {
            {whiteSpot, player2, whiteSpot, player2, whiteSpot, player2, whiteSpot, player2},
            {player2, whiteSpot, player2, whiteSpot, player2, whiteSpot, player2, whiteSpot},
            {whiteSpot, player2, whiteSpot, player2, whiteSpot, player2, whiteSpot, player2},
            {blackSpot, whiteSpot, blackSpot, whiteSpot, blackSpot, whiteSpot, blackSpot, whiteSpot},
            {whiteSpot, blackSpot, whiteSpot, blackSpot, whiteSpot, blackSpot, whiteSpot, blackSpot},
            {player1, whiteSpot, player1, whiteSpot, player1, whiteSpot, player1, whiteSpot},
            {whiteSpot, player1, whiteSpot, player1, whiteSpot, player1, whiteSpot, player1},
            {player1, whiteSpot, player1, whiteSpot, player1, whiteSpot, player1, whiteSpot}
    };
    public static int player2amount = 12;
    public static int player1amount = 12;
    public static boolean playersLeft = true;


    public static void main(String[] args) {
        drawFields(fields);

        while (playersLeft) {
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
        }
    }
}
