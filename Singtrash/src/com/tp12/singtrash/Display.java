package com.tp12.singtrash;
import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.app.AlertDialog;
import android.opengl.Visibility;
import android.view.View;
import android.widget.ImageView;

public class Display
{
	//Constant
	private final int cardPadding = 10;
	private final CardImgFactory CARD_IMAGE_FACTORY = new CardImgFactory();
	
	//Instances
	private Activity activity;
	private ImageView deckImg;
	private ImageView pileImg;
	private ArrayList<ImageView> cardImgs;
	private int screenHeight;
	private int cardWidth;
	private int cardHeight;
	private Game game;

	@SuppressWarnings("deprecation")
	public Display(Game game, Activity activity)
	{
		this.game = game;
		this.activity = activity;
		this.screenHeight = activity.getWindowManager().getDefaultDisplay().getHeight();
		cardImgs = new ArrayList<ImageView>();
		cardHeight = (int) (screenHeight / 3.1);
		cardWidth = (int) (cardHeight * .71428571428);
		getComponents();
		styleDeckAndPile();
		styleCards();
		addListeners();
	}

	/**
	 * Add the listeners to clickable cards
	 */
	private void addListeners()
	{
		for (ImageView iv : cardImgs)
		{
			iv.setOnClickListener(new ClickListener(game));
		}
		deckImg.setOnClickListener(new ClickListener(game));
	}

	/**
	 * Style the table cards
	 */
	private void styleCards()
	{
		for (ImageView iv : cardImgs)
		{
			iv.getLayoutParams().width = cardWidth;
			iv.getLayoutParams().height = cardHeight;
			iv.setPadding(cardPadding, cardPadding, cardPadding, cardPadding);
		}
	}

	/**
	 * Style the deck and pile
	 */
	private void styleDeckAndPile()
	{
		ImageView imgs[] = {deckImg, pileImg};
		for (ImageView iv : imgs)
		{
			iv.getLayoutParams().width = cardWidth;
			iv.getLayoutParams().height = cardHeight;
			iv.setPadding(cardPadding, cardPadding, cardPadding, cardPadding);
		}
		pileImg.setImageDrawable(null);
	}

	/**
	 * Get all of the components
	 */
	private void getComponents()
	{
		deckImg = (ImageView) activity.findViewById(R.id.deck);
		pileImg = (ImageView) activity.findViewById(R.id.pile);
		for (int i : TableIds.getIds())
		{
			cardImgs.add((ImageView) activity.findViewById(i));
		}
	}
	
	/**
	 * Update display every time a change is made
	 */
	public void update()
	{
		//Update pile
		Card current = game.getCurrentCard();
		if (current != null)
			pileImg.setImageResource(CARD_IMAGE_FACTORY.cardImage(current));
		else
			pileImg.setImageDrawable(null);
		//Update deck
		if (game.deckIsEmpty())
			deckImg.setImageDrawable(null);
		else
			deckImg.setImageResource(R.drawable.b1fv);
		int i = 0;
		//Update table
		for (Card c : game.getTable())
		{
			if (c.isFaceUp())
				cardImgs.get(i).setImageResource(CARD_IMAGE_FACTORY.cardImage(c));
			else
				cardImgs.get(i).setImageResource(R.drawable.b1fv);
			i++;
		}
		for (i = i; i < 10; i++)
		{
			cardImgs.get(i).setVisibility(View.GONE);
		}
	}
}
