public class MetroUserInterface {
    public MetroUserInterface(MetroMap metroMap) {
        runUserInterface(metroMap);
    }

    private void runUserInterface(MetroMap map) {
        map.findBestRoute("119", "112"); //  good
        System.out.println();
        map.findBestRoute("69", "3"); //  good
		System.out.println();
        map.findBestRoute("69", "1"); //   good
		System.out.println();
		map.findBestRoute("8", "3"); //  good
		System.out.println();
//		metroMap.findBestRoute("Riverside", "Bowdoin");
//		System.out.println();
//		metroMap.findBestRoute("Riverside", "BostonCollege");
    }
}
