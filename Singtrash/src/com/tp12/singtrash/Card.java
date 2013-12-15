package com.tp12.singtrash;

import android.graphics.Color;

public class Card
{
	private char suit;
	private int value;
	private boolean faceup;
	
	public Card(char suit, int value)
	{
		this.suit = suit;
		this.value = value;
	}
	
	/**
	 * Turn the card to its face up position
	 */
	public void flipFaceUp()
	{
		faceup = true;
	}
	
	/**
	 * Turn the card to its face down position
	 */
	public void flipFaceDown()
	{
		faceup = false;
	}
	
	/**
	 * 
	 * @return the suit of the card
	 */
	public char getSuit()
	{
		return suit;
	}
	
	/**
	 * 
	 * @return the value of the card
	 */
	public int getValue()
	{
		return value;
	}
	
	/**
	 * 
	 * @return true if the card is face up
	 */
	public boolean isFaceUp()
	{
		return faceup;
	}
	
	public int getColor()
	{
		if (suit == 'd' || suit == 'h')
			return Color.RED;
		else
			return Color.BLACK;
	}
	
	/**
	 * String representation of the card
	 */
	public String toString()
	{
		return suit + "" + value;
	}
}
