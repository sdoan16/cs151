import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import javax.swing.*;

public class Circle implements Icon
{
	private int size;
	private Color color;
	
	public Circle (int size, Color color)
	{
		this.size = size;
		this.color = color;
	}
	public void setColor(Color color)
	{
		this.color = color;
	}
	public int getIconWidth()
	{
		return size;
	}
	public int getIconHeight()
	{
		return size;
	}
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D)g;
		Ellipse2D.Double circ = new Ellipse2D.Double(x, y, size, size);
		//Color color = Color.RED;
		g2.setColor(color);
		g2.fill(circ);
	}
	
}
