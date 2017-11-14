package com.lidiabazhenova;

import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeagueTable<L extends Team> {

    private String name;
    private ArrayList<L> league = new ArrayList<>();

    public LeagueTable(String name) {
        this.name = name;
    }


    public boolean addTeam(L team) {
        if (league.contains(team)) {
            System.out.println(team.getName() + " is already on the team");
            return false;
        } else {
            league.add(team);
            System.out.println(team.getName() + " picked for " + team.getClass().getSimpleName());
            return true;
        }
    }

    public int numPlayers() {
        return this.league.size();
    }

    public void showLeagueTable() {
        Collections.sort(league);
        for (final L team : league) {
            System.out.println(team);
        }
    }


}

