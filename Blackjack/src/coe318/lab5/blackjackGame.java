/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe318.lab5;

/**
 *
 * @author crvnt
 */
public class blackjackGame {

    private cardPile deck;
    private cardPile houseCards;
    private cardPile yourCards;
    private boolean houseDone;
    private boolean playerDone;
    private simpleUI ui;

    public blackjackGame(simpleUI ui) {
        this.ui = ui;
        ui.setGame(this);
        deck = new cardPile();
        for (int i = 2; i < 15; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(new Card(i, j, true));
            }
        }
        houseCards = new cardPile();
        yourCards = new cardPile();
        houseDone = false;
        playerDone = false;
    }

    public void start() {
        Card c;
        c = deck.removeRandom();
        c.setFaceUp(false);
        getHouseCards().add(c);
        getHouseCards().add(deck.removeRandom());
        getYourCards().add(deck.removeRandom());
        getYourCards().add(deck.removeRandom());
        ui.display();
    }

    public void play() {
        while (!houseDone || !playerDone) {
            if (!houseDone) {
                if (score(getHouseCards()) <= 17) {
                    getHouseCards().add(deck.removeRandom());
                    ui.display();
                } else {
                    houseDone = true;
                }
            }
            if (!playerDone) {
                if (ui.hitMe()) {
                    getYourCards().add(deck.removeRandom());
                    ui.display();
                } else {
                    playerDone = true;
                }
            }
        }
    }

    public void end() {
        getHouseCards().getCards().get(0).setFaceUp(true);
        ui.gameOver();
    }

    /**
     * Determine the score of a pile of cards.
     *
     * @param p
     * @return the score
     */
    public int score(cardPile p) {
//FIX THIS
        int score = 0;
        for (Card card : p.getCards()) {
            if ((card.getRank() == 11) || (card.getRank() == 12) || (card.getRank() == 13)) {
                score += 10;
            } else if (card.getRank() == 14) {
                score += 1;
            } else {
                score = score + card.getRank();
            }
        }
        return score;
    }

    /**
     * @return the houseCards
     */
    public cardPile getHouseCards() {
        return houseCards;
    }

    /**
     * @return the yourCards
     */
    public cardPile getYourCards() {
        return yourCards;
    }

    public static void main(String[] args) {
        blackjackGame game = new blackjackGame(new simpleUI());
        game.start();
        game.play();
        game.end();
    }
}
