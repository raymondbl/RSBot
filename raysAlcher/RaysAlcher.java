package raysAlcher;

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
	private String status = "Waiting for input...";
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
    public void messaged(MessageEvent msg) {
        if(msg.text().contains("coins have been"))
        {
        	((Alch)(alch)).resetCount();
        	casts++;
        }
    	if (msg.text().contains("Item could not be found:") || 
        		msg.text().contains("You do not have enough")) {
            ctx.controller().stop();
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
			setRunTime(time);
		}
	}
	
	public void setRunTime(long time)
	{
		long remaining;
		int hours = (int)(time / 3600000);
		remaining = time % 3600000;
		int minutes = (int)(remaining / 60000);
		remaining = time % 60000;
		int seconds = (int)(remaining / 1000);
		String sMinutes = 
				(new Integer(minutes).toString().length() < 2) 
				? ("0" + minutes) : "" + minutes;
		String sSeconds = 
				(new Integer(seconds).toString().length() < 2)
				? ("0" + seconds) : "" + seconds;
		gui.setRunTime(hours + ":" + sMinutes + ":" + sSeconds);
	}
	
	public void submitButtonActionPerformed(java.awt.event.ActionEvent evt)
	{
		itemID = gui.getItemID();
		((Alch)alch).setItemID(itemID);
    	((Withdraw)withdraw).setItemID(itemID);
	}

}