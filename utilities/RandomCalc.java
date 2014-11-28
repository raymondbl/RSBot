package utilities;

import org.powerbot.script.Random;

public class RandomCalc extends org.powerbot.script.Random 
{
	public static int millis(double[] dArray, int[][] iArray)
    {
    	double interval = Random.nextDouble();
    	for(int i = 0; i < dArray.length; i++)
    	{
    		if( interval <= dArray[i])
    		{
    			return Random.nextGaussian(iArray[i][0], iArray[i][1], 1.58);
    		}
    	}
    	return 0;
    }

}
