package com.vladimirsimek.checkers;

import java.util.Locale;
import static com.vladimirsimek.checkers.Logic.*;
import static com.vladimirsimek.checkers.Main.*;

public class Gui {

    public static int[] intCoordinates = new int[2];
    public static int[] intCoordinatesMoveTo = new int[2];

    public static void drawGameName() {
        System.out.println("  _______           __                  __   ________                                ___                    _         \n" +
                " / ___/ /  ___ ____/ /_____ _______    / /  /_  __/ /  ___    ___  ___ _    __   ___/ (_)_ _  ___ ___  ___ (_)__  ___ \n" +
                "/ /__/ _ \\/ -_) __/  '_/ -_) __(_-<   / /    / / / _ \\/ -_)  / _ \\/ -_) |/|/ /  / _  / /  ' \\/ -_) _ \\(_-</ / _ \\/ _ \\\n" +
                "\\___/_//_/\\__/\\__/_/\\_\\\\__/_/ /___/  / /    /_/ /_//_/\\__/  /_//_/\\__/|__,__/   \\_,_/_/_/_/_/\\__/_//_/___/_/\\___/_//_/\n" +
                "                                    /_/                                                                               ");
    }

    public static void drawFields(String[][] fields) {
        System.out.println("⚫ 0 1 2  3 4 5 6 7");
        for (int i = 0; i < fields.length; i++) {
            String[] field = fields[i];
            System.out.print(i + " ");
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
        System.out.print("\033[H\033[2J");
        System.out.flush();
    } // Should clear screen

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

    public static void notValidCoordinate() {
        while (!isCoordinateValid(fields, rawCoordinates)) {
            System.out.println(row);
            System.out.println("Coordinates that you entered are not valid! Please enter valid coordinates \"x,y\"");
            rawCoordinates = sc.next();
        }
    } // Tells player that his input is invalid and will require a new one

    public static void gameOver1Won() {
        clearScreen();
        System.out.println("Game over!");
        System.out.println("Player 1 won the game! Congratulations!");
        System.out.println(row);
        System.out.println("It took you total of " + (runTimeCycles - 2) + " rounds to beat player 2.");
        System.exit(0);
    } // Ends the game if Player 1 won

    public static void gameOver2Won() {
        clearScreen();
        System.out.println("Game over!");
        System.out.println("Player 2 won the game! Congratulations!");
        System.out.println(row);
        System.out.println("It took you total of " + (runTimeCycles - 2) + " rounds to beat player 1.");
        System.exit(0);
    } // Ends the game if Player 2 won

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

    public static void drawProgressBars() {
        player2amount = 0;
        player1amount = 0;
        for (String[] field : fields) {
            for (String s : field) {
                if (s.equals(PLAYER_2)) {
                    player2amount++;
                } else if (s.equals(PLAYER_1)) player1amount++;
            }
        }
        System.out.println("Progress bar for Player 1:");
        if (player2amount == 12) {
            System.out.println("[                        ] 0%");
        } else if (player2amount == 11) {
            System.out.println("[##                      ] 8.3%");
        } else if (player2amount == 10) {
            System.out.println("[####                    ] 16.6%");
        } else if (player2amount == 9) {
            System.out.println("[######                  ] 25%");
        } else if (player2amount == 8) {
            System.out.println("[########                ] 33.3%");
        } else if (player2amount == 7) {
            System.out.println("[##########              ] 41.6%");
        } else if (player2amount == 6) {
            System.out.println("[############            ] 50%");
        } else if (player2amount == 5) {
            System.out.println("[##############          ] 58.3%");
        } else if (player2amount == 4) {
            System.out.println("[################        ] 66.6%");
        } else if (player2amount == 3) {
            System.out.println("[##################      ] 75%");
        } else if (player2amount == 2) {
            System.out.println("[####################    ] 83.3%");
        } else if (player2amount == 1) {
            System.out.println("[######################  ] 91.6%");
        } else if (player2amount == 0) {
            System.out.println("[########################] 100%");
        }
        System.out.println("Progress bar for player 2:");
        if (player1amount == 12) {
            System.out.println("[                        ] 0%");
        } else if (player1amount == 11) {
            System.out.println("[##                      ] 8.3%");
        } else if (player1amount == 10) {
            System.out.println("[####                    ] 16.6%");
        } else if (player1amount == 9) {
            System.out.println("[######                  ] 25%");
        } else if (player1amount == 8) {
            System.out.println("[########                ] 33.3%");
        } else if (player1amount == 7) {
            System.out.println("[##########              ] 41.6%");
        } else if (player1amount == 6) {
            System.out.println("[############            ] 50%");
        } else if (player1amount == 5) {
            System.out.println("[##############          ] 58.3%");
        } else if (player1amount == 4) {
            System.out.println("[################        ] 66.6%");
        } else if (player1amount == 3) {
            System.out.println("[##################      ] 75%");
        } else if (player1amount == 2) {
            System.out.println("[####################    ] 83.3%");
        } else if (player1amount == 1) {
            System.out.println("[######################  ] 91.6%");
        } else if (player1amount == 0) {
            System.out.println("[########################] 100%");
        }
    } // Counts players and draws progress bar

    public static boolean isLeftOrRightValidPlayer(String[][] fields, String leftOrRight) {
        boolean isValid = false;

        String lowLeftOrRight = leftOrRight.toLowerCase(Locale.ROOT);

        if (lowLeftOrRight.equals("a") || lowLeftOrRight.equals("b")) {
            isValid = true;
        }

        if (isValid) {
            if (runTimeCycles % 2 == 0) {
                if (lowLeftOrRight.equals("a")) {
                    intCoordinatesMoveTo[0] = intCoordinatesMoveTo[0]+1;
                    intCoordinatesMoveTo[1] = intCoordinatesMoveTo[1]-1;
                } else {
                    intCoordinatesMoveTo[0] = intCoordinatesMoveTo[0]+1;
                    intCoordinatesMoveTo[1] = intCoordinatesMoveTo[1]+1;
                }
            } else {
                if (lowLeftOrRight.equals("a")) {
                    intCoordinatesMoveTo[0] = intCoordinatesMoveTo[0]-1;
                    intCoordinatesMoveTo[1] = intCoordinatesMoveTo[1]-1;
                } else {
                    intCoordinatesMoveTo[0] = intCoordinatesMoveTo[0]-1;
                    intCoordinatesMoveTo[1] =intCoordinatesMoveTo[1]+1;
                }
            }
        }

        return isValid;
    }

    public static void notValidLeftOrRight() {
        while (!isLeftOrRightValidPlayer(fields, rawCoordinates)) {
            System.out.println(row);
            System.out.println("Your input or side you have chosen is invalid. Enter a new one:");
            leftOrRight = sc.next();
        }
    }
    
    public static void  move() {
        
    }
}
