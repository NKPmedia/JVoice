package de.nkpmedia.jvoice.sysinterface.clementine;

import java.util.Map;
import org.freedesktop.dbus.DBusInterface;
import org.freedesktop.dbus.DBusInterfaceName;
import org.freedesktop.dbus.DBusSignal;
import org.freedesktop.dbus.Variant;
import org.freedesktop.dbus.exceptions.DBusException;

@DBusInterfaceName("org.freedesktop.MediaPlayer")
public interface ClementineInterface extends DBusInterface
{
  @In0("QVariantMap")
   public static class TrackChange extends DBusSignal
   {
      public final Map<String,Variant> a;
      public TrackChange(String path, Map<String,Variant> a) throws DBusException
      {
         super(path, a);
         this.a = a;
      }
   }
  @In0("DBusStatus")
   public static class StatusChange extends DBusSignal
   {
      public final Struct2 a;
      public StatusChange(String path, Struct2 a) throws DBusException
      {
         super(path, a);
         this.a = a;
      }
   }
   public static class CapsChange extends DBusSignal
   {
      public final int a;
      public CapsChange(String path, int a) throws DBusException
      {
         super(path, a);
         this.a = a;
      }
   }

  public void Pause();
  public void Stop();
  public void Play();
  public void Prev();
  public void Next();
  public void Repeat(boolean a);
  @Out0("DBusStatus")
  public Struct1 GetStatus();
  public void VolumeSet(int a);
  public int VolumeGet();
  public void PositionSet(int a);
  public int PositionGet();
  @Out0("QVariantMap")
  public Map<String,Variant> GetMetadata();
  public int GetCaps();
  public void VolumeUp(int a);
  public void VolumeDown(int a);
  public void Mute();
  public void ShowOSD();

}