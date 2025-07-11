package Start_idea;

import codedraw.*;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Cube_Help_Meths {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //cubes(500,500); //cube everywhere and nowhere at once, quanden cube

        //draw_Square_V1(); // a square duh
        //draw_Square_V2(500);

        //draw_Cube_Pers_V1(500);
        //draw_Cube_Pers_V2(500);

        //stabelising_Cube_V1(650,200);
        //stabelising_Cube_fast(500,500);

        //drawACubeV2(500, 10);
        DrawV3(500, 100);
    }

    // creates a new square at a somewhat random location (one random number between 0 and the width and one between 0 and the height)
    public static void cubes(int width, int height) {

        CodeDraw cd = new CodeDraw(width, height);

        int x = 10;
        int y = 10;
        int laenge = 50;

        int a = 10;

        while (true) {

            cd.drawSquare(x, y, laenge);

            Random randy = new Random();
            int randomX = randy.nextInt(width);
            for (int i = 0; randomX > width - 50; i++) {
                randomX = randy.nextInt(width);
            }
            int randomY = randy.nextInt(height);
            for (int i = 0; randomY > height - 50; i++) {
                randomY = randy.nextInt(height);
            }

            x = randomX;
            y = randomY;
            a--;
            cd.show(50);
            cd.clear(); // with memory or without?
        }
    }


    // draws a square with the left upper corner being at 150|150 and the bottom right being at 350|350
    public static void draw_Square_V1(){
        CodeDraw cd = new CodeDraw(500, 500);

        cd.setLineWidth(2);
        cd.drawLine(150,150,350,150);
        cd.drawLine(350,150,350,350);
        cd.drawLine(350,350,150,350);
        cd.drawLine(150,350,150,150);

        cd.show();
    }

    // draws a square arround the center of the window with a diameter of half the window
    public static void draw_Square_V2(int width){
        CodeDraw cd = new CodeDraw(width, width);

        int oneCord = width/2 - ((width/10)*2); // the first cord for the square
        int secCord = width/2 + ((width/10)*2); // the second cord for the square in a square canvas

        cd.setLineWidth(2);
        cd.drawLine(oneCord,oneCord,secCord,oneCord);
        cd.drawLine(secCord,oneCord,secCord,secCord);
        cd.drawLine(secCord,secCord,oneCord,secCord);
        cd.drawLine(oneCord,secCord,oneCord,oneCord);

        cd.show();
    }


    // the first try of creating a perspective cube with a bit of a rotation on the y and z axes
    public static void draw_Cube_Pers_V1(int width){
        CodeDraw cd = new CodeDraw(width+width/5, width);

        int oneCord = width/2 - ((width/10)*2); // the first cord for the square / 500 -> 150
        int secCord = width/2 + ((width/10)*2); // the second cord for the square in a square canvas / 500 -> 350

        cd.setLineWidth(2);
        // the main lines on the cube so the main square
        cd.drawLine(oneCord, oneCord, secCord, oneCord + 20);
        cd.drawLine(secCord, oneCord + 20, secCord, secCord + 20);
        cd.drawLine(secCord, secCord + 20, oneCord, secCord);
        cd.drawLine(oneCord, secCord, oneCord, oneCord);

        // top lines of the cube
        cd.drawLine(oneCord + 100, oneCord - 75, secCord + 100, oneCord + 20 - 75); // top back
        cd.drawLine(oneCord, oneCord, oneCord + 100, oneCord - 75); // top left
        cd.drawLine(secCord, oneCord + 20, secCord + 100, oneCord + 20 - 75); // top right

        // side lines on the right of the cube
        cd.drawLine(secCord + 100, oneCord + 20 - 75, secCord + 100, secCord + 20 - 75); // right back
        cd.drawLine(secCord, secCord + 20, secCord + 100, secCord + 20 - 75); // right bottom

        cd.show(100);
        cd.clear();
    }

    //second try, quite simulare outcome but not exact
    public static void draw_Cube_Pers_V2(int width){

        CodeDraw cd = new CodeDraw(width+width/5, width);

        int oneCord = width/2 - ((width/10)*2); // the first cord for the square / 500 -> 150
        int secCord = width/2 + ((width/10)*2); // the second cord for the square in a square canvas / 500 -> 350
        int cubeOffset = width/25; // 500 -> 20 fuern würfel
        int cubeDistanc = width/5; // 500 -> 100 fuern würfel
        double temp = width/6.6; // 500 -> 75 fuern würfel
        int cubeVerschiebung = (int)temp;


        cd.setLineWidth(2);
        cd.drawLine(oneCord, oneCord, secCord, oneCord + cubeOffset);
        cd.drawLine(secCord, oneCord + cubeOffset, secCord, secCord + cubeOffset);
        cd.drawLine(secCord, secCord + cubeOffset, oneCord, secCord);
        cd.drawLine(oneCord, secCord, oneCord, oneCord);

        cd.drawLine(oneCord + cubeDistanc, oneCord - cubeVerschiebung, secCord + cubeDistanc, oneCord + cubeOffset - cubeVerschiebung); // top back
        cd.drawLine(oneCord, oneCord, oneCord + cubeDistanc, oneCord - cubeVerschiebung); // top left
        cd.drawLine(secCord, oneCord + cubeOffset, secCord + cubeDistanc, oneCord + cubeOffset - cubeVerschiebung); // top right

        cd.drawLine(secCord + cubeDistanc, oneCord + cubeOffset - cubeVerschiebung, secCord + cubeDistanc, secCord + cubeOffset - cubeVerschiebung); // right back
        cd.drawLine(secCord, secCord + cubeOffset, secCord + cubeDistanc, secCord + cubeOffset - cubeVerschiebung); // right bottom

        cd.show(100);
        cd.clear();
    }


    // having a drawn cube with all the correct points for it to look like perspecitve cube V1/V2 but adding a random value to the end of the lines
    // with that the cube seems to be a total mess in the beginning but starts to stabaliese a bit each round, like an AI learning
    // each round the random value is reduced by 1 or it can be changed depending on the speed it should finish
    public static void stabelising_Cube_V1(int width, int intesiti){
        CodeDraw cd = new CodeDraw(width+width/5, width);

        int oneCord = width/2 - ((width/10)*2); // the first cord for the square / 500 -> 150
        int secCord = width/2 + ((width/10)*2); // the second cord for the square in a square canvas / 500 -> 350
        int cubeOffset = width/25; // 500 -> 20 fuern würfel
        int cubeDistanc = width/5; // 500 -> 100 fuern würfel
        double temp = width/6.6; // 500 -> 75 fuern würfel
        int cubeVerschiebung = (int)temp;

        Random randy = new Random();
        int amplifier = intesiti; // abweichungen bestimmen x3
        int startO = oneCord - intesiti;
        int startS = secCord + intesiti/2;

        int[] cords = new int[36];

        for (int k = 0; 0 < amplifier; k++) {

            //alle random nummern gennerieren
            for (int i = 0; i < cords.length; i++) {
                cords[i] = randy.nextInt(0, amplifier);
            }

            cd.setLineWidth(2);
            cd.drawLine(startO + cords[0], startO + cords[1], startS + cords[2], startO + cubeOffset + cords[3]); // top main
            cd.drawLine(startS + cords[4], startO + cubeOffset + cords[5], startS + cords[6], startS + cubeOffset + cords[7]); // right main
            cd.drawLine(startS + cords[8], startS + cubeOffset + cords[9], startO + cords[10], startS + cords[11]); // bottom main
            cd.drawLine(startO + cords[12], startS + cords[13], startO + cords[14], startO + cords[15]); // left main

            cd.drawLine(startO + cubeDistanc + cords[16], startO - cubeVerschiebung + cords[17], startS + cubeDistanc + cords[18], startO + cubeOffset - cubeVerschiebung + cords[19]); // top back
            cd.drawLine(startO + cords[20], startO + cords[21], startO + cubeDistanc + cords[22], startO - cubeVerschiebung + cords[23]); // top left
            cd.drawLine(startS + cords[24], startO + cubeOffset + cords[25], startS + cubeDistanc + cords[26], startO + cubeOffset - cubeVerschiebung + cords[27]); // top right

            cd.drawLine(startS + cubeDistanc + cords[28], startO + cubeOffset - cubeVerschiebung + cords[29], startS + cubeDistanc + cords[30], startS + cubeOffset - cubeVerschiebung + cords[31]); // right back
            cd.drawLine(startS + cords[32], startS + cubeOffset + cords[33], startS + cubeDistanc + cords[34], startS + cubeOffset - cubeVerschiebung + cords[35]); // right bottom

            amplifier --; // reduziert den amp damit es ned mehr so wobbelt
            startO ++; // erhoht den start0 dammit er näher am richtigen punkt ist reduziert auch das wobbeln
            if(k%2==0)startS --; // verringert den startS dammit er näher am richtigen punkt ist reduziert auch das wobbeln

            cd.show(100);
            cd.clear();

        }

        Scanner input = new Scanner(System.in);
        System.out.println("another round?");
        String answer = input.next();
        if(answer.equals("yes")){
            System.out.println("Wanna change anything?");
            answer = input.next();
            if(answer.equals("no")){
                stabelising_Cube_V1(width, intesiti);
            }else{
                System.out.println("What is it gona be this time? (first width, then intensiti)");
                int breite = input.nextInt();
                int abweichung = input.nextInt();
                if(breite > 100 && abweichung > 10 ) stabelising_Cube_V1(breite, abweichung);
                else System.out.println("What did i just tell you??? try again later");
            }
        }else{
            System.out.println("well then, bye bye ^^");
        }

    }



    // stabelising cube but with accelerated speed so it
    // 1. doesnt take so long
    // 2. looks cooler cause fast and big to slow and precise looks good
    public static void stabelising_Cube_fast(int width, int intesiti){
        CodeDraw cd = new CodeDraw(width+width/5, width);

        int oneCord = width/2 - ((width/10)*2); // the first cord for the square / 500 -> 150
        int secCord = width/2 + ((width/10)*2); // the second cord for the square in a square canvas / 500 -> 350
        int cubeOffset = width/25; // 500 -> 20 fuern würfel
        int cubeDistanc = width/5; // 500 -> 100 fuern würfel
        double temp = width/6.6; // 500 -> 75 fuern würfel
        int cubeVerschiebung = (int)temp;

        Random randy = new Random();
        int amplifier = intesiti; // abweichungen bestimmen x3
        int startO = oneCord - intesiti;
        int startS = secCord + intesiti/2;

        int[] cords = new int[36];


        for (int k = 0; 0 < amplifier; k++) {

            //alle random nummern gennerieren
            for (int i = 0; i < cords.length; i++) {
                cords[i] = randy.nextInt(0, amplifier);
            }

            cd.setLineWidth(2);
            cd.drawLine(startO + cords[0], startO + cords[1], startS + cords[2], startO + cubeOffset + cords[3]); // top main
            cd.drawLine(startS + cords[4], startO + cubeOffset + cords[5], startS + cords[6], startS + cubeOffset + cords[7]); // right main
            cd.drawLine(startS + cords[8], startS + cubeOffset + cords[9], startO + cords[10], startS + cords[11]); // bottom main
            cd.drawLine(startO + cords[12], startS + cords[13], startO + cords[14], startO + cords[15]); // left main

            cd.drawLine(startO + cubeDistanc + cords[16], startO - cubeVerschiebung + cords[17], startS + cubeDistanc + cords[18], startO + cubeOffset - cubeVerschiebung + cords[19]); // top back
            cd.drawLine(startO + cords[20], startO + cords[21], startO + cubeDistanc + cords[22], startO - cubeVerschiebung + cords[23]); // top left
            cd.drawLine(startS + cords[24], startO + cubeOffset + cords[25], startS + cubeDistanc + cords[26], startO + cubeOffset - cubeVerschiebung + cords[27]); // top right

            cd.drawLine(startS + cubeDistanc + cords[28], startO + cubeOffset - cubeVerschiebung + cords[29], startS + cubeDistanc + cords[30], startS + cubeOffset - cubeVerschiebung + cords[31]); // right back
            cd.drawLine(startS + cords[32], startS + cubeOffset + cords[33], startS + cubeDistanc + cords[34], startS + cubeOffset - cubeVerschiebung + cords[35]); // right bottom


            int tenth = (int)Math.ceil(amplifier/10.0);

            // amp reduzieren
            amplifier -= tenth; // reduziert den amp damit es ned mehr so wobbelt
            startO += tenth; // erhoht den start0 dammit er näher am richtigen punkt ist reduziert auch das wobbeln
            if(k%2==0)startS -= tenth; // verringert den startS dammit er näher am richtigen punkt ist reduziert auch das wobbeln

            cd.show(100);
            cd.clear();
            System.out.println("round " + k);
        }

        Scanner input = new Scanner(System.in);
        System.out.println("another round?");
        String answer = input.next();
        if(answer.equals("yes")){
            System.out.println("Wanna change anything?");
            answer = input.next();
            if(answer.equals("no")){
                stabelising_Cube_fast(width, intesiti);
            }else{
                System.out.println("What is it gona be this time? (first width, then intensiti)");
                int breite = input.nextInt();
                int abweichung = input.nextInt();
                if(breite > 100 && abweichung > 10 ) stabelising_Cube_fast(breite, abweichung);
                else System.out.println("What did i just tell you??? try again later");
            }
        }else{
            System.out.println("well then, bye bye ^^");
        }

    }


    // a bit out of place cube, but ey its a cube so its great anyways :))
    public static void drawACubeV2(int width, int intesiti) {
        CodeDraw cd = new CodeDraw(width+width/5, width);

        int oneCord = width/2 - ((width/10)*2); // the first cord for the square / 500 -> 150
        int secCord = width/2 + ((width/10)*2); // the second cord for the square in a square canvas / 500 -> 350
        //int cubeOffset = width/25; // 500 -> 20 fuern würfel
        int cubeDistanc = width/5; // 500 -> 100 fuern würfel
        double temp = width/6.6; // 500 -> 75 fuern würfel
        int cubeVerschiebung = (int)temp;


        cd.setLineWidth(2);
        cd.drawLine(150,150,350,150); // top mid
        cd.drawLine(350,150,350,350); // top right
        cd.drawLine(350,350,150,350); // top bottom
        cd.drawLine(150,350,150,150); // top left

        cd.drawLine(150,150,250,50); // top back
        cd.drawLine(250,50,450,50); // top left
        cd.drawLine(450,50, 350,150); // top right

        cd.drawLine(450,50,450,250); // right back
        cd.drawLine(350,350, 450, 250); // right bottom

        cd.show(100);
        cd.clear();

    }


    // not sure whats so different from this to the V2 or the other perspecitve ones but yeah cube V3 i guess :)
    public static void DrawV3(int width, int intesiti){
        CodeDraw cd = new CodeDraw(width+width/5, width);

        int oneCord = width/2 - ((width/10)*2); // the first cord for the square / 500 -> 150
        int secCord = width/2 + ((width/10)*2); // the second cord for the square in a square canvas / 500 -> 350
        //int cubeOffset = width/25; // 500 -> 20 fuern würfel
        int cubeDistanc = width/5; // 500 -> 100 fuern würfel
        double temp = width/6.6; // 500 -> 75 fuern würfel
        int cubeVerschiebung = (int)temp;


        cd.setLineWidth(2);
        cd.drawLine(oneCord, oneCord, secCord, oneCord + 20);
        cd.drawLine(secCord, oneCord + 20, secCord, secCord + 20);
        cd.drawLine(secCord, secCord + 20, oneCord, secCord);
        cd.drawLine(oneCord, secCord, oneCord, oneCord);

        cd.drawLine(oneCord + 100, oneCord - 75, secCord + 100, oneCord + 20 - 75); // top back
        cd.drawLine(oneCord, oneCord, oneCord + 100, oneCord - 75); // top left
        cd.drawLine(secCord, oneCord + 20, secCord + 100, oneCord + 20 - 75); // top right

        cd.drawLine(secCord + 100, oneCord + 20 - 75, secCord + 100, secCord + 20 - 75); // right back
        cd.drawLine(secCord, secCord + 20, secCord + 100, secCord + 20 - 75); // right bottom

        cd.show(100);
        cd.clear();
    }



}
