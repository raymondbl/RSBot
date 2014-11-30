package raysAlcher;

import java.awt.Point;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.Action;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Item;

import utilities.RandomCalc;
import utilities.Task;


public class Alch extends Task<ClientContext>
{
    private Item item;
    private Task<ClientContext> reset;
    private boolean first = true;		//determines if the mouse is on the item
    private int itemID;
    private Point point;				//point where the mouse clicks the item
    private Action action;				//reference value for alch on the combatBar
    private static final double[] DOUBLEARRAY1 = 
    	{0.8, 1.0}; 	//arbitrary anti-pattern values
    private static final int[][] INTARRAY1 = 
    	{ {15, 17}, {18, 21} };
    private static final double[] DOUBLEARRAY2 = 
    	{0.8, 0.92, 0.96, 0.99, 1.00};
    private static final int[][] INTARRAY2 = 
    	{ {12, 15}, {10, 12}, {15, 17}, {17, 19}, {2576, 3185} };
    
    public Alch(ClientContext ctx)
    {
        super(ctx);
        reset = new Reset(ctx);
        action = ctx.combatBar.actionAt(0);
    }
    
    @Override
    public boolean activate()
    {
    	if(!ctx.backpack.select().id(itemID).isEmpty())
    	{
	    	item = ctx.backpack.id(itemID).reverse().peek();
	    	return true;
    	}
    	return false;
    }

    @Override
    public void execute()
    {
    	if(reset.activate())
    	{
    		reset.execute();
    	}
		while(!action.select())
		{
			Condition.sleep(RandomCalc.millis(DOUBLEARRAY1, INTARRAY1));
		}
    	if(!first && ctx.input.getLocation().equals(point) && ctx.client().isSpellSelected())
    	{
    		ctx.input.click(true);
    	}
    	else if(first || !ctx.input.getLocation().equals(point))
    	{
    		item.interact("Cast");
    		first = false;
    		point = ctx.input.getPressLocation();
    	}
    	else if(!ctx.client().isSpellSelected())
    	{
    		return;
    	}
    	
    	((Reset)reset).increment();
    	Condition.sleep(RandomCalc.millis(DOUBLEARRAY2, INTARRAY2));
    }
    
    public void setFirstTrue()
    {
    	first = true;
    }
    
    public void resetCount()
    {
    	((Reset)reset).resetCount();
    }
    
    public void setItemID(int itemID)
    {
    	this.itemID = itemID;
    }

    private class Reset extends Task<ClientContext> 
    {
    	
    	public Reset(ClientContext ctx) 
    	{
    		super(ctx);
    		resetRandomInt();
    	}
    	
    	private int count;		//The number of clicks that have occured before an alch
    	private int randomInt;

    	public boolean activate()
    	{
    		if(count >= randomInt)
    		{
    			resetRandomInt();
    			return true;
    		}
    		else return false;
    	}
    	
    	private void resetRandomInt()
    	{
    		randomInt = RandomCalc.nextGaussian(5, 20, 1.5);
    	}
    	
    	private void resetCount()
    	{
    		count = 0;
    	}

    	public void execute() 
    	{
    		setFirstTrue();
    	}
    	
    	private void increment()
    	{
    		count++;
    	}
    }

}