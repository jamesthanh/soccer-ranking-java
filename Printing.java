/*
  RMIT University Vietnam
  Course: INTE2512 Object-Oriented Programming
  Semester: 2017C
  Assignment: 2
  Author: Nguyen Tan Thanh
  ID: s3634815
  Created date: 12/05/2017
*/


// purpose of this methid is to create a formatted table for better looking, more detailed rankings of the teams.
package Assignment2;

import java.io.File;
import java.io.PrintWriter;

public class Printing {
    public static void printToFile(EplTeam[] arrayOfEplTeam) throws Exception{
        // create an txt format output and name it standings
        File outputFile = new File("standings.txt");
        outputFile.createNewFile(); // using built in methods.

        // create a new object of type PrintWriter.
        PrintWriter output = new PrintWriter(outputFile);
        // with the help if Prinf, formating is at easy.
        output.printf("\t\t\t\t\t - Total -  \t\t       - Home -\t\t\t   - Away -");
        output.println();
        output.printf("\t\t\t\t  Pld   W  D  L    F:A    + -  Pts    W   D   L      F:A            W    D    L     F:A");
        output.println();
        // print out the tables for all 20 teams
        for(int i = 0; i < 20; i++){
            arrayOfEplTeam[i].formatFilePrinting(i + 1, output);
        }
        // close the file after finish.
        output.close();
        System.out.println("Save to standings.txt Please check the scr default directory of InteliJ for the output file");

    } // end printToFile
} // end Printing
