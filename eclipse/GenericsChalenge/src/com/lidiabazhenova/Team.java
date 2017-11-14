package com.lidiabazhenova;

public class Team<L> implements Comparable<Team<L>> {
    private String name;
    int points;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public String toString() {
        return name + ":" + points;
    }

    @Override

    public int compareTo(Team<L> team) {
        if (this.getPoints() > team.getPoints()) {
            return -1;
        } else if (this.getPoints() < team.getPoints()) {
            return 1;
        } else
            return 0;
    }

}
