package Version_1;


import codedraw.CodeDraw;

import java.sql.SQLOutput;

/**
 * a class used in combination with @Class Coordinates to describe the different objects in the world
 * using 3 values, same as coordinates but those arnt the location, that's covered by a coordinate itself
 * those are the direction of the vektor in which and how strong it goes
 */
public class Vector {


    private Coordinates startPoint;

    private int xDirection;
    private int yDirection;
    private int zDirection;



    /// ___________________________ CONSTRUCTS _________________________________________


    /**
     * The plain default constructor giving the startPoint the 0|0|0 cords
     * as well as setting the direction also to 0|0|0
     * so point at the center with no direction, great for custom use later
     */
    public Vector(){
        startPoint = new Coordinates();

        xDirection = 0;
        yDirection = 0;
        zDirection = 0;
    }

    /**
     * The basic constructor allowing for a custom coordinate as well as custom directions
     * If Cord is null the cords will be set to default (0|0|0)
     * @param cord -> the wished for coordinate, if null set to default (0|0|0)
     * @param xDir -> the x-Direction for the Vector
     * @param yDir -> the y-Direction for the Vector
     * @param zDir -> the z-Direction for the Vector
     */
    public Vector(Coordinates cord, int xDir, int yDir, int zDir){

        try{
            setStartPoint(cord);
        }catch (NullPointerException np){
            setStartPoint(new Coordinates());
        }

        xDirection = xDir;
        yDirection = yDir;
        zDirection = zDir;
    }

    /**
     * The, a bit more complex, basic constructor, requiring 6 integer-values
     * 3 for the Coordinate
     * 3 for the Direction
     * @param xCord -> x Coordinate
     * @param yCord -> y Coordinate
     * @param zCord -> z Coordinate
     * @param xDir -> x Direction
     * @param yDir -> y Direction
     * @param zDir -> z Direction
     */
    public Vector(int xCord, int yCord, int zCord, int xDir, int yDir, int zDir){

        setStartPoint(new Coordinates(xCord, yCord, zCord));

        xDirection = xDir;
        yDirection = yDir;
        zDirection = zDir;
    }


    /// _____________________ GETTERS AND SETTERS _____________________________

    /**
     * Getter for startPoint
     * @return the Startpoint a Coordinate
     */
    public Coordinates getStartPoint() {
        return startPoint;
    }

    /**
     * The setter for the startpoint
     * @param startPoint -> the given startPoint used to overwrite the current value or assign for the first time
     * @throws NullPointerException -> if the given Coordinate is NULL a Null-pointer is thrown
     */
    public void setStartPoint(Coordinates startPoint) throws NullPointerException {
        try{
            this.startPoint = startPoint;
        }catch (NullPointerException np){
            System.out.println("| Vector | setStartPoint | NULL-ERROR | The given Coordinate was NULL |");
            throw new NullPointerException("Coordinate was Null");
        }
    }



    /**
     * the getters and setters for the Directions
     * @return the wanted direction factor of the Vactor, and all of them at once if needed
     */
    public int getxDirection() {
        return xDirection;
    }

    public void setxDirection(int xDirection) {
        this.xDirection = xDirection;
    }

    public int getyDirection() {
        return yDirection;
    }

    public void setyDirection(int yDirection) {
        this.yDirection = yDirection;
    }

    public int getzDirection() {
        return zDirection;
    }

    public void setzDirection(int zDirection) {
        this.zDirection = zDirection;
    }

    public int[] getAllDirection(){
        return new int[] {xDirection, yDirection, zDirection};
    }



    /// ____________________________________ CALCS __________________________________________

    //TODO descriptions needed

    // einmal auf der x,y ebene
    // und einaml auf der x,z ebene
    // die rotation berechnen
    public double[] calcAngles(){

        System.out.println("| Vector | calcAngles | INFO | starting the method");
        return new double[] {calcAngle(xDirection, yDirection), calcAngle(xDirection, zDirection)};
    }

    public double calcAngle(int x, int y){

        System.out.println("| Vector | calcAngle | INFO | starting the method");

        if(x != 0 ) { // we got increase on x
            if(y != 0) { // we got increase on y

                // actual values that need to be calced
                System.out.println("| Vector | calcAngle | INFO | calcing degrees");
                double angleRad = Math.atan2(y, x);
                return Math.toDegrees(angleRad);

            }else{

                if(x > 0){ // normal straight right
                    System.out.println("| Vector | calcAngle | VALUE-INFO | First is positive (>0) and second is 0 --> 0°");
                    return 0.0;
                }else{ // straight left
                    System.out.println("| Vector | calcAngle | VALUE-INFO | First is negative (<0) and second is 0 --> 180°");
                    return 180.0;
                }
            }

        } else if (y != 0) { // rest to just check fast and catch the 0s

            if(y > 0){ // y is positive so top site and no x straight up
                System.out.println("| Vector | calcAngle | VALUE-INFO | Second is positive (>0) and First is 0 --> 90°");
                return 90.0;
            }else{ // y is negative and straight down
                System.out.println("| Vector | calcAngle | VALUE-INFO | Second is positive (<0) and First is 0 --> 270°");
                return 270.0;
            }

        }

        System.out.println("| Vector | calcAngle | INFO | Both values are 0 so no angle possible");;
        return 0;
    }


    // first calc all the possible connections between those test cords and calc the rates and find out how to put negativ numbers into this game without fucking up
    // either taking the biggest value of the 3 and give the rate working with that
    // or taking the wanted axes
    // not sure what will work better or might be more usefull but im just gona make both cant hurt and worst-case one wont be used
    public double[] calcRates(String axes){

        String comp = axes.toLowerCase();

        return switch (comp) {
            case "x" -> calcXRate();
            case "y" -> calcYRate();
            case "z" -> calcZRate();
            default -> new double[]{0, 0, 0};
        };
    }

    public double[] calcXRate(){

        System.out.println("| Vector | calcXRate | INFO | Starting Methode");


        if(xDirection != 0){ // if x is 0 or not, dividing by 0 wouldn't be that nice
            double yDx = (double) yDirection/xDirection; // y divided by x
            double zDx = (double) zDirection /xDirection; // z divided by x

            System.out.println("| Vector | calcXRate | VALUE-INFO | Rates calculated successfully | Y/X: " + yDx + " | Z/X: " + zDx + " |");

            return new double[]{1,yDx, zDx};

        }else if(yDirection != 0){ // if y is 0 or not and calcing the rate after it as x is irrelevant
            System.out.println("| Vector | calcXRate | VALUE-INFO | X is 0 so orientating after Y and calling calcYRate()");
            return calcYRate();

        }else if (zDirection != 0) { // if so we only got z left
            System.out.println("| Vector | calcXRate | VALUE-INFO | X and Y direction are 0 so the rate is only Z: " + zDirection);
            return new double[]{0, 0, zDirection};
        }

        System.out.println("| Vector | calcXRate | VALUE-INFO | All directions are 0 so the rates are all 0");
        return new double[] {0, 0, 0};
    }

    public double[] calcYRate(){

        System.out.println("| Vector | calcYRate | INFO | Starting Methode");


        if(yDirection != 0){ // if y is 0 or not cause div by 0 no bueno

            double xDy = (double) xDirection/yDirection; // x divided by y
            double zDy = (double) zDirection/yDirection; // z divided by y

            System.out.println("| Vector | calcYRate | VALUE-INFO | Rates calculated successfully | X/Y: " + xDy + " | Z/Y: " + zDy + " |");

            return new double[]{xDy, 1, zDy};

        }else if (zDirection != 0){
            System.out.println("| Vector | calcYRate | VALUE-INFO | Y is 0 so orientating after Z and calling calcZRate()");
            return calcZRate();

        }else if (xDirection != 0){ // all are 0 so we back with
            System.out.println("| Vector | calcXRate | VALUE-INFO | Y and Z direction are 0 so the rate is only X: " + xDirection);
            return new double[]{xDirection,0,0};
        }

        System.out.println("| Vector | calcYRate | VALUE-INFO | All directions are 0 so the rates are all 0");
        return new double[] {0, 0, 0};
    }

    public double[] calcZRate(){

        System.out.println("| Vector | calcZRate | INFO | Starting Methode");

        if(zDirection != 0){ // check if z is 0 cause div by 0 ain't fun

            double xDz = (double) xDirection/zDirection; // x divided by z
            double yDz = (double) yDirection/zDirection; // y divided by z

            System.out.println("| Vector | calcZRate | VALUE-INFO | Rates calculated successfully | X/Z: " + xDz + " | Y/Z: " + yDz + " |");

            return new double[]{xDz, yDz, 1};

        }else if (xDirection != 0){ // check if x is an alternative
            System.out.println("| Vector | calcZRate | VALUE-INFO | Z is 0 so orientating after X and calling calcXRate()");
            return calcXRate();

        }else if (yDirection != 0){ // is even y = 0 or not
            System.out.println("| Vector | calcZRate | VALUE-INFO | X and Z direction are 0 so the rate is only Y: " + yDirection);
            return new double[]{0,yDirection,0};
        }


        System.out.println("| Vector | calcZRate | VALUE-INFO | All directions are 0 so the rates are all 0");
        return new double[] {0, 0, 0};
    }



    /// _________________________________________VISUAL_____________________________________________

    //TODO descriptions needed

    public void visualize2D(CodeDraw cdXY, CodeDraw cdXZ){
        // TODO write code draw function

        System.out.println("| Vector | visualize2D | INFO | starting the Methode");

        if(cdXY == null){
            System.out.println("| Vector | visualize2D | VALUE-ERROR | cdXY (XY drawing Window) is null/not given, XY vector can't/won't be drawn");
        }
        if(cdXZ == null){
            System.out.println("| Vector | visualize2D | VALUE-ERROR | cdXZ (XZ drawing Window) is null/not given, XZ vector can't/won't be drawn");
        }
        double[] rates = calcXRate();

        // drawing the layout for the vectors

        cdXY.drawBezier();



    }


    public void visualize3D(CodeDraw cd){
        // TODO write code draw function
    }


    public void drawVector(CodeDraw cd, Kamera kam){
        // TODO write drawVector but think about if the vector is visible
    }


    ///_______________________________________________STATS__________________________________


    /**
     * checks if a vector is totally identical
     * @param obj the given obj to be compared
     * @return true if identical and false if not
     */
    @Override
    public boolean equals(Object obj) {

        if(obj.getClass().equals(Vector.class)){
            if(((Vector) obj).startPoint.equals(startPoint) &&
                ((Vector) obj).xDirection == xDirection &&
                ((Vector) obj).yDirection == yDirection &&
                ((Vector) obj).zDirection == zDirection){
                return true;
            }
        }
        return false;
    }


    /**
     * The hashCode, duh
     * @return adds the cord.hashCode and the values of the directions
     */
    @Override
    public int hashCode(){
        return startPoint.hashCode() + xDirection + yDirection + zDirection;
    }


    /**
     * The toString of a Vector returning all the details in a nice single string/ one line
     * @return the toString from the start-Coordinate as well as the directional vector with its values
     */
   @Override
    public String toString(){
        return startPoint.toString() + " --> | " + xDirection + " | " + yDirection + " | " + zDirection + " |";
    }

    /// TODO description needed
    public String toStringDetailed(){
        String ret = "";
        double[] rates = calcXRate();
        double[] angles = calcAngles();
        ret += "Start: "  + startPoint.toString() + "\n";
        ret += "Direction: | " + xDirection + " | " + yDirection + " | " + zDirection + " |\n";
        ret += "Rates:     | x " + rates[0] + " | y " + rates[1] + " | z " + rates[2] + " |\n";
        ret += "Angles:    | X/Y: " + angles[0] + " | X/Z: " + angles[1] + " |";

        return ret;
    }

}
