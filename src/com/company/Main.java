package com.company;
import java.util.*;


import del1.gruppe19.test.MainTest;

import java.util.concurrent.TimeUnit; //Til test Oliver

import gui_fields.GUI_Player;

import gui_main.GUI;

// TODO: 24-09-2019 Agree on spaces in code

public class Main {

    static int die1;
    static int die2;
    static int pointTotal1 = 0;


    static GUI gui;
    static GUI_Player player1;
    static GUI_Player player2;

    // TODO: 24-09-2019 De fleste public i metoderne skal ændres til private (ift opg beskrivelse)
    public static int returnPairTest(){//returner hvilken type par, hvis der er et par ellers return 0
        if(die1 == die2){
            return(die1);
        }
        else{
            return(0);
        }
    }


    // metode der returner sum for givent kast
    public static int getSum() {
        return(die1 + die2);
    }

    public static void rollDice() {

        Random random = new Random();

        die1 = random.nextInt(6) + 1;
        die2 = random.nextInt(6) + 1;
        System.out.println("Du har slået: " + die1 + " og " + die2);
        gui.setDice(die1, die2);
    }

    //Dánjal
    private static int checkSnakeEyes(int total){   //Ser om begge terninge er 1
        if(die1 == 1 && die2 == 1){                 //Hvis ja, så begynder du fra 0 igen
            total = 0;
            return total;
        }else{
            return total + getSum();
        }
    }

    //Dánjal
    //Ser om terningerne er et par, hvis ja, så får spilleren et extra kast
    private static void checkDicePair(GUI_Player player){
        while(die1 == die2){
            gui.showMessage(player.getName() + " får et extra kast");
            gui.showMessage(player.getName() + " har " + player.getBalance() + " point");
            rollDice();
            player.setBalance(checkSnakeEyes(player.getBalance()));
        }
    }

    public static void playerTurn(GUI_Player player){           //Der er blevet lavet en method til spiller 1's tur.
        System.out.println("spiller 1's tur");
        gui.showMessage(player.getName() + " det er din tur");
        rollDice();
        player.setBalance(checkSnakeEyes(player.getBalance()));
        System.out.println("spiller 1 total: " + pointTotal1);
        checkDicePair(player);
    }

    public static void main(String[] args) throws InterruptedException {

        // Oliver
        gui = new GUI();
        player1 = new GUI_Player(gui.getUserString("Indtast navnet på 1. spiller"), 0);
        player2 = new GUI_Player(gui.getUserString("Indtast navnet på 2. spiller"), 0);

        gui.showMessage("Velkommen til spiller " + player1.getName() + " og " + player2.getName() + "!");


        int roundCount = 0;

        while(player1.getBalance() < 40 && player2.getBalance() < 40) {

            roundCount++;

            if (roundCount % 2 == 1) {

                playerTurn(player1);

            }
            else if (roundCount % 2 == 0) {
                playerTurn(player2);
            }

            gui.showMessage(player1.getName() + " har " + player1.getBalance() + " point og " + player2.getName() + " har " + player2.getBalance() + " point");
        }

        if(player1.getBalance() > player2.getBalance()) {
            System.out.println("spiller 1 har vundet!");
            gui.showMessage(player1.getName() + " du har vundet!");
        }
        else {
            System.out.println("spiller 2 har vundet!");
            gui.showMessage(player2.getName() + " du har vundet!");
        }

        MainTest.test(); //kører test fra MainTest-klassen
    }
}
