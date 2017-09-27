/*
 * To change this license header, choose License Headers 
 * in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcircularlinkedlist;

/**
 *
 * @author tutoring
 */
public class PlayerPotato extends Player {

    private static int playerCount = 0;
    //The Player's count number is their ID
    private int playerID;   //Unique Numeric Player ID
    private boolean fistL, fistR;   //validation of fists

    // DEFAULT Constructor
    public PlayerPotato() {
        super();
        setPlayerID();
        setFists();

    }

    // 1:PARAMETER Constructor
    public PlayerPotato(String n) {
        super(n);
        setPlayerID();
        setFists();
    }

    /*
     * Mutator
     * 
     * @noparam Sets the Potato Player's unique ID based on player count
     */
    private void setPlayerID() {
        playerID = ++playerCount;
    }

    /*
     * ACCESSOR Method
     * 
     * @return Potato Player's Numeric ID
     */
    public String getPlayerID() {
        return "[ID#" + playerID + "]";
    }

    /*
     * MUTATOR Method
     * 
     * @noparam Alters both fists to be achivable for initial gameplay
     */
    private void setFists() {
        fistL = true;
        fistR = true;
    }

    /*
     * ACCESSOR Method
     * 
     * @return Total of achivable fists
     */
    public int getFistCount() {
        int amt = 0;
        if (fistL == true) {
            amt += 1;
        }
        if (fistR == true) {
            amt += 1;
        }
        //System.out.println(getPlayerID() + " - " + amt);
        return amt;
    }

    /*
     * MUTATOR Method
     * 
     * @param x decides which fish becomes unachivable
     */
    public void downFist(Fist x) {
        switch (x) {
            case right:
                fistR = false;

                break;
            case left:
                fistL = false;
                break;
        }
    }

    /*
     * ACCESSOR Method
     * 
     * @return String of requested fist
     */
    public String getFist(Fist f) {
        String out = getPlayerID() + getName();
        switch (f) {
            case right:
                out += " [ Right ] ";
                break;
            case left:
                out += " [ Left ] ";
                break;
        }
        return out;
    }

    /*
     * ACCESSOR Method
     * 
     * @return left fist status
     */
    public boolean getFistL() {
        return fistL;
    }

    /*
     * ACCESSOR Method
     * 
     * @return Right fist status
     */
    public boolean getFistR() {
        return fistR;
    }

    /*
     * ACCESSOR Method
     * 
     * @return String of achivable fists
     */
    public String getFistStatus() {
        String out = " [";
        if (fistL == true) {
            out += " Left ";
        }
        if (fistR == true) {
            out += " Right ";
        }
        return out + "]";
    }

    /*
     * ACCESSOR Method
     *
     * @return Potato Player ID, Name & Status of Fists
     */
    public String toString() {
        return getPlayerID() + getName() + getFistStatus();
    }

}
