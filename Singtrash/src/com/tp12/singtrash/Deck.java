package com.tp12.singtrash;
import java.util.ArrayList;
import java.util.Collections;
@SuppressWarnings("serial")
public class Deck extends ArrayList<Card>
{
	private final int FULLSIZE = 52;
	private final int GAMESIZE = 30;
	private Deck startDeck;
	
	public Deck()
	{
		char suits[] = {'c', 'd', 'h', 's'};
		for (char s : suits)
		{
			for (int i = 1; i <= 13; i++)
				add(new Card(s, i));
		}
		shuffle();
		/**
		 * Remove enough cards to get the deck to
		 * the right size for the game.
		 */
		for (int i = 0; i < FULLSIZE - GAMESIZE; i++)
		{
			remove(0);
		}
	}
	
	/**
	 * Suffles the deck
	 */
	public void shuffle()
	{
		Collections.shuffle(this);
	}
}
