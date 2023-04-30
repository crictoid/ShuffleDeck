// Mark Bulmer - CSC 151 - 5-6-2022
// Shuffle the deck.

// The main class which will generate a deck of cards, shuffle it, deal five cards to a hand, total the point value
// of the cards, declare a winner based on the largest point total, and display this information.

// I failed to design around your template, so I did my best to reconstruct the program
// following most of your variables, though it doesn't align perfectly, and I re-wrote the Card class.
// If I can't get my code to run first, I have difficulty in troubleshooting effectively,
// and so I started from scratch and tried to match it up with yours.
// Unfortunately, even when working backwards using your model I was unsuccessful in duplicating it.
// I have submitted this version, which will compile at least, and utilizes most of the intended features.

public class MainBulmer {                               // the main class which will deal the hands and
                                                        // determine the winner

    public static final int shuffles = 42,                  // the deck will be shuffled an arbitrary number of times
            cardsToDeal = 5;                    // the number of cards which will be dealt in a hand

    public static int winner(Hand hand1, Hand hand2) {   // method which will determine the game winner
                                                        // by adding up the points and checking to see
                                                        // who had the most points.

        int totalPoints1, totalPoints2;                                 // labels for total of hands 1 and 2

        totalPoints1 = hand1.getPointValue();				    // get total point value of hand 1
        totalPoints2 = hand2.getPointValue();				    // get total point value of hand 2
        if (totalPoints1 > totalPoints2)
            return 1;                                   // refers to switch in main method when player 1 wins
        else if (totalPoints2 > totalPoints1)
            return 2;                                   // refers to switch in main method when player 2 wins
        else
            return 3;                                   // refers to switch in main method when game is tied

    }



    public static void main(String[] args) {            // main method which deals hands and determines points

        DeckBulmer deck = new DeckBulmer();				// create a new deck of cards

        Hand hand1 = new Hand(), hand2 = new Hand();    // create the two hands

        deck.shuffleDeck(shuffles);						// shuffle the deck



        for (int j = 0; j <= cardsToDeal - 1; j++) { // cards are drawn by hand 1 until the number in cardsToDeal is
                                                    // reached when top card is drawn, there is one less card to deal.

            hand1.drawTopCard(deck);				    // hand 1 draws the top card
        }

        for (int j = 0; j <= cardsToDeal - 1; j++) { // cards are drawn by hand 2 until the number in cardsToDeal is
                                                    // reached when top card is drawn, there is one less card to deal.

            hand2.drawTopCard(deck);				    // hand 2 draws the top card
        }


        System.out.println("Hand 1: Total Points  " + hand1.getPointValue() ); // prints hand 1's total point value
        hand1.getHand();						    // hand 1 is displayed
        System.out.println();                       // line break

        System.out.println("Hand 2: Total Points  " + hand2.getPointValue() ); // prints hand 2's total point value
        hand2.getHand();						    // hand 2 is displayed
        System.out.println();                       // line break


        switch (MainBulmer.winner(hand1, hand2)) {
            case 1 -> System.out.println("Hand 1 Wins"); // printed if hand 1 wins
            case 2 -> System.out.println("Hand 2 Wins"); // printed if hand 2 wins
            case 3 -> System.out.println("The game is tied"); // print in a tied game
        }

    }


}

class CardBulmer {                                    // class which will generate a card


    private int rank;                           // card rank
    private String suit;                        // card suit

    public CardBulmer() {                             // create a new card object
        rank = 0;                                // card rank is empty
        suit = "";                                // card suit is empty
    }

    public void getCard() {                    // the method which prints the card information

        if ((2 <= rank) && (rank <= 10))
            System.out.print(rank);            // will print rank for cards 2-10 based on number value
        else
            switch (rank) {                    // if the card is a face card, it is labeled appropriately
                case 11 -> System.out.print("Jack");
                case 12 -> System.out.print("Queen");
                case 13 -> System.out.print("King");
                case 14 -> System.out.print("Ace");
            }
        System.out.print(" of " + suit + " (point value = " + getPointValue() + ")");   // prints the suit after the card's rank
                                                                                        // then adds the point value through getPointValue method

    }

    public void setRank(int getPointValue) {                    // method which sets the value of the card

        rank = getPointValue;
    }

    public int getPointValue() {                            //  method which return the card's point value
        if ((2 <= rank) && (rank <= 10))                    // cards 2-10 return their actual rank
        return rank;
        else if (rank == 14)                                // Aces are worth 13 less than its rank
            return rank - 13;
        else if
            (rank == 13)                                    // Kings are worth their rank
            return rank ;
        else if
        (rank == 12)                                        // Queens are worth their rank
            return rank ;
        else if
        (rank == 11)                                        // Jacks are worth their rank
            return rank ;

        return getPointValue();

    }

    public void setSuit(String setSuit) {                // method which sets the suit of the card

        suit = setSuit;
    }



}
class Hand {

    private final CardBulmer[] Hand;                       // an empty hand to hold the cards
    private int cardsInHand;                     // number of cards which have been drawn

    public Hand() {                            // Initializes a new hand
        Hand = new CardBulmer[5];             // A hand will contain five cards
        cardsInHand = 0;                 // The number of cards in a hand starts with zero
    }

    public void drawTopCard(DeckBulmer deck) {                // method which allows each hand to be drawn

        Hand[cardsInHand] = deck.nextTopCard();    // takes the card at the top position
        cardsInHand++;                         // the number of cards in the hand increases
    }

    public int getPointValue() {                // method which adds the point value of a hand and finds a total

        int
                cardPointValue,                      // a card's total point value
                totalPoints = 0;                    // the total points of all cards in a hand

        for (int i = 0; i <= cardsInHand - 1; i++) {
            cardPointValue = Hand[i].getPointValue();
            if (cardPointValue <= 10 && cardPointValue >=2)     // numbered cards add their face value to the total
                totalPoints = totalPoints + cardPointValue;
            else if (cardPointValue == 13)
                totalPoints = totalPoints + 13;    // Kings add 13 points to the total
            else if (cardPointValue == 12)
                totalPoints = totalPoints + 12;    // Queens add 12 points to the total
            else if (cardPointValue == 11)
                totalPoints = totalPoints + 11;    // Jacks add 11 points to the total
            else
                totalPoints = totalPoints + 1;    // Aces add 1 point to the total
        }
        return totalPoints;                        // returns the value of all points added together
    }



    public void getHand() {                           // method which displays the cards in each hand

        for (int i = 0; i <= cardsInHand - 1; i++) {  // checks to see if any cards are remaining in the hand
            System.out.print(" ");
            Hand[i].getCard();                       // prints each card
            System.out.println();                    // line break
        }

    }


}


