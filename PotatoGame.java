/*
 * To change this license header, choose License Headers in 
 Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcircularlinkedlist;

/**
 *
 * @author tutoring
 */
public class PotatoGame {

    private int MAX_MOVES = 8;  //Max amount of potato knocks (potato = fist)

    private int movesP; //Amount of potatoes knocked.  
    //Increments after every knock

    private boolean winner = false; //Is there a winner

    private DLLCircularQueue<PlayerPotato> plrList;     // List of Players
    private DLLNode<PlayerPotato> plr;  // Bookmark

    //  DEFAULT Constructor
    public PotatoGame() {
        winner = false;
    }

    // 1:PARAMETER Constructer
    public PotatoGame(DLLCircularQueue<PlayerPotato> pL) {
        winner = false;
        setPlayerList(pL);
    }

    /*
     * MUTATOR method
     * 
     * @noparam Runs the game until a winner is chosen
     */
    public void playGame() {
        if (plrList != null) {
            System.out.println("Players: \n" + plrList);
            while (!winner && plrList.size() > 1) {
                potato();
                System.out.println(plrList);

            }
            System.out.println(plr.getElement() + " WINS HOT POTATO!");
        } else {
            System.out.println("Please set a group of players.");
        }
    }

    /*
     * MUTATOR Method
     * 
     * @param focus is the Player in question
     */
    public void knock(DLLNode<PlayerPotato> focus) {
        int moves = focus.getElement().getFistCount();
        //Number of fists in a player
        Fist fist = null;   //The last most recent fist used/altered.  

        switch (moves) {
            case 2: //2 Fists = 2 Moves
                if (moves + movesP > MAX_MOVES) {
                    System.out.print(++movesP + " Potato!"
                            + focus.getElement().getFist(Fist.left));
                    fist = Fist.left;
                } else {
                    System.out.println(++movesP + " Potato!"
                            + focus.getElement().getFist(Fist.left));
                    System.out.print(++movesP + " Potato!"
                            + focus.getElement().getFist(Fist.right));
                    fist = Fist.right;
                }
                break;
            case 1:
                if (focus.getElement().getFistL()) {
                    System.out.print(++movesP + " Potato!"
                            + focus.getElement().getFist(Fist.left));
                    fist = Fist.left;
                } else if (focus.getElement().getFistR()) {
                    System.out.print(++movesP + " Potato!"
                            + focus.getElement().getFist(Fist.right));
                    fist = Fist.right;
                }
                break;
            default:
                System.out.println("Error knocking the potatoes");
                break;
        }

        popPotato(focus, fist, moves);

        System.out.println();

    }

    /*
     * MUTATOR Method
     * 
     * @param focus fist moves passed through to determine if player is
     *          removed or subtracted of a fist
     */
    public void popPotato(DLLNode<PlayerPotato> focus, Fist fist, int moves) {
        if (movesP >= MAX_MOVES) {
            System.out.println(" <- POP GOES THE POTATO!");

            if (moves <= 1) {
                plr = plr.getNext();
                if (plrList.size() > 2) {
                    plrList.remove(focus.getElement());
                } else {
                    winner = true;
                }

            } else {
                if (fist == Fist.right) {
                    plr = plr.getNext();
                    focus.getElement().downFist(Fist.right);
                } else {
                    focus.getElement().downFist(Fist.left);
                }
            }
        }
    }

    /*
     * MUTATOR Method
     * 
     * @noparam runs knock until movesP is incremented to MAX_MOVES
     */
    public void potato() {
        movesP = 0;

        knock(plr);   //First Player's Knock

        while (movesP < MAX_MOVES) {
            plr = plr.getNext();
            knock(plr);
        }

    }

    /*
     * MUTATOR Method
     * 
     * @param pL sets the player list to be used in the game
     *          the first player is chosen here
     */
    public void setPlayerList(DLLCircularQueue<PlayerPotato> pL) {
        plrList = pL;
        plr = plrList.getHead(); //CHANGE
    }

}
