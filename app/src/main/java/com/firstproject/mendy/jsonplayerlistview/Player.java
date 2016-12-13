package com.firstproject.mendy.jsonplayerlistview;

import java.io.Serializable;

/**
 * Created by Mendy on 12/12/2016.
 */

public class Player implements Serializable {
    private String team;
    private int number;
    private String position;
    private String fullName;
    private String club;
    private String clubContry;
    private String dateOfBirth;
    private boolean captain;

    public Player(String team, int number, String position, String fullName, String club, String clubContry, String dateOfBirth, boolean captain) {
        this.team = team;
        this.number = number;
        this.position = position;
        this.fullName = fullName;
        this.club = club;
        this.clubContry = clubContry;
        this.dateOfBirth = dateOfBirth;
        this.captain = captain;
    }

    public String getTeam() {
        return team;
    }

    public int getNumber() {
        return number;
    }

    public String getPosition() {
        return position;
    }

    public String getFullName() {
        return fullName;
    }

    public String getClub() {
        return club;
    }

    public String getClubContry() {
        return clubContry;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean isCaptain() {
        return captain;
    }

    public String getElementByI(int i){
        switch (i){
            case 0:
                return getTeam();
            case 1:
                return String.valueOf(getNumber());
            case 2:
                return getPosition();
            case 3:
                return getFullName();
            case 4:
                return getClub();
            case 5:
                return getClubContry();
            case 6:
                return getDateOfBirth();
            case 7:
                return String.valueOf(isCaptain());
        }
        return null;
    }
}