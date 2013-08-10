package de.nkpmedia.jvoice.tts;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.UnsupportedAudioFileException;
import marytts.client.MaryClient;
import marytts.util.data.audio.AudioPlayer;
import marytts.util.http.Address;

public class Mary {
	
	public String text;
	private String locale = "en_US";
	private String outputType = "AUDIO";
	private String inputType = "TEXT";
	private String audioType = "WAVE";
	private String defaultVoiceName = "dfki-spike";
	private ByteArrayOutputStream baos;
	private String serverHost;
	private int serverPort;
	private MaryClient mary;

	public Mary()
	{
		try
		{
			this.serverHost = System.getProperty("server.host", "localhost");
			this.serverPort = Integer.getInteger("server.port", 59125).intValue();
			this.mary = MaryClient.getMaryClient(new Address(serverHost, serverPort));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		this.text = "This is a test";
	}
	public void say(String text)
	{
		this.text = text;
		this.baos = new ByteArrayOutputStream();
		AudioInputStream ais = null;
		try
		{
			mary.process(this.text, this.inputType, this.outputType, this.locale, this.audioType, this.defaultVoiceName, this.baos);
			// The byte array constitutes a full wave file, including the headers.
			// And now, play the audio data:
			ais = AudioSystem.getAudioInputStream(new ByteArrayInputStream(baos.toByteArray()));
		}
		catch (UnsupportedAudioFileException | IOException e)
		{
			e.printStackTrace();
		}	
		AudioPlayer ap = new AudioPlayer(ais);
		ap.start();
		}
}