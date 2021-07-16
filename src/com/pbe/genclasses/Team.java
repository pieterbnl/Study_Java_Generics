package com.pbe.genclasses;

import java.util.ArrayList;

// Allows the creation of various types of teams
// Using T to accept type arguments, extends to Member ("bounded type parameter") which sets Member as 'upper bound',
// as such restricting this class to accept only objects of type Member
// Implementing Comparable to be able to compare Teams
public class Team<T extends Member> implements Comparable<Team<T>> {

    // Team specifics
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    // Array hold the members of a team
    // using parameterized type T
    private ArrayList<T> members = new ArrayList<>();

    // Set the name of a team
    public Team(String name) {
        this.name = name;
    }

    // Get the name of a team
    public String getName() {
        return name;
    }

    // Add a player to a team
    // using parameterized type T
    public boolean addPlayer(T player) {

        // Check if a player is already on the team
        if (members.contains(player)) {
            System.out.println(player.getName() + " is already on this team");
            return false;
        } else { // player is not yet on team, add as member
            members.add(player);
            System.out.println(player.getName() + " drafted for team " + this.name);
            return true;
        }
    }

    // Returns size of array
    public int numPlayers() {
        return this.members.size();
    }

    // Determine the result between two teams
    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {

        // progress match results
        String message;
        if(ourScore > theirScore) {
            won++; // adding a win to the team's # of wins
            message = " beat ";
        } else if(ourScore == theirScore) {
            tied++; // adding a win to the team's # of ties
            message = " drew with ";
        } else {
            lost++; // adding a win to the team's # of losses
            message = " lost to ";
        }
        played++; // add a played match to the team's # of played matches

        if(opponent != null) {
            // display match results
            System.out.println(this.getName() + message + opponent.getName());

            // invoke opponent matchResults, to progress their score as well
            // passing null, so that no message will be displayed
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    // Calculate ranking of team
    public int ranking() {
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team<T> team) {

        // alternatively, single line: return Integer.compare(team.ranking(), this.ranking());

        if (this.ranking() > team.ranking()) {
            return -1;
        } else if(this.ranking() < team.ranking()) {
            return 1;
        } else {
            return 0;
        }
    }
}