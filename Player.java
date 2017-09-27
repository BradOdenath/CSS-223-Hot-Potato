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
public class Player {

    private final String DEFAULT_NAME = "Computer"; //Default Name
    private String name;    //Player Name

    // DEFAULT Constructor
    public Player() {
        setName(DEFAULT_NAME);
    }

    // PARAMETER:1 Constructor
    public Player(String n) {
        setName(n);
    }

    /*
     * MUTATOR Method
     *
     * @param n
     */
    private void setName(String n) {
        name = n;
    }

    /*
     * ACCESSOR Method
     *
     * @return Player Name name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }

}
