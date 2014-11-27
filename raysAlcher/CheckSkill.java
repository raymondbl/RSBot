package raysAlcher;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;
import org.powerbot.script.rt6.Hud;

import utilities.RandomCalc;
import utilities.Task;

public class CheckSkill extends Task<ClientContext>
{
	public CheckSkill(ClientContext ctx) {
		super(ctx);
	}
	private Component magic;
	public boolean activate()
	{
		return RandomCalc.nextDouble() >= 0.998;
	}
	
	public void execute()
	{
		if (!ctx.hud.opened(Hud.Window.SKILLS))
		{
			ctx.input.send("h");
			magic = ctx.widgets.component(1466, 7).component(15);
			ctx.input.move(magic.nextPoint());
			Condition.sleep(RandomCalc.nextInt(2000, 6000));
			ctx.input.send("b");
		}
	}
	
	
}
