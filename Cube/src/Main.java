import java.util.Scanner;

import Start_idea.Cube_actuell;
import codedraw.CodeDraw;

public class Main {

    //main size vals
    private static int width = 1000;
    private static int height = 500;

    //extra val to increas the field for a better view | but not fuck with the clean values
    private static int extra = 200;


    public static void main(String[] args) {

        System.out.println("Hello what we doin today");

        Scanner input = new Scanner(System.in);

        int option = input.nextInt();

        if(option == 1){ // whatever i was working on bevor putting it on ice
            System.out.println("First option");
            CodeDraw mainPlain = new CodeDraw(width + extra, height + extra);

            plain(mainPlain);

            mainPlain.show();
        }else if(option == 2){ // the old main option i did for the creative project
            System.out.println("Second option");

            Cube_actuell actuell = new Cube_actuell();

            int nextInput = input.nextInt();

        }else{ // work option -> what ever im working at the moment
            System.out.println("Third option");

            int nextInput = input.nextInt();

        }
    }


    public static void plain(CodeDraw mainPlain){

        //end of the horizons
        mainPlain.drawCircle(100, 350, 1);
        mainPlain.drawCircle(1100, 350, 1);


        //middle line
        mainPlain.drawLine(600,100,600,600);

        //connection lines
        mainPlain.drawLine(600,100,100,350);
        mainPlain.drawLine(600,100,1100,350);
        mainPlain.drawLine(600,600,100,350);
        mainPlain.drawLine(600,600,1100,350);

        //equation for needed y value
        float y_hight = (float) (350 - 100)/(600-100);
        System.out.println(y_hight + " | " + 500*0.5);

        float inner = (float) (550-100)*y_hight;
        float middle = (float) (500-100)*y_hight;
        float outer = (float) (450-100)*y_hight;

        System.out.println(inner + " | " + middle + " | " + outer);

        //Cube side lines ??? innen | mittl | ausen
        mainPlain.drawLine(550,inner,550,600-inner);
        mainPlain.drawLine(650,inner,650,600-inner);

        mainPlain.drawLine(500,middle,500,600-middle);
        mainPlain.drawLine(700,middle,700,600-middle);

        mainPlain.drawLine(450,outer,450,600-outer);
        mainPlain.drawLine(750,outer,750,600-outer);


    }



}