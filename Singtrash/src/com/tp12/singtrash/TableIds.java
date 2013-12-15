package com.tp12.singtrash;

import java.util.ArrayList;

public class TableIds
{
	/**
	 * Gets all of the ids of the cards images for the table.
	 * @return
	 */
	public static ArrayList<Integer> getIds()
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		int ids[] =
		{ R.id.c0, R.id.c1, R.id.c2, R.id.c3, R.id.c4, R.id.c5, R.id.c6,
				R.id.c7, R.id.c8, R.id.c9 };
		for (int id : ids)
		{
			list.add(id);
		}
		return list;
	}
}
