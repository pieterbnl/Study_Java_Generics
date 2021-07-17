package com.pbe.genclasses;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    public String name;

    // ArrayList to hold the leagues' teams
    private ArrayList<T> league = new ArrayList<>();

    // Constructor
    public League(String name) {
        this.name = name;
    }

    // To add
    public boolean add(T team) {
        if(league.contains(team)) {
            return false;
        }
        league.add(team);
        return true;
   }

   // Display league table
   public void showLeagueTable() {
       System.out.println("Current standings: ");
        Collections.sort(league); // Will automatically use the (own) compareTo method from Team
        for(T t : league) { // Sort the table
            System.out.println(t.getName() + ": " + t.ranking());
        }
    }
}
