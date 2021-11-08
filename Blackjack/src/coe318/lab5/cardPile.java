/**
 *
 * Thomas Cervantes (500961203)
 */
package coe318.lab5;
import java.util.ArrayList;

/**
 * A pile of cards.
 *
 */
public class cardPile {
    //Instance variables
    private ArrayList<Card> cards;

    public cardPile() {
        //Initialize the instance variable.
        cards = new ArrayList<Card> ();
    }
    /**
     * Add a card to the pile.
     * @param crd
     */
    public void add(Card crd) {
        this.cards.add(crd);
    
    }

    /**
     * Remove a card chosen at random from the pile.
     * @return
     */
    public Card removeRandom() {
        int num = (int)(Math.random()*this.cards.size());
        return (this.cards.remove(num));//FIX THIS
    }

    /**
     * The string representation is a space separated list
     * of each card.
     * @return
     */
    @Override
    public String toString() {
        String cardlist = "\n";
        for (Card card : this.cards) {
            cardlist += card.toString() + "\n";
        }
        //FIX THIS
        return cardlist;
    }
    
    /**
     * @return the cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public static void main(String[] args) {
        cardPile p = new cardPile();
        p.add(new Card(2, 1, true));
        p.add(new Card(3, 2, true));
        p.add(new Card(4, 3, false));
        p.add(new Card(14, 1, true));
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("");
        cardPile deck = new cardPile();
        for(int i = 2; i < 15; i++) {
            for(int j = 0; j < 4; j++) {
                deck.add(new Card(i, j, true));
            }
        }
        for (int i = 0; i < 52; i++) {
            System.out.println((i+1) + ": " + deck.removeRandom());

        }
    }


}