package de.nkpmedia.jvoice.sysinterface.clementine;

import org.freedesktop.dbus.Position;
import org.freedesktop.dbus.Struct;
public final class Struct1 extends Struct
{
   @Position(0)
   public final int a;
   @Position(1)
   public final int b;
   @Position(2)
   public final int c;
   @Position(3)
   public final int d;
  public Struct1(int a, int b, int c, int d)
  {
   this.a = a;
   this.b = b;
   this.c = c;
   this.d = d;
  }
}