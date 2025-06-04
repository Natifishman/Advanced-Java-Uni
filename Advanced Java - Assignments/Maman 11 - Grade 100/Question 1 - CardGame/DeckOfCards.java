import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * Question 1 in Maman11
 * Code written by Natanel Fishman.
 *
 * Represents a deck of cards
 */

public class DeckOfCards {
    private ArrayList<Card> deck;
    private static final int NUMBER_OF_CARDS = 52;
    private static final SecureRandom randomNumbers = new SecureRandom();

    // Constructor to initialize deck of cards
    public DeckOfCards() {
        deck = new ArrayList<Card>();
        String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        String[] suits = { "Clubs", "Spades", "Hearts", "Diamonds"};
        // Fill the deck with Cards
        for (int count = 0; count < NUMBER_OF_CARDS; count++)
            deck.add( new Card(faces[count % 13], suits[count / 13]));
    }

    // Method to clear the deck
    public void clearDeck() {
        deck.clear();
    }

    // Method to shuffle the deck of Cards
    public void shuffle() {
    	// After each deal, the next dealt card will be from the top of the deck.
    	// For each card, select another card randomly from 0 to 51 and exchange them.
        for(int first = 0; first < deck.size(); first++) {
            // select a random number between 0 and 51
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
            // swap the current Card with a randomly selected Card
            Card temp = deck.get(first);
            deck.set(first,deck.get(second));
            deck.set(second,temp);
        }
    }

    public Card dealCard() {
        // Check if there are remaining cards to be dealt
        if (!deck.isEmpty())
            return deck.remove(0); // Take and return the top card from the deck
        return null; // Return null indicating that there are no cards left to deal
    }
    
    // Method to check if the deck is empty
    public boolean isDeckEmpty() {
        return deck.size()==0;
    }
    
    // Method to return the size of the deck
    public int SizeOfDeck() {
        return deck.size();
    }

    // Method to add a card to the deck
    public void addCard(Card card) {
        deck.add(card);
    }
    
    // Method to add a deck(other) to the deck
    public void addDeck(DeckOfCards other) {
        while (!other.isDeckEmpty())
            deck.add(other.dealCard());
    }
} // End class DeckOfCards