import java.awt.*;
import java.util.*;

public class PrintArray 
{
	
	public static void main (String[] args)
	{
		Object [] types = {"String", 6, "hi", 12, new Rectangle(12, 20)};
		Object [] nums = {-1.34, 23, 87, "hello", new Point(3,5)};
		
		dumpArray(nums);
		//dumpArray(types);
		}
	
	public static void dumpArray (Object [] array)
	{
		for(int i=0; i < array.length; i++)
		{
			if(array[i].getClass() == Integer.class)
			{
				System.out.println("This is an int: " + array[i]);
			}
			else if(array[i].getClass() == Double.class)
			{
				System.out.println("This is an double: " + array[i]);
			}
			
			else if(array[i].getClass() == String.class)
			{
				System.out.println("This is a string: " + array[i]);
			}
			else if (array[i].getClass() == Float.class)
			{
				System.out.println("This is a float: " + array[i]);
			}
			else
			{
				Class s = array[i].getClass();
				
				
				
				
				System.out.println("This is a " + s.getSimpleName() + " object: " + array[i].toString());
			}
		}
	}

}
