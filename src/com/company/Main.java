package com.company;
import java.util.*;

public class Main {

    static int dieSum = 0;
    static int die1;
    static int die2;

    public static void getSum() {
        dieSum = die1 + die2;
    }

    public static void rollDice() {

        Random random = new Random();

        die1 = random.nextInt(6)+1;
        die2 = random.nextInt(6)+1;
        System.out.println("Du har slået: "+die1+" og "+die2);
    }

    public static void main(String[] args) {
        // write your code here
        int roundCount = 0;
        int pointTotal1 = 0;
        int pointTotal2 = 0;

        while(pointTotal1 < 40 && pointTotal2 < 40) {

            roundCount++;

            if (roundCount%2 == 1) {
                System.out.println("spiller 1's tur");
                rollDice();
                getSum();
                pointTotal1 = pointTotal1+dieSum;
                System.out.println("spiller 1 total: "+pointTotal1);
            }
            else if (roundCount%2 == 0) {
                System.out.println("spiller 2's tur");
                rollDice();
                getSum();
                pointTotal2 = pointTotal2+dieSum;
                System.out.println("spiller 2 total: "+pointTotal2);
            }

        }
        if(pointTotal1 > pointTotal2) {
            System.out.println("spiller 1 har vundet!");
        }
        else if (pointTotal1 < pointTotal2){
            System.out.println("spiller 2 har vundet!");
        }
    }
}
