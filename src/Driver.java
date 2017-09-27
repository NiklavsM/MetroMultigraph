import java.io.IOException;

public class Driver {

	public static void main(String[] args) {		
		MetroMapParser mmp;
		MetroMap metroMap = null;
		try {
			System.out.println("System.getProperty(\"user.dir\");" + System.getProperty("user.dir"));
			mmp = new MetroMapParser("bostonmetro.txt");
		    metroMap = mmp.generateGraphFromFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		metroMap.findBestRoute("Riverside", "Mattapan"); // maybe can store stations immediately good
		System.out.println();
		metroMap.findBestRoute("Riverside", "Wonderland"); // kinda good
		System.out.println();
		metroMap.findBestRoute("Riverside", "Alewife"); //  kinda good
		System.out.println();
		metroMap.findBestRoute("Riverside", "State"); // kinda good
		System.out.println();
		metroMap.findBestRoute("Riverside", "Bowdoin"); // kinda good (colors no good)
		System.out.println();
		metroMap.findBestRoute("Riverside", "BostonCollege"); //  perfect
	}

}
