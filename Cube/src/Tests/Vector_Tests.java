package Tests;

import Version_1.Coordinates;
import Version_1.Vector;
import codedraw.CodeDraw;

public class Vector_Tests {
    //TODO
    // write some Tests that should work and what values they should have considering the values
    // just tests duhhhh
    // an maybe make it test-driven


    public Vector_Tests(){
        System.out.println("| Vector_Tests | Constructor | INFO | we gettin started here, runnin all the tests");
        // TODO
        //  write all test methods here :)

        //creating test Cords
        Coordinates cordDefault = new Coordinates(0,0,0); // Default
        Coordinates cordNorm = new Coordinates(4,3,2);    // normal
        Coordinates cordNx = new Coordinates(-5,1,2);     // negative x
        Coordinates cordNy = new Coordinates(2,-5,3);     // negative y
        Coordinates cordNz = new Coordinates(2,1,-1);     // negative z
        Coordinates cordNxy = new Coordinates(-6,-4,5);   // negative xy
        Coordinates cordNxz = new Coordinates(-4,3,-3);   // negative xz
        Coordinates cordNyz = new Coordinates(3,-3,-2);   // negative yz
        Coordinates cordNxyz = new Coordinates(-4,-4,-3); // negative xyz

        //values for test vectors
        //default 0,0,0
        //norm    1,1,2
        //Nx      -4,5,1
        //Ny      4,-1,1
        //Nz      1,3,-9
        //Nxy     -9,-8,1
        //Nxz     -1,2,-1
        //Nxyz    -1,-10,-9


        System.out.println("| Vector_Tests | Constructor | 1.TEST | Constructors");
        Vector vDefault = new Vector();
        Vector vCordVal = new Vector(cordNorm, 1, 1, 0);
        Vector vInts = new Vector(4,3,2,1,1,0);


        System.out.println("| Default |");
        String comp = "| 0 | 0 | 0 | --> | 0 | 0 | 0 |";
        System.out.println(comp.equals(vDefault.toString()) ? "PASS" : "ERROR" );

        System.out.println("| Cords and Values |");
        comp = "| 4 | 3 | 2 | --> | 1 | 1 | 0 |";
        System.out.println(comp.equals(vCordVal.toString()) ? "PASS" : "ERROR" );

        System.out.println("| Only Ints |");
        System.out.println(comp.equals(vInts.toString()) ? "PASS" : "ERROR" );



        System.out.println("| Vector_Tests | Constructor | 2.TEST | GETTER & SETTER");
        System.out.println();
        System.out.println("| Vector_Tests | Constructor | 3.TEST | CALC");
        System.out.println("| CalcAngles |");
        Vector vNormC = new Vector(cordNorm, 5,6,7);
        double[] angls = vNormC.calcAngles();
        System.out.println("| X/Y: " + angls[0] + " | X/Z: " + angls[1] + " |");

        Vector vAngleX = new Vector(cordNorm, 1,0,0);
        angls = vAngleX.calcAngles();
        System.out.println("| X/Y: " + angls[0] + " | X/Z: " + angls[1] + " |");

        Vector vAngleY = new Vector(cordNorm, 0,1,0);
        angls = vAngleY.calcAngles();
        System.out.println("| X/Y: " + angls[0] + " | X/Z: " + angls[1] + " |");

        System.out.println();
        System.out.println("| CalcRates | basic calc test if math is right |");
        double[] rates = vNormC.calcRates("x");
        System.out.println("| X-focused | X: " + rates[0] + " | Y: " + rates[1] + " | Z: " + rates[2] + " |");
        rates = vNormC.calcRates("y");
        System.out.println("| Y-focused | X: " + rates[0] + " | Y: " + rates[1] + " | Z: " + rates[2] + " |");
        rates = vNormC.calcRates("z");
        System.out.println("| Z-focused | X: " + rates[0] + " | Y: " + rates[1] + " | Z: " + rates[2] + " |");

        System.out.println();
        System.out.println("| CalcRates | check if it switches to other methods |");
        rates = vAngleX.calcRates("x");
        System.out.println("| X-focused | X: " + rates[0] + " | Y: " + rates[1] + " | Z: " + rates[2] + " |");
        rates = vAngleX.calcRates("y");
        System.out.println("| Y-focused | X: " + rates[0] + " | Y: " + rates[1] + " | Z: " + rates[2] + " |");

        System.out.println();
        System.out.println("| CalcRates | try negativ numbers |");
        Vector vNegX = new Vector(cordNorm,-4,5,1);
        rates = vNegX.calcRates("x");
        System.out.println("| negative-X-focused | X: " + rates[0] + " | Y: " + rates[1] + " | Z: " + rates[2] + " |");
        rates = vNegX.calcRates("y");
        System.out.println("| positive-Y-focused | X: " + rates[0] + " | Y: " + rates[1] + " | Z: " + rates[2] + " |");


        System.out.println();
        System.out.println("| Vector_Tests | Constructor | 4.TEST | VISUALISE");
        System.out.println("| 2D Visualizing | one window for the xy rate, one window for the xz rate");
        CodeDraw cdXY = new CodeDraw(700,500);
        //CodeDraw cdXZ = new CodeDraw(700,500);
        Vector vNorm = new Vector(cordNorm, 5,6,7);
        vNorm.visualize2D(cdXY, null);


        System.out.println();
        System.out.println("| Vector_Tests | Constructor | 5.TEST | STATS");
    }


}
