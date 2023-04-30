public class DeckBulmer {               // class which builds a deck of cards and shuffles it

    private final CardBulmer[] deck;                 		// new deck of cards
    private int topCard;                     // determines which card is "on top"

    public DeckBulmer() {								//creates a deck of cards


        deck = new CardBulmer[52];             		// create a new deck of cards
        topCard = 0;							// set the position of the top card to 0


        for (int i = 0; i <= 51; i++) {			// continue creating cards until 52 have been created
            deck[i] = new CardBulmer();        		// create card "i"
            deck[i].setRank((i % 13) + 2);      // assign ranks to cards
            switch (i / 13) {                    // assign suits to cards
                case 0 -> deck[i].setSuit("Hearts");
                case 1 -> deck[i].setSuit("Diamonds");
                case 2 -> deck[i].setSuit("Clubs");
                case 3 -> deck[i].setSuit("Spades");
            }
        }
    }

    public void shuffleDeck(int x) {				// shuffleDeck method shuffles the cards and sets top card position

        int y;									// used as a temporary value

        CardBulmer z;								// used as a temporary card

        for (int i = 1; i <= x; i++)			// the deck is shuffled "x" times
            for (int j = 0; j <= 51; j++) {
                y = (int) (52*Math.random());	// generates 52 random positions at "y"
                z = deck[j];				// deck z and j are swapped
                deck[j] = deck[y];          // deck j and y are swapped
                deck[y] = z;                // deck y and z are swapped
            }
        topCard = 0;							// the top card is given primacy as value "0"
    }

    public CardBulmer nextTopCard() {					// changes the next card's value when a card is drawn
                                                        // so that it is recognized as the top card
        topCard++;
        return deck[topCard - 1];
    }
}



