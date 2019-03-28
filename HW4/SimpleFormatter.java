/**
   A simple invoice formatter.
*/
public class SimpleFormatter implements InvoiceFormatter
{
   public String formatHeader()
   {
      total = 0;
      return "     I N V O I C E\n\n\n\n\n";
   }

   public String formatLineItem(LineItem item)
   {
	   
      total += item.getPrice();
      
      String s = "";
      String r = "";
      if(item.toString().equals("Hammer"))
      {
    	  double hammerQuantity = 0;
    	  hammerQuantity++;
    	 s = String.format( "%s: $%.2f X % .1f\n",item.toString(),item.getPrice(), item.getQuantity() + 1);
    	 
      }
      else 
      {
    	  double bundleQuantity = 0;
    	  bundleQuantity++;
    	  r = String.format( "%s: $%.2f X % .1f\n",item.toString(),item.getPrice(), item.getQuantity() + 1);
    	  
      }
      return s + r;
   }

   public String formatFooter()
   {
      return (String.format("\n\nTOTAL DUE: $%.2f\n", total));
   }

   private double total;
   private double hammerTotal;
   private double bundleTotal;
   
}
