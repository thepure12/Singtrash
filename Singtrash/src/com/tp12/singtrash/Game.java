package com.tp12.singtrash;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.app.AlertDialog;

public class Game
{
	private Activity activity;
	private Deck deck;
	private Pile pile;
	private Table table;
	private Display display;
	private int level;
	private Card currentCard;
	
	public Game(Activity activity)
	{
		this.activity = activity;
		deck = new Deck();
		pile = new Pile();
		table = new Table();
		display = new Display(this, activity);
		level = 1;
		setTable();
		display.update();
	}
	
	private void setTable()
	{
		for (int i = 0; i < table.getSize(); i++)
		{
			Card c = deck.get(0);
			deck.remove(0);
			table.add(c);
		}
	}

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
	
	public Card getCurrentCard()
	{
		return currentCard;
	}
	
	public boolean deckIsEmpty()
	{
		return deck.size() == 0;
	}

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
		if (win) new AlertDialog.Builder(activity).setTitle("You win").show();
	}
	
	public Table getTable()
	{
		return table;
	}
}
