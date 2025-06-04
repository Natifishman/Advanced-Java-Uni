import javax.swing.*;

/**
 * Question 1 in Maman11
 * Code written by Natanel Fishman.
 *
 * Assignment Description:
 * Write an application that implements the card game "War" as follows: The program will define the classes
 * the following: a class representing a card, a class representing a deck of cards and a main management class
 * the game. The game proceeds as follows:
 * - Deal a deck of cards to two players.
 * - In each turn both players show the top card in the deck.
 * - The player whose card value is higher wins the two cards and puts them at the bottom of the deck
 *   his. In the event that the value of the two cards is the same, a "war" situation is declared - each player adds 3 cards,
 *   and the player whose third card is higher wins all the cards drawn in the turn. If values
 *   the cards are again the same, perform a "war" until one wins.
 */

public class Main {
    public static void main(String[] args) {
        // Start the warGame
        warGame();
    }

    // Start the warGame
    public static void warGame() {
        String message;
        boolean flag=true;
        // Create two decks for Player A and Player B
        DeckOfCards deckA = new DeckOfCards();
        DeckOfCards deckB = new DeckOfCards();
        DeckOfCards temp = new DeckOfCards();
        // Clear the decks
        deckA.clearDeck();
        deckB.clearDeck();
        // Shuffle the temporary deck
        temp.shuffle();
        // Divide the shuffled cards between deckA and deckB
        divide(deckA, deckB, temp);
        temp.clearDeck();

        // Main game loop
        while(!deckA.isDeckEmpty() && !deckB.isDeckEmpty()) {
            // Deal one card from each deck
            Card cardA = deckA.dealCard();
            Card cardB = deckB.dealCard();
            // Prepare message for current round
            message = "Player 1 Card is: " + cardA + "\nPlayer 2 Card is: " + cardB.toString();
            if (cardA.cardValue() > cardB.cardValue()) {
                // Player A wins the round
            	addToDeck(cardA, cardB, deckA, temp);
                message += "\nPlayer 1 won!";
            }
            else if (cardA.cardValue() < cardB.cardValue()) {
                // Player B wins the round
            	addToDeck(cardB, cardA, deckB, temp);
                message += "\nPlayer 2 won!";
            }
            // War mode
            else {
                message += "\nIts a war!";
                // We will add 2 cards from each player to the temp deck and after the war will give them to the winner
                for (int i = 0; i < 2; i++){
                    cardA = deckA.dealCard();
                    cardB = deckB.dealCard();
                    temp.addCard(cardA);
                    temp.addCard(cardB);
                }
            }
            // Display message and ask for user choice
            int choice = JOptionPane.showOptionDialog(null, message + "\nDo you want to continue to the next round?", "Game Round Result",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (choice == JOptionPane.NO_OPTION || choice == JOptionPane.CLOSED_OPTION) {
                // Player chose to close the game
            	flag=false;
                break;
            }
        }// End of while
        // Determine the winner of the game
        if(flag)
        	declareWinner(deckA, deckB);
    }

    // Make a message of who won the game
    public static void declareWinner (DeckOfCards A, DeckOfCards B) {
        if(A.isDeckEmpty())
            JOptionPane.showMessageDialog(null,  "Player 2 won the game!");
        else
            JOptionPane.showMessageDialog(null, "Player 1 won the game!");
    }

    // Add cards A and B and temporary deck to the deck
    public static void addToDeck(Card cardA, Card cardB, DeckOfCards deck, DeckOfCards temp) {
        temp.addCard(cardA);
        temp.addCard(cardB);
        deck.addDeck(temp);
        temp.clearDeck();
    }

    // Divide the cards from deck MainDeck to deckA and deckB
    public static void divide(DeckOfCards deckA,DeckOfCards deckB, DeckOfCards MainDeck) {
        for(int i=0;i<52;i++) {
            if(i%2==0)
                deckA.addCard(MainDeck.dealCard());
            else
                deckB.addCard(MainDeck.dealCard());
        }
    }
}// End of class Main