package com.example.java;

import java.util.Random;

public class Main {

    // MAIN
    public static void main(String[] args) {

        // Play the game
        Chutes_and_ladders.game_player(300000000);

    }


}

class Chutes_and_ladders{

    // Set up variables
    private static int curr_position;
    private static int number_of_turns;
    private static int my_spin;
    private static int max_turns = 0;
    // Create array of board spaces
    private static int[] spaces = {
            37,0,0,10,0,0,0,0,22,0,
            0,0,0,0,0,-10,0,0,0,0,
            21,0,0,0,0,0,0,56,0,0,
            0,0,0,0,0,8,0,0,0,0,
            0,0,0,0,0,0,-21,0,-38,0,
            16,0,0,0,0,-3,0,0,0,0,
            0,-43,0,-4,0,0,0,0,0,0,
            20,0,0,0,0,0,0,0,0,20,
            0,0,0,0,0,0,-63,0,0,0,
            0,0,-20,0,-20,0,0,-20,0,0
    };

    // Game player
    static void game_player(int number_of_games) {

        // Play n number of times based on what user specified
        for(int i=1; i<=number_of_games; i++) {

            // Initialize the variables
            initialize_vars();

            // Spin and move around the board until you land exactly on the 100 space
            while (curr_position < 100) {
                my_spin = spinner();
                update_position();
            }

            if (number_of_turns > max_turns) {
                max_turns = number_of_turns;
                System.out.println("Game: " + i + ", Max turns: " + max_turns);
            }
        }
    }

    // Update position based on spin and chute/ladder encounter
    private static void update_position(){
        number_of_turns += 1;
        // Update current position based on last spin
        curr_position += my_spin;
        // Add or subtract if chute or ladder encountered
        if (curr_position <= 100) {
            curr_position += spaces[curr_position-1];
        }
        else{
            curr_position -= my_spin;
        }
    }

    // Initialize variables
    public static void initialize_vars(){
        curr_position = 0;
        number_of_turns = 0;
    }

    // Spinner
    private static int spinner(){
        return randInt(1,6);
    }

    // Random number generator
    private static int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value, so add 1 to make it inclusive
        return rand.nextInt((max - min) + 1) + min;
    }

}