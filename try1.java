package Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class try1 {

    public static void main(String[] Args) {

        class Card {
            private int value;

            @Override
            public String toString() {
                String cardSuit;
                char cardValue;

                int tValue1 = this.value / 100;

                if (tValue1 == 1) {
                    cardSuit = "Clubs";
                } else if (tValue1 == 2) {
                    cardSuit = "Diamonds";
                } else if (tValue1 == 3) {
                    cardSuit = "Hearts";
                } else if (tValue1 == 4) {
                    cardSuit = "Spades";
                } else {
                    cardSuit = "WTF";
                }

                int tValue2 = this.value % 100;

                if (tValue2 == 1) {
                    cardValue = 'A';
                } else if (tValue2 == 2) {
                    cardValue = '2';
                } else if (tValue2 == 3) {
                    cardValue = '3';
                } else if (tValue2 == 4) {
                    cardValue = '4';
                } else if (tValue2 == 5) {
                    cardValue = '5';
                } else if (tValue2 == 6) {
                    cardValue = '6';
                } else if (tValue2 == 7) {
                    cardValue = '7';
                } else if (tValue2 == 8) {
                    cardValue = '8';
                } else if (tValue2 == 9) {
                    cardValue = '9';
                } else if (tValue2 == 10) {
                    cardValue = 'T';
                } else if (tValue2 == 11) {
                    cardValue = 'J';
                } else if (tValue2 == 12) {
                    cardValue = 'Q';
                } else if (tValue2 == 13) {
                    cardValue = 'K';
                } else {
                    cardValue = 'F';
                }
                return "Suit = " + cardSuit + ", Value = " + cardValue;
            }
        }

        class Dealer {

            public List<Card> getSortedDeck() {
                ArrayList<Card> sortedDeck = new ArrayList<>();

                for (int j = 1; j < 5; j++) {
                    for (int i = 1; i < 14; i++) {
                        Card newOne = new Card();
                        newOne.value = j * 100 + i;
                        sortedDeck.add(newOne);
                    }
                }
                return sortedDeck;
            }

            public List<Card> getMixedDeck() {
                Random rnd = new Random();
                List<Card> sortedDeck = getSortedDeck();

                for (int i = 0; i < sortedDeck.size(); i++) {
                    int position = i + rnd.nextInt(sortedDeck.size() - i);
                    Card temp = sortedDeck.get(i);
                    sortedDeck.set(i, sortedDeck.get(position));
                    sortedDeck.set(position, temp);
                }
                List<Card> mixedDeck = sortedDeck;
                return mixedDeck;
            }
        }

        Dealer newDeck = new Dealer();

        Scanner scanner = new Scanner(System.in);
        System.out.println("!!! Choose 1 for sorted deck or 2 for mixed deck !!!");
        int typeDeck = scanner.nextInt();
        int i = 0;

        if (typeDeck == 1) {
            for (Card currentCard : newDeck.getSortedDeck()) {
                System.out.println(currentCard.toString());
                i++;
            }
        } else if (typeDeck == 2) {
            for (Card currentCard : newDeck.getMixedDeck()) {
                System.out.println(currentCard.toString());
                i++;
            }
        }
        System.out.println("Total cards = " + i);
    }
}
