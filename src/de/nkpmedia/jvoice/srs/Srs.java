package de.nkpmedia.jvoice.srs;

import de.nkpmedia.jvoice.main.Go;
import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;


public class Srs implements Runnable
{

	Recognizer recognizer;
	private Go go;
	
	public Srs(Go go)
	{
		this.go = go;
	}

	@Override
	public void run()
	{
		System.out.print("The SRS is loading...  ");
		ConfigurationManager cm;
        cm = new ConfigurationManager(Srs.class.getResource("helloworld.config.xml"));
        System.out.println("OK");
        System.out.print("Starting the Recognizer...  ");
        this.recognizer = (Recognizer) cm.lookup("recognizer");
        this.recognizer.allocate();
        System.out.println("OK");

        // start the microphone or exit if the programm if this is not possible
        System.out.print("Looking for a micophone...   ");
        Microphone microphone = (Microphone) cm.lookup("microphone");
        if (!microphone.startRecording())
        {
            System.out.println("Cannot start microphone.");
            this.recognizer.deallocate();
            System.exit(1);
        }
        System.out.println("OK");
        System.out.println("Strarting SRS-Loop...");
        loop();
		
	}
    
    public void loop()
    {
        // loop the recognition until the programm exits.
    	System.out.println("Start speaking. Press Ctrl-C to quit.");
        while (true)
        {
        	Result result = this.recognizer.recognize();

            if (result != null)
            {
                String resultText = result.getBestFinalResultNoFiller();
                this.go.handler.handelText(resultText);
                System.out.println("You said: " + resultText + ' ');
            } 
            else
            {
                System.out.println("I can't hear what you said.\n");
            }
        }
    }
}