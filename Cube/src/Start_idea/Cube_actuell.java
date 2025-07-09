package Start_idea;

import codedraw.CodeDraw;

import java.util.Scanner;

public class Cube_actuell {

    public static void main(String[] args){ // Das ist zwar schon relativ weit aber noch ned vollständig, just vor fun würd ich dann aber noch die fertige version beim Abgabegesrpäch herzeigen
        Scanner input = new Scanner(System.in);
        System.out.println("How big should the Canvas be (bigger then a 100 cause you wont see much) and after that the intensiti (bigger then 10 cause it should be a bit fun right?)");
        //int width = input.nextInt();
        //int intensiti = input.nextInt();
        //if(width > 100 && intensiti > 10 )
        drawACubeV2(500, 10);
        DrawV3(500, 100);
        //else System.out.println("What did i just tell you??? try again later");
    }

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
