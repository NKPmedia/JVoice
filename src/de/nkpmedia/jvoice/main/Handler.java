package de.nkpmedia.jvoice.main;

import java.io.IOException;

import javax.sound.sampled.UnsupportedAudioFileException;

import de.nkpmedia.jvoice.externinterface.Weather;
import de.nkpmedia.jvoice.sysinterface.KeyPress;
import de.nkpmedia.jvoice.sysinterface.Time;
import de.nkpmedia.jvoice.sysinterface.clementine.ClementineAPI;

public class Handler
{
	private KeyPress keyPress;
	private Go go;
	
	public Handler(Go go)
	{
		this.go = go;
		this.keyPress = new KeyPress();
	}
	public void handelText(String text)
	
	{
		switch(text)
		{
			case "all workspace":
				this.keyPress.pressKey("17-18-38");
				this.go.tts.say("Show all workspaces");
				break;
			case "left workspace":
				this.keyPress.pressKey("17-18-37");
				break;
			case "right workspace":
				this.keyPress.pressKey("17-18-39");
				break;
			case "all programms":
				this.keyPress.pressKey("17-18-40");
				break;
			case "key up":
				this.keyPress.pressKey("38");
				break;
			case "key down":
				this.keyPress.pressKey("40");
				break;
			case "key right":
				this.keyPress.pressKey("39");
				break;
			case "key left":
				this.keyPress.pressKey("37");
				break;
			case "key delete":
				this.keyPress.pressKey("8");
				break;
			case "key escape":
				this.keyPress.pressKey("27");
				break;
			case "key enter":
				this.keyPress.pressKey("10");
				break;
			case "play the music":
				new ClementineAPI().Play();
				break;
			case "stop the music":
				new ClementineAPI().Stop();
				break;
			case "next title":
				new ClementineAPI().Next();
				break;
			case "preview title":
				new ClementineAPI().Prev();
				break;
			case "what is the name of this title":
				try
				{
					this.go.tts.say(new ClementineAPI().GetMetadata().get("title").toString());
				} 
				catch (Exception e)
				{
					this.go.tts.say("There is no title.");
				}
				break;
			case "what is the name of this album":
				try
				{
					this.go.tts.say(new ClementineAPI().GetMetadata().get("album").toString());
				} catch (Exception e)
				{
					this.go.tts.say("There is no album name.");
				}
				break;
			case "how is the weather today":
				this.go.tts.say(new Weather().getWeatherToday());
				break;
			case "how is the weather tomorrow":
				this.go.tts.say(new Weather().getWeatherTomorrow());
				break;
			case "what is the time":
				this.go.tts.say(new Time().getTime());
				break;
			case "what is the date":
				this.go.tts.say(new Time().getDate());
				break;
		}
	}
}