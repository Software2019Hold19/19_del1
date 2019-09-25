package com.company;
import java.util.*;

import java.util.concurrent.TimeUnit; //Til test Oliver

import gui_fields.GUI_Player;
import gui_main.GUI;

// TODO: 24-09-2019 Agree on spaces in code

public class Main {

    static int die1;
    static int die2;
    static int roundCount = 0;
    static int pointTotal1 = 0;
    static int pointTotal2 = 0;

    // TODO: 24-09-2019 De fleste public i metoderne skal ændres til private (ift opg beskrivelse)

    public static int getSum() {
        return(die1 + die2);
    }

    public static void rollDice() {

        Random random = new Random();

        die1 = random.nextInt(6) + 1;
        die2 = random.nextInt(6) + 1;
        System.out.println("Du har slået: " + die1 + " og " + die2);
    }
    public static void player1Turn(){           //Der er blevet lavet en method til spiller 1's tur.
        System.out.println("spiller 1's tur");
        rollDice();
        int sum = getSum();
        pointTotal1 += sum;
        System.out.println("spiller 1 total: " + pointTotal1);

    }

    public static void player2Turn(){           //Der er blevet lavet en method til spiller 2's tur.
        System.out.println("spiller 2's tur");
        rollDice();
        int sum = getSum();
        pointTotal2 += sum;
        System.out.println("spiller 2 total: " + pointTotal2);
    }

    public static void main(String[] args) throws InterruptedException {
        int roundCount = 0;
        int pointTotal1 = 0;
        int pointTotal2 = 0;

        while(pointTotal1 < 40 && pointTotal2 < 40) {

            roundCount++;

            // TODO: 24-09-2019 Implimenter ekstra tur ved 2 ens terninger

            if (roundCount % 2 == 1) {
                player1Turn();

            }
            else if (roundCount % 2 == 0) {
                player2Turn();

            }

        }

        if(pointTotal1 > pointTotal2) {
            System.out.println("spiller 1 har vundet!");
        }
        else {
            System.out.println("spiller 2 har vundet!");
        }




        // Oliver
        // sporg spillerne om navne
        GUI gui = new GUI();

        GUI_Player player1 = new GUI_Player(gui.getUserString("Indtast navnet på 1. spiller"), 0);
        GUI_Player player2 = new GUI_Player(gui.getUserString("Indtast navnet på 2. spiller"), 0);
        boolean isPlayer1 = true;
        int pntMax = 40;
        gui.setDice(1,2);
        gui.showMessage("Velkommen til spiller " + player1.getName() + " og " + player2.getName() + "!");
    }
}
