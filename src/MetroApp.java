import java.io.IOException;

public class MetroApp {

	public static void main(String[] args) {
		MetroMapParser mmp;
		try {
			mmp = new MetroMapParser("bostonmetro.txt");
            mmp.generateMetroMapFromFile();
		} catch (Exception e) {
			e.printStackTrace();}
	}

}
