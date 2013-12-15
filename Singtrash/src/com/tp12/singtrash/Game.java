package com.tp12.singtrash;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.app.AlertDialog;

public class Game
{
	private Activity activity;
	private Deck startDeck;
	private Deck deck;
	private Pile pile;
	private Table table;
	private Display display;
	private int level;
	private int difficulty;
	private Card currentCard;
	
	public Game(Activity activity)
	{
		this.activity = activity;
		startDeck = new Deck();
		deck = (Deck) startDeck.clone();
		pile = new Pile();
		table = new Table();
		display = new Display(this, activity);
		level = 1;
		difficulty = 1;
		setTable();
		display.update();
	}
	
	/**
	 * Set the card in the table at the beginning
	 *  of the level.
	 */
	private void setTable()
	{
		for (int i = 0; i < table.getSize(); i++)
		{
			Card c = deck.get(0);
			deck.remove(0);
			table.add(c);
		}
	}

	/**
	 * Flip the next card off the top of the deck and put
	 * it face up into the pile.
	 */
	public void nextCard()
	{
		if (deck.size() == 0) return;
		Card c = deck.get(0);
		c.flipFaceUp();
		pile.add(c);
		currentCard = c;
		deck.remove(c);
		display.update();
	}
	
	/**
	 * 
	 * @return the card currently being displayed in
	 * the pile.
	 */
	public Card getCurrentCard()
	{
		return currentCard;
	}
	
	/**
	 * 
	 * @return true if the deck is empty.
	 */
	public boolean deckIsEmpty()
	{
		return deck.size() == 0;
	}

	/**
	 * Check if the position in the table that the player
	 * clicked matches the value of the current card.
	 * @param id of the card on the table that was clicked.
	 */
	public void checkMatch(int id)
	{
		int clickedPosition = TableIds.getIds().indexOf(id);
		System.err.println("Checking for match at pos " + (clickedPosition + 1));
		if (currentCard != null && currentCard.getValue() == clickedPosition + 1)
		{
			System.err.println("Found match");
			Card c = table.get(clickedPosition);
			c.flipFaceUp();
			table.set(clickedPosition, currentCard);
			pile.set(0, c);
			currentCard = c;
			display.update();
			checkWin();
		}
	}
	
	/**
	 * Check to see if the player has won.
	 */
	private void checkWin()
	{
		boolean win = true;
		for (Card c : table)
		{
			if (!c.isFaceUp())
			{
				win = false;
			}
		}
		if (win)
			nextLevel();
	}
	
	/**
	 * Remove cards from the deck based on difficulty.
	 */
	private void removeCardsFromDeck()
	{
		for (int i = 0; i < difficulty; i++)
		{
			deck.remove(0);
		}
	}

	/**
	 * Increase the level. Set the deck back to the starting deck.
	 * Flip all of the cards face down. Create a new pile and table.
	 * Shuffle the deck. Set the current card to null. Reduce the
	 * table size based on level. Remove cards from the deck based
	 * on difficulty. Set the table. Update the display.
	 */
	private void nextLevel()
	{
		level++;
		deck = (Deck) startDeck.clone();
		flipCards();
		pile = new Pile();
		table = new Table();
		deck.shuffle();
		currentCard = null;
		table.reduceSize(level);
		removeCardsFromDeck();
		startDeck = (Deck) deck.clone();
		setTable();
		display.update();
	}

	/**
	 * Flips all the cards in the start deck face down.
	 */
	private void flipCards()
	{
		for (Card c : startDeck)
		{
			c.flipFaceDown();
		}
	}

	/**
	 * 
	 * @return the table of the game.
	 */
	public Table getTable()
	{
		return table;
	}
}
