package com.vladimirsimek.checkers;

import java.util.Scanner;

import static com.vladimirsimek.checkers.gui.clearScreen;
import static com.vladimirsimek.checkers.gui.drawFields;

public class Main {

    public static final String blackspot = "■";
    public static final String whitespot = "□";
    public static final String player1 = "©";
    public static final String player2 = "®";
    public static final String row = "-----------------------------------";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] fields = {
                {whitespot,player1,whitespot,player1,whitespot,player1,whitespot,player1},
                {player1,whitespot,player1,whitespot,player1,whitespot,player1,whitespot},
                {whitespot,player1,whitespot,player1,whitespot,player1,whitespot,player1},
                {blackspot,whitespot,blackspot,whitespot,blackspot,whitespot,blackspot,whitespot},
                {whitespot,blackspot,whitespot,blackspot,whitespot,blackspot,whitespot,blackspot},
                {player2,whitespot,player2,whitespot,player2,whitespot,player2,whitespot},
                {whitespot,player2,whitespot,player2,whitespot,player2,whitespot,player2},
                {player2,whitespot,player2,whitespot,player2,whitespot,player2,whitespot}
        };
        drawFields(fields);

        int player1amount = 1;
        int player2amount = 1;

        while (player1amount != 0 || player2amount != 0) {
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
                System.out.println("GGWP!");
            }
            System.out.println(row);


        }
        clearScreen();
        System.out.println("GGWP!");    

    }
}
