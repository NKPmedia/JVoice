package de.nkpmedia.jvoice.sysinterface;

import java.awt.AWTException; 
import java.awt.Robot; 
import java.io.IOException;
import java.util.regex.Pattern;
public class KeyPress {
	
	public void pressKey(String key) { 
		
		String text = key;
		Robot robot = null;
		try
		{
			robot = new Robot();
		} catch (AWTException e)
		{
			e.printStackTrace();
			System.out.println("ERROR: Can't build Robot!");
		} 
		if(Pattern.matches( ".*-.*-.*", text )){
			String[] strings = text.split("-");
			robot.keyPress(Integer.valueOf(strings[0]));
			robot.keyPress(Integer.valueOf(strings[1]));
			robot.keyPress(Integer.valueOf(strings[2]));
			robot.keyRelease(Integer.valueOf(strings[2]));
			robot.keyRelease(Integer.valueOf(strings[1]));
			robot.keyRelease(Integer.valueOf(strings[0]));
		}
		else if(Pattern.matches( ".*-.*", text )){
			String[] strings = text.split("-");
			robot.keyPress(Integer.valueOf(strings[0]));
			robot.keyPress(Integer.valueOf(strings[1]));
			robot.keyRelease(Integer.valueOf(strings[1]));
			robot.keyRelease(Integer.valueOf(strings[0]));
		}
		else if(Pattern.matches( ".*", text )){
			String strings  = text;
			robot.keyPress(Integer.valueOf(strings));
			robot.keyRelease(Integer.valueOf(strings));
		}
	} 
}