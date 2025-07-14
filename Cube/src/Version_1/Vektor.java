package Version_1;


/**
 * a class used in combination with @Class Coordinates to describe the different objects in the world
 * using 3 values, same as coordinates but those arnt the location, that's covered by a coordinate itself
 * those are the direction of the vektor in which and how strong it goes
 */
public class Vektor {


    private Coordinates startPoint;

    private int xDirection;
    private int yDirection;
    private int zDirection;

    /**
     * The plain default constructor giving the startPoint the 0|0|0 cords
     * as well as setting the direction also to 0|0|0
     * so point at the center with no direction, great for custom use later
     */
    public Vektor(){
        startPoint = new Coordinates();

        xDirection = 0;
        yDirection = 0;
        zDirection = 0;
    }


    public Vektor(Coordinates cord, int xDir, int yDir, int zDir){


    }


    public Vektor(int xCord, int yCord, int zCord, int xDir, int yDir, int zDir){



    }


    public Coordinates getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Coordinates startPoint) {
        this.startPoint = startPoint;
    }

    public int getxDirection() {
        return xDirection;
    }

    public void setxDirection(int xDirection) {
        this.xDirection = xDirection;
    }

    public int getzDirection() {
        return zDirection;
    }

    public void setzDirection(int zDirection) {
        this.zDirection = zDirection;
    }

    public int getyDirection() {
        return yDirection;
    }

    public void setyDirection(int yDirection) {
        this.yDirection = yDirection;
    }


    public int[] getAllDirection(){
        return new int[] {xDirection, yDirection, zDirection};
    }


    public int[] getAngles(){




        return new int[] {0, 0};
    }


    @Override
    public boolean equals(Object obj) {

        if(obj.getClass().equals(Vektor.class)){
            if(((Vektor) obj).startPoint.equals(startPoint) &&
                ((Vektor) obj).xDirection == xDirection &&
                ((Vektor) obj).yDirection == yDirection &&
                ((Vektor) obj).zDirection == zDirection){
                return true;
            }
        }
        return false;
    }

    /**
     * The toString of a Vector returning all the details in a nice single string/ one line
     * @return the toString from the start-Coordinate as well as the directional vector with its values
     */
    public String toString(){
        return startPoint.toString() + " --> | " + xDirection + " | " + yDirection + " | " + zDirection + " |";
    }

}
