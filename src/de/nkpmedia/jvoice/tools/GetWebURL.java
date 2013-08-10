package de.nkpmedia.jvoice.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;

public class GetWebURL
{
	
	private String url;

	public GetWebURL(String url)
	{
		this.url = url;
	}
	
	public String getSite()
	{
		if(new InternetConnection().isConnected()){
			BufferedReader reader = null;
			String string = "";
			try
			{
				URL url = new URL(this.url);
			    reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			    for (String line; (line = reader.readLine()) != null;)
			    {
			        string += line + "\n";
			    }
			} 
			catch (UnsupportedEncodingException e)
			{
				e.printStackTrace();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			} 
			finally 
			{
			    if (reader != null) try { reader.close(); } catch (IOException ignore) {}
			}
			return string;
		}
		System.out.println("The internet connection is broken!");
		return "FALSE";
	}
}
