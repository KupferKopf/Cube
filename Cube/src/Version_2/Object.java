package Version_2;

import codedraw.CodeDraw;

/**
 * a general version of an object
 * needs to have rawCords, projectedCords, and faces
 * because without cords and faces made of them that shit ain't no object
 */
public interface Object {


    Coordinate[] rawCords = new Coordinate[0];
    Coordinate[] projectedCords = new Coordinate[0];
    Face[] faces = new Face[0];

    /**
     * does it need anything else?
     * Todo: later extend with different position (camera pos), when calcing projections
     */


    /// ----------------------------- SETUP --------------------------------------


    /**
     * Set up the cords for the object, changes depending on the object type
     */
    private void setUpRawCords() {}


    /**
     * start-setup for the given object, the hardcoded faces, that seem the most logical
     */
    private void setUpFaces(){}


    /// ------------------------------ SETTER & GETTERS ----------------------------------


    /**
     * sets the entire rawCords-array
     * @param cords -> the replacement array
     */
    private void setRawCords(Coordinate[] cords) {}

    /**
     * set a specific cord
     * @param pos -> the position of the desired cord that should be replaced
     * @param cord -> the cord to replace the old one
     */
    void setRawCord(int pos, Coordinate cord);

    /**
     * @return a copy of the entire rawCords-array
     */
    Coordinate[] getRawCords();

    /**
     * @param pos -> the position of the desired rawCord
     * @return the rawCord at the given position
     */
    Coordinate getRawCord(int pos);


    /**
     * sets/replaces all Faces in the array with a new Face-array
     * @param faces -> the array used for replacement
     */
    private void setFaces(Face[] faces){}

    /**
     * set a Face at a desired position in the array
     * @param pos -> the pos in the array that should be changed
     * @param face -> the face that will replace the old one
     */
    private void setFace(int pos, Face face){}

    /**
     * @return a copy of the Faces array
     */
    Face[] getFaces();

    /**
     * @param pos -> the position of the Face in the array
     * @return a copy of the Face
     */
    Face getFace(int pos);


    /**
     * change the projected cords at the wished position
     * @param pos -> position that will be changed
     * @param x -> the x-value for the cord
     * @param y -> the y-value for the cord
     */
    private void setProjectedCord(int pos, double x, double y){};


    /**
     * @return all projectedCords, a copy of the entire array
     */
    Coordinate[] getProjectedCords();


    /**
     * Returns the projectedCord on the desired postion
     * @param pos -> the position of the cord in the array
     * @return the wished for projectedCord
     */
    Coordinate getProjectedCord(int pos);



    /// --------------------------------- CALCULATIONS & DRAWING ------------------------------------



    /**
     * draws/projects the object onto the codedraw window
     * @param cd -> the Codedraw window in which it will be drawn
     */
    void project(CodeDraw cd);


    /**
     * Calculates the screenCords for the codeDraw
     * saves the douuble array with the [0]=sX and [1]=sY representing the cords on the screen into the projected array
     * with the steps:
     *
     * 1. get them to the right distance
     * x' = x/z
     * y' = y/z
     *
     * 2. get them to the right scaling for the screen, x and y go from -1..1 in the fov
     * -1..1 -> 0..2 -> 0..1 -> minSize..maxSize
     * sX = (x' + widthRatio) / (widthRatio*2)
     * sY = (y' + heightRatio) / (heightRatio*)
     * @param cd -> the Codedraw window where the points will be projected onto
     */
    void calcProjection(CodeDraw cd);


    /**
     *  I take the face, go through all the cords of it and always connect 2 after-each-other with a line
     *  so I loop through the array and use % to get back to the front
     *  while going through the array i take the cords and get their x,y on the codedraw screen and then connect them
     *
     * @param cd -> the CodeDraw window that the faces should be drawn into
     * @param minimal -> the boolean deciding if the object is drawn with the minimal-amount of lines
     */
    void connectFaces(CodeDraw cd, boolean minimal);


    /**
     * Draws a line on the given CodeDraw between the firstPoint and secondPoint
     *
     * @param cd -> the given CodeDraw where the line will be drawn
     * @param firstPoint -> the first point, type int, value representing the positon in the projectedCords-Array
     * @param secondPoint -> the second point, type int, value representing the positon in the projectedCords-Array
     */
    void connectPoints(CodeDraw cd, int firstPoint, int secondPoint);


    /// ----------------------------- Movement -------------------------------



    /**
     * Move the entire object along the X-Axes by the given value +/-
     * @param x -> the value by which the Object should be moved along the x-axes
     */
    void moveX(double x);

    /**
     * Move the entire object along the Y-Axes by the given value +/-
     * @param y -> the value by which the Object should be moved along the y-axes
     */
    void moveY(double y);

    /**
     * Move the entire object along the Z-Axes by the given value +/-
     * @param z -> the value by which the Object should be moved along the z-axes
     */
    void moveZ(double z);


    void moveVector(Vector v);


    ///  ------------------------------------- STATS -----------------------------------------


    /**
     * @return the give object as a String, containing all the needed details one might want
     */
    String toString();

}
