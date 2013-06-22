package de.nkpmedia.jvoice.sysinterface.clementine;

import java.util.Map;

import org.freedesktop.dbus.DBusConnection;
import org.freedesktop.dbus.Variant;
import org.freedesktop.dbus.exceptions.DBusException;

public class ClementineAPI implements ClementineInterface
{
	
	private static String ObjectPath = "/Player";
	private static String ServiceBusName = "org.mpris.clementine";
	private static DBusConnection conn;
	private ClementineInterface c;
	
	public ClementineAPI()
	{
		try
		{
			conn = DBusConnection.getConnection(DBusConnection.SESSION);
			c =  conn.getRemoteObject(ServiceBusName, ObjectPath,ClementineInterface.class);
		}
		catch(DBusException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void test()
	{
		this.c.Play();
	}

	@Override
	public boolean isRemote()
	{
		return c.isRemote();
	}

	@Override
	public void Pause()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Stop()
	{
		c.Pause();
		
	}

	@Override
	public void Play()
	{
		c.Play();
		
	}

	@Override
	public void Prev()
	{
		c.Prev();
		
	}

	@Override
	public void Next()
	{
		c.Next();
		
	}

	@Override
	public void Repeat(boolean a)
	{
		c.Repeat(a);
		
	}

	@Override
	@Out0("DBusStatus")
	public Struct1 GetStatus()
	{
		return c.GetStatus();
	}

	@Override
	public void VolumeSet(int a)
	{
		c.VolumeSet(a);
		
	}

	@Override
	public int VolumeGet()
	{
		return c.VolumeGet();
	}

	@Override
	public void PositionSet(int a)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public int PositionGet()
	{
		return c.PositionGet();
	}

	@Override
	@Out0("QVariantMap")
	public Map<String, Variant> GetMetadata()
	{
		return c.GetMetadata();
	}

	@Override
	public int GetCaps()
	{
		return c.GetCaps();
	}

	@Override
	public void VolumeUp(int a)
	{
		c.VolumeUp(a);
		
	}

	@Override
	public void VolumeDown(int a)
	{
		c.VolumeDown(a);
		
	}

	@Override
	public void Mute()
	{
		c.Mute();
		
	}

	@Override
	public void ShowOSD()
	{
		c.ShowOSD();
		
	}
}