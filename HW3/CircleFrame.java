import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
    
public class CircleFrame 
{
	private static Circle c;
	private static JLabel j;
	
	public static void main (String [] args)
	{
		
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		JButton red = new JButton("Red");
		red.addActionListener(changeColor(Color.RED));
		JButton green = new JButton("Green");
		green.addActionListener(changeColor(Color.GREEN));
		JButton blue = new JButton("Blue");
		blue.addActionListener(changeColor(Color.BLUE));
		//Circle is initially red
		c = new Circle(100, Color.RED);
		j = new JLabel(c);
	
		frame.add(red);
		frame.add(green);
		frame.add(blue);
		frame.add(j);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        
	}
	
	public static ActionListener changeColor (final Color col)
	{
		return new ActionListener()
				{
					public void actionPerformed (ActionEvent e)
					{
						c.setColor(col);
						j.repaint();
					}
				};
	}
}
