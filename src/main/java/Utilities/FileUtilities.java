package Utilities;
import domain.AccessRecords;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtilities {


    public static void loadFile(String fileName){
         File accessRecords = new File("data\\" + fileName);

        try (FileInputStream fStream = new FileInputStream(accessRecords)){
            System.out.println("Opening file: " + fileName);
            //Future enhancement, check file size <= 0 then don't open
            System.out.println("The size of the file is: " + accessRecords.length() + " bytes");
            BufferedReader br = new BufferedReader(new InputStreamReader(fStream));

            List<String> myLine = br.lines().collect(Collectors.toList());
                //for(String s : myLine){                     // For each line in the list
                //    System.out.println(s);                  // Printout each line of file read
                //}                                           //
            //Need to skip the file header information of the CSV file
            //System.out.println(br);
            br.close();                                         //close the buffered reader
            //System.out.println(myLine);                         //print list test
            System.out.println("Number of rows in file with header: " + myLine.size());
            //Future enhancement, only process if number of items > 0
            //System.out.println(myLine.get(0));                  //test output of header line
            //System.out.println(myLine.get(myLine.size()-1));      //test output of last line

            String[] accessArray = myLine.toArray(new String[0]);
            int numberLines = accessArray.length;
            System.out.println("Number of items in accessArray: " + numberLines);

            AccessRecords[] accessRecords1 = new AccessRecords[numberLines];  //Create AccessRecords from number lines lists


           for(int x=1; x < numberLines; x++){ //loop through list splitting into sub lists
                System.out.println("Line " + x + ": " + Arrays.asList(myLine.get(x).split(",")));

                List<String> fileItems = Arrays.asList(myLine.get(x).split(","));
                //System.out.println("Item 2: " + fileItems.get(3));
                for(int i = 1; i < 6; i++) {
                    System.out.print(fileItems.get(i));
                }
               System.out.print("\n");
            }
        } catch (IOException ioe) {
            System.out.println("Could not find the file " + fileName);
        }

    }

}
