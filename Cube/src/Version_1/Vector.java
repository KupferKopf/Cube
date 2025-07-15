package Version_1;


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

    // GETTERS AND SETTERS START
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
    // GETTERS AND SETTERS END


    // einmal auf der x,y ebene
    // und einaml auf der x,z ebene
    // die rotation berechnen
    public int[] calcAngles(){



        return new int[] {0, 0};
    }


    // first calc all the possible connections between those test cords and calc the rates and find out how to put negativ numbers into this game without fucking up
    public int[] calcRates(String axes){



        return new int[] {0, 0, 0};
    }


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
    public String toString(){
        return startPoint.toString() + " --> | " + xDirection + " | " + yDirection + " | " + zDirection + " |";
    }

}
