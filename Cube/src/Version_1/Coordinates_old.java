package Version_1;


import java.util.NoSuchElementException;

/**
 * The most basic underlying class for this project
 * having 3 doubles (in future maybe double for 0. cords) values representing the location
 * and a couple methods to get and change/Set those values
 */
public class Coordinates_old {


    private double x;
    private double y;
    private double z;


    /**
     * the default constructor for cords if there is no need for special values just a quick new point in the world
     */
    public Coordinates_old(){
        x = 0;
        y = 0;
        z = 0;
    }

    /**
     * the custom/normal constructor for cords, allowing any kind of cord, as long as its an double (maybe later it will be double)
     * @param x -> the x part of the coordinate
     * @param y -> the y part of the coordinate
     * @param z -> the z part of the coordinate
     */
    public Coordinates_old(double x, double y, double z){
        try{
            setAll(new double[] {x,y,z});
        }catch(NullPointerException np){ // not needed to catch this but still gona do it just in case
            System.out.println("| Coordinates | double-Constructor | NULL-ERROR | " + np.getMessage());
        }catch(NoSuchElementException nse){ // not need to catch as well but still just to be safe
            System.out.println("| Coordinates | double-Constructor | VALUE-ERROR | " + nse.getMessage());
        }

    }

    /**
     * also a custom constructor used if you want to make a carbon coby of a cord directly
     * @param cords -> the coordinates that you want to copy
     */
    public Coordinates_old(Coordinates_old cords){
        try{
            setByCords(cords);
        }catch(NullPointerException np){ // possible
            System.out.println("| Coordinates | cords-Constructor | NULL-ERROR | " + np.getMessage());
        }
    }


    /**
     * Getters and setters for the cords
     * @return the individual cords for all the values
     */
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double[] getAll(){
       return new double[] {x,y,z};
    }
    /*
     * end of generic setters and getters
     */


    /**
     * sets the 3 cords of the coordinate to the new values contained in vals
     * @param vals -> double array that contains the new values for the coordinates
     * @throws NullPointerException -> if the array is null
     * @throws NoSuchElementException -> if the array is too short or too long
     */
    public void setAll(double[] vals) throws NullPointerException, NoSuchElementException{
        try{
            if(vals.length != 3){
                throw new NoSuchElementException("The given array didn't contain 3 doubles");
            }
            setX(vals[0]);
            setY(vals[1]);
            setZ(vals[2]);
        }catch (NullPointerException np){ // if the array is null
            System.out.println("| Coordinates | setAll | NULL-ERROR | The given array was null");
            throw new NullPointerException("The given array was null");
        }catch (NoSuchElementException nse){ // if the array doesn't contain enough or to many elements
            System.out.println("| Coordinates | setAll | VALUE-ERROR | The given array didn't contain 3 doubles ");
            throw new NoSuchElementException(nse.getMessage());
        }
    }


    /**
     * sets the cords of the coordinate by using the values of another coordinate
     * @param cords -> the other coordinate used for the values
     * @throws NullPointerException -> if the cord's null
     */
    public void setByCords(Coordinates_old cords) throws NullPointerException{
        try{
            setX(cords.getX());
            setY(cords.getY());
            setZ(cords.getZ());
        }catch(NullPointerException nl){
            System.out.println("| Coordinates | setAll | NULL-ERROR | The given array was null");
            throw new NullPointerException("The given array was null");
        }
    }


    public double calcAngels(Coordinates_old cord){


        return 0;
    }



    public double calcVektor(Coordinates_old cord){

        return 0;
    }



    /**
     * Checks if the given obj is -> a Coordinate
     *                            -> has the same values
     * @param obj -> the given obj to check
     * @return true if the obj fulfills both criteria and false if not
     */
    @Override
    public boolean equals(Object obj) {
        if(obj.getClass().equals(Coordinates_old.class)){ // are they cords?
            if(x == ((Coordinates_old) obj).x && y == ((Coordinates_old) obj).y && z == ((Coordinates_old) obj).z){ // do they have the same values?
                return true;
            }
        }
        return false;
    }

    /**
     * The toString method gives the details of the coordinate
     * @return a String containing the x, y and z (in this order) parts
     */
    public String toString(){
        return "| " + x + " | " + y + " | " + z + " |";
    }

}
