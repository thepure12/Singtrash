package com.tp12.singtrash;
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
	
	public void flipFaceUp()
	{
		faceup = true;
	}
	
	public void flipFaceDown()
	{
		faceup = false;
	}
	
	public char getSuit()
	{
		return suit;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public boolean isFaceUp()
	{
		return faceup;
	}
	
	public String toString()
	{
		return suit + "" + value;
	}
}
