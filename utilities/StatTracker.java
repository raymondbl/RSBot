package utilities;

import org.powerbot.script.rt6.ClientContext;

public class StatTracker extends Task<ClientContext> {

	private final int EXP0, LEVEL0;
	private final long TIME0;
	
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

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
