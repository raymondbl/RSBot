package raysAlcher;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Item;

import utilities.RandomCalc;
import utilities.Task;

public class Withdraw extends Task<ClientContext>
{
	private int itemID;
	
	public Withdraw(ClientContext ctx)
	{
		super(ctx);
	}
	
	public void setItemID(int itemID)
	{
		this.itemID = itemID;
	}
	public boolean activate()
	{
		int i;
		Item[] items = ctx.backpack.items();
        for(i = 27; i >= 0; i--)
        {
            if(items[i].id() == itemID)
            {
                return false;
            }
        }
        return true;
	}
	
	public void execute() 
	{
		ctx.bank.open();
		Condition.sleep(RandomCalc.nextInt(146, 307));
		ctx.input.send("2");
		Condition.sleep(RandomCalc.nextInt(146, 307));
	}

}
