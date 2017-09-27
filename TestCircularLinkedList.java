/**
 * CSC-223 Weeks #5/6 Lab #3 * DUE DATE: DATE SUBMITTED: PROGRAMMED BY:
 * DESCRIPTION: Create and test circular double linked list
 *
 */
package testcircularlinkedlist;

/**
 *
 * @author Anita
 */
public class TestCircularLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        DLLCircularQueue<PlayerPotato> queue = new DLLCircularQueue<PlayerPotato>();

//        for (int i = 0; i < 4; i++) {
//            queue.enqueue(new PlayerPotato());
//        }
        
        queue.enqueue(new PlayerPotato("Hal"));
        queue.enqueue(new PlayerPotato("Dave"));
        queue.enqueue(new PlayerPotato("Hal"));
        queue.enqueue(new PlayerPotato("Dave"));
        
        PotatoGame hotPotato = new PotatoGame(queue);
        hotPotato.playGame();
        

        
    }

}
