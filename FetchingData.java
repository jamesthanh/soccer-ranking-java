/*
  RMIT University Vietnam
  Course: INTE2512 Object-Oriented Programming
  Semester: 2017C
  Assignment: 2
  Author: Nguyen Tan Thanh
  ID: s3634815
  Created date: 12/05/2017
*/

package Assignment2;

import java.io.*;
import java.util.Scanner;

// the purpose of this method is to get necessary data from the txt to get information such team name, scores, home or away
// so that the program can perform sorting action.

public class FetchingData {
    public static void getData(EplTeam[] arrayOfEplTeam) throws Exception {

        // create an inputFile to get data from the txt file with the name below.
        File inputFile = new File("EPL-scores.txt");

        // create scanner to do specific tasks such as scan a whole line or just scan  a specific area like score.
        Scanner scanLine = new Scanner(inputFile);
        Scanner scanScore = new Scanner(inputFile);

        // continue if it doesn't read to the end of the file.
        while (scanLine.hasNextLine()) {

            String line = scanLine.nextLine();
            // using regex and theh methid findInLine to scan for a match's score which has the form of a-b.
            String score = scanScore.findInLine("[\\d]+-[\\d]+");
            Scanner characterScanner = new Scanner(line);
            // if the score is not empty
            if (score != null) {
                // search for the middle "character" '-' that divide the two scores.
                int middleScoreSep = score.indexOf("-");
                // the home scores will be on the left hand side and the away team's score will be on the right hand side.
                // by converting from String to int using parse we can get the first part of the home team and the second part of the
                // guess team after the index of the middle '-'
                int homeScores = Integer.parseInt(score.substring(0, middleScoreSep));
                int guessScores = Integer.parseInt(score.substring(middleScoreSep + 1));
                // create varibles to store the team names
                String homeTeamName = "";
                String awayTeamName = "";

                // we use another scanner that is only to catch the team name
                String holderString = characterScanner.next();
                // by comparing different strings until found a match of the hometeam.
                while (!holderString.equals(score)) {
                    homeTeamName = homeTeamName + holderString + " ";
                    holderString = characterScanner.next();
                }
                // extract all of the home team name using the index of beginning and ending.
                homeTeamName = homeTeamName.substring(0, homeTeamName.length() - 1);

                // do the same for the away team to get the name of it
                do {
                    holderString = characterScanner.next();
                    awayTeamName = awayTeamName + holderString + " ";
                } while (characterScanner.hasNext());

                awayTeamName = awayTeamName.substring(0, awayTeamName.length() - 1);
                // using the findTeamPlace to find the team's position in the arrayOfTeam
                int homeTeamID = EplTeam.findTeamPlace(arrayOfEplTeam, homeTeamName);
                int awayTeamID = EplTeam.findTeamPlace(arrayOfEplTeam, awayTeamName);
                // Use the left hand score as the homeTeam's comparator.
                // if the home goals is greater than the away's score, then check if it is truly a a homeTeam which often sit on the
                // left and two other parameters which are homeScores and guessScores to add up in the standing table later.
                if (homeScores > guessScores) {
                    arrayOfEplTeam[homeTeamID].processWinningMatches(true, homeScores, guessScores);
                    arrayOfEplTeam[awayTeamID].processLostMatches(false, homeScores, guessScores);
                }
                // process is the same if the away team is winning.
                else if (homeScores < guessScores) {
                    arrayOfEplTeam[homeTeamID].processLostMatches(true, homeScores, guessScores);
                    arrayOfEplTeam[awayTeamID].processWinningMatches(false, homeScores, guessScores);
                }
                // or else if they have a draw match, we wil use the drawing match method to check their rankings.
                else {
                    arrayOfEplTeam[homeTeamID].processDrawingMatches(true, homeScores, guessScores);
                    arrayOfEplTeam[awayTeamID].processDrawingMatches(false, homeScores, guessScores);
                }
            }
            // countinue to read next core
            scanScore.nextLine();
            characterScanner.close();
            // close the character's scanner because we have enough info.
        }
        // close all scanner.
        scanLine.close();
        scanScore.close();
    } // end getData
} // end FetchingData
