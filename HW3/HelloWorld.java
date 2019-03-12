import java.awt.*;
import java.awt.event.*;
import java.time.*;
import javax.swing.*;
import javax.swing.Timer;

public class HelloWorld 
{
	public static void main (String [] args)
	{	
		ActionListener listener = e -> System.out.println("Hello world");
		final int DELAY = 1000;
		Timer t = new Timer(DELAY, listener);
		t.start();
		
		try
		{ Thread.sleep(10000);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
