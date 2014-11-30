package raysAlcher;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import utilities.RandomCalc;
import utilities.Task;

public class Withdraw extends Task<ClientContext>
{
	private int itemID;
	
	public Withdraw(ClientContext ctx)
	{
		super(ctx);
	}
	
	@Override
	public boolean activate()
	{
    	return ctx.backpack.select().id(itemID).isEmpty();
	}
	
	@Override
	public void execute() 
	{
		ctx.bank.open();
		Condition.sleep(RandomCalc.nextGaussian(146, 307, 1.5));
		ctx.bank.presetGear2();
		Condition.sleep(RandomCalc.nextGaussian(146, 307, 1.5));
	}
	
	public void setItemID(int itemID)
	{
		this.itemID = itemID;
	}
	

}
