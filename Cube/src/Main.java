import Start_idea.Cube_old;
import Tests.Main_Test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        System.out.println("Hello what we doin today");
        System.out.println("We got 1: whatever im working on right now in active or inactive development");
        System.out.println("We got 2: all the old methods from the old Cube class, were you get more to chose from");
        System.out.println("We got 3: the test-menu");
        Scanner input = new Scanner(System.in);

        while(!input.hasNextInt()){ // check if we got an int in the commandline or not, do read inputs until there are numbers that we can use
            System.out.println("thats not an int buddy, try again");
            System.out.println("we got 1, 2 or 3 on the menu, pick one of those");
           input.next();
        }
        int option = input.nextInt();

        if(option == 1){ // whatever im working on rn
            System.out.println("| First option | well we are working on something i guess, duh");

            int nextInput = input.nextInt();

        }else if(option == 2){ // the old main option i did for the creative project
            System.out.println("| Second option | Creative cube methods");

             Cube_old co = new Cube_old();

            int nextInput = input.nextInt();

        }else if(option == 3){ // selecting what kind tests to run
            System.out.println("| Third option | The tests-Menu, select what you wana test");
            System.out.println("| Instructions | Just type the letters for whatever you wana test from the following list");
            System.out.println("|    Options   |");
            System.out.println("|    Vector    | v or V");
            System.out.println("|   Examples   | a String that would test just Vectors: 'v' or two times 'vv'");
            // TODO
            //  add like the other possible classe one would like to tests and if there are no tests for the classes write them or something
            //  make a quick test option so it doesnt always show so many thing to select from, just run all tests and return what comes from them, if they just return tests

            while (!input.hasNext()){
                input.next();
            }

            Main_Test mainTest = new Main_Test(input.next());

        }else{
            System.out.println("| Whatever-the-fuck-this-is | bro, listen, i told you what we got on the menu so pick one of those or get lost");
            main(args);
        }
    }







}