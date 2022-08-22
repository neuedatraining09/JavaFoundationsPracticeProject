import Utilities.ConsoleScreens;
import Utilities.FileUtilities;
import java.io.IOException;
//import domain.AccessRecords;
//import java.io.File;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.Collections;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName= "data\\access.csv";//Set the file name, can rewrite to get filename from user if time permits;
        ConsoleScreens buildIntroScreen = new ConsoleScreens();
        buildIntroScreen.buildIntroScreen();
        buildIntroScreen.buildMenu();
        FileUtilities.readAccessCSVFile(fileName);              //Simple method to get List from SCV
        // write report as class
        // write db records


        //  Trying other ways to produce results as experiment
//        List<List<String>> myList = new ArrayList<>();
//        myList = FileUtilities.readData(fileName);
//        FileUtilities.printCSVList(myList);


        //Test Contents of myList
//        System.out.println(myList.get(23));     //Test get the 23 item in myList
//        System.out.println(myList.size());      //list number of rows in myList
//        FileUtilities.testCSVList(myList);
//        FileUtilities.printList(myList);


        // FileUtilities.loadFile(fileName);    //Nope

        //READ A CSV FILE into a standard list


       // AccessRecords myList = new AccessRecords();
       // myList = FileUtilities.readAccessCSVFile(fileName);





        // System.out.println(AccessRecords);
    }
}

