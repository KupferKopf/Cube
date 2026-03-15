package Version_2;

public class Face {

    //Coordinate[] cords;

    // the points in the cords array of the object, so it doesn't need the exact cords directly
    int[] points;

    public Face(int size){
        points = new int[size];
        for (int i = 0; i < size; i++) {
            points[i] = -1;
        }
        //cords = new Coordinate[size];
    }

    public Face(int[] points){
        this.points = points;
        //this.cords = cords;
    }

    public void addCord(int point){
        if(point == -1){
            System.out.println("| Face | addCord | NULL-ERROR | the given point is -1 -> can't be added to face |");
            return;
        }

        for (int i = 0; i < points.length; i++) {
            if(points[i] == -1){     // -1 used for empty points array
                points[i] = point;
                return;
            }
        }

    }

    // maybe
    public boolean removeCord(int pos){
        return false;
    }


    public boolean replaceCord(int removePoint, int replacePoint){

        for (int i = 0; i < points.length; i++) {
            if(points[i] == removePoint){
                points[i] = replacePoint;
                return true;
            }
        }
        System.out.println("| Face | replaceCord | INFO | FAIL - point couldn't be found, nothing changed |");
        return false;
    }

    public int[] getPoints(){
        return points;
    }

}
