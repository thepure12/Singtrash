package com.tp12.singtrash;
import java.util.ArrayList;
@SuppressWarnings("serial")
public class Table extends ArrayList<Card>
{
	private int size;
	
	public Table()
	{
		size = 10;
	}
	
	/**
	 * Only add a card if the current size is
	 * smaller than the allowed size.
	 */
	@Override
	public boolean add(Card object)
	{
		if (size() < size)
			return super.add(object);
		return false;
	}
	
	/**
	 * Reduce the allowed size buy one less
	 * than the level
	 * @param level the player is currently on
	 */
	public void reduceSize(int level)
	{
		level--;
		size -= level;
	}
	
	/**
	 * 
	 * @return the allowed size of the table.
	 */
	public int getSize()
	{
		return size;
	}
}
