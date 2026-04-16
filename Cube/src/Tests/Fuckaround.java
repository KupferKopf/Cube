package Tests;

import Version_2.Coordinate;
import Version_2.Face;
import Version_2.Cube;
import Version_2.Object;
import codedraw.CodeDraw;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * just a class with methods to fuckaround with some stuff that got into my mind
 * to test stuff manually first to then automate it and test that with the main tests
 */
public class Fuckaround {


    List<Object> objects;

    int width;
    int height;

    public Fuckaround(){
        width = 960;
        height = 540;
        CodeDraw cd = new CodeDraw(width, height);

        objects = new LinkedList<Object>();

        //cube rigth
        Coordinate tempCord = new Coordinate(-3.5,-3.5,4);
        Cube cube = new Cube(tempCord, 3, cd);
        objects.add(cube);

        // cube left
        tempCord = new Coordinate(0.5,-3.5,4);
        cube = new Cube(tempCord, 3, cd);
        objects.add(cube);

        // cube top
        tempCord = new Coordinate(-3.5,0.5,4);
        cube = new Cube(tempCord, 3, cd);
        objects.add(cube);

        // cube bottom
        tempCord = new Coordinate(0.5,0.5,4);
        cube = new Cube(tempCord, 3, cd);
        objects.add(cube);



        Iterator<Object> objIter = objects.stream().iterator();
        while (objIter.hasNext()){
            System.out.println();
            System.out.println(objIter.next());
        }

        fuckaroundAll(cd);
        //fuckaround(cube, cd);

    }

    // how to make methode vars optional '?'
    public Fuckaround(int width, int height){
        this.width = width;
        this.height = height;
        CodeDraw cd = new CodeDraw(width, height);
        fuckaround(null, cd);
    }


    private void fuckaround(Cube cube, CodeDraw cd){
        System.out.println("fucking around...");

        double z = 1;
        while(z < 100){
            cd.clear(); // remove for funny tunnel

            cube.moveZ(0.25);
            if(z > 10 && z < 30) cube.moveX(0.25);
            if(z > 30) cube.moveX(-0.5);
            cube.project(cd);
            System.out.println(cube.getRawCord(0).getZ());
            cd.show(45);
            z+= 0.25;
        }


    }

    private void fuckaroundAll(CodeDraw cd){
        System.out.println("fucking around with all Objects");
        System.out.println("Object types: ");
        ListIterator<Object> objList = objects.listIterator();

        int i = 0;
        while (objList.hasNext()){
            Object curObj = objList.next();
            System.out.println(curObj.getClass());
            i++;
        }

        double z = 1;
        while(z < 100){
            objList = objects.listIterator();
            cd.clear(); // remove for funny tunnel


            while (objList.hasNext()){
                Object cube = objList.next();
                cube.moveX(0.25);
                cube.project(cd);
                System.out.println(cube.getRawCord(0).getZ());

            }

            cd.show();
            z+= 0.25;
        }

        System.out.println("We got " + i + " objects");
    }


}
