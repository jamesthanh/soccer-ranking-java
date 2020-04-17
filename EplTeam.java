/*
  RMIT University Vietnam
  Course: INTE2512 Object-Oriented Programming
  Semester: 2017C
  Assignment: 2
  Author: Nguyen Tan Thanh
  ID: s3634815
  Created date: 12/05/2017
*/


// This method has purpose of of create characteristics of a team.

package Assignment2;

import java.io.*;

public class EplTeam {
    // all attributes of a Epl team.
    private String name;
    private int round;
    private int homeWin;
    private int homeAgain;
    private int awayWin;
    private int awayDraw;
    private int awayLoss;
    private int awayFor;
    private int homeDraw;
    private int homeLoss;
    private int homeFor;
    private int awayAgain;
    private int totalScoreDifference;
    private int gainedPoints;
    private int totalWinMatches;
    private int totalDrawMatches;
    private int totalLossMatches;
    private int allFor;
    private int allAgain;

    // constructor with one argument
    public EplTeam(String newName){
        name = newName;
        round = 0;
        allAgain = 0;
        totalScoreDifference = 0;
        gainedPoints = 0;
        homeWin = 0;
        homeAgain = 0;
        awayWin = 0;
        awayDraw = 0;
        awayLoss = 0;
        awayFor = 0;
        awayAgain = 0;
        totalWinMatches = 0;
        totalDrawMatches = 0;
        totalLossMatches = 0;
        allFor = 0;
        homeDraw = 0;
        homeLoss = 0;
        homeFor = 0;


    }
    // Accessor methods or getter methods to access the attributes if needed since they are private.
    public String getName(){
        return this.name;
    }
    public int getAllFor(){
        return allFor;
    }
    public int getAllAgain(){
        return allAgain;
    }

    public int getPld(){
        return round;
    }
    public int getTotalScoreDifference(){
        return totalScoreDifference;
    }
    public int getTotalWinMatches(){
        return totalWinMatches;
    }
    public int getTotalDrawMatches(){
        return totalDrawMatches;
    }
    public int getTotalLossMatches(){
        return totalLossMatches;
    }
    public int getPoint(){
        return gainedPoints;
    }
    public int getHomeWin(){
        return homeWin;
    }
    public int getHomeDraw (){
        return homeDraw;
    }
    public int getHomeLoss(){
        return homeLoss;
    }
    public int getHomeFor(){
        return homeFor;
    }
    public int getHomeAgain(){
        return homeAgain;
    }
    public int getAwayWin(){
        return awayWin;
    }
    public int getAwayDraw(){
        return awayDraw;
    }
    public int getAwayLoss(){
        return awayLoss;
    }
    public int getAwayFor(){
        return awayFor;
    }
    public int getAwayAgain(){
        return awayAgain;
    }


    // calculating all of the figures of a team if it won or lost using two other input arguments.
    public void processWinningMatches(boolean isHomeTeam, int homeScores, int awayScores ){
        // if it is the home team.
        if(isHomeTeam == true){
            // if it won, FA, scores, goalsm and points increases.
            allFor = allFor + homeScores;
            allAgain = allAgain + awayScores;
            homeFor = homeFor + homeScores;
            homeAgain = homeAgain + awayScores;
            homeWin++;
        }
        else{
            // else the point is given to the enemy team.
            allFor = allFor + awayScores;
            allAgain = allAgain + homeScores;
            awayWin++;
            awayFor = awayFor + awayScores;
            awayAgain = awayAgain + homeScores;

        }
        // winning team will takes 3 points.
        gainedPoints = gainedPoints +  3;
        totalWinMatches++;
        round++; //  number of played round increases
        // score different = goal that the team has earned - the goals that being earned by the enemy team.
        totalScoreDifference = allFor - allAgain;

    }


    // same logic applied for the drawing match.
    public void processDrawingMatches(boolean isHomeTeam, int homeGoals, int awayGoals){
        if(isHomeTeam == true){
            // numbers will add up to the home team.
            allFor = allFor + homeGoals;
            allAgain = allAgain + awayGoals;
            homeFor = homeFor + homeGoals;
            homeDraw ++;
            homeAgain = homeAgain +  awayGoals;

        }
        // for the enemy team.
        else{
            allFor = allFor + awayGoals;
            awayDraw++;
            allAgain = allAgain + homeGoals;
            awayFor = awayFor + awayGoals;
            awayAgain = awayAgain + homeGoals;
        }
        // in a drawing match, both team can only earth 1 points.
        round++;
        totalDrawMatches++;
        gainedPoints++;
    }
    // lost match has the same logic as winning match but only reverse.
    public void processLostMatches(boolean isHomeTeam, int homeGoals, int awayGoals){
        if(isHomeTeam == true){
            allFor = allFor + homeGoals;
            allAgain += awayGoals;
            homeLoss++;
            homeFor = homeFor + homeGoals;
            homeAgain += awayGoals;
        }
        else{
            awayLoss++;
            allFor = allFor + awayGoals;
            allAgain = allAgain + homeGoals;
            awayFor = awayFor + awayGoals;
            awayAgain = awayAgain + homeGoals;
        }
        // the lost team doesn't have any points, and number of lost matches and round count up.
        totalLossMatches++;
        round++;
        totalScoreDifference = allFor - allAgain;
    }

    // using 2D bubble sort to sort the order of the teams after each round.
    // it takes the array of teams as input argument.
    public static void processStandings(EplTeam[] inputArray){
        EplTeam eplTeamPlaceHolder;
        for(int i = 0; i < inputArray.length; i++){
            for(int j = 1; j < (inputArray.length - i); j++){
                // using the total earned points of the team to determine its rank.
                if(inputArray[j - 1].gainedPoints < inputArray[j].gainedPoints){
                    //switch places if the team score is greater than others.
                    // Also using a temporary holder to store data.
                    eplTeamPlaceHolder = inputArray[j - 1];
                    inputArray[j - 1] = inputArray[j];
                    inputArray[j] = eplTeamPlaceHolder;
                }
                else if(inputArray[j - 1].gainedPoints == inputArray[j].gainedPoints){
                    if(inputArray[j - 1].totalScoreDifference < inputArray[j].totalScoreDifference){
                        //swap elements
                        eplTeamPlaceHolder = inputArray[j - 1];
                        inputArray[j - 1] = inputArray[j];
                        inputArray[j] = eplTeamPlaceHolder;
                    } // end if
                }
            } // end small for
        } // end for big for
    } // end processStandings

    // This method helps to display the team's ranking and data nicely.
    public void formatFilePrinting(int standings, PrintWriter printFile){
        printFile.printf("%3d.%-30s%2d %3d %3d %3d%4d:%-3d  %3d  %3d   %2d %2d %4d  %6d:%-6d   %4d %4d %4d  %6d:%-6d", standings,
                name, round, totalWinMatches, totalDrawMatches, totalLossMatches, allFor, allAgain, totalScoreDifference, gainedPoints, homeWin, homeDraw,
                homeLoss, homeFor, homeAgain, awayWin, awayDraw, awayLoss, awayFor, awayAgain);
        printFile.println();
    } // end formatFilePrinting

    // this method allows to look up the name of the team from the array of Team by comparing the names of it with an input string.
    public static int findTeamPlace(EplTeam[] inputArray, String inputString){
        int teamPlace = -1;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].name.equals(inputString)) {
                teamPlace = i;
                break;
                // if found a matches, break out from the loop/
            }
        }
        return teamPlace;
    }
} // findTeamPlace
