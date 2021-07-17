package com.pbe.genclasses;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        // Create some teams
        // Passing each team type parameter with an object type, to define it's type
        Team<Cyclist> jumboVisma = new Team<>("Jumbo Visma");
        Team<Basketball> lakers = new Team<>("Lakers");
        Team<Soccer> ajax = new Team<>("Ajax");
        Team<Soccer> vitesse = new Team<>("Vitesse");
    //  Team<Yankees> = new Team<>("Yankees"); // won't be accepted, non existing object type: generics type safety

        // Create some team members
        Cyclist dumoulin = new Cyclist("Dumoulin, Tom");
        Cyclist kruijswijk = new Cyclist("Kruijswijk, Steven");
        Cyclist vanaert = new Cyclist("van Aert, Wout");
        Cyclist kuss = new Cyclist("Kuss, Sep");
        Basketball lebron = new Basketball("LeBron, James");
        Basketball kobe = new Basketball("Kobe, Bryant");
        Basketball oneal = new Basketball("O'neal, Shaquille");
        Soccer stekelenburg = new Soccer("Stekelenburg, Maarten");
        Soccer bos = new Soccer("Bos, Theo");
        Soccer sturing = new Soccer("Sturing, Edward");

        // Add members to teams
        System.out.println("Drafting results:");
        jumboVisma.addPlayer(dumoulin);
        jumboVisma.addPlayer(kruijswijk);
        jumboVisma.addPlayer(vanaert);
        jumboVisma.addPlayer(kuss);
        ajax.addPlayer(stekelenburg);
        vitesse.addPlayer(bos);
        vitesse.addPlayer(sturing);
        lakers.addPlayer(lebron);
        lakers.addPlayer(kobe);
        lakers.addPlayer(oneal);
    //  ajax.addPlayer(oneal); // can't add a player that doesn't exist in a certain team: generics type safety
        System.out.println();

        // Show number of players for each team
        System.out.println("Number of team members:");
        System.out.println("On team" + jumboVisma.getName() + ": " + jumboVisma.numPlayers());
        System.out.println("On team " + lakers.getName() + ": " + lakers.numPlayers());
        System.out.println("On team " + ajax.getName() + ": " + ajax.numPlayers());
        System.out.println("On team " + vitesse.getName() + ": " + vitesse.numPlayers());
        System.out.println();

        // Play a fictive match
        System.out.println("Match results:");
        ajax.matchResult(vitesse, 1, 0);
        ajax.matchResult(vitesse, 2, 2);
        ajax.matchResult(vitesse, 3, 1);
    //  lakers.matchResult(ajax, 1, 0); // can't play a match between different type of teams: generics type safety
        System.out.println();

        // Display rankings
//        System.out.println("Rankings:");
//        System.out.println(ajax.getName() + ": " + ajax.ranking());
//        System.out.println(vitesse.getName() + ": " + vitesse.ranking());
//        System.out.println();

        // Compare rankings (note: compareTo function could be used for sorting when sorting via Collections.sort)
//        System.out.println("Compare rankings:");
//        System.out.println("Ajax vs Vitesse: " + ajax.compareTo(vitesse));
//        System.out.println("Vitesse vs Ajax: " + vitesse.compareTo(ajax));
//        System.out.println();

        // Create league and show league results
        League<Team<Soccer>> soccerLeague = new League<>("Eredivisie");
        soccerLeague.add(ajax);
        soccerLeague.add(vitesse);
        soccerLeague.showLeagueTable();
        System.out.println();

        // Example of unchecked warnings and no warnings
        System.out.println("Example of unchecked warnings and no warnings");
        Team rawTeam = new Team("Raw Team"); // creating a team without specifying a type
        rawTeam.addPlayer(dumoulin); // unchecked warning
        rawTeam.addPlayer(kuss); // unchecked warning

        League<Team> rawLeague = new League<>("Raw league");
        rawLeague.add(ajax); // no warning
        rawLeague.add(vitesse); // no warning

        League reallyrawLeague = new League("Really raw league"); // creating a league without specifying a type
        reallyrawLeague.add(ajax); // not using generics - unchecked warning
        reallyrawLeague.add(vitesse); // not using generics - unchecked warning
    }
}