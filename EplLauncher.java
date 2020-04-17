/*
  RMIT University Vietnam
  Course: INTE2512 Object-Oriented Programming
  Semester: 2017C
  Assignment: 2
  Author: Nguyen Tan Thanh
  ID: s3634815
  Created date: 12/05/2017
*/

// in this method, it will create an array of objects that filled with 20 given teams from Epl 2017 -2018

package Assignment2;

public class EplLauncher {
    public static void Launch() throws Exception{
        // creating an array of 20 elements
        EplTeam[] arrayOfEplTeam = new EplTeam[20];
        arrayOfEplTeam[0] = new EplTeam("Chelsea FC");
        arrayOfEplTeam[1] = new EplTeam("Arsenal FC");
        arrayOfEplTeam[2] = new EplTeam("Tottenham Hotspur");
        arrayOfEplTeam[3] = new EplTeam("West Ham United");
        arrayOfEplTeam[4] = new EplTeam("Crystal Palace");
        arrayOfEplTeam[5] = new EplTeam("Manchester United");
        arrayOfEplTeam[6] = new EplTeam("Manchester City");
        arrayOfEplTeam[7] = new EplTeam("Everton FC");
        arrayOfEplTeam[8] = new EplTeam("Liverpool FC");
        arrayOfEplTeam[9] = new EplTeam("West Bromwich Albion");
        arrayOfEplTeam[10] = new EplTeam("Newcastle United");
        arrayOfEplTeam[11] = new EplTeam("Stoke City");
        arrayOfEplTeam[12] = new EplTeam("Southampton FC");
        arrayOfEplTeam[13] = new EplTeam("Leicester City");
        arrayOfEplTeam[14] = new EplTeam("AFC Bournemouth");
        arrayOfEplTeam[15] = new EplTeam("Watford FC");
        arrayOfEplTeam[16] = new EplTeam("Brighton & Hove Albion");
        arrayOfEplTeam[17] = new EplTeam("Burnley FC");
        arrayOfEplTeam[18] = new EplTeam("Huddersfield Town");
        arrayOfEplTeam[19] = new EplTeam("Swansea City");

        // caling methods from other files to performe a specific tasks
        FetchingData.getData(arrayOfEplTeam); // get data from the txt file
        EplTeam.processStandings(arrayOfEplTeam); // put the teams into to standing order based on the their performance.
        Printing.printToFile(arrayOfEplTeam); // format the output and print.
        
    } // end Launch
} // EplLauncher
