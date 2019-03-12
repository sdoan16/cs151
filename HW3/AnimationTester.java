import java.awt.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
    
    /**
       This program implements an animation that moves
       a car shape.
    */
    public class AnimationTester extends JFrame
   {
      public static void main(String[] args)
      {
         JFrame frame = new JFrame();
         //frame.setSize(400, 200);
 		//frame.setResizable(false);
 		final ArrayList<MoveableShape> shapes = new ArrayList <MoveableShape>();
   
         final MoveableShape shape1
               = new CarShape(0, 0, CAR_WIDTH);
         final MoveableShape shape2
         = new CarShape(50, 200, CAR_WIDTH);
         final MoveableShape shape3
         = new CarShape(100, 450 , CAR_WIDTH);
         shapes.add(shape1);
         shapes.add(shape2);
         shapes.add(shape3);
         
         
         
   
         ShapeIcon icon = new ShapeIcon(shapes, ICON_WIDTH, ICON_HEIGHT);
        
         
      
         
         
   
         final JLabel label = new JLabel(icon);
         
         frame.setLayout(new FlowLayout());
         frame.add(label);
         
   
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.pack();
         frame.setVisible(true);
   
         final int DELAY = 100;
         // Milliseconds between timer ticks
         Timer t = new Timer(DELAY, event ->
            {
            	for(MoveableShape s: shapes)
            	{
            		s.move();
            		label.repaint();
            	}
            	
            });
         t.start();
      }
   
      private static final int ICON_WIDTH = 1000;
      private static final int ICON_HEIGHT = 1000;
      private static final int CAR_WIDTH = 100;
   }