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
	
	@Override
	public boolean add(Card object)
	{
		if (size() < size)
			return super.add(object);
		return false;
	}
	
	public void reduceSize()
	{
		size--;
	}
	
	public int getSize()
	{
		return size;
	}
}
