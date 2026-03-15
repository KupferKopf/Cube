package Version_2;

import codedraw.CodeDraw;

/**
 * a Cube, having equally sized sides and faces
 * the points of the cube are order like this
 *        [0]                  [1]                  [2]                [3]
 * bottom left front | bottom right front | bottom right back | bottom left back |
 *      [4]              [5]               [6]              [7]
 * top left front | top right front | top right back | top left back
 */
public class Cube implements Object{

    Coordinate[] rawCords;
    Coordinate[] projectedCords;
    Face[] faces;


    /// ----------------------------- SETUP --------------------------------------


    public Cube(Coordinate startCord, double width, CodeDraw cd){
        rawCords = new Coordinate[8];
        projectedCords = new Coordinate[8];
        faces = new Face[6];
        setUpCords(startCord, width);

    }

    /**
     * creates the rawCords for the cube from the bottom left so the startCord is the front bottom left corner of the cube
     * front and bottom left in the way of, pov, facing +z, having +x for right and -x for negative and y for height
     * @param startCord -> the startCords from where the cube will be build
     * @param width -> how wide the cube should be as all sides are the same length needs no other size-var
     */
    private void setUpCords(Coordinate startCord, double width){

        double x = startCord.getX();
        double y = startCord.getY();
        double z = startCord.getZ();

        for (int i = 0; i < 2; i++) {
            rawCords[(i*4)] = new Coordinate(x,y + (width*i),z);
            rawCords[(i*4)+1] = new Coordinate(x + width,y + (width*i),z);
            rawCords[(i*4)+2] = new Coordinate(x + width,y + (width*i),z + width);
            rawCords[(i*4)+3] = new Coordinate(x,y + (width*i),z + width);;
        }
        setUpFaces();
    }

    /**
     * The cube has 8 points -> blf, brf, brba, blba, tlf, trf, trba, tlba
     * So the numbers are    -> [0], [1], [2], [3], [4], [5], [6], [7]
     * b = bottom, t = top
     * l = left, r = right
     * f = front, ba = back
     */
    private void setUpFaces(){
        // bottomFace
        faces[0] = new Face(new int[]{0,1,2,3});
        // topFace
        faces[1] = new Face(new int[]{4,5,6,7});
        // rightFace
        faces[2] = new Face(new int[]{1,2,6,5});
        // leftFace
        faces[3] = new Face(new int[]{0,3,7,4});
        // frontFace
        faces[4] = new Face(new int[]{0,1,5,4});
        // backFace
        faces[5] = new Face(new int[]{2,3,7,6});
    }

    /// ------------------------------ SETTER & GETTERS ----------------------------------

    /**
     * overrides the entire Faces array with a new one
     * @param faces -> the array used for replacement
     */
    private void setFaces(Face[] faces) {
        this.faces = faces;
    }

    /**
     * overrides the face on the given pos with a new one
     * @param pos -> the pos in the array that should be changed
     * @param face -> the face that will replace the old one
     */
    private void setFace(int pos, Face face) {
        faces[pos] = face;
    }

    /**
     * @return the Face array
     */
    public Face[] getFaces(){return faces;}

    /**
     * @param pos -> the position of the Face in the array
     * @return the face on the wished-for pos
     */
    @Override
    public Face getFace(int pos) {
        return faces[pos];
    }

    /** NOT NEEDED AT THE MOMENT
     * overrides the entire rawCords array with a new one
     * @param cords -> the replacement array
     */
    private void setRawCords(Coordinate[] cords) {
        rawCords = cords;
    }

    /**
     * overrides the rawCords at the wanted pos
     * @param pos -> the position of the desired cord that should be replaced
     * @param cord -> the cord to replace the old one
     */
    @Override
    public void setRawCord(int pos, Coordinate cord) {
        rawCords[pos] = cord;
    }

    /**
     * @return the entire Coordinate[] rawCords
     */
    @Override
    public Coordinate[] getRawCords(){
        return rawCords;
    }

    /**
     * @param pos -> the position of the desired rawCord
     * @return the rawCord at the pos
     */
    @Override
    public Coordinate getRawCord(int pos) {
        return rawCords[pos];
    }

    /**
     * sets the projected cords at that given pos
     * @param pos -> the position of the cord you want to change
     * @param x -> the x-value for the cord
     * @param y -> the y-value for the cord
     */
    private void setProjectedCords(int pos, double x, double y){
        projectedCords[pos] = new Coordinate(x,y,0);
    }

    /**
     * @return the projectedCord array
     */
    @Override
    public Coordinate[] getProjectedCords() {
        return projectedCords;
    }

    /**
     * @param pos -> the position of the cord in the array
     * @return the wished-for projectedCord in the array
     */
    @Override
    public Coordinate getProjectedCord(int pos) {
        return projectedCords[pos];
    }


    /// --------------------------------- CALCULATIONS & DRAWING ------------------------------------


    /**
     * projects/draws the cube in the codedraw window  <br>
     * 1.  calls calcProjection to get the projected Cords for the given Codedraw window   <br>
     * 2.  calls connectFaces to go through the Faces and their Points and connect them    <br>
     * -> and with that actually drawing the cube
     * @param cd -> the Codedraw window in which it will be drawn
     */
    @Override
    public void project(CodeDraw cd) {
        calcProjection(cd);
        connectFaces(cd, true);
    }


    /**
     * Calculates the screenCords for the codeDraw                                        <br>
     * saves the double array with the [0]=sX and [1]=sY representing the cords on the screen into the projected array
     * with the steps:                                                                    <br> <br>
     * 1. get them to the right distance                                                  <br>
     * x' = x/z                                                                           <br>
     * y' = y/z                                                                           <br> <br>
     * 2. get them to the right scaling for the screen, x and y go from -1..1 in the fov  <br>
     * -1..1 -> 0..2 -> 0..1 -> minSize..maxSize                                          <br>
     * sX = (x' + widthRatio) / (widthRatio*2)                                            <br>
     * sY = (y' + heightRatio) / (heightRatio*)                                           <br>
     *
     * @param cd -> the Codedraw window where the points will be projected onto
     */
    @Override
    public void calcProjection(CodeDraw cd) {
        double width = cd.getWidth();
        double height = cd.getHeight();

        double widthRatio;
        double heightRatio;
        if(width > height){
            heightRatio = 1;
            widthRatio = width/height;
        } else if (height > width) {
            widthRatio = 1;
            heightRatio = height/width;
        } else {
            widthRatio = heightRatio = 1;
        }

        double xP, yP, sX, sY;
        int i = 0;
        for (Coordinate cord : rawCords) {
            // x/yP -> projected
            xP = cord.getX() / cord.getZ();
            yP = cord.getY() / cord.getZ();

            // -1..1 -> 0..2 -> 0..1
            sX = (xP+widthRatio)/(widthRatio*2);
            sY = (yP+heightRatio)/(heightRatio*2);

            setProjectedCords(i, sX, sY);
            i++;
        }
    }



    /**
     *  I take the face, go through all the cords of it and always connect 2 after-each-other with a line
     *  so I loop through the array and use % to get back to the front
     *  while going through the array i take the cords and get their x,y on the codedraw screen and then connect them
     *
     * @param cd -> the CodeDraw window that the faces should be drawn into
     * @param minimal -> the boolean deciding if the object is drawn with the minimal-amount of lines
     */
    @Override
    public void connectFaces(CodeDraw cd, boolean minimal) {

        if(minimal) { ///  minimal amount of lines
            for (int j = 0; j < 2; j++ ) { // go through all the faces
                for (int i = 0; i < faces[j].getPoints().length; i++) { // for each face go through its points and connect them
                    connectPoints(cd,
                            faces[j].points[i],
                            faces[j].points[(i + 1) % faces[j].getPoints().length]);
                }
            }
            connectPoints(cd, 0,4);
            connectPoints(cd, 1,5);
            connectPoints(cd, 2,6);
            connectPoints(cd, 3,7);

        }else {  /// drawing each face
            for (Face face : faces) { // go through all the faces
                for (int i = 0; i < face.getPoints().length; i++) { // for each face go through its points and connect them
                    connectPoints(cd,
                            face.points[i],
                            face.points[(i + 1) % face.getPoints().length]);
                }
            }
        }
    }




    /**
     * Draws a line on the given CodeDraw between the firstPoint and secondPoint
     *
     * @param cd -> the given CodeDraw where the line will be drawn
     * @param firstPoint -> the first point, type int, value representing the positon in the projectedCords-Array
     * @param secondPoint -> the second point, type int, value representing the positon in the projectedCords-Array
     */
    @Override
    public void connectPoints(CodeDraw cd, int firstPoint, int secondPoint) {
        cd.drawLine(projectedCords[firstPoint].getX()*cd.getWidth(),
                    projectedCords[firstPoint].getY()*cd.getHeight(),
                     projectedCords[secondPoint].getX()*cd.getWidth(),
                     projectedCords[secondPoint].getY()*cd.getHeight());
    }


    /// ----------------------------- Movement -------------------------------


    /**
     * Moves the cube on the X-Axes by x-much
     * @param x -> the value by which the Object should be moved along the x-axes
     */
    @Override
    public void moveX(double x) {
        for(Coordinate cord : rawCords){
            cord.setX(cord.getX()+x);
        }
    }

    /**
     * Moves the cube on the Y-Axes by y-much
     * @param y -> the value by which the Object should be moved along the y-axes
     */
    @Override
    public void moveY(double y) {
        for(Coordinate cord : rawCords){
            cord.setY(cord.getY()+y);
        }
    }

    /**
     * Moves the cube on the Z-Axes by z-much
     * @param z -> the value by which the Object should be moved along the z-axes
     */
    @Override
    public void moveZ(double z) {
        for(Coordinate cord : rawCords){
            cord.setZ(cord.getZ()+z);
        }
    }

    /**
     * moves the entire Cube by a giving vector, by moving each point by the vector value,
     * only considering the directional cords of the vector NOT the start point of the Vector
     * @param v -> the Vector used to move the Object
     */
    @Override
    public void moveVector(Vector v) {
        moveX(v.getxDirection());
        moveY(v.getyDirection());
        moveZ(v.getzDirection());
    }



    ///  ------------------------------------- STATS -----------------------------------------



    /**
     * @return a String containing all the details about that Cube
     */
    @Override
    public String toString(){

        StringBuilder retString = new StringBuilder();
        retString = new StringBuilder("| Cube to-String |\n");

        for (Coordinate rawCord : rawCords) {
            retString.append(rawCord.toString()).append("\n");

        }
        retString.append("\n|----------------|");
        return retString.toString();
    }
}
