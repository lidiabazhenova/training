package com.lidiabazhenova;

import com.sun.media.sound.SoftAudioProcessor;

public class Main {

    public static void main(String[] args) {
        // Create a generic class to implement a league table for a sport.
        // The class should allow teams to be added to the list, and store
        // a list of teams that belong to the league.
        //
        // Your class should have a method to print out the teams in order,
        // with the team at the top of the league printed first.
        //
        // Only teams of the same type should be added to any particular
        // instance of the league class - the program should fail to compile
        // if an attempt is made to add an incompatible team.

        PremierLeague chelsea = new PremierLeague("Chelsea");
        PremierLeague manchesterCity = new PremierLeague("Manchester City");
        PremierLeague manchesterUnited = new PremierLeague("Manchester United");

        Championship wolverhampton = new Championship("Wolverhampton");
        Championship sheffieldUnited = new Championship("Sheffield United");
        Championship cardiff = new Championship("Cardiff");


        LeagueTable<PremierLeague> premierLeagueTable = new LeagueTable<>("Premier League");
        premierLeagueTable.addTeam(chelsea);
        premierLeagueTable.addTeam(manchesterCity);
        premierLeagueTable.addTeam(manchesterUnited);


        LeagueTable<Championship> championshipLeagueTable = new LeagueTable<>("Championship");
        championshipLeagueTable.addTeam(wolverhampton);
        championshipLeagueTable.addTeam(sheffieldUnited);
        championshipLeagueTable.addTeam(cardiff);


        System.out.println(premierLeagueTable.numPlayers());

        //System.out.println(championshipLeagueTable.numPlayers());

        chelsea.setPoints(2);
        manchesterCity.setPoints(20);
        manchesterUnited.setPoints(13);
        cardiff.setPoints(29);

        premierLeagueTable.showLeagueTable();


    }
}
