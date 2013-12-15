package com.tp12.singtrash;
import android.view.View;
import android.view.View.OnClickListener;
public class ClickListener implements OnClickListener
{
	private Game game;
	
	public ClickListener(Game game)
	{
		this.game = game;
	}

	/**
	 * Handle clicks
	 */
	@Override
	public void onClick(View v)
	{
		if (v.getId() == R.id.deck)
			game.nextCard();
		for (int id : TableIds.getIds())
		{
			if (v.getId() == id)
			{
				game.checkMatch(id);
			}
		}
	}
}
