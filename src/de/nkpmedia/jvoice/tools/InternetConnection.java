package de.nkpmedia.jvoice.tools;

import java.io.IOException;

public class InternetConnection
{

	public boolean isConnected()
	{
		Process p1;
		int returnVal = 2;
		try
		{
			p1 = java.lang.Runtime.getRuntime().exec("ping -c 1 google.com");
			returnVal = p1.waitFor();
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		boolean connected = (returnVal==0);
		return connected;
	}
}
