package com.tp12.singtrash;
import android.graphics.Color;

public class Achievements
{
	private static Achievements achievements;
	private boolean allRed, allBlack;
	
	public static Achievements instance()
	{
		if (achievements == null)
			achievements = new Achievements();
		return achievements;
	}
	
	/**
	 * Check if any of the achievements are fulfilled.
	 * @param table of the level just passed.
	 */
	public void checkAnyAchieved(Table table)
	{
		if (!allRed) checkAllRed(table);
		if (!allBlack) checkAllBlack(table);
	}

	/**
	 * Check if all of the cards are red.
	 * @param table of the level just passed.
	 */
	private void checkAllRed(Table table)
	{
		for (Card c : table)
		{
			if (c.getColor() == Color.BLACK)
				return;
		}
		System.err.println("Achievement: All Red");
		allRed = true;
	}
	
	/**
	 * Check if all of the cards are black.
	 * @param table of the level just passed.
	 */
	private void checkAllBlack(Table table)
	{
		for (Card c : table)
		{
			if (c.getColor() == Color.RED)
				return;
		}
		System.err.println("Achievement: All Black");
		allRed = true;
	}
	
	/**
	 * Get all the achievements as an array
	 * @return the achievements as an array
	 */
	public boolean[] getAll()
	{
		return new boolean[] {};
	}
}
