package raysAlcher;

import org.powerbot.script.Condition;
import org.powerbot.script.MessageEvent;
import org.powerbot.script.MessageListener;
import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt6.ClientContext;

import utilities.StatTracker;
import utilities.Task;

import java.awt.Graphics;
import java.awt.Point;
import java.lang.Override;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;

@Script.Manifest(name="Ray's Alcher", description="Efficient High Alchemy")
public class RaysAlcher extends PollingScript<ClientContext> 
						implements MessageListener, PaintListener
{
	private Task<ClientContext> alch;
	private Task<ClientContext> withdraw;
	private Task<ClientContext> checkSkill;
	private List<Task<ClientContext>> tasks = new ArrayList<Task<ClientContext>>();
	private Gui gui;
	private int itemID;
	private int casts;
	private int coinsAlched;
	private boolean lastWithdraw;
	private String status;
	private StatTracker statTracker;
	private JButton submitButton;
	
    @Override
    public void start()
    {
    	statTracker = new StatTracker(ctx);
    	gui = new Gui();
    	gui.setVisible(true);
    	alch = new Alch(ctx);
    	withdraw = new Withdraw(ctx);
    	checkSkill = new CheckSkill(ctx);
    	itemID = gui.getItemID();
    	((Alch)alch).setItemID(itemID);
    	((Withdraw)withdraw).setItemID(itemID);
    	statTracker.setPrice(itemID);
    	tasks.addAll(Arrays.asList(alch, withdraw, checkSkill));
    	submitButton = gui.getButton();
    	submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
    }

    @Override
    public void poll()
    {
    	for(Task<ClientContext> task : tasks)
    	{
    		if(task.activate())
    		{
    			if(task instanceof Alch)
    			{
    				status = "Alching";
    			}
    			else if(task instanceof Withdraw)
    			{
    				if(lastWithdraw)
    				{
    					status = "Run out of items to alch.";
    					Condition.sleep(100);
    					ctx.controller.stop();
    				}
    				status = "Banking";
    				((Alch)alch).setFirstTrue();
    			}
    			else if(task instanceof CheckSkill)
    			{
    				status = "Checking Magic skill";
    				((Alch)alch).setFirstTrue();
    			}
    			task.execute();
    		}
    	}
    }
    
    @Override
    public void messaged(MessageEvent msg) 
    {
    	switch(msg.text())
    	{
    		case "coins have been":
    		{
    			if(coinsAlched == 0)
            	{
            		String text = msg.text();
            		Pattern pattern = Pattern.compile("((\\d+)(,)*)+");
            		Matcher matcher = pattern.matcher(text);
            		String coins = "";
            		if(matcher.find())
            		{
            		coins = matcher.group();
            		}
            		coins = coins.replaceAll(",", "");
            		coinsAlched = Integer.parseInt(coins);
    	        	statTracker.setCoins(coinsAlched);
    	        	
            	}
    			((Alch)(alch)).resetCount();
            	casts++;
            	statTracker.updateProfit();
    			break;
    		}
    		case "You do not have enough" :
    		{
        		status = "Run out of nature runes.";
        		Condition.sleep(100);
                ctx.controller.stop();
                break;
            }
    		case "Item could not be found:" :
    		{
    			lastWithdraw = true;
    			break;
    		}
    		default:
    		{
    			break;
    		}
    	}
    }

	@Override
	public void repaint(Graphics g) 
	{
		Point p = ctx.input.getLocation();
		g.drawLine((p.x - 4), p.y, p.x + 4, p.y);
		g.drawLine(p.x, p.y - 4, p.x, p.y + 4);
		if(!tasks.isEmpty())
		{
			int exp = statTracker.getExpGained();
			long time = statTracker.getTime();
			gui.setMagicExpGained(exp);
			gui.setMagicExpHr(statTracker.getPerHr(exp, time));
			gui.setCasts(casts);
			gui.setCastsHr(statTracker.getPerHr(casts, time));
			gui.setLevelsGained(statTracker.getLevelsGained());
			gui.setStatus(status);
			gui.setProfit(statTracker.getProfit());
			gui.setProfitHr(statTracker.getProfitHr(time));
			setRunTime(time);
		}
	}
	
	public void setRunTime(long time)
	{
		int hours = (int)(time / 3600000 % 24);
		int minutes = (int)(time / 60000 % 60);
		int seconds = (int)(time / 1000 % 60);
		
		gui.setRunTime(String.format("%02d:%02d:%02d", hours, minutes, seconds));
	}
	
	public void submitButtonActionPerformed(java.awt.event.ActionEvent evt)
	{
		itemID = gui.getItemID();
		((Alch)alch).setItemID(itemID);
    	((Withdraw)withdraw).setItemID(itemID);
    	coinsAlched = 0;
	}

}