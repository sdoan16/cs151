import java.awt.*;

    import java.util.*;
    import javax.swing.*;
    
    /**
       An icon that contains a moveable shape.
    */
    public class ShapeIcon implements Icon
    {
    	private int width;
        private int height;
        
        public ArrayList <MoveableShape> shapes;
        
      public ShapeIcon(ArrayList shapes, int width, int height)
      {
    	 this.shapes = shapes;
         this.width = width;
         this.height = height;
         
      }
      
     public int getIconWidth()
      {
         return width;
      }
   
      public int getIconHeight()
      {
         return height;
      }
      
     
  
      public void paintIcon(Component c, Graphics g, int x, int y)
      {
    	  Graphics2D g2 = (Graphics2D) g;
    	  for(MoveableShape s: shapes)
    	  {
    		  s.draw(g2);
    	  }
      }
   }
   
   