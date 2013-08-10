package de.nkpmedia.jvoice.main;

import java.io.IOException;

import de.nkpmedia.jvoice.srs.Srs;
import de.nkpmedia.jvoice.tools.InternetConnection;
import de.nkpmedia.jvoice.tts.Mary;

public class Go
{
	public Thread srs;
	public Handler handler;
	public boolean internetConnection;
	public Mary tts;

	public Go()
	{
		System.out.println("OK");
		
		System.out.print("Looking up Internet Connection...  ");
		InternetConnection internetConnection = new InternetConnection();
		if(internetConnection.isConnected())
		{
			System.out.println("Is connected");
			this.internetConnection = true;
		}
		else
		{
			System.out.println("Connection faild");
			this.internetConnection = false;
		}
		
		System.out.print("The TTS is loading...  ");
		this.tts = new Mary();
		System.out.println("OK");
		
		System.out.print("Buliding Threads...  ");
		
		this.handler = new Handler(this);
		
		this.srs = new Thread(new Srs(this));
		
		System.out.println("OK");
		this.srs.start();
	}
}
