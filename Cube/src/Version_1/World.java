package Version_1;

/**
 *  So first up I will need a world in which i can portrait everything duh
 *  in that world to properly display everything i will need a start-point, a point of origin, a viewpoint, A Camera
 *  so thats the first thing i will have to make -> Kamera
 *  then to test if the camera works i will need something to display, for that i will have the differen typse of Objects -> Koerper
 *  on one hand something simple but works to test most things, a line from one point to another
 *  on the other something more advanced to actually do what i wanted to, a cube with alle 8 corners and 6 sides working on displaying what when
 **/

public class World {


    //Kamera
    private Kamera kamera;

    // Ein Körper
    private Koerper koerper;


    /**
     * The default constructor, if you don't know or want to give a certain kamera and koerper
     * not sure what i should make the default for now
     */
    public World(){
        // TODO use usefull values as a default setting for a world
        // this.kamera =;
        // this.koerper =;
    }

    /**
     * A Constructor using the given value to create a new World using that kamera and that koerper
     *
     * @param kamera, the given kamera with predetermend settings for the world              | must not be null |
     * @param koerper, the given koerper that will be portrait in this world and its details | must not be null |
     */
    public World(Kamera kamera, Koerper koerper) {
        this.kamera = kamera;
        this.koerper = koerper;
    }



    /**
     * the toString methode returns a String containing the most relevant details about this world
     * calls The toString of the Kamera and the Koerper
     * @return a String containing all the details about this World in two lines
     */
    public String toString(){
        return "Kamera: " + kamera.toString() + " \n Koerper: " + koerper.toString();
    }

}
