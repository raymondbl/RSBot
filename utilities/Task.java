package utilities;

import org.powerbot.script.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;

public abstract class Task<C extends ClientContext> extends ClientAccessor<C>
{
    public Task(C ctx)	
    {
        super(ctx);
    }

    public abstract boolean activate();

    public abstract void execute();
    
    public void activate(Task<ClientContext> t) {};
    
    public void execute(Task<ClientContext> t) {};
    
    
}