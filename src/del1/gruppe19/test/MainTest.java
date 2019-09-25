package del1.gruppe19.test;

import com.company.Main;

public class MainTest {
    public static void test(){
        //variabler bruges i for-loopet
        int testValue = 0;
        int testTotal = 0;

        //opretter variabler til at holde øje med antal slag, rolls[x], med værdi x+2. Bruges i switch.
            // altså første plads i listen, rolls[0], holder øje med antal slag med værdi 2.
        int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for(int i = 0; i < 1000; i++) { //kører loop 1000 gange

            Main.rollDice(); //giver nye random værdier til getSum-metoden (kalder rollDice-metoden fra main)
            testValue = Main.getSum();//tildeler værdi for antal øjne ved hvert slag (kalder getSum-metode fra Main)

            testTotal += testValue; //holder det totale antal øjne kastet i testen

            //holder øje med hvor mange gange hver mulig sum er kastet.
            switch (testValue){
                case 2: rolls[0]++;
                    break;
                case 3: rolls[1]++;
                    break;
                case 4: rolls[2]++;
                    break;
                case 5: rolls[3]++;
                    break;
                case 6: rolls[4]++;
                    break;
                case 7: rolls[5]++;
                    break;
                case 8: rolls[6]++;
                    break;
                case 9: rolls[7]++;
                    break;
                case 10: rolls[8]++;
                    break;
                case 11: rolls[9]++;
                    break;
                case 12: rolls[10]++;
                    break;
            }
        }
        for (int i = 0; i < 11; i++){//loop kører 11 gange (antal mulige værdi for roll (2-12)
            //printer antal gange hver roll-værdi er slået
            System.out.println("Antal gange der er rullet værdien " + (i + 2) + ": " + rolls[i]);
        }
        System.out.println("Der er i alt blevet slået " + testTotal + " øjne i testen");
        System.out.println("Det gennemsnitlige slag er da: " + (testTotal / 1000) );
    }
}
