import Start_idea.Cube_old;

import java.util.Scanner;

public class Main {

    //main size vals
    private static int width = 1000;
    private static int height = 500;

    //extra val to increas the field for a better view | but not fuck with the clean values
    private static int extra = 200;


    public static void main(String[] args) {

        System.out.println("Hello what we doin today");
        System.out.println("We got 1: whatever im working on right now in active or inactive development");
        System.out.println("We got 2: all the old mehtods from the old Cube class, were you get more to chose from");
        System.out.println("We got 3: who knows whats there havn't found a use yet");
        Scanner input = new Scanner(System.in);

        int option = input.nextInt();

        if(option == 1){ // whatever im working on rn
            System.out.println("| First option | well we are working on something i guess, duh");

            int nextInput = input.nextInt();

        }else if(option == 2){ // the old main option i did for the creative project
            System.out.println("| Second option | Creative cube methods");

             Cube_old co = new Cube_old();

            int nextInput = input.nextInt();

        }else{ // well who know whats gona end up here
            System.out.println("| Third option | man i dont even know");

            int nextInput = input.nextInt();

        }
    }





}