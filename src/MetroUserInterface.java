public class MetroUserInterface {
    public MetroUserInterface(MetroMap metroMap) {
        runUserInterface(metroMap);
    }

    private void runUserInterface(MetroMap map) {
        map.findBestRoute("119", "112"); // maybe can store stations immediately good
        System.out.println("gg who needs path.. that part is uncommented for now");
//		metroMap.findBestRoute("Riverside", "Wonderland"); // kinda good
//		System.out.println();
//		metroMap.findBestRoute("Riverside", "Alewife"); //  kinda good
//		System.out.println();
//		metroMap.findBestRoute("Riverside", "State"); // kinda good
//		System.out.println();
//		metroMap.findBestRoute("Riverside", "Bowdoin"); // kinda good (colors no good)
//		System.out.println();
//		metroMap.findBestRoute("Riverside", "BostonCollege"); //  perfect
    }
}
