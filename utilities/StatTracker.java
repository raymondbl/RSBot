package utilities;

import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GeItem;

public class StatTracker extends Task<ClientContext> {

	private final int EXP0, LEVEL0;
	private final long TIME0;
	private int itemPrice;
	private int natureRunePrice;
	private int profit;
	private int totalProfit;
	private static final int NATURE_RUNE_ID = 561;
	
	public StatTracker(ClientContext ctx)
	{
		super(ctx);
		EXP0 = ctx.skills.experience(6);
		LEVEL0 = ctx.skills.level(6);
		TIME0 = System.currentTimeMillis();
	}
	
	public int getExpGained()
	{
		return ctx.skills.experience(6) - EXP0;
	}
	
	public int getLevelsGained()
	{
		return ctx.skills.level(6) - LEVEL0; 
	}
	
	public long getTime()
	{
		return System.currentTimeMillis() - TIME0;
	}
	
	
	public int getPerHr(int x, long time)
	{
		return (int)((double)x / ((double)time / 3600000.0));
	}

	public void setPrice(int itemID)
	{
		itemPrice = GeItem.price(itemID);
		natureRunePrice = GeItem.price(NATURE_RUNE_ID);
	}
	
	public void setCoins(int coinsAlched)
	{
		profit = coinsAlched - itemPrice - natureRunePrice;
	}
	
	public void updateProfit()
	{
		totalProfit += profit;
	}
	
	public int getProfit()
	{
		return totalProfit;
	}
	
	public int getProfitHr(long time)
	{
		return getPerHr(totalProfit, time);
	}
	
	
	@Override
	public boolean activate() 
	{
		return false;
	}

	@Override
	public void execute() 
	{		
	}
}
