package com.tp12.singtrash;
import java.util.ArrayList;
import java.util.Collections;
@SuppressWarnings("serial")
public class Deck extends ArrayList<Card>
{
	private final int FULL = 52;
	private final int GAME = 30;
	
	public Deck()
	{
		char suits[] = {'c', 'd', 'h', 's'};
		for (char s : suits)
		{
			for (int i = 1; i <= 13; i++)
				add(new Card(s, i));
		}
		Collections.shuffle(this);
		for (int i = 0; i < FULL - GAME; i++)
		{
			remove(0);
		}
	}
}
