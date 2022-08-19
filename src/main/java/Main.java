import Utilities.ConsoleScreens;
import Utilities.FileUtilities;

public class Main {
    public static void main(String[] args) {
        String fileName;
        ConsoleScreens buildIntroScreen = new ConsoleScreens();
        buildIntroScreen.buildIntroScreen();
        buildIntroScreen.buildMenu();

        //Set the file name, can rewrite to get filename from user if time permits
        fileName = "access.csv";
        FileUtilities.loadFile(fileName);

    }
}
