Deutsche Version:


Der CUBE
ein Spaß-projekt von mir an welchem ich arbeit um einerseits zu lernen wie man object im 3 Dimensionalen Raum darstellt bewegt skaliert und vieles mehr i guess
Es ist nicht perfekt und hat auch ne gute menge an fehlenden sachen aber die werden mit der zeit anders, also weniger alte probleme und mehr neue
am ende wers cool wenn ich damit animation machen kann und diese dann als png/jpg maybe gif oder irgendein anderes multiframe-format

Klassen:



------|Coordinate|------
Type: Klasse
Beschreibung:
    Kann man sich schon fast denken aber aggiert als eine Koordinate.
    Einer wenn nicht sogar der Grundbaustein für mein Projekt, da jedes Object auf Koordinaten bassiert und Codedraw diese zum zeichnen verwendet.
Attribute:
    double x,y,z -> die x,y,z Position der Koordinate
Methoden:
    Coordinate()
    Coordinate(double x, double y, double z)
    copy() : Coordinate
    getters x,y,z,All() : double, double[]
    setters x,y,z (double x,y,z)
    setAll( x,y,z | double[] cords | Coordinates cords)
    calcAngels(Coordinate cord) -> not yet implemented
    calcVector(Coordinate cord) -> not yet implemented
    equals(Object obj) : boolean
    toString() : String



------|Vector|------  TODO stuff
Type: Klasse
Beschreibung:
    Ein weiterer wichtiger Teil des Base-Programms zur darstellung.
    Aggiert wie ein Vektor, in sofern, es hat nen start, ne richtung welche auch die länge beinhaltet (Maybe i should rework that, yes i should, onto the to-do list)
Attribute:
    Coordinate startPoint,
    double directionX,Y,Z
Methoden:
    Vector()
    Vector(Coordinate cord, double x,y,z)
    Vector(double x,y,zStart , double x,y,zDirection)
    getters x,y,z,All() : double, double[]
    setters x,y,z(double x,y,z)
    CalcAngels() : double[]
    CalcAngel(double x,y) : double
    CalcRateX,Y,Z() : double[]
    equals() : boolean
    hashCode() : int
    toString() : String
    toStringDetailed() : String



------|Face|------   TODO rework/revisit --> seems a bit weird after looking at it again
Type: Klasse
Beschreibung:
    Ein Object besteht aus mehreren Faces/Oberflächen, welche am Ende zusammen das Object bilden.
    Diese Faces/Oberflächen bestehen in sich aus Punkten, Platzhalter, welche die Coordinaten representieren von den einzelnen Objekten
Attribute:
    int[] points
Methoden:
    Face(int size)
    Face(int[] points)
    addPoint(int point) : boolean
    removePoint(int point) : boolean -> not implemented
    replacePoint(int removePoint, int replacePoint) : boolean
    getPoint() : int point



------|Object|------
Type: Interface
Beschreibung:
    The base interface for every type of Object yet to come to the system
    Containing already a solid base for what will be needed of and for easy usability of the objects
Attribute:
     Coordinate[] rawCords
     Coordinate[] projectedCords
     Face[] faces
Methoden:
    setupRawCords()
    setupFaces()
    setRawCords(Coordinates[] cords)
    setRawCord(int pos, Coordinate cord)
    getRawCord(int pos) : Coordinate cord
    setFaces(Face[] faces)
    setFace(int pos, Face face)
    getFaces() : Face[] faces
    getFace(int pos) : Face face
    setProjectedCord(int pos, double x, double y)
    getProjectedCords() : Coordinate[] cords
    getProjectedCord(int pos) : Coordinate cord
    project(CodeDraw cd)
    calcProject(CodeDraw cd)
    connectFaces(CodeDraw cd, boolean minimal) -> TODO perchance rework the idea of "minimal"??
    connectPoints(CodeDraw cd, int first, int second)
    moveX,Y,Z(double x,y,z)
    moveVector(Vector vector)
    toString() : String

------|Cube|------
Type: Klasse
Beschreibung:
    Die erste implementierte Object-Klasse
    Wird für das meiste testen verwendet
Methoden:
    Siehe Object Interface


-----|Fuckaround|------
Typ: Test-Klasse
Beschreibung:
    Fuck around and find out
    Die aktive Testklasse in der ich alles ausprobiere was ich fabriziere
Methoden:
    Fuckaround()
    Fuckaround(int width, int height)
    fuckaround(Cube cube, CodeDraw cd)
    FuckaroundAll(CodeDraw cd)




Englisch Version:


Planned: a program for accurately displaying 3D objects
         aka a 3D renderer









Clean version for personal use only, or whoever finds it useful: