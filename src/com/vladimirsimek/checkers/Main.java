package com.vladimirsimek.checkers;

import java.util.Scanner;

import static com.vladimirsimek.checkers.gui.*;

public class Main {

    public static final String blackSpot = "■";
    public static final String whiteSpot = "□";
    public static final String player1 = "©";
    public static final String player2 = "®";
    public static final String row = "-----------------------------------";
    public static String rawCoordinates;
    public static Scanner sc = new Scanner(System.in);
    public static int runTimeCycles = 0;


    public static void main(String[] args) {
        String[][] fields = {
                {whiteSpot,player1,whiteSpot,player1,whiteSpot,player1,whiteSpot,player1},
                {player1,whiteSpot,player1,whiteSpot,player1,whiteSpot,player1,whiteSpot},
                {whiteSpot,player1,whiteSpot,player1,whiteSpot,player1,whiteSpot,player1},
                {blackSpot,whiteSpot,blackSpot,whiteSpot,blackSpot,whiteSpot,blackSpot,whiteSpot},
                {whiteSpot,blackSpot,whiteSpot,blackSpot,whiteSpot,blackSpot,whiteSpot,blackSpot},
                {player2,whiteSpot,player2,whiteSpot,player2,whiteSpot,player2,whiteSpot},
                {whiteSpot,player2,whiteSpot,player2,whiteSpot,player2,whiteSpot,player2},
                {player2,whiteSpot,player2,whiteSpot,player2,whiteSpot,player2,whiteSpot}
        };
        drawFields(fields);

        int player1amount = 1;
        int player2amount = 1;

        while (player1amount != 0 || player2amount != 0) {
            runTimeCycles++;
            player1amount = 0;
            player2amount = 0;
            for (String[] field : fields) { // Checks if there are still some players left
                for (String s : field) {
                    if (s.equals(player1)) {
                        player1amount++;
                    } else if (s.equals(player2)) {
                        player2amount++;
                    }
                }
            } if (player1amount == 0 || player2amount == 0) { // If someone lost all checkers the game will end
                clearScreen();
                System.out.println("Good game well played!");
            }
            System.out.println(row);
            if (runTimeCycles % 2 == 0) {
                System.out.println("Write down coordinates for player number 2 \"x,y\".");
            } else System.out.println("Write down coordinates for player number 1 \"x,y\".");
            rawCoordinates = sc.next();

            while (!isCoordinateValid(fields, rawCoordinates)){
                notValidCoordinate();
            }
            if (isCoordinateValid(fields, rawCoordinates)) {
                if (runTimeCycles % 2 == 0){
                    while (!isCharacterValidPlayer(fields, intCoordinates[0],intCoordinates[1] )) {
                        notValidCoordinate();
                    }
                } else {
                    while (!isCharacterValidPlayer(fields, intCoordinates[0],intCoordinates[1] )) {
                        notValidCoordinate();
                    }
                }
            }
        }
        clearScreen();
        System.out.println("Good game well played!");
    }
}
