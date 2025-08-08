package Tests;

public class Main_Test {

    private String testSequanz;

    public Main_Test(String testSequanz){
        if(testSequanz == null){
            testSequanz = "";
        }

        this.testSequanz = testSequanz.toLowerCase();
        System.out.println("| Main_Test | Constructor | INFO | we got this String/tests: " + testSequanz);
        runTests();
    }


    private void runTests(){

        System.out.println("| Main_Test | runTests | INFO | getting started with testing");

        while(!testSequanz.isEmpty()){
            char next = testSequanz.charAt(0);
            if(testSequanz.length() > 1) {
                testSequanz = testSequanz.substring(1);
            }else{
                testSequanz = "";
            }

            System.out.println("| Main_Test | runTests | INFO | We got " + next);

            /// Vector-tests
            if(next == 'v'){
                System.out.println("| Main_Test | runTests | INFO | Starting Vector-tests ");
                Vector_Tests vTests = new Vector_Tests();
            }else{
                System.out.println("| Main_Test | runTests | VALUE-ERROR | We dont have this value on the list, cant test what we dont know");
            }

            // TODO
            //  possible break point asking "wana continue or not"
        }
    }





}
