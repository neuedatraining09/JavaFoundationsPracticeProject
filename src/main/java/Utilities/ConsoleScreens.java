package Utilities;

import java.util.Scanner;

public class ConsoleScreens implements UserResponse {
    @Override
    public void buildIntroScreen() {
        System.out.println("*************************************************");
        System.out.println("*\t\tAllstate Java Foundations Course\t\t*");
        System.out.println("*\t\t\tPractice Project Group 4\t\t\t*");
        System.out.println("*\t\t\t\t\tDesk Usage\t\t\t\t\t*");
        System.out.println("*\t\t\t\tAuthor: Michael Kelly\t\t\t*");
        System.out.println("*************************************************");
        System.out.println("This application reads employees from an employee.csv file, \nthen validates and displays those employees by hour accessed.");

    }

    @Override
    public void buildMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean runReport = false;
        while (!runReport){
            System.out.println("Are you ready to continue? (Y/N)");
            String input = scanner.nextLine();
            switch(input.toUpperCase().charAt(0)){
                case 'Y':{
                    System.out.println("OK, lets get started!");
                    runReport=true;
                    break;
                } //Run Report
                case 'N':{
                    //Don't run report
                    System .out.println("OK, come back when you are ready.");
                    runReport = false;
                    System.exit(0);
                    break;
                }
                default: {
                    //User hit an improper key
                    System.out.println("Please enter 'Y' or 'N'");
                    break;
                }
            }//end switch
        }  //end while
    }
}
