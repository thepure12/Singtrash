package com.tp12.singtrash;

import java.util.HashMap;

import android.app.Activity;
import android.widget.ImageView;

public class CardImgFactory
{
	private int drawables[] =
	{ R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4,
	  R.drawable.c5, R.drawable.c6, R.drawable.c7, R.drawable.c8,
	  R.drawable.c9, R.drawable.c10, R.drawable.cj, R.drawable.cq,
	  R.drawable.ck, R.drawable.d1, R.drawable.d2, R.drawable.d3,
	  R.drawable.d4, R.drawable.d5, R.drawable.d6, R.drawable.d7,
	  R.drawable.d8, R.drawable.d9, R.drawable.d10, R.drawable.dj,
	  R.drawable.dq, R.drawable.dk, R.drawable.h1, R.drawable.h2,
  	  R.drawable.h3, R.drawable.h4, R.drawable.h5, R.drawable.h6,
	  R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10,
	  R.drawable.hj, R.drawable.hq, R.drawable.hk, R.drawable.s1,
	  R.drawable.s2, R.drawable.s3, R.drawable.s4, R.drawable.s5,
	  R.drawable.s6, R.drawable.s7, R.drawable.s8, R.drawable.s9,
	  R.drawable.s10, R.drawable.sj, R.drawable.sq, R.drawable.sk };
	private HashMap<Character, Integer> map;

	public CardImgFactory()
	{
		map = new HashMap<Character, Integer>();
		map.put('c', 0);
		map.put('d', 1);
		map.put('h', 2);
		map.put('s', 3);
	}
	
	public int cardImage(Card card)
	{
		char suit = card.getSuit();
		int value = card.getValue();
		int muliplyer = map.get(suit);
		int index = muliplyer * 13 + value - 1;
		return drawables[index];
	}
}
