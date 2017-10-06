import java.io.IOException;

public class MetroApp {

    public static void main(String[] args) {
        MetroMapParser mmp;
        try {
            mmp = new MetroMapParser("Resources/bostonmetro.txt");
            mmp.generateMetroMapFromFile();
        } catch (Exception e) {
            System.out.println("System is down");
        }
    }

}
