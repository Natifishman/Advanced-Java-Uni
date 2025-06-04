/**
 * Question 1 in Maman11
 * Code written by Natanel Fishman.
 *
 * Represents a playing card with a face and a suit.
 */

public class Card {
    private final String face; // The face value of the card
    private final String suit; // The suit of the card

    /**
     * Constructs a Card object with a specified face and suit.
     * @param cardFace The face value of the card.
     * @param cardSuit The suit of the card.
     */
    public Card(String cardFace, String cardSuit) {
        this.face = cardFace;
        this.suit = cardSuit;
    }

    /**
     * Returns a string representation of the card.
     * @return The string representation of the card.
     */
    public String toString() {
        return face + " of " + suit;
    }

    /**
     * Returns the numerical value of the card.
     * @return The numerical value of the card.
     */
    public int cardValue() {
        String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        for(int i=0;i<faces.length;i++) {
            if(face.equals(faces[i])) // Using equals() for string comparison
                return i+1;
        }
        return 0; // Default return value if face not found
    }
} // End class Card