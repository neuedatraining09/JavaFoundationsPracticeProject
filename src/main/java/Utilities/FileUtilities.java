package Utilities;
import domain.AccessRecords;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.*; //LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class FileUtilities {

//    public static List<List<String>> readData(String file) throws IOException {
//        //    int count = 0;
//        System.out.println("reading data from: " + file + " ...");
//
//        List<List<String>> csvFile = new ArrayList<>();                     //Create a List Array csvFile
//        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//            String line = "";                                                           //initialize string line for reading file
//            while ((line = br.readLine()) != null) {                                   //read each line from CSV File into line
//                //System.out.println(line);                                               //Test print line out as read
//                String[] fileLine = line.split(",");                                //Split the fileLine by commas
//                List<String> fileField = new ArrayList<>(fileLine.length);          //Create a List Array fileField
//                for (String piece : fileLine) {                                             //loop through fileLine for each field
//                    fileField.add(piece);                                                   //add field to fileField Array
//                }
//                csvFile.add(fileField);                                                     // list of fields (records) to csvFile array
//            }
//
//
//        } catch (FileNotFoundException e) {
//            //Some error logging
//            System.out.println("Could not find the data file: " + file + ".");
//        }
//        return csvFile;
//    }
//
//    public static void printCSVList(List<List<String>> csvFile) {
//        //write the CSV back out to the screen
//        for (List<String> fieldItem : csvFile)                           //loop through all records
//        {
//            if (!fieldItem.isEmpty())                                    //place the commas correctly
//            {
//                System.out.print(fieldItem.get(0));
//                for (int i = 1; i < fieldItem.size(); i++)                 //Loop through all fields items
//                {
//                    System.out.print("\t\t" + fieldItem.get(i));       //print out field
//                }
//            }
//            System.out.print("\n");                                    //next record
//        }
//    }
//
//    public static void testCSVList(List<List<String>> csvFile) {
//        csvFile.forEach(System.out::println);
//    }
//
//    public static void printList(List<List<String>> csvFile) {
//        //Printing the list the short way (Java 8)
//        // print out each item in list of list as a new line
//        csvFile.forEach((list) -> {
//            list.forEach((num) -> System.out.println(num));
//        });
//
//    }
//
//
//    public class ListComparator<T extends Comparable<T>> implements Comparator<List<T>> {    //use Comparator to sort list
//        @Override
//        public int compare(List<T> o1, List<T> o2) {
//            for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {                  //loop through list of list finding minimum
//                int c = o1.get(i).compareTo(o2.get(i));
//                if (c != 0) {
//                    return c;
//                }
//            }
//            return Integer.compare(o1.size(), o2.size());
//        }
//    }
//
//
//    public static void loadFile(String fileName) {         //Another method to load CSV file with List and Array
//        File accessRecords = new File(fileName);
//        //File is in assessRecords object.  Need to read in the contents
//        try (FileInputStream fStream = new FileInputStream(accessRecords)) {
//            System.out.println("Opening file: " + fileName);
//            //Future enhancement, check file size <= 0 then don't open
//            System.out.println("The size of the file is: " + accessRecords.length() + " bytes");
//            BufferedReader br = new BufferedReader(new InputStreamReader(fStream));     //Read Line to Buffered Reader
//
//            List<String> myLine = br.lines().collect(Collectors.toList());
//            //    for(String s : myLine){                     // For each line in the list
//            //        System.out.println(s);                  // Printout each line of file read
//            //    }                                           //
//            //Need to skip the file header information of the CSV file
//            //System.out.println(br);
//            br.close();                                         //close the buffered reader
//            //System.out.println(myLine);                         //print list test
//            System.out.println("Number of rows in file with header: " + myLine.size());
//            //Future enhancement, only process if number of items > 0
//            //System.out.println(myLine.get(0));                  //test output of header line
//            //System.out.println(myLine.get(myLine.size()-1));      //test output of last line
//
//            String[] accessArray = myLine.toArray(new String[0]);
//            int numberLines = accessArray.length;
//            System.out.println("Number of items in accessArray: " + numberLines);
//            AccessRecords[] accessRecords1 = new AccessRecords[numberLines];  //Create AccessRecords from number lines lists
//            for (int x = 1; x < numberLines; x++) { //loop through list splitting into sub lists
//                System.out.println("Line " + x + ": " + Arrays.asList(myLine.get(x).split(",")));   //use Array as List method to populate list of list
//                List<String> fileItems = Arrays.asList(myLine.get(x).split(","));
//                //System.out.println("Item 2: " + fileItems.get(3));
//                for (int i = 1; i < 6; i++) {
//                    System.out.print(fileItems.get(i));
//                }
//                System.out.print("\n");
//            }
//        } catch (IOException ioe) {
//            System.out.println("Could not find the file " + fileName);
//        }
//    }
//
    public static void readAccessCSVFile(String fileName) throws IOException {          //Reading CSV into a List from Class example
        Path accessRecords = Paths.get(fileName);
        List<AccessRecords> loadedRecord = new ArrayList<>();
        Scanner scanner = new Scanner(accessRecords);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
//            System.out.println(line);
            if (!line.startsWith("TurnstileID")) {   //Do Not import the header record
                String[] fields = line.split(",");
                fields[0] = fields[0].trim().replaceAll("\"", ""); //TurnstileID
                fields[1] = fields[1].trim().replaceAll("\"", ""); //Building
                fields[2] = fields[2].trim().replaceAll("\"", ""); //Floor
                fields[3] = fields[3].trim().replaceAll("\"", ""); //DateOfEntry
                fields[4] = fields[4].trim().replaceAll("\"", ""); //TimeOfEntry
                fields[5] = fields[5].trim().replaceAll("\"", ""); //StaffID
                AccessRecords accessRecord = new AccessRecords(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]), LocalDate.parse(fields[3]), LocalTime.parse(fields[4]), Integer.parseInt(fields[5]));
                loadedRecord.add(accessRecord);
            }
        }
        System.out.println("Total number of records: " + loadedRecord.size());          //Print out the number of record rows read

        //  Build the report of access
        loadedRecord.sort(Comparator.comparing(AccessRecords::getBuilding).thenComparing(AccessRecords::getFloor));   // Sort collection based on Building then Floor
        LocalTime startHourTime =LocalTime.parse("00:00:00").minusNanos(1);
        LocalTime endHourTime = LocalTime.parse("01:00:00");//.plusNanos(1); //startHourTime.plusHours(1).minusNanos(1);
        for(int i = 0; i <24; i++){
              LocalTime finalStartHourTime = startHourTime;
              LocalTime finalEndHourTime = endHourTime;
              List<AccessRecords> buildingAccess = loadedRecord.stream()
                      .distinct()     //Need to fix to override dup records by filtering without turnstile and floor
                      .filter((b) -> {
                          return b.getTimeOfEntry().isAfter(finalStartHourTime) && b.getTimeOfEntry().isBefore(finalEndHourTime);
                      })
                      .collect(Collectors.toList());
              int floorCount=0;                                             //initialize floor counter
              int currentFloor=0;                                           //initialize current floor number
              String currentBuilding = "";
              if(buildingAccess.size()>0 ) {                                //if there are any records in filtered report for hour
                      System.out.print("Number of records accessed after " + finalStartHourTime.plusNanos(1) + " and before " + finalEndHourTime + " are: ");
                      System.out.print(buildingAccess.size() + "\n");
                      for(AccessRecords floor: buildingAccess){             //for each floor in the filtered building hour
                          if(floor.getFloor()==currentFloor){               //if the floor is the same as the current floor (List was pre-sorted by Building/Floor so no need to loop buildings
                              floorCount=++floorCount;                      //add one to the floor counter of people
                           }
                          else{                                             //otherwise print the current total (below)
                              if(floorCount>0){                             //
                                  System.out.println("During the " + finalStartHourTime.plusNanos(1) + " hour "+ currentBuilding + " floor " + currentFloor + " had a count of: " + floorCount );
                              }
                              floorCount=1;                                 //counter is set to 1 to account for this person on a new floor
                              currentFloor=floor.getFloor();                //the current floor number is recorded
                          }
                          currentBuilding=floor.getBuilding();              //Seed current building
                      }                                                     //finished with last floor for the hour so print the final tally for the floor (below)
                      System.out.println("During the " + finalStartHourTime.plusNanos(1) + " hour "+ currentBuilding + " floor "  + currentFloor + " had a count of: " + floorCount );
                      System.out.print("\n");                               //write a blank line
              }
              startHourTime = startHourTime.plusHours(1);           //Increment the start time for the next hour
              endHourTime = endHourTime.plusHours(1);               //Increment the end time for the next hour
        }
        //output the report back to a csv file
        //record the building, the floor number, the hour of the day, and the number of *unique* staff users (can fix unique with SQL)
    }
 }
