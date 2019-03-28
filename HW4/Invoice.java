import java.util.*;
import javax.swing.event.*;

/**
   An invoice for a sale, consisting of line items.
*/
public class Invoice
{
   /**
      Constructs a blank invoice.
   */
   public Invoice()
   {
      items = new ArrayList<>();
      listeners = new ArrayList<>();
   }

  /**
      Adds an item to the invoice.
      @param item the item to add
   */
   public void addItem(LineItem item)
   {
	   
      items.add(item);
      // Notify all observers of the change to the invoice
      ChangeEvent event = new ChangeEvent(this);
      for (ChangeListener listener : listeners)
         listener.stateChanged(event);
   }

   /**
      Adds a change listener to the invoice.
      @param listener the change listener to add
   */
   public void addChangeListener(ChangeListener listener)
   {
      listeners.add(listener);
   }

   /**
      Gets an iterator that iterates through the items.
      @return an iterator for the items
   */
   public Iterator<LineItem> getItems()
   {
      return new
         Iterator<LineItem>()
         {
            public boolean hasNext()
            {
               return current < items.size();
            }
            
            public LineItem next()
            {
               return items.get(current++);
            }
            
			public void remove()
            {
               throw new UnsupportedOperationException();
            }

            private int current = 0;
         };
   }

   public String format(InvoiceFormatter formatter)
   {
	  String temp = formatter.formatHeader();
      String r = "";
      String s = "";
      
      
      
      hmrcnt = 1;
      bndcnt =1;
      
      countHammers =1;
      countBundles =1;
      
      //double count = 1;
      Iterator<LineItem> iter = getItems();
      while (iter.hasNext()) 
      
      {
    	  LineItem l = iter.next();
    if(l.toString().equals("Hammer"))
    {
    
      r = formatter.formatLineItem(l);
      
      
      hmrcnt =countHammers++;
      l.setQuantity(hmrcnt);
      
      
      
      
      
      
    }
    else
    {
    	s = formatter.formatLineItem(l);
    	bndcnt = countBundles++;
    	l.setQuantity(bndcnt);
    	
    	
    	
    	
    	
    }
      
    temp =r + s;
   
      
      }
      //System.out.println(hmrcnt);
      
      
      return  temp + formatter.formatFooter();	
      
   }
   public void setHammerCount(double hmrcnt)
   {
	   this.hmrcnt= hmrcnt;
   }
   public double getHammerCount()
   {
	   System.out.println("Hammers " + hmrcnt);
	   return hmrcnt;
   }
   public void setBundleCount(double bndcnt)
   {
	   this.bndcnt = bndcnt;
   }
   public double getBundleCount()
   {
	 
	   return bndcnt;
   }
   

   private ArrayList<LineItem> items;
   private ArrayList<ChangeListener> listeners;
   private double countHammers;
   private double countBundles;
   private double hmrcnt;
   private double bndcnt;
   
}
