package de.nkpmedia.jvoice.externinterface;

import de.nkpmedia.jvoice.tools.GetWebURL;

public class Weather
{
	public String getWeatherToday()
	{
		GetWebURL site = new GetWebURL("http://weather.tuxnet24.de/?id=GMXX5980");
		String siteContent = site.getSite();
		if(siteContent != "FALSE")
		{
			String[] lines = siteContent.split("\n");
			for(String line : lines)
			{
				if(line.startsWith("current_text"))
				{
					return "Today the weather is " + line.split("=")[1];
				}
			}
		}
		return "There is no internet connection!";
	}
	
	public String getWeatherTomorrow()
	{
		GetWebURL site = new GetWebURL("http://weather.tuxnet24.de/?id=GMXX5980");
		String siteContent = site.getSite();
		if(siteContent != "FALSE")
		{
			String[] lines = siteContent.split("\n");
			for(String line : lines)
			{
				if(line.startsWith("tomorrow_text"))
				{
					return "Tomorrow the weather is " + line.split("=")[1];
				}
			}
		}
		return "There is no internet connection!";
	}
}
